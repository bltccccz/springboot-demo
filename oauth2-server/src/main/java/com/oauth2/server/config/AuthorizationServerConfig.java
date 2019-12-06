package com.oauth2.server.config;

import com.oauth2.server.service.impl.ClientDetailImpl;
import com.oauth2.server.service.impl.UserDetailImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;

import javax.annotation.Resource;

/**
 * @author zhicheng.zhang
 * @date 2019-11-30
 * @description
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * @AutoWird由spring提供，@Resource由j2EE提供，
     * @AutoWird根据类型加载，可以使用@Bean(name="xxxx"), @Qualifier("xxx")指定引用
     * @Resource根据Name加载，通过name制定bean的名称，type制定bean的类型 优先级(name = xxx, type = xxx)-->(name=xxx)-->()
     * 密码模式必须提供AuthenticationManager
     */
    @Resource(name = "manager", type = AuthenticationManager.class)
    AuthenticationManager authenticationManage;

    /**
     * 密码加密方式，存入数据库的密码需要加密，否则有异常
     */
    @Resource(name = "encoder", type = BCryptPasswordEncoder.class)
    BCryptPasswordEncoder encoder;

    /**
     * 自定义的客户端信息
     *
     * @return
     */
    @Bean
    public ClientDetailsService clientDetailsService() {
        return new ClientDetailImpl();
    }

    /**
     * 自定义的用户信息
     *
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailImpl();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //允许表单数据进行客户端验证
        security.allowFormAuthenticationForClients();
        security.passwordEncoder(encoder);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManage);
        endpoints.allowedTokenEndpointRequestMethods();
        endpoints.userDetailsService(userDetailsService());
    }
}
