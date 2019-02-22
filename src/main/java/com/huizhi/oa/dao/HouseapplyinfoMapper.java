package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Houseapplyinfo;
import com.huizhi.oa.entity.Userinfo;

import java.util.List;

public interface HouseapplyinfoMapper {
    int deleteByPrimaryKey(Integer haId);

    int insert(Houseapplyinfo record);

    int insertSelective(Houseapplyinfo record);

    Houseapplyinfo selectByPrimaryKey(Integer haId);

    int updateByPrimaryKeySelective(Houseapplyinfo record);

    int updateByPrimaryKey(Houseapplyinfo record);

    List<Houseapplyinfo> getAllHouseapplyinfo();

    /**
     * 查询员工编号和姓名
     * @return
     */
    List<Userinfo> getUserIdAndTureName();
}