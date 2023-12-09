package dev.bekzod.courierservice.controllers;

import dev.bekzod.courierservice.dto.CourierCreateDTO;
import dev.bekzod.courierservice.dto.CourierDTO;
import dev.bekzod.courierservice.services.CourierService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/couriers")
public class CourierController {
    private final CourierService service;

    private static final Logger log= LoggerFactory.getLogger(CourierController.class);

    @PostMapping
    public ResponseEntity<CourierDTO> createCourier(@RequestBody CourierCreateDTO dto) {
        return service.createCourier(dto);
    }


    @GetMapping
    @CircuitBreaker(name = "getCouriers")
    public ResponseEntity<List<CourierDTO>> getCouriers(){
        return service.getCouriers();
    }


}
