package com.oauth2.server.service;

import com.oauth2.pojo.OauthAuthorities;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.Set;

/**
 * @author zhicheng.zhang
 * @date 2019-11-30
 * @description
 */
public interface OauthAuthorityService {

    @Cacheable(cacheNames = "OauthAuthorities", key = "'findInIds'")
    @CachePut(cacheNames = "OauthAuthorities", key = "'findInIds'")
    Set<OauthAuthorities> findInIds(Set<String> ids);
}
