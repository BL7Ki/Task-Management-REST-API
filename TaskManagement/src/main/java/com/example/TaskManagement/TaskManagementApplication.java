package com.example.TaskManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @springBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan sao os essenciais
@SpringBootApplication
public class TaskManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}

}

// Devtools tem o hot swap que permite atualizar o codigo sem precisar reiniciar o servidor, assim economizando tempo
