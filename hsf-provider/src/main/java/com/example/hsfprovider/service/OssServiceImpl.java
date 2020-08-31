package com.example.hsfprovider.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.example.hsfprovider.bean.OssConstant;
import com.example.hsfprovider.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class OssServiceImpl implements OssService {

    @Autowired
    private OssConstant ossConstant;

    public OSS init() {
        String endpoint = ossConstant.getEndpoint();
        String accessKeyId = ossConstant.getAccessKeyId();
        String accessKeySecret = ossConstant.getAccessKeySecret();
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        return ossClient;
    }
    public void destroy(OSS ossClient){
        ossClient.shutdown();
    }



    @Override
    public String upload(File file, String fileKey) {
        OSS ossClient = init();
        String resultStr = null;
        try {
            //以输入流的形式上传文件
            InputStream is = new FileInputStream(file);
            //文件名
            String fileName = file.getName();
            //文件大小
            Long fileSize = file.length();
            ObjectMetadata metadata = getMetadata(is);
            //指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
            metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
            //上传文件   (上传文件流的形式)
            PutObjectResult putResult = ossClient.putObject(ossConstant.getBucketName(), fileKey, is, metadata);
            //解析结果
            resultStr = putResult.getETag();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭OSSClient。
            destroy(ossClient);
            //删除临时文件
            file.delete();
            return resultStr;
        }
    }




    @Override
    public String upload(String picture,String fileKey) {
        OSS ossClient = init();
        String resultStr = null;
        try {
            //以输入流的形式上传文件
            byte[] decode = FileUtil.decode(picture);
            InputStream is = new ByteArrayInputStream(decode);
            ObjectMetadata metadata = getMetadata(is);
            //上传文件   (上传文件流的形式)
            PutObjectResult putResult = ossClient.putObject(ossConstant.getBucketName(), fileKey, is, metadata);
            //解析结果
            resultStr = putResult.getETag();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭OSSClient。
            destroy(ossClient);
            return resultStr;
        }
    }

    @Override
    public void download(String fileKey) {

    }



    public ObjectMetadata getMetadata(InputStream is) throws IOException {
        //创建上传Object的Metadata
        ObjectMetadata metadata = new ObjectMetadata();
        //上传的文件的长度
        metadata.setContentLength(is.available());
        //指定该Object被下载时的网页的缓存行为
        metadata.setCacheControl("no-cache");
        //指定该Object下设置Header
        metadata.setHeader("Pragma", "no-cache");
        //指定该Object被下载时的内容编码格式
        metadata.setContentEncoding("utf-8");
        //文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
        //如果没有扩展名则填默认值application/octet-stream
        metadata.setContentType("image/jpeg");
        return metadata;
    }
}
