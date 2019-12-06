package com.oauth2.server.dao;

import com.oauth2.pojo.OauthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author zhicheng.zhang
 * @date 2019-11-30
 * @description
 */
public interface OauthUserDao extends JpaRepository<OauthUser, String> {

    Optional<OauthUser> findOauthUserByUsername(String username);
}
