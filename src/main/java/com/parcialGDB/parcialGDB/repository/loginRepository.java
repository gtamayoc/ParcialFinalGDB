package com.parcialGDB.parcialGDB.repository;

import com.parcialGDB.parcialGDB.model.Access;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface loginRepository extends MongoRepository<Access, String> {

    @Query("{ 'correo' : ?0, 'clave' : ?1 }")
    Access findByCorreoAndClave(String correo, String clave);

    @Query(value = "{}")
    List<Access> obtenerTodosLosAccesos();
}
