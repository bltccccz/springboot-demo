package com.oauth2.server.service.impl;

import com.oauth2.pojo.OauthUser;
import com.oauth2.server.dao.OauthUserDao;
import com.oauth2.server.service.OauthUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhicheng.zhang
 * @date 2019-11-30
 * @description
 */
@Service
public class OauthUserServiceImpl implements OauthUserService {

    @Resource
    OauthUserDao userDao;

    @Override
    public OauthUser findOne(String id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public OauthUser findByUsername(String username) {
        return userDao.findOauthUserByUsername(username).orElse(null);
    }
}
