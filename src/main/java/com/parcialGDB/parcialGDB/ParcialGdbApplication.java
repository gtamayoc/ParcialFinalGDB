package com.parcialGDB.parcialGDB;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ParcialGdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParcialGdbApplication.class, args);
	}

	/*@Bean
	public MongoClient mongoClient1() {
		return MongoClients.create("mongodb://localhost:27017");
	}*/

	@Bean
	public MongoClient mongoClient() {
		String connectionString = "mongodb+srv://giuseppe:giuseppe12345@cluster0.ztu4uye.mongodb.net/";
		ConnectionString connString = new ConnectionString(connectionString);
		MongoClientSettings settings = MongoClientSettings.builder()
				.applyConnectionString(connString)
				.build();
		return MongoClients.create(settings);
	}

	@Bean
	public MongoDatabase mongoDatabase() {
		return mongoClient().getDatabase("parcialGDB1");
	}
}
