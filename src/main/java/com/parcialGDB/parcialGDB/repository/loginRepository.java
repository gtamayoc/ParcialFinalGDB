package com.parcialGDB.parcialGDB.repository;

import com.parcialGDB.parcialGDB.model.Acceso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface loginRepository extends MongoRepository<Acceso, String> {

    @Query("{ 'correo' : ?0, 'clave' : ?1 }")
    Acceso findByCorreoAndClave(String correo, String clave);

    @Query(value = "{}")
    List<Acceso> obtenerTodosLosAccesos();
}
