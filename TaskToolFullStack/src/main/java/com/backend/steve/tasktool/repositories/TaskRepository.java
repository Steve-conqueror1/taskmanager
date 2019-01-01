package com.backend.steve.tasktool.repositories;

import com.backend.steve.tasktool.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

}
