package com.huizhi.oa.service.impl;

import com.huizhi.oa.dao.TiaoxiuinfoMapper;
import com.huizhi.oa.entity.Tiaoxiuinfo;
import com.huizhi.oa.service.TiaoxiuinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiaoxiuinfoServiceImpl implements TiaoxiuinfoService {
    @Autowired
    private TiaoxiuinfoMapper tiaoxiuinfoMapper;
    @Override
    public int deleteByPrimaryKey(Integer txId) {
        return tiaoxiuinfoMapper.deleteByPrimaryKey(txId);
    }

    @Override
    public int insert(Tiaoxiuinfo record) {
        return tiaoxiuinfoMapper.insert(record);
    }

    @Override
    public int insertSelective(Tiaoxiuinfo record) {
        return tiaoxiuinfoMapper.insertSelective(record);
    }

    @Override
    public Tiaoxiuinfo selectByPrimaryKey(Integer txId) {
        return tiaoxiuinfoMapper.selectByPrimaryKey(txId);
    }

    @Override
    public List<Tiaoxiuinfo> selectGetAll(){
        return tiaoxiuinfoMapper.selectGetAll();
    };

    @Override
    public List<Tiaoxiuinfo> selectTiaoxiuinfo(Tiaoxiuinfo tiaoxiuinfo) {
        return tiaoxiuinfoMapper.selectTiaoxiuinfo(tiaoxiuinfo);
    }

    @Override
    public int updateByPrimaryKeySelective(Tiaoxiuinfo record) {
        return tiaoxiuinfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Tiaoxiuinfo record) {
        return tiaoxiuinfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Tiaoxiuinfo> searchTiaoxiuinfo(Tiaoxiuinfo tiaoxiuinfo) {
        return tiaoxiuinfoMapper.searchTiaoxiuinfo(tiaoxiuinfo);
    }
}
