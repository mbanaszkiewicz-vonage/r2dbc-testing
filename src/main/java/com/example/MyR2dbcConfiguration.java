package com.example;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

import java.time.Duration;

import static io.r2dbc.spi.ConnectionFactoryOptions.DATABASE;
import static io.r2dbc.spi.ConnectionFactoryOptions.DRIVER;
import static io.r2dbc.spi.ConnectionFactoryOptions.HOST;
import static io.r2dbc.spi.ConnectionFactoryOptions.PASSWORD;
import static io.r2dbc.spi.ConnectionFactoryOptions.PORT;
import static io.r2dbc.spi.ConnectionFactoryOptions.PROTOCOL;
import static io.r2dbc.spi.ConnectionFactoryOptions.USER;

@Configuration
public class MyR2dbcConfiguration extends AbstractR2dbcConfiguration {
  @Override
  @Bean
  public ConnectionFactory connectionFactory() {
    ConnectionFactory connectionFactory = ConnectionFactories.get(ConnectionFactoryOptions.builder()
        .option(DRIVER, "pool")
        .option(PROTOCOL, "mysql")
        .option(HOST, "localhost")
        .option(PORT, 3306)
        .option(USER, "root")
        .option(PASSWORD, "root")
        .option(DATABASE, "sample_schema")
        .build());

    ConnectionPoolConfiguration poolConfiguration = ConnectionPoolConfiguration.builder(connectionFactory)
        .maxIdleTime(Duration.ofSeconds(40))
        .maxLifeTime(Duration.ofSeconds(60))
        .maxSize(10)
        .build();

    return new ConnectionPool(poolConfiguration);
  }
}
