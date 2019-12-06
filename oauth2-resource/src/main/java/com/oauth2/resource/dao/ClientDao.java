package com.oauth2.resource.dao;

import com.oauth2.pojo.OauthClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zhicheng.zhang
 * @date 2019/12/3
 * @description
 */
@Repository
public interface ClientDao extends JpaRepository<OauthClient, String> {

    @Query(value = "select clientSecret from OauthClient where clientId=?1")
    String findClientSecretByClientId(String clientId);
}
