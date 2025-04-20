package com.example.projects.task_mannager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;



public class Task_service {

    private final task_repository repository;

    @Autowired
    public Task_service(task_repository repository) {
        this.repository = repository;
    }

    public void add_task(task taskk) {
        repository.add_task(taskk);
    }

    public void update_task(Map<String, Object> fieldList, String id) {
        repository.update_task(fieldList, id);
    }

    public int delete_task(String id) {
        return repository.deleteTaskById(id);
    }

    public List<task> get_all_tasks() {
        return repository.getAllTasks();
    }
}
