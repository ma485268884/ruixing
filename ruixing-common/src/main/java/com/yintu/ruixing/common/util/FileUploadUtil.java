package com.yintu.ruixing.common.util;

import com.yintu.ruixing.common.exception.BaseRuntimeException;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Properties;

/**
 * @author:mlf
 * @date:2020/6/23 19:28
 */
public class FileUploadUtil {
    public static final String WINDOW_FILE_PATH = "C:\\files\\";
    public static final String LINUX_FILE_PATH = "/files/";
    public static String FINAL_PATH = null;

    static {
        Properties props = System.getProperties(); //系统属性
        String osName = props.getProperty("os.name");
        String os = osName.split(" ")[0];
        FINAL_PATH = "Windows".equals(os) ? WINDOW_FILE_PATH : LINUX_FILE_PATH;
        File file = new File(FINAL_PATH);
        if (!file.exists())
            if (!file.mkdirs())
                throw new RuntimeException("创建文件夹失败");
    }

    /**
     * 指定文件名保存磁盘返回绝对路径
     *
     * @param fileName 文件名
     */
    public static String save(InputStream is, String fileName) {
        String filePathName = null;
        FileInputStream fis = is instanceof FileInputStream ? (FileInputStream) is : null;
        FileOutputStream fos = null;
        FileChannel inFileChannel = null;
        FileChannel outFileChannel = null;
        try {
            if (fis == null)
                throw new RuntimeException("输入流有误");
            filePathName = FINAL_PATH + fileName;
            File file = new File(filePathName);
            if (file.exists())
                throw new BaseRuntimeException("文件存在");
            fos = new FileOutputStream(file);
            inFileChannel = fis.getChannel();
            outFileChannel = fos.getChannel();
            ByteBuffer dst = ByteBuffer.allocate(1024);
            while ((inFileChannel.read(dst)) != -1) {
                dst.flip();
                outFileChannel.write(dst);
                dst.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inFileChannel != null) {
                    inFileChannel.close();
                }
                if (outFileChannel != null) {
                    outFileChannel.close();
                }
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return filePathName;
    }
}
