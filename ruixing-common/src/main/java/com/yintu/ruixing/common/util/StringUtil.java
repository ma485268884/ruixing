package com.yintu.ruixing.common.util;

/**
 * @author:mlf
 * @date:2020/5/22 15:09
 */
public class StringUtil {

    /**
     * @param s 字符串
     * @return true or false
     */
    public static boolean isNumber(String s) {
        if (s != null)
            return s.trim().matches("^[0-9]*$");
        else
            return false;
    }

    public static <T> String arrayToStrWithComma(T[] array) {
        StringBuilder sb = new StringBuilder();
        for (T t : array) {
            sb.append(t.toString()).append(",");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

}
