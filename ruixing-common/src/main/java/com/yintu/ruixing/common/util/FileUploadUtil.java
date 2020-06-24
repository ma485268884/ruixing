package com.yintu.ruixing.common.util;

import com.yintu.ruixing.common.exception.BaseRuntimeException;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Properties;
import java.util.UUID;

/**
 * @author:mlf
 * @date:2020/6/23 19:28
 */
public class FileUploadUtil {
    public static final String WINDOW_BASE_FILE_PATH = "C:\\data\\files\\ruixing";
    public static final String LINUX_BASE_FILE_PATH = "/data/files/ruixing";
    public static String defaultBaseFilePath = WINDOW_BASE_FILE_PATH;

    static {
        Properties props = System.getProperties(); //系统属性
        String osName = props.getProperty("os.name");
        String os = osName.split(" ")[0];
        defaultBaseFilePath = "Windows".equals(os) ? WINDOW_BASE_FILE_PATH : LINUX_BASE_FILE_PATH;
        File file = new File(defaultBaseFilePath);
        if (!file.exists())
            if (!file.mkdirs())
                throw new RuntimeException("创建文件夹失败");
    }

    /**
     * 指定文件名保存磁盘返回相对路径
     *
     * @param fileName 文件名
     */
    public static String save(InputStream is, String fileName) {
        String uuidValue = null;
        FileInputStream fis = is instanceof FileInputStream ? (FileInputStream) is : null;
        FileOutputStream fos = null;
        FileChannel inFileChannel = null;
        FileChannel outFileChannel = null;
        try {
            if (fis == null)
                throw new RuntimeException("输入流有误");
            uuidValue = "\\" + UUID.randomUUID().toString();
            File filePath = new File(defaultBaseFilePath + uuidValue);
            if (!filePath.exists())
                if (!filePath.mkdirs())
                    throw new RuntimeException("创建文件夹失败");


            String filePathName = filePath.getPath() + "\\" + fileName;
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
        return uuidValue;
    }


    public static void get(OutputStream outputStream, String filePathName) {
        FileInputStream fis = null;
        try {
            File file = new File(defaultBaseFilePath + filePathName);
            if (file.exists()) {
                fis = new FileInputStream(file);
                byte[] byteArr = new byte[1024];
                while ((fis.read(byteArr)) != -1) {
                    outputStream.write(byteArr, 0, byteArr.length);
                    outputStream.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void delete(String filePathName) {
        File file = new File(defaultBaseFilePath + filePathName);
        if (file.exists()) {
            if (file.delete()) {
                File parentFile = file.getParentFile();
                if (parentFile.exists()) {
                    if (parentFile.delete()) {
                        System.out.println("");
                    }
                }
            }
        }
    }


}

