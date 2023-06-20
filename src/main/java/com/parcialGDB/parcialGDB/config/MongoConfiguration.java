package com.parcialGDB.parcialGDB.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.parcialGDB.parcialGDB.model.Acceso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class MongoConfiguration {

    private final MongoClient mongoClient;

    @Autowired
    public MongoConfiguration(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Bean
    public MongoCollection<Acceso> accesoCollection() {
        // Obtener la referencia a la base de datos
        String databaseName = "parcialGDB";
        MongoDatabase database = mongoClient.getDatabase(databaseName);

        // Obtener la referencia a la colección
        String collectionName = "restaurantes";
        MongoCollection<Acceso> collection = database.getCollection(collectionName, Acceso.class);

        return collection;
    }
}
