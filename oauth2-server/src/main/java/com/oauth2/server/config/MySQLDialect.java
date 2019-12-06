package com.oauth2.server.config;

import org.hibernate.dialect.MySQL55Dialect;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhicheng.zhang
 * @date 2019-11-30
 * @description
 */
@Configuration
public class MySQLDialect extends MySQL55Dialect {
    @Override
    public String getTableTypeString() {
        return "engine=innodb charset=utf8";
    }
}
