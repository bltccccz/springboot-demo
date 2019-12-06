package com.oauth2.server.service;

import com.oauth2.pojo.OauthRole;

import java.util.Set;

/**
 * @author zhicheng.zhang
 * @date 2019-11-30
 * @description
 */
public interface OauthRoleService {

    Set<OauthRole> findInIds(Set<String> ids);
}
