package com.oauth2.resource.dao;

import com.oauth2.pojo.OauthRole;
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
@Component("roleDao")
public interface RoleDao extends JpaRepository<OauthRole, String> {

    @Query("select roleId from OauthRole where roleName=?1")
    String getRoleIdByName(String roleName);
}
