package com.oauth2.server.service;

import com.oauth2.pojo.OauthClient;

/**
 * @author zhicheng.zhang
 * @date 2019-11-30
 * @description
 */
public interface OauthClientService {

    OauthClient findOne(String clientId);
}
