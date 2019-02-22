package com.huizhi.oa.service.impl;

import com.huizhi.oa.dao.EmailinfoMapper;
import com.huizhi.oa.entity.Emailinfo;
import com.huizhi.oa.service.EmailinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailinfoServiceImpl<service> implements EmailinfoService {
    @Autowired
    private EmailinfoMapper emailinfoMapper;

    @Override
    public int deleteByPrimaryKey(String eId) {
        return emailinfoMapper.deleteByPrimaryKey(eId);
    }

    @Override
    public int insert(Emailinfo record) {
        return emailinfoMapper.insert(record);
    }

    @Override
    public int insertSelective(Emailinfo record) {
        return emailinfoMapper.insertSelective(record);
    }

    @Override
    public Emailinfo selectByPrimaryKey(String eId) {
        return emailinfoMapper.selectByPrimaryKey(eId);
    }

    @Override
    public int updateByPrimaryKeySelective(Emailinfo record) {
        return emailinfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Emailinfo record) {
        return emailinfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Emailinfo> getAllEmailInfo() {
        return emailinfoMapper.getAllEmailInfo();
    }

    @Override
    public List<Emailinfo> getAllEmailInfoByeSendid(int eSendid) {
        return emailinfoMapper.getAllEmailInfoByeSendid(eSendid);
    }

    @Override
    public List<Emailinfo> getAllEmailInfoByeAcceptid(int eAcceptid) {
        return emailinfoMapper.getAllEmailInfoByeAcceptid(eAcceptid);
    }

    @Override
    public List<Emailinfo> getAllByeAcceptidBox(int eAcceptid) {
        return emailinfoMapper.getAllByeAcceptidBox(eAcceptid);
    }

    @Override
    public List<Emailinfo> getAllByeAcceptidBoxUnread(int eAcceptid) {
        return emailinfoMapper.getAllByeAcceptidBoxUnread(eAcceptid);
    }

    @Override
    public List<Emailinfo> getAllByeSendididDraft(int eSendid) {
        return emailinfoMapper.getAllByeSendididDraft(eSendid);
    }

    @Override
    public List<Emailinfo> getAllByeAcceptidDustbin(int eAcceptid) {
        return emailinfoMapper.getAllByeAcceptidDustbin(eAcceptid);
    }
}
