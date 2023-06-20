package com.parcialGDB.parcialGDB.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class auth {

    @GetMapping()
    public ResponseEntity<String> getStringAsJson() {
        String myString = "Hello, World!";
        // Convierte el string en formato JSON
        String json = "{\"message\": \"" + myString + "\"}";

        // Retorna el string JSON con un código de estado 200 (OK)
        return new ResponseEntity<>(json, HttpStatus.OK);
    }
}
