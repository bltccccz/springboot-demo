package com.oauth2.server.dao;

import com.oauth2.pojo.OauthClient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhicheng.zhang
 * @date 2019-11-30
 * @description
 */
public interface ClientDao extends JpaRepository<OauthClient, String> {
}
