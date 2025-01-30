package com.example.TaskManagement.models;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // Entity seria uma tabela. Sem essa anotação, o JPA não reconhecerá essa classe como uma entidade.
@Getter @Setter // Lombok cria os métodos get e set automaticamente
@NoArgsConstructor // Lombok cria um construtor vazio automaticamente
@AllArgsConstructor // Lombok cria um construtor com todos os argumentos
@ToString // Lombok cria um método toString automaticamente
public class Task {

    @Id // Indica que esse atributo será uma chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Sera gerado automaticamente, melhor pra mysql pq ja usa autoincrement do banco. Estao em cima de id
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING) // Transforma o ENUM em string no banco
    private TaskStatus status; // Vantagem de deixar ENUM eh que pode padronizar os status como: PENDENTE, EM_ANDAMENTO, FINALIZADO

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist // Define comportamento antes de salvar no banco
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate // Define comportamento antes de atualizar no banco
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
