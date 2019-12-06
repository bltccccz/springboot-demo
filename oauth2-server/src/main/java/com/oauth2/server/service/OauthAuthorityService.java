package com.oauth2.server.service;

import com.oauth2.pojo.OauthAuthorities;

import java.util.Set;

/**
 * @author zhicheng.zhang
 * @date 2019-11-30
 * @description
 */
public interface OauthAuthorityService {

    Set<OauthAuthorities> findInIds(Set<String> ids);
}
