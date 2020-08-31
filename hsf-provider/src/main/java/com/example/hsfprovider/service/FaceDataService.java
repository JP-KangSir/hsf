package com.example.hsfprovider.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.hsfprovider.bean.FaceData;

public interface FaceDataService extends IService<FaceData> {

    void insertFaceData(FaceData faceData);

}
