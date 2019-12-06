package com.oauth2.server.service;

import com.oauth2.pojo.OauthUser;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author zhicheng.zhang
 * @date 2019-11-30
 * @description
 */
public interface OauthUserService {

    OauthUser findOne(String id);

    @Cacheable(cacheNames = "OauthUser", key = "'username '+#username")
    @CachePut(cacheNames = "OauthUser", key = "'username '+#username")
    OauthUser findByUsername(String username);
}
