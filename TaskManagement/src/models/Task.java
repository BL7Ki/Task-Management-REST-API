package TaskManagement.src.models;

import org.springframework.data.annotation.Id;

@Entity // Entity seria uma tabela. Sem essa anotação, o JPA não reconhecerá essa classe como uma entidade.
public class Task {
    @Id // Indica que esse atributo será uma chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) // Indica que essa chave primária será gerada automaticamente. Estao em cima de id
    private Long id;
    private String title;
    private String description;
    private String status;

    public Task(Long id, String title, String description, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Task() {} // construtor vazio

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

    public void setTitle(Long title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
