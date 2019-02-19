package com.huizhi.oa.service.impl;

import com.huizhi.oa.entity.Carapplyinfo;
import com.huizhi.oa.service.CarapplyinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarapplyinfoServiceImpl implements CarapplyinfoService {

    @Autowired
    private CarapplyinfoService carapplyinfoService;

    @Override
    public int deleteByPrimaryKey(String caId) {
        return carapplyinfoService.deleteByPrimaryKey(caId);
    }

    @Override
    public int insert(Carapplyinfo record) {
        return carapplyinfoService.insert(record);
    }

    @Override
    public int insertSelective(Carapplyinfo record) {
        return carapplyinfoService.insertSelective(record);
    }

    @Override
    public Carapplyinfo selectByPrimaryKey(String caId) {
        return carapplyinfoService.selectByPrimaryKey(caId);
    }

    @Override
    public int updateByPrimaryKeySelective(Carapplyinfo record) {
        return carapplyinfoService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Carapplyinfo record) {
        return carapplyinfoService.updateByPrimaryKey(record);
    }
}
