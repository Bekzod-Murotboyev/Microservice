package dev.bekzod.courierservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CourierServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourierServiceApplication.class, args);
    }

}
