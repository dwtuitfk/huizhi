package com.huizhi.oa.service.impl;

import com.huizhi.oa.entity.Emailinfo;
import com.huizhi.oa.service.EmailinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailinfoServiceImpl<service> implements EmailinfoService {
    @Autowired
    private EmailinfoService emailinfoService;

    @Override
    public int deleteByPrimaryKey(String eId) {
        return emailinfoService.deleteByPrimaryKey(eId);
    }

    @Override
    public int insert(Emailinfo record) {
        return emailinfoService.insert(record);
    }

    @Override
    public int insertSelective(Emailinfo record) {
        return emailinfoService.insertSelective(record);
    }

    @Override
    public Emailinfo selectByPrimaryKey(String eId) {
        return emailinfoService.selectByPrimaryKey(eId);
    }

    @Override
    public int updateByPrimaryKeySelective(Emailinfo record) {
        return emailinfoService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Emailinfo record) {
        return emailinfoService.updateByPrimaryKey(record);
    }
}
