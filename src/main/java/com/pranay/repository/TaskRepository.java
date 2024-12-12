package com.pranay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pranay.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    void deleteById(int id);
}
