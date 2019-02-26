package com.huizhi.oa.service.impl;

import com.huizhi.oa.dao.LeaveinfoMapper;
import com.huizhi.oa.entity.Leaveinfo;
import com.huizhi.oa.service.LeaveinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaveinfoServiceImpl implements LeaveinfoService {

    @Autowired
    private LeaveinfoMapper leaveinfoMapper;

    @Override
    public int deleteByPrimaryKey(String lId) {
        return leaveinfoMapper.deleteByPrimaryKey(lId);
    }

    @Override
    public int insert(Leaveinfo record) {
        return leaveinfoMapper.insert(record);
    }

    @Override
    public int insertSelective(Leaveinfo record) {
        return leaveinfoMapper.insertSelective(record);
    }

    @Override
    public List<Leaveinfo> selectTest(Leaveinfo leaveinfo) {
        return leaveinfoMapper.selectTest(leaveinfo);
    }

    @Override
    public Leaveinfo selectByPrimaryKey(String lId) {
        return leaveinfoMapper.selectByPrimaryKey(lId);
    }

    @Override
    public int updateByPrimaryKeySelective(Leaveinfo record) {
        return leaveinfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Leaveinfo record) {
        return leaveinfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Leaveinfo> getAllLeaveInfo() {
        return leaveinfoMapper.getAllLeaveInfo();
    }

    @Override
    public List<Leaveinfo> getOneLeaveInfoAndBM(Integer userId) {
        return leaveinfoMapper.getOneLeaveInfoAndBM(userId);
    }

    @Override
    public List<Leaveinfo> getAllLeaveInfoAndBM() {
        return leaveinfoMapper.getAllLeaveInfoAndBM();
    }

    @Override
    public List<Leaveinfo> getAllBusinessInfoAndBM() {
        return leaveinfoMapper.getAllBusinessInfoAndBM();
    }

    @Override
    public List<Leaveinfo> selectLeaveinfo(Leaveinfo leaveinfo){
        return leaveinfoMapper.selectLeaveinfo(leaveinfo);
    }
}
