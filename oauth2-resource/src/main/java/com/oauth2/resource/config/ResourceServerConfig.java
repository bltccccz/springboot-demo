package com.oauth2.resource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.AbstractSecurityExpressionHandler;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * @author zhicheng.zhang
 * @date 2019/12/2
 * @description
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        //设置resourceId名称，对应token中的resourceId
        resources.resourceId("oauth_test");
        resources.tokenServices(resourceConfig());
    }

    /**
     * 配置授权服务器解析token
     *
     * @return
     */
    @Bean
    public ResourceServerTokenServices resourceConfig() {
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:8001/oauth/check_token");
        return remoteTokenServices;
    }

    @Bean
    public PermissionEvaluator permissionEvaluator() {
        return new PermissionEvaluatorCus();
    }

    /**
     * 是注解中@hasPermission生效,若配置权限在该类的configure中，则配置DefaultWebSecurityExpressionHandler
     *
     * @return
     */
    @Bean
    public AbstractSecurityExpressionHandler abstractSecurityExpressionHandler() {
        DefaultMethodSecurityExpressionHandler handler = new DefaultMethodSecurityExpressionHandler();
        handler.setPermissionEvaluator(new PermissionEvaluatorCus());
        return handler;
    }


}
