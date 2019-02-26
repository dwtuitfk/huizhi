package com.huizhi.oa.dao;

import com.huizhi.oa.entity.Meethouse;
import com.huizhi.oa.entity.UserRoleDep;

import java.util.List;

public interface MeethouseMapper {
    int deleteByPrimaryKey(Integer mhId);

    int insert(Meethouse record);

    int insertSelective(Meethouse record);

    Meethouse selectByPrimaryKey(Integer mhId);

    int updateByPrimaryKeySelective(Meethouse record);

    int updateByPrimaryKey(Meethouse record);

    List<Meethouse> getAllMeethouse();

    /**
     * 多项删除
     * @param ids
     * @return
     */
    int delMoreMeethouse(List<Integer> ids);

    /**
     * 模糊查询
     * @param meethouse
     * @return
     */
    List<Meethouse> seachMeethouse(Meethouse meethouse);
}