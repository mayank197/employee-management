package com.workplace.employeeentity.config;

/*
    File Name : DatabaseConfig.java
    Used for configuring Database
    
    @author Mayank Sharma
    First Created on 01-07-2020 at 22:49
*/

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Bean
    public DataSource dataSource(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(dbUrl);
        return new HikariDataSource(hikariConfig);
    }

}
