package com.huizhi.oa.service.impl;

import com.huizhi.oa.dao.UserinfoMapper;
import com.huizhi.oa.entity.UserJur;
import com.huizhi.oa.entity.UserRoleDep;
import com.huizhi.oa.entity.Userinfo;
import com.huizhi.oa.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;



import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * created by dwtuitfk on 2019/2/17.
 */
@Service
@Transactional
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserinfoServiceImpl.class);

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

    @Transactional(propagation= Propagation.NOT_SUPPORTED)
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

    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Override
    public List<UserRoleDep> getAllUserinfo() {
        return userinfoMapper.getAllUserinfo();
    }

    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Override
    public List<UserJur> getUserJurInfo() {
        return userinfoMapper.getUserJurInfo();
    }

    @Override
    public UserRoleDep getUserinfo(Integer userid) {
        return userinfoMapper.getUserinfo(userid);
    }

    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Override
    public List<UserRoleDep> seachUserinfo(UserRoleDep userRoleDep) {
        return userinfoMapper.seachUserinfo(userRoleDep);
    }

    @Override
    public UserRoleDep userlogin(Integer userid, Integer password) {
        return userinfoMapper.userlogin(userid,password);
    }

    @Override
    public Userinfo finduserById(Integer userid) {
        return userinfoMapper.finduserById(userid);
    }


    @Override
    public Userinfo findById(Integer userid) {
        // 从缓存中获取信息
        String key = "userid-" + userid;
        ValueOperations<String, Userinfo> operations = redisTemplate.opsForValue();

        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            Userinfo user = operations.get(key);

            LOGGER.info("从缓存中获取了用户 >> " +"userid: "+ user.getUserid()+", username: "+user.getTurename()+",password: "+user.getPassword());
            return user;
        }
        Userinfo user;
        // 从 DB 中获取用户信息
        user = userinfoMapper.finduserById(userid);


        // 插入缓存
        if(user!=null){
            operations.set(key, user, 30, TimeUnit.SECONDS);
            LOGGER.info("用户插入缓存 >> " +"userid: "+ user.getUserid()+", username: "+user.getTurename()+",password: "+user.getPassword());
        }

        return user;
    }

}
