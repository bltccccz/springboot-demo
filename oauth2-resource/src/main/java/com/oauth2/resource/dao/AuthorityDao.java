package com.oauth2.resource.dao;

import com.oauth2.pojo.OauthAuthorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author zhicheng.zhang
 * @date 2019/12/4
 * @description
 */
@Repository
@Component("authorityDao")
public interface AuthorityDao extends JpaRepository<OauthAuthorities, String> {

    @Query("select authorityId from OauthAuthorities where authorityName=?1")
    String getAuthorityIdByName(String authorityName);
}
