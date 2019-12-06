package com.oauth2.resource.dao;

import com.oauth2.pojo.OauthPermission;
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
@Component("permissionDao")
public interface PermissionDao extends JpaRepository<OauthPermission, String> {

    @Query("select permissionId from OauthPermission where permissionName=?1")
    String getIdByName(String permissionName);
}
