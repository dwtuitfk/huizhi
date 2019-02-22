package com.huizhi.oa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.dao.UserzdMapper;
import com.huizhi.oa.entity.Userzd;
import com.huizhi.oa.service.UserzdService;
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
public class UserzdServiceImpl implements UserzdService {

    @Autowired
    private UserzdMapper userzdMapper;


    @Override
    public int insert(Userzd record) {
        return userzdMapper.insert(record);
    }

    @Override
    public int insertSelective(Userzd record) {
        return userzdMapper.insertSelective(record);
    }

    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Override
    public List<Userzd> getAllUserzd() {
        List<Userzd> list = userzdMapper.getAllUserzd();
        return list;
    }

    @Override
    public int updateUserzd(Userzd record) {
        return userzdMapper.updateUserzd(record);
    }

    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Override
    public Userzd getUserzd(int userzdid) {
        return userzdMapper.getUserzd(userzdid);
    }

    @Override
    public int delMoreUserzd(List<Integer> ids) {
        return userzdMapper.delMoreUserzd(ids);
    }

    @Override
    public Userzd getRoleName(int rolename) {
        return userzdMapper.getRoleName(rolename);
    }


}
