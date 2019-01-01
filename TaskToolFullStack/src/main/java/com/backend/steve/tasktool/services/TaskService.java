package com.backend.steve.tasktool.services;

import com.backend.steve.tasktool.model.Task;
import com.backend.steve.tasktool.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveOrUpdateTask(Task task){
        //Logic
        return taskRepository.save(task);
    }
}
