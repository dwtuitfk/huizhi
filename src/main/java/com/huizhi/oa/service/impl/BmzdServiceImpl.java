package com.huizhi.oa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.dao.BmzdMapper;
import com.huizhi.oa.entity.Bmzd;
import com.huizhi.oa.service.BmzdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * created by dwtuitfk on 2019/2/17.
 */
@Service
@Transactional
public class BmzdServiceImpl implements BmzdService {
    @Autowired
    protected BmzdMapper bmzdMapper;

    @Override
    public int insert(Bmzd record) {
        return bmzdMapper.insert(record);
    }

    @Override
    public int insertSelective(Bmzd record) {
        return bmzdMapper.insertSelective(record);
    }

    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Override
    public List<Bmzd> getAllBmzd() {
        List<Bmzd> list = bmzdMapper.getAllBmzd();
        return list;
    }

    @Override
    public int updateBmzd(Bmzd record) {
        return bmzdMapper.updateBmzd(record);
    }

    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Override
    public Bmzd getBmzd(int bmzdid) {
        return bmzdMapper.getBmzd(bmzdid);
    }

    @Override
    public int delMoreBmzd(List<Integer> ids) {
        return bmzdMapper.delMoreBmzd(ids);
    }


}
