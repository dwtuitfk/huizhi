package com.huizhi.oa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huizhi.oa.dao.UserinfoMapper;
import com.huizhi.oa.entity.Userinfo;
import com.huizhi.oa.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by dwtuitfk on 2019/2/17.
 */
@Service
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer userid) {
        return userinfoMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public int insert(Userinfo record) {
        return userinfoMapper.insert(record);
    }

    @Override
    public int insertSelective(Userinfo record) {
        return userinfoMapper.insertSelective(record);
    }

    @Override
    public Userinfo selectByPrimaryKey(Integer userid) {
        return userinfoMapper.selectByPrimaryKey(userid);
    }

    @Override
    public int updateByPrimaryKeySelective(Userinfo record) {
        return userinfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Userinfo record) {
        return userinfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Userinfo> getAllUserinfo() {
        return userinfoMapper.getAllUserinfo();
    }

    @Override
    public PageInfo<Userinfo> selectUserinfoALL(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Userinfo> list = userinfoMapper.getAllUserinfo();
        return new PageInfo<>(list);
    }
}
