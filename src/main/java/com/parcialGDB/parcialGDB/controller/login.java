package com.parcialGDB.parcialGDB.controller;

import com.mongodb.client.MongoCollection;
import com.parcialGDB.parcialGDB.model.Acceso;
import com.parcialGDB.parcialGDB.repository.loginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class login {

    private final loginRepository loginRepository;

    @Autowired
    private MongoCollection<Acceso> accesoCollection;

    @Autowired
    public login(loginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @GetMapping("/accesos")
    public List<Acceso> obtenerAccesosConMQL() {
        return accesoCollection.find().into(new ArrayList<>());
    }


    @PostMapping("/")
    public Acceso registrarAcceso(@RequestBody Acceso acceso) throws Exception {
        Acceso accesoExistente = loginRepository.findByCorreoAndClave(acceso.getCorreo(), acceso.getClave());

        if (accesoExistente != null) {
            throw new Exception("Ya existe un acceso con el mismo correo y clave");
        }
        if (!esValido(acceso)) {
            throw new Exception("El acceso proporcionado es inválido");
        }

        return loginRepository.save(acceso);
    }

    private boolean esValido(Acceso acceso) {
        if (acceso.getCorreo() == null || acceso.getCorreo().isEmpty()) {
            return false;
        }
        if (acceso.getClave() == null || acceso.getClave().isEmpty()) {
            return false;
        }
        return true;
    }

}
