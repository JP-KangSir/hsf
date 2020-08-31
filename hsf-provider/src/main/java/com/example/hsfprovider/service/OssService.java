package com.example.hsfprovider.service;

import java.io.File;

public interface OssService {

    /**
     * 上传-文件形式
     * @param file  图片文件
     * @param fileKey  Oss的文件key
     * @return
     */
    public String upload(File file, String fileKey);

    /**
     * 上传-流形式
     * @return
     */
    public String upload(String picture,String fileKey);

    /**
     * 下载
     */
    public void download(String fileKey);
}
