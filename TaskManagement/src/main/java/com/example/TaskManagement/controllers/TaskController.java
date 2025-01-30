package com.example.TaskManagement.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Define que essa classe é um controlador REST. Uma juncao de @Controller e @ResponseBody
@RequestMapping("/tasks") // Define a URL base
public class TaskController {

    @GetMapping // Mapeia requisições GET para /tasks
    public TaskDTO tasks() {
        return new TaskDTO(1L, "Estudar Spring Boot", "Aprender Controllers", "pendente");
    }

// DTO para representar os dados da tarefa
record TaskDTO(Long id, String title, String description, String status) {}

}
/*
 * Criar um DTO(Data Transfer Object) serve para transferir apenas os dados necessarios, porque
 * o controller nao precisa saber sobre o mundo interno da aplicacao, supondo que tivesse um campo como algo mais privado/pessoal
 * Assim o frontend recebe apenas os dados necessarios no formato json ja. Eh uma melhoria de seguranca
 */