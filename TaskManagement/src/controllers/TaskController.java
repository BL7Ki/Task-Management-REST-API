package TaskManagement.src.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//Stateful = o estado é mantido entre as requisições, ou seja, o cliente fez uma requisicao e precisou logar, o estado
// mantem. O servidor "lembra" do cliente e do contexto da sessão anterior

//Stateless = o estado não é mantido entre as requisições. Cada requisicao e tratada de forma independente
// Cliente sempre mandando um login e senha ou recebendo um token, isso torna a experiencia menos rica e continua

// controladores da API(endpoints)
@RestController
@Controller
@ResponseBody
@RequestMapping("/tasks") // mapeamento das rotas, quero a rota /tasks
public class TaskController {
    // post, get, put, delete, patch, options, head

    @GetMapping // qual o tipo de requisição que esse meu metodo sera, aqui no caso mapeia para o get
    // Responde GET a requisicao no endpoint /tasks
    public String tasks() {
        return "Hello World";
    }
}
