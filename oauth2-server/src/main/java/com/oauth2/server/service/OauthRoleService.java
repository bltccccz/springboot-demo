package com.oauth2.server.service;

import com.oauth2.pojo.OauthRole;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.Set;

/**
 * @author zhicheng.zhang
 * @date 2019-11-30
 * @description
 */
public interface OauthRoleService {
    @Cacheable(cacheNames = "OauthRoles", key = "'findOauthByRoleIds'")
    @CachePut(cacheNames = "OauthRoles", key = "'findOauthByRoleIds'")
    Set<OauthRole> findInIds(Set<String> ids);
}
