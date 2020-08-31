package com.example.hsfprovider.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.hsfprovider.bean.FaceData;
import com.example.hsfprovider.dao.FaceDataDao;
import com.example.hsfprovider.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FaceDataServiceImpl extends ServiceImpl<FaceDataDao, FaceData> implements FaceDataService {

    @Autowired
    private OssService ossService;

    @Override
    public void insertFaceData(FaceData faceData) {
        this.insert(faceData);

        //上传头像到OSS
        ossService.upload(faceData.getPicture(), faceData.getFaceId() + ".jpg");
    }
}
