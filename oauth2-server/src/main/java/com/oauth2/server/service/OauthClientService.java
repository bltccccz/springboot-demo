package com.oauth2.server.service;

import com.oauth2.pojo.OauthClient;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author zhicheng.zhang
 * @date 2019-11-30
 * @description
 */
public interface OauthClientService {
    @Cacheable(cacheNames = "OauthClient", key = "'client_id '+ #clientId")
    @CachePut(cacheNames = "OauthClient", key = "'client_id '+ #clientId")
    OauthClient findOne(String clientId);
}
