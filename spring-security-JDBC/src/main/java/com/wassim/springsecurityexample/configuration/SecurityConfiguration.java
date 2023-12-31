package com.wassim.springsecurityexample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager=new JdbcUserDetailsManager(dataSource);

        // Define the query to retrieve a user by username
        userDetailsManager
                .setUsersByUsernameQuery("SELECT USER_NAME, PASSWORD, ACTIVE FROM MEMBERS WHERE USER_NAME=?");

        // Define the query to retrieve the roles by username
        userDetailsManager
                .setAuthoritiesByUsernameQuery("SELECT USER_NAME, ROLE FROM ROLES WHERE USER_NAME=?");

        return userDetailsManager;
    }
}
