package com.huizhi.oa.service;

import com.huizhi.oa.entity.Emailinfo;

import java.util.List;

public interface EmailinfoService {
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
    /**
     *通过收件人、邮件状态state为1或者2，获取他的所有未读、已读邮件
     * @return
     */
    List<Emailinfo> getAllByeAcceptidBox(int eAcceptid);
    /**
     *通过收件人、邮件状态state为1，获取他的所有未读邮件
     * @return
     */
    List<Emailinfo> getAllByeAcceptidBoxUnread(int eAcceptid);
    /**
     *通过寄件人、邮件状态state为0，获取他的草稿邮件
     * @return
     */
    List<Emailinfo> getAllByeSendididDraft(int eSendid);
    /**
     *通过收件人、邮件状态state为3，获取他的垃圾箱
     * @return
     */
    List<Emailinfo> getAllByeAcceptidDustbin(int eAcceptid);
}