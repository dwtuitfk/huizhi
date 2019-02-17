package com.huizhi.oa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.dao.UserzdMapper;
import com.huizhi.oa.entity.Userzd;
import com.huizhi.oa.service.UserzdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by dwtuitfk on 2019/2/17.
 */
@Service
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

    @Override
    public List<Userzd> getAllUserzd() {
        List<Userzd> list = userzdMapper.getAllUserzd();
        return list;
    }

    @Override
    public PageInfo<Userzd> selectUserzdALL(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Userzd> list = userzdMapper.getAllUserzd();
        return new PageInfo<>(list);
    }


}
