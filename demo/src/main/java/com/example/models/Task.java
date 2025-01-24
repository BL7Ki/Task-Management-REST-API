package com.example.models;

import java.security.Timestamp;

public class Task {
    private int id;  // Sem setter
    private String title;
    private String description;
    private String status;
    private Timestamp created_at;  // Sem setter
    private Timestamp updated_at;  // Sem setter, pode ser alterado apenas por lógica interna

    public Task(String title, String description, String status, Timestamp created_at, Timestamp updated_at) {
        // O id será gerado automaticamente pelo banco de dados
        this.title = title;
        this.description = description;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
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

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
