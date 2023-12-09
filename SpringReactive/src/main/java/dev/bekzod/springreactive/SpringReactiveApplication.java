package dev.bekzod.springreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;


@EnableWebFlux
@EnableR2dbcRepositories
@SpringBootApplication
public class SpringReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringReactiveApplication.class, args);
    }

}
