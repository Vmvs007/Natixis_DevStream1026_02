package pt.natixis.hello_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String cumprimentar(){
        return "Bom dia! Seja bem-vindo/a à minha API Spring Boot";
    }

    @GetMapping("/hello/{nome}")
    public String cumprimentarPeloNome(@PathVariable String nome){
        return "Olá "+ nome + " sê bem-vindo/a à minha API Spring Boot! :D";
    }

}
