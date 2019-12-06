package com.oauth2.server.service.impl;

import com.oauth2.pojo.OauthClient;
import com.oauth2.server.dao.ClientDao;
import com.oauth2.server.service.OauthClientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhicheng.zhang
 * @date 2019-11-30
 * @description
 */
@Service
public class OauthClientServiceImpl implements OauthClientService {
    @Resource
    ClientDao clientDao;

    @Override
    public OauthClient findOne(String clientId) {
        return clientDao.findById(clientId).orElse(null);
    }
}
