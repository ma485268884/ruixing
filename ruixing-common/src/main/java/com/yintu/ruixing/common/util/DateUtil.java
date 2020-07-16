package com.yintu.ruixing.common.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author:mlf
 * @date:2020/7/16 14:46
 */
public class DateUtil {

    /**
     * 获取当前日期
     *
     * @return
     */
    public static Date getDate() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }


    public static void main(String[] args) {
        System.out.println(getDate());
    }


}
