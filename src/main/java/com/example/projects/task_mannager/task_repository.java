package com.example.projects.task_mannager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class task_repository {

    private final JdbcTemplate jdbcTemplate;

    
    @Autowired
    public task_repository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to add a task
    public void add(task taskk) {
        String sql_entry = """
                INSERT INTO task_mannager (TASK, DESCRIPTION, DUE_DATE, STARTED_AT, ENDS_AT, STATUS, PRIORITY) 
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        jdbcTemplate.update(sql_entry, 
            taskk.getTASK(),
            taskk.getDESCRIPTION(),
            taskk.getDUE_DATE(),
            taskk.getSTART_DATE(),
            taskk.getEND_DATE(),
            taskk.getSTATUS(),
            taskk.getPRIORITY());
    }

    
    public void update(Map<String, Object> fieldsToUpdate, String id) {

        
        ArrayList<Object> paramValueList = new ArrayList<>();
        StringBuilder sqlQuery = new StringBuilder("UPDATE task_mannager SET ");

        
        for (String field : fieldsToUpdate.keySet()) {
            sqlQuery.append(field).append(" = ?, ");
            paramValueList.add(fieldsToUpdate.get(field)); 
        }

        // Remove the trailing comma and space
        sqlQuery.setLength(sqlQuery.length() - 2);

        
        sqlQuery.append(" WHERE ID = ?");
        paramValueList.add(id); 

        
        jdbcTemplate.update(sqlQuery.toString(), paramValueList.toArray());
    }

    // Method to delete a task by ID
    public int deleteTaskById(int id) {
        String sql = "DELETE FROM task_mannager WHERE ID = ?";
        return jdbcTemplate.update(sql, id); 
    }

    // Method to fetch all tasks from the database
    @SuppressWarnings("Convert2Lambda")
    public List<task> getAllTasks() {
        String sql = "SELECT * FROM task_mannager"; 

        return jdbcTemplate.query(sql, new RowMapper<task>() { 
            @Override
            public task mapRow(ResultSet rs, int rowNum) throws SQLException {
                task taskk = new task(rs.getInt("ID") , rs.getString("TASK") , rs.getString("DESCRIPTION") , rs.getDate("DUE_DATE") , rs.getTimestamp("STARTED_AT") , rs.getTimestamp("ENDS_AT") , rs.getString("STATUS") , rs.getString("PRIORITY")); 

                // Mapping each column from the result set to task's attributes
                taskk.setID(rs.getInt("ID"));
                taskk.setTASK(rs.getString("TASK"));
                taskk.setDESCRIPTION(rs.getString("DESCRIPTION"));
                taskk.setDUE_DATE(rs.getDate("DUE_DATE"));
                taskk.setSTART_DATE(rs.getTimestamp("STARTED_AT"));
                taskk.setEND_DATE(rs.getTimestamp("ENDS_AT"));
                taskk.setSTATUS(rs.getString("STATUS"));
                taskk.setPRIORITY(rs.getString("PRIORITY"));

                return taskk; 
            }
        });
    }
}
