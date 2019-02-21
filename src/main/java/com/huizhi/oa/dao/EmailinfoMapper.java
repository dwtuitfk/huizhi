package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Emailinfo;

import java.util.List;

public interface EmailinfoMapper {
    int deleteByPrimaryKey(String eId);

    int insert(Emailinfo record);

    int insertSelective(Emailinfo record);

    Emailinfo selectByPrimaryKey(String eId);

    int updateByPrimaryKeySelective(Emailinfo record);

    int updateByPrimaryKey(Emailinfo record);

    /**
     * 获取所有邮件
     * @return
     */
    List<Emailinfo> getAllEmailInfo();

    /**
     *通过寄件人编号获取他的所有邮件
     * @return
     */
    List<Emailinfo> getAllEmailInfoByeSendid(int eSendid);

    /**
     *通过收件人编号获取他的所有邮件
     * @return
     */
    List<Emailinfo> getAllEmailInfoByeAcceptid(int eAcceptid);
}