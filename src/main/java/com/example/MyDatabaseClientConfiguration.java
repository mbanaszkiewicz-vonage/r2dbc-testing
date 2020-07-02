package com.example;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.DatabaseClient;

@Configuration
public class MyDatabaseClientConfiguration {
  @Autowired
  ConnectionFactory connectionFactory;

  @Bean
  DatabaseClient databaseClient(){
    return DatabaseClient.create(connectionFactory);
  }
}
