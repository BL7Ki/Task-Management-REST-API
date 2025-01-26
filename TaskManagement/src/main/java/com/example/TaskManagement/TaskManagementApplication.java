package com.example.TaskManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication // framework vai funcionando atraves dessas anotacoes
@ Configuration // metodos que definem beans
@ EnableAutoConfiguration // spring boot vai configurar automaticamente
@ ComponentScan // permitir que o spring escaneie os componentes da aplicação
public class TaskManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}

}
