package com.huizhi.oa.service.impl;

import com.huizhi.oa.dao.CarapplyinfoMapper;
import com.huizhi.oa.entity.AllApply;
import com.huizhi.oa.entity.Carapplyinfo;
import com.huizhi.oa.service.CarapplyinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarapplyinfoServiceImpl implements CarapplyinfoService {

    @Autowired
    private CarapplyinfoMapper carapplyinfoMapper;

    @Override
    public int deleteByPrimaryKey(String caId) {
        return carapplyinfoMapper.deleteByPrimaryKey(caId);
    }

    @Override
    public int insert(Carapplyinfo record) {
        return carapplyinfoMapper.insert(record);
    }

    @Override
    public int insertSelective(Carapplyinfo record) {
        return carapplyinfoMapper.insertSelective(record);
    }

    @Override
    public Carapplyinfo selectByPrimaryKey(String caId) {
        return carapplyinfoMapper.selectByPrimaryKey(caId);
    }

    @Override
    public int updateByPrimaryKeySelective(Carapplyinfo record) {
        return carapplyinfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Carapplyinfo record) {
        return carapplyinfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Carapplyinfo> getAllCarApplyInfoCheck() {
        return carapplyinfoMapper.getAllCarApplyInfoCheck();
    }

    @Override
    public List<AllApply> getAllApplyInfoCheck(Integer userId) {
        return carapplyinfoMapper.getAllApplyInfoCheck(userId);
    }
}
