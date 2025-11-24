package com.Juan.rest_with_spring_boot_and_java.controlers;

import com.Juan.rest_with_spring_boot_and_java.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingControler {
    // o %s! vai retornar o nome
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //localhost:8080/greeting
    @RequestMapping("/greeting") //metodo esposto via HTTP, vamos acessar na url
    public Greeting greeting(
            //É o parâmetro que vamos por na url, o default é world
            @RequestParam(value = "name", defaultValue = "World") String name) {
        //retorna e incrementa o id, adiciona o valor do RequestParam em name %s!
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
