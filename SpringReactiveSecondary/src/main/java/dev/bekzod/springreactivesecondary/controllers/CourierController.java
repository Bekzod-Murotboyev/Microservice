package dev.bekzod.springreactivesecondary.controllers;

import dev.bekzod.springreactivesecondary.dto.CourierCreateDTO;
import dev.bekzod.springreactivesecondary.dto.CourierDTO;
import dev.bekzod.springreactivesecondary.services.CourierService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/couriers")
public record CourierController(CourierService service) {



    @PostMapping
    public Mono<CourierDTO> createCourier(@RequestBody CourierCreateDTO dto){
        return service.createCourier(dto);
    }


    @GetMapping
    public Flux<CourierDTO> getCouriers(){
        return service.getCouriers();
    }


}
