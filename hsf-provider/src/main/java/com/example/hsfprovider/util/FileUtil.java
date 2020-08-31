package com.example.hsfprovider.util;

import org.bouncycastle.util.encoders.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileUtil {
    /**
     * base64编码转成图片文件
     *
     * @param base64 图片的base64编码
     * @param filePath 图片文件的保存路径
     *
     * @return
     * @throws Exception
     */
    public static String decryptByBase64(String base64, String filePath) throws Exception{

        try {
            Files.write(Paths.get(filePath), Base64.decode(base64), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw e;
        }
        return "指定路径下生成文件成功！";
    }

    public static byte[] decode(String base64){
        if (base64 == null) {
            throw new RuntimeException("文件base64编码为空");
        }
        return Base64.decode(base64);

    }


    /**
     * 图片转化成base64字符串
     *
     * @param imgPath
     * @return
     */
    public static String GetImageStr(String imgPath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        String imgFile = imgPath;// 待处理的图片
        InputStream in = null;
        byte[] data = null;
        String encode = null; // 返回Base64编码过的字节数组字符串
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            // 读取图片字节数组
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            encode = encoder.encode(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return encode;
    }


}
