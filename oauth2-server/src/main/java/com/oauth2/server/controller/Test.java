package com.oauth2.server.controller;

import com.oauth2.pojo.*;
import com.oauth2.server.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author zhicheng.zhang
 * @date 2019-11-30
 * @description
 */
@RestController
@CrossOrigin
public class Test {

    final
    AuthorityDao authorityDao;

    final
    ClientDao clientDao;

    final
    OauthUserDao userDao;

    final
    PermissionDao permissionDao;

    final
    RoleDao roleDao;

    final
    RoleAndPermissionDao roleAndPermissionDao;

    public Test(AuthorityDao authorityDao, ClientDao clientDao, OauthUserDao userDao, PermissionDao permissionDao, RoleDao roleDao, RoleAndPermissionDao roleAndPermissionDao) {
        this.authorityDao = authorityDao;
        this.clientDao = clientDao;
        this.userDao = userDao;
        this.permissionDao = permissionDao;
        this.roleDao = roleDao;
        this.roleAndPermissionDao = roleAndPermissionDao;
    }

    @GetMapping("/")
    public String init() {

        Set<OauthRole> build = OauthRole.build();
        Set<OauthPermission> build1 = OauthPermission.build();
        Set<OauthAuthorities> build2 = OauthAuthorities.build();
        Set<OauthUser> build3 = OauthUser.build();
        Set<OauthClient> build4 = OauthClient.build();
        Set<OauthRoleAndPermission> build5 = OauthRoleAndPermission.build();

        authorityDao.saveAll(build2);
        roleDao.saveAll(build);
        permissionDao.saveAll(build1);
        userDao.saveAll(build3);
        clientDao.saveAll(build4);
        roleAndPermissionDao.saveAll(build5);

        return "OK";
    }
}
