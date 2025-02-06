package com.example.TaskManagement.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskManagement.models.Task;
import com.example.TaskManagement.repositories.TaskRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Operation(summary = "Busca todas as tasks", description = "Retorna a lista de todas as tasks cadastradas.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de tasks retornada com sucesso")
    })
    @GetMapping
    public List<TaskDTO> tasks() {
        return taskRepository.findAll().stream()
                .map(task -> new TaskDTO(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.getStatus() != null ? task.getStatus().name() : "UNKNOWN"
                ))
                .collect(Collectors.toList());
    }

    @Operation(summary = "Busca uma task pelo ID", description = "Retorna uma task específica pelo ID informado.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Task encontrada"),
        @ApiResponse(responseCode = "404", description = "Task não encontrada")
    })
    @GetMapping("/{id}") // to get by id
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Cria uma nova task", description = "Adiciona uma nova task ao banco de dados.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Task criada com sucesso")
    })
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @Operation(summary = "Atualiza uma task", description = "Modifica uma task existente com base no ID informado.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Task atualizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Task não encontrada")
    })
    @PutMapping("/{id}") // just id because RequestMapping is already defined
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setDescription(updatedTask.getDescription());
                    task.setStatus(updatedTask.getStatus());
                    Task savedTask = taskRepository.save(task);
                    return ResponseEntity.ok(savedTask);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deleta uma task", description = "Remove uma task do banco de dados pelo ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Task deletada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Task não encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        return taskRepository.findById(id)
            .map(task -> {
                taskRepository.delete(task);
                return ResponseEntity.noContent().<Void>build();
            })
            .orElse(ResponseEntity.notFound().build());
    }

    public static class TaskDTO {
        private Long id;
        private String title;
        private String description;
        private String status;

        public TaskDTO(Long id, String title, String description, String status) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.status = status;
        }

        public Long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getStatus() {
            return status;
        }
    }
}
