package com.parcialGDB.parcialGDB.controller;
import com.parcialGDB.parcialGDB.models.LoginRequest;
import com.parcialGDB.parcialGDB.models.User;

import com.parcialGDB.parcialGDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
class Login {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/")
    public ResponseEntity logincontroller(@RequestBody LoginRequest loginRequest) {
        Map<String, Object> response = new HashMap<>();
        try {
            User user = userService.findByEmail(loginRequest.getEmail());
            if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
                response.put("message", "Inicio de sesión exitoso");
                response.put("data", user);
                return new ResponseEntity(response, HttpStatus.OK);
            } else {
                response.put("message", "Credenciales inválidas");
                return new ResponseEntity(response, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            response.put("message", "Error en el inicio de sesión");
            response.put("data", e.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
