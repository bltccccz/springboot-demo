package com.oauth2.server.service;

import com.oauth2.pojo.OauthUser;

/**
 * @author zhicheng.zhang
 * @date 2019-11-30
 * @description
 */
public interface OauthUserService {

    OauthUser findOne(String id);

    OauthUser findByUsername(String username);
}
