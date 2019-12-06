package com.oauth2.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author ngu.cc
 * @date 2019-11-29
 */
@SpringBootApplication
//开启@PreAuthorize注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableJpaRepositories
@EntityScan("com.oauth2.pojo")
public class ResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }


}
