package com.oauth2.resource.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhicheng.zhang
 * @date 2019/12/3
 * @description
 */
@RestController
@CrossOrigin
public class TestController {
    

    /**
     * hasPermission注解第一个参数没有回报错，但是貌似随便给一个值都行，具体为啥还是没有搞清楚
     *
     * @return
     */
    @GetMapping("/")
    @PreAuthorize("hasRole('USER') and hasPermission('ROLE_USER','READ')")
    public String test() {
        return "用户具有角色ROLE_USER,并且该角色下拥有READ权限";
    }

    @GetMapping("/1")
    @PreAuthorize("hasRole('ADMIN')")
    public String test1() {
        return "用户具有USER_ADMIN权限";
    }

    @GetMapping("/2")
    @PreAuthorize("hasAuthority('ROOT')")
    public String test2() {
        return "用户具有ROOT权限";
    }

    @GetMapping("/3")
    @PreAuthorize("#oauth2.hasScope('client_scope')")
    public String test3() {
        return "客户端具有client_scope的访问范围";
    }

    @GetMapping("/4")
    @PreAuthorize("#oauth2.clientHasRole('client_auth')")
    public String test4() {
        return "客户端模式下，客户端具有权限client_auth";
    }
}
