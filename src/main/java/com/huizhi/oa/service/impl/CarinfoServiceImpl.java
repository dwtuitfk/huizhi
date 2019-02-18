package com.huizhi.oa.service.impl;

import com.huizhi.oa.entity.Carinfo;
import com.huizhi.oa.service.CarinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarinfoServiceImpl implements CarinfoService {

    @Autowired
    private CarinfoService carinfoService;

    @Override
    public int deleteByPrimaryKey(String cId) {
        return carinfoService.deleteByPrimaryKey(cId);
    }

    @Override
    public int insert(Carinfo record) {
        return carinfoService.insert(record);
    }

    @Override
    public int insertSelective(Carinfo record) {
        return carinfoService.insertSelective(record);
    }

    @Override
    public Carinfo selectByPrimaryKey(String cId) {
        return carinfoService.selectByPrimaryKey(cId);
    }

    @Override
    public int updateByPrimaryKeySelective(Carinfo record) {
        return carinfoService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Carinfo record) {
        return carinfoService.updateByPrimaryKey(record);
    }
}
