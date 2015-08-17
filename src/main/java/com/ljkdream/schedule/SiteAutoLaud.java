package com.ljkdream.schedule;

import com.ljkdream.schedule.producerConsumer.AbstractSchedule;

/**
 * 星期衣自动点赞
 * Created by LJK on 2015/8/17.
 */
public class SiteAutoLaud extends AbstractSchedule {

    public static final String list = "http://www.xing71.com/web/getindexdatas.json?start=10&size=20&tpid=-1&_=1439805729366";
    public static final String laud = "http://www.xing71.com/ivenus/laud.json?type=260&tid=10354&uid=11806706&token=w6TrMZ5dhQpGOmNn";


    @Override
    public void execute() {
        //TODO
        /*
            1、获取 搭配图id，访问接口失败，则插入失败数据，并发送加急邮件提醒。
            2、使用这些id 点赞
            3、成功的就插入某个表做记录。
            4、如果有邮件功能则发个邮件。
         */
    }


}
