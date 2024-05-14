package com.bancolombia.backend.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculadora")
public class CalculadoraController {

    @GetMapping
    public String messageinitial(){
        return "Welcome to my first backend project with spring";
    }

    @GetMapping("/sumarize")
    public int sumarize(@RequestParam int value1,
                        @RequestParam int value2){
        return value1+value2;

    }

    @GetMapping("/{name}")
    public String messageinitial(@PathVariable String name){
        return "Welcome to my first backend project with spring. Mr "+name ;
    }

    @GetMapping("/dividir-valor")
    public ResponseEntity dividir(@RequestParam int value1,
                                   @RequestParam int value2){
        if(value2!=0) {
            double resultado = value1/value2;
            return ResponseEntity.status(HttpStatus.OK).body(resultado);

        }
        return ResponseEntity.status(HttpStatus.OK).body("No se puede dividir por 0");

        }

    }


