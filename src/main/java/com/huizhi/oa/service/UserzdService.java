package com.huizhi.oa.service;

import com.github.pagehelper.PageInfo;
import com.huizhi.oa.entity.Userzd;

import java.util.List;

public interface UserzdService {
    int insert(Userzd record);

    int insertSelective(Userzd record);

    List<Userzd> getAllUserzd();

    //LagUI分页显示
    PageInfo<Userzd> selectUserzdALL(Integer pageNum, Integer pageSize);

    int updateUserzd(Userzd record);

    Userzd getUserzd(int userzdid);

    int delMoreUserzd(List<Integer> ids);
}