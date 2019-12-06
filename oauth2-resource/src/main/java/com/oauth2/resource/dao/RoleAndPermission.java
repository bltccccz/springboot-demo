package com.oauth2.resource.dao;

import com.oauth2.pojo.OauthRoleAndPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author zhicheng.zhang
 * @date 2019/12/4
 * @description
 */
@Repository
@Component("roleAndPer")
public interface RoleAndPermission extends JpaRepository<OauthRoleAndPermission, String> {

    @Query("select permissionId from OauthRoleAndPermission where roleId in(:ids)")
    Set<String> getPermissionIdsByAuthIds(@Param("ids") Set<String> ids);
}
