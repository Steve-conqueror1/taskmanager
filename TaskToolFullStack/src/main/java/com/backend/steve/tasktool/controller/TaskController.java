package com.backend.steve.tasktool.controller;

import com.backend.steve.tasktool.model.Task;
import com.backend.steve.tasktool.services.MapValidationErrorService;
import com.backend.steve.tasktool.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewTask(@Valid @RequestBody Task task, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap!=null){
            return errorMap;
        }

        Task task1 = taskService.saveOrUpdateTask(task);
        return new ResponseEntity<Task>(task, HttpStatus.CREATED);

    }
}
