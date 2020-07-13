package com.yintu.ruixing.common.util;

import com.yintu.ruixing.common.enumobject.EnumPlatform;

/**
 * @author:mlf
 * @date:2020/7/13 14:23
 */
public class OSInfoUtil {

    private static final String OS = System.getProperty("os.name").toLowerCase();

    private static final OSInfoUtil _instance = new OSInfoUtil();

    private EnumPlatform platform;

    private OSInfoUtil() {
    }

    public static boolean isLinux() {
        return OS.contains("linux");
    }

    public static boolean isMacOS() {
        return OS.contains("mac") && OS.indexOf("os") > 0 && !OS.contains("x");
    }

    public static boolean isMacOSX() {
        return OS.contains("mac") && OS.indexOf("os") > 0 && OS.indexOf("x") > 0;
    }

    public static boolean isWindows() {
        return OS.contains("windows");
    }

    public static boolean isOS2() {
        return OS.contains("os/2");
    }

    public static boolean isSolaris() {
        return OS.contains("solaris");
    }

    public static boolean isSunOS() {
        return OS.contains("sunos");
    }

    public static boolean isMPEiX() {
        return OS.contains("mpe/ix");
    }

    public static boolean isHPUX() {
        return OS.contains("hp-ux");
    }

    public static boolean isAix() {
        return OS.contains("aix");
    }

    public static boolean isOS390() {
        return OS.contains("os/390");
    }

    public static boolean isFreeBSD() {
        return OS.contains("freebsd");
    }

    public static boolean isIrix() {
        return OS.contains("irix");
    }

    public static boolean isDigitalUnix() {
        return OS.contains("digital") && OS.indexOf("unix") > 0;
    }

    public static boolean isNetWare() {
        return OS.contains("netware");
    }

    public static boolean isOSF1() {
        return OS.contains("osf1");
    }

    public static boolean isOpenVMS() {
        return OS.contains("openvms");
    }

    /**
     * 获取操作系统名字
     *
     * @return 操作系统名
     */
    public static EnumPlatform getOSName() {
        if (isAix()) {
            _instance.platform = EnumPlatform.AIX;
        } else if (isDigitalUnix()) {
            _instance.platform = EnumPlatform.Digital_Unix;
        } else if (isFreeBSD()) {
            _instance.platform = EnumPlatform.FreeBSD;
        } else if (isHPUX()) {
            _instance.platform = EnumPlatform.HP_UX;
        } else if (isIrix()) {
            _instance.platform = EnumPlatform.Irix;
        } else if (isLinux()) {
            _instance.platform = EnumPlatform.Linux;
        } else if (isMacOS()) {
            _instance.platform = EnumPlatform.Mac_OS;
        } else if (isMacOSX()) {
            _instance.platform = EnumPlatform.Mac_OS_X;
        } else if (isMPEiX()) {
            _instance.platform = EnumPlatform.MPEiX;
        } else if (isNetWare()) {
            _instance.platform = EnumPlatform.NetWare_411;
        } else if (isOpenVMS()) {
            _instance.platform = EnumPlatform.OpenVMS;
        } else if (isOS2()) {
            _instance.platform = EnumPlatform.OS2;
        } else if (isOS390()) {
            _instance.platform = EnumPlatform.OS390;
        } else if (isOSF1()) {
            _instance.platform = EnumPlatform.OSF1;
        } else if (isSolaris()) {
            _instance.platform = EnumPlatform.Solaris;
        } else if (isSunOS()) {
            _instance.platform = EnumPlatform.SunOS;
        } else if (isWindows()) {
            _instance.platform = EnumPlatform.Windows;
        } else {
            _instance.platform = EnumPlatform.Others;
        }
        return _instance.platform;
    }


    public static void main(String[] args) {
        System.out.println(OSInfoUtil.getOSName());// 获取系统类型
        System.out.println(OSInfoUtil.isWindows());// 判断是否为windows系统
    }

}
