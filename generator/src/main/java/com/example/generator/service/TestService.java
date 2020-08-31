package com.example.generator.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.generator.bean.HsfFaceData;
import com.example.generator.dao.HsfFaceDataDao;

public class TestService extends ServiceImpl<HsfFaceDataDao, HsfFaceData>  {


    public void a(){
        HsfFaceData hsfFaceData = new HsfFaceData();
        this.insert(hsfFaceData);

    }
}
