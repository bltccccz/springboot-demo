package com.oauth2.server.service.impl;

import com.oauth2.pojo.OauthRole;
import com.oauth2.server.dao.RoleDao;
import com.oauth2.server.service.OauthRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhicheng.zhang
 * @date 2019-11-30
 * @description
 */
@Service
public class OauthRoleServiceImpl implements OauthRoleService {

    @Resource
    RoleDao roleDao;

    @Override
    public Set<OauthRole> findInIds(Set<String> ids) {
        Set<OauthRole> set = new HashSet<>();

        ids.stream().forEach(id ->
                set.add(roleDao.findById(id).get())
        );

        return set;
    }
}
