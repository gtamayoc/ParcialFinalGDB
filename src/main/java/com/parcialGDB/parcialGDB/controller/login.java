package com.parcialGDB.parcialGDB.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.parcialGDB.parcialGDB.model.Access;
import com.parcialGDB.parcialGDB.model.Restaurante;
import com.parcialGDB.parcialGDB.repository.loginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class login {

    private final loginRepository loginRepository;


    @Autowired
    private MongoDatabase mongoDatabase;

    @Autowired
    public login(loginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @GetMapping("/data")
    public String getData() {
        MongoCollection<Restaurante> collection = mongoDatabase.getCollection("restaurantes", Restaurante.class);

        StringBuilder result = new StringBuilder();
        for (Restaurante restaurante : collection.find()) {
            result.append(restaurante.toString()).append("\n");
        }

        return result.toString();
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
