package com.huizhi.oa.service;

import com.huizhi.oa.entity.AllApply;
import com.huizhi.oa.entity.Carapplyinfo;

import java.util.List;

public interface CarapplyinfoService {
    int deleteByPrimaryKey(String caId);

    int insert(Carapplyinfo record);

    int insertSelective(Carapplyinfo record);

    Carapplyinfo selectByPrimaryKey(String caId);

    int updateByPrimaryKeySelective(Carapplyinfo record);

    int updateByPrimaryKey(Carapplyinfo record);


    /**
     * 获取所有车辆申请信息
     */
    List<Carapplyinfo> getAllCarApplyInfoCheck();
    /**
     * 获取查看某个人所有申请状况
     */
    List<AllApply> getAllApplyInfoCheck(Integer userId);
}