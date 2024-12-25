package com.storemanagement.core_management.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoRestController {

    @GetMapping("/hola/{nombre}")
    public String saludo(@PathVariable String nombre){
        return "Hola papu :V "+nombre;
    }

    @GetMapping("/")
    public String saludo2(){
        return "Hola  :V";
    }
    
    @GetMapping("/dragon")
    public String saludo3(){
        return "Hola personalidad del dragon";
    }
}
