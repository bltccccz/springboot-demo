package com.oauth2.server.service.impl;

import com.oauth2.pojo.OauthAuthorities;
import com.oauth2.pojo.OauthRole;
import com.oauth2.pojo.OauthUser;
import com.oauth2.server.service.OauthAuthorityService;
import com.oauth2.server.service.OauthRoleService;
import com.oauth2.server.service.OauthUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhicheng.zhang
 * @date 2019-11-29
 * @description
 */
public class UserDetailImpl implements UserDetailsService {

    @Resource
    OauthUserService userService;

    @Resource
    OauthRoleService roleService;

    @Resource
    OauthAuthorityService authorityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        OauthUser byUsername = userService.findByUsername(username);

        if (byUsername == null) {
            throw new UsernameNotFoundException("不存在该用户");
        }

        Set<OauthRole> inIds = roleService.findInIds(StringUtils.commaDelimitedListToSet(byUsername.getRoleId()));

        Set<OauthAuthorities> inIds1 = authorityService.findInIds(StringUtils.commaDelimitedListToSet(byUsername.getAuthoritiesId()));

        Set<String> authorities = new HashSet<>();

        inIds.stream().forEach(role -> authorities.add(role.getRoleName()));
        inIds1.stream().forEach(role -> authorities.add(role.getAuthorityName()));


        return new User(username, byUsername.getPassword(), authoritySet(authorities));
    }

    private Set<GrantedAuthority> authoritySet(Set<String> authorities) {
        Set<GrantedAuthority> set = new HashSet<>();

        authorities.stream().forEach(auth ->
                set.add(new SimpleGrantedAuthority(auth))
        );

        return set;
    }
}
