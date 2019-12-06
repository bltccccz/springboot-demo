package com.oauth2.server.dao;

import com.oauth2.pojo.OauthRoleAndPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhicheng.zhang
 * @date 2019/12/4
 * @description
 */
@Repository
public interface RoleAndPermissionDao extends JpaRepository<OauthRoleAndPermission, String> {
}
