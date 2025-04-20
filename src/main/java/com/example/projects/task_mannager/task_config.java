package com.example.projects.task_mannager;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class task_config {

    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // Don't forget this
        dataSource.setUrl("jdbc:mysql://localhost:3306/task_mannager_database"); // Corrected syntax
        dataSource.setUsername("root"); // No need for @localhost
        dataSource.setPassword("root");
        return dataSource;
    }

    // 2. JdbcTemplate Bean using the DataSource
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    // 3. Task Repository Bean using JdbcTemplate
    @Bean
    public task_repository taskRepository(JdbcTemplate jdbcTemplate) {
        return new task_repository(jdbcTemplate);
    }

    @Bean
    public Task_service return_task_service(task_repository taskRepository) {
        return new Task_service(taskRepository);
    }
}
