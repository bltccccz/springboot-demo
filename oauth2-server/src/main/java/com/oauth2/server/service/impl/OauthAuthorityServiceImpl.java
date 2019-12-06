package com.oauth2.server.service.impl;

import com.oauth2.pojo.OauthAuthorities;
import com.oauth2.server.dao.AuthorityDao;
import com.oauth2.server.service.OauthAuthorityService;
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
public class OauthAuthorityServiceImpl implements OauthAuthorityService {

    @Resource
    AuthorityDao dao;

    @Override
    public Set<OauthAuthorities> findInIds(Set<String> ids) {
        Set<OauthAuthorities> set = new HashSet<>();

        ids.stream().forEach(id ->
                set.add(dao.findById(id).get())
        );

        return set;
    }
}
