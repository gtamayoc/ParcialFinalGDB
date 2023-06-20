package com.parcialGDB.parcialGDB.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.parcialGDB.parcialGDB.model.Access;
import com.parcialGDB.parcialGDB.model.Restaurante;
import com.parcialGDB.parcialGDB.repository.loginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class login {

    private final loginRepository loginRepository;

    @Autowired
    private MongoDatabase mongoDatabase;

    private final ObjectMapper objectMapper;

    @Autowired
    public login(loginRepository loginRepository, ObjectMapper objectMapper) {
        this.loginRepository = loginRepository;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/login")
    public ResponseEntity<String> getData() {
        MongoCollection<Restaurante> collection = mongoDatabase.getCollection("restaurants", Restaurante.class);

        List<Restaurante> restaurantes = new ArrayList<>();
        collection.find().iterator().forEachRemaining(restaurantes::add);

        try {
            String json = objectMapper.writeValueAsString(restaurantes);
            return ResponseEntity.ok(json);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting to JSON");
        }
    }

    @PostMapping("/")
    public Access registrarAcceso(@RequestBody Access acceso) throws Exception {
        Access accesoExistente = loginRepository.findByCorreoAndClave(acceso.getCorreo(), acceso.getClave());

        if (accesoExistente != null) {
            throw new Exception("Ya existe un acceso con el mismo correo y clave");
        }
        if (!esValido(acceso)) {
            throw new Exception("El acceso proporcionado es inválido");
        }

        return loginRepository.save(acceso);
    }

    private boolean esValido(Access acceso) {
        if (acceso.getCorreo() == null || acceso.getCorreo().isEmpty()) {
            return false;
        }
        if (acceso.getClave() == null || acceso.getClave().isEmpty()) {
            return false;
        }
        return true;
    }

}
