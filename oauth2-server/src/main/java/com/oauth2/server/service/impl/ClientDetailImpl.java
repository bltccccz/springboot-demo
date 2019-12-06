package com.oauth2.server.service.impl;

import com.oauth2.pojo.OauthClient;
import com.oauth2.server.service.OauthClientService;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import javax.annotation.Resource;

/**
 * @author zhicheng.zhang
 * @date 2019-11-29
 * @description
 */
public class ClientDetailImpl implements ClientDetailsService {

    @Resource
    OauthClientService clientService;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        OauthClient one = clientService.findOne(clientId);

        if (one == null) {
            throw new NullPointerException("Can not found client");
        }
        BaseClientDetails baseClientDetails = new BaseClientDetails(clientId, one.getResourceId(), one.getScope(),
                one.getGrantType(), one.getAuthorities(), "http://localhost:8001/code_page");
        baseClientDetails.setClientSecret(one.getClientSecret());
        baseClientDetails.setAccessTokenValiditySeconds(one.getAccessExpire());
        baseClientDetails.setRefreshTokenValiditySeconds(one.getRefreshExpire());

        return baseClientDetails;
    }
}
