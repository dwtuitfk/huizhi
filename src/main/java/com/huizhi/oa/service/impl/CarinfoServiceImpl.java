package com.huizhi.oa.service.impl;

import com.huizhi.oa.dao.CarinfoMapper;
import com.huizhi.oa.entity.Carinfo;
import com.huizhi.oa.service.CarinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarinfoServiceImpl implements CarinfoService {

    @Autowired
    private CarinfoMapper carinfoMapper;

    @Override
    public int deleteByPrimaryKey(String cId) {
        return carinfoMapper.deleteByPrimaryKey(cId);
    }

    @Override
    public int insert(Carinfo record) {
        return carinfoMapper.insert(record);
    }

    @Override
    public int insertSelective(Carinfo record) {
        return carinfoMapper.insertSelective(record);
    }

    @Override
    public Carinfo selectByPrimaryKey(String cId) {
        return carinfoMapper.selectByPrimaryKey(cId);
    }

    @Override
    public int updateByPrimaryKeySelective(Carinfo record) {
        return carinfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Carinfo record) {
        return carinfoMapper.updateByPrimaryKey(record);
    }



    /**
     * 显示车辆所以信息
     * @return
     */
    @Override
    public List<Carinfo> getAllCarinfo() {
        return carinfoMapper.getAllCarinfo();
    }

    /**
     * 删去更多
     * @param ids
     * @return
     */
    @Override
    public int delMoreCar(List<String> ids) {
        return carinfoMapper.delMoreCar(ids);
    }

    /**
     * 高级搜索
     * @return
     */
    @Override
    public List<Carinfo> seachCarinfo(Carinfo c) {
        return carinfoMapper.seachCarinfo(c);
    }


}
