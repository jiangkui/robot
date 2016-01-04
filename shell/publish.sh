#!/bin/bash
#
#-----------------版权--------------------
# 名称：自动发布脚本（发布到阿里云）
# 版本：1.0
# 语言：bash shell
# 日期：2016年01月04日18:27:12
# 作者：ljk
# 邮件：1013939150@qq.com
#-----------------环境--------------------
# Ubuntu 14.04.3 LTS
# GNU bash，版本 4.3.11(1)-release (x86_64-pc-linux-gnu)

#-----------------常量--------------------
projectWar="/robot.war"
serverUser="root@alicloud"
serverTomcatHome="/root/program/apache-tomcat-7.0.67"

#关闭 tomcat 时，等待默认等待n秒，如果还未关掉，则提示是否 kill
defaultWaitTime=10

#-----------------变量--------------------
localProjectPath=$(cd `dirname $0`; cd ../; pwd)
localWarFile=${localProjectPath}"/target"${projectWar}

serverTomcatBin=${serverTomcatHome}"/bin"
serverTomcatWebapps=${serverTomcatHome}"/webapps"
serverWarFile=${serverTomcatWebapps}${projectWar}
serverFileName=${serverTomcatWebapps}"/robot"

#-----------------数组--------------------


#-----------------方法--------------------

#打印日志
function printLog(){
    echo "================================================"
    echo $1
    echo "================================================"
}

function remoteExecute(){
    ssh ${serverUser} $1
}

#统计 java 进程数量
function processCount(){
    remoteExecute "ps -ef | grep -e 'bootstrap\.jar' -c"
}

#杀掉 Java 进程
function killProcess(){
    #此处不能使用 remoteExecute 方法
    tomcatId=$(ssh ${serverUser} ps -ef | awk '/bootstrap\.jar/ {print $2}')

    echo "准备 kill tomcat 进程"

    if test -z ${tomcatId}; then
        echo "进程id为空，跳过"
        return
    fi
    echo "干掉 $tomcatId 进程"
    remoteExecute "kill -9 ${tomcatId}"
}

function packWar(){
    printLog "打 war 包"
    cd ${localProjectPath}
    mvn clean
    mvn package -Dmaven.test.skip=true
}

function stopTomcat(){
    printLog "停止 tomcat"

    count=`processCount`
    if [ ${count} -gt 0 ]; then
        remoteExecute ${serverTomcatBin}"/shutdown.sh"

        echo ""
        echo "正在停止 tomcat..."
        sleep 1

        waitSecond=1
        while [[ ${count} -gt 0 ]]; do
            echo "已等待"${waitSecond}"秒"

            if [[ ${waitSecond} -ge ${defaultWaitTime} ]]; then
                read -p "等待超时，请输入（y/n） kill掉/继续等待  " tryKill
                if [[ ${tryKill} == "y" ]]; then
                    killProcess
                else
                    waitSecond=0
                fi
            fi

            ((waitSecond = waitSecond + 1))
            sleep 1
            count=`processCount`
        done

        echo "tomcat 已经停止"
    fi
}

function uploadWar(){
    printLog "上传war包 ${localWarFile} 到 ${serverUser}:${serverTomcatWebapps}"

    localWarMd5=$(md5sum ${localWarFile} | awk '{print $1}')

    serverWarMd5=""
    uploadNum=0
    while [[ ${localWarMd5} != ${serverWarMd5} ]]; do
        ((uploadNum=uploadNum + 1))

        if [[ ${uploadNum} -gt 3 ]] ; then
            echo "上传次数超过3次，上传失败！请手动上传！"
            exit 0;
        fi

        echo "第 ${uploadNum} 次上传。。。"

        scp ${localWarFile} ${serverUser}":"${serverTomcatWebapps}

        serverWarMd5=$(ssh ${serverUser} "md5sum ${serverWarFile}" | awk '{print $1}')

        echo "localFileMd5:${localWarMd5}"
        echo "serverWarMd5:${serverWarMd5}"

        if [[ ${localWarMd5} != ${serverWarMd5} ]]; then
            echo "md5sum 不等，文件上传过程中有损坏！"

            read -p "请输入 y/n 重新尝试上传！" tryAgain
            if [[ ${tryAgain} != "y" ]]; then
                exit 0;
            fi
        else
            echo "md5sum 相等，文件上传成功！"
        fi
    done
}

#-----------------main--------------------

packWar

stopTomcat

uploadWar

#删除 server 上的 ROOT包
printLog "删除原 ${serverFileName} 文件"
remoteExecute "rm -rf ${serverFileName}"
sleep 1

printLog "重启 tomcat"
remoteExecute "bash ${serverTomcatBin}/startup.sh"
remoteExecute "cd ${serverTomcatHome}/logs; tail -f catalina.out"

