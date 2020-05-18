package com.example.config;

import com.example.data.RoleDataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration()
public class DatabaseConfiguration {

    @Autowired
    RoleDataAccessService roleDataAccessService;


    @Primary
    @Bean
    public DataSource customDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("rootlozinka");
        dataSource.setUrl("jdbc:mysql://localhost:3306/rrre?autoReconnect=true&useSSL=false");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        return dataSource;

    }



    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(customDataSource());
    }



}