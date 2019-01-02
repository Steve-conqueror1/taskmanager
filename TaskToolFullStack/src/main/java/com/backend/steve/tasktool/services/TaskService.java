package com.backend.steve.tasktool.services;

import com.backend.steve.tasktool.exceptions.TaskIdException;
import com.backend.steve.tasktool.model.Task;
import com.backend.steve.tasktool.repositories.TaskRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveOrUpdateTask(Task task){
        //Logic
        try{
            task.setTaskIdentifier(task.getTaskIdentifier().toLowerCase());
            return taskRepository.save(task);
        }catch (Exception e){
            throw new TaskIdException("Task Id "+ task.getTaskIdentifier().toUpperCase()+"'already exists'");
        }
    }


    public Task findTaskByIdentifier(String taskId){

        Task task = taskRepository.findByTaskIdentifier(taskId);

         if (task==null){
             throw new TaskIdException("Task id " + taskId+ " does not exist");
         }
         return task;
    }

    public Iterable<Task> findAllTasks(){
        return taskRepository.findAll();
    }

    public void deleteTaskByIdentifier(String taskId){
       Task task = taskRepository.findByTaskIdentifier(taskId);

       if (task == null){
           throw new TaskIdException("You tried to delete a task that does not exist");
       }
       taskRepository.delete(task);
    }
}
