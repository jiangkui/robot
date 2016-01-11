package com.ljkdream.core.util;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则工具类
 * Created by ljk on 16-1-9.
 */
public class RegexUtil {

    /**
     * 是否是正确的 IP 地址
     *
     * @param ipAddress 带判定的参数
     * @return true 是
     */
    public static boolean isIpAddress(String ipAddress) {
        String rexp = "((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))";

        Pattern pat = Pattern.compile(rexp);

        Matcher mat = pat.matcher(ipAddress);

        return mat.matches();
    }

    /**
     * 粗略判断字符串是否包含中文
     *
     * 效率较低
     *
     * @param str str
     * @return true 包含
     */
    public static boolean containZhSimple(String str) {
        if (StringUtils.isNotBlank(str)) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                boolean chinese = isChinese(c);
                if (chinese) {
                    return true;
                }
            }

        }

        return false;
    }

    /**
     * 输入的字符是否是汉字
     * @param a char
     * @return boolean
     */
    public static boolean isChinese(char a) {
        int v = (int)a;
        return (v >=19968 && v <= 171941);
    }
}
