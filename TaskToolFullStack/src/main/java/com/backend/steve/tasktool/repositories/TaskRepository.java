package com.backend.steve.tasktool.repositories;

import com.backend.steve.tasktool.model.Task;
import org.hibernate.sql.Update;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    Task findByTaskIdentifier(String taskId);

    @Override
    Iterable<Task> findAll();

    @Override
    void delete(Task task);




}
