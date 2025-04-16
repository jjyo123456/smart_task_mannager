package com.example.projects.task_mannager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class task_config {

    
    
    @Bean
    public JdbcTemplate return_jdbc_template(){

         DriverManagerDataSource dataSource = new DriverManagerDataSource();

         dataSource.setUrl("jdbc::mysql://localhost:3036//task_mannager_database");
         dataSource.setUsername("root@localhost");
         dataSource.setPassword("root");

        return new JdbcTemplate(dataSource);
    }
}
