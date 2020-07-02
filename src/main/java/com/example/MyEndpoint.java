package com.example;

import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/")
public class MyEndpoint {

  private DatabaseClient databaseClient;

  MyEndpoint(DatabaseClient databaseClient) {
    this.databaseClient = databaseClient;
  }

  @GetMapping
  public Flux<String> queriesDb() {
    return databaseClient.execute("SELECT name, SLEEP(1) FROM sample_table")
        .map(row -> row.get(0, String.class))
        .all();
  }
}
