package com.example.TaskManagement.repositories;

import com.example.TaskManagement.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Garante que o Spring reconheça essa classe como um componente de repositório
public interface TaskRepository extends JpaRepository<Task, Long> {
}
