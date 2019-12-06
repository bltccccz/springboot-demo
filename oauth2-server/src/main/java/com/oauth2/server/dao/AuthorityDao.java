package com.oauth2.server.dao;

import com.oauth2.pojo.OauthAuthorities;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhicheng.zhang
 * @date 2019-11-30
 * @description
 */
public interface AuthorityDao extends JpaRepository<OauthAuthorities, String> {
}
