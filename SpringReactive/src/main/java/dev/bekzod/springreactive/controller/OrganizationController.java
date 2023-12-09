package dev.bekzod.springreactive.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import dev.bekzod.springreactive.dto.OrganizationCreateDTO;
import dev.bekzod.springreactive.dto.OrganizationDTO;
import dev.bekzod.springreactive.service.OrganizationService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/organizations")
public record OrganizationController(OrganizationService service) {

    @PostMapping
    Mono<OrganizationDTO> createOrganization(@RequestBody OrganizationCreateDTO dto) {
        return service.createOrganization(dto);
    }


    @GetMapping
    Flux<OrganizationDTO> getOrganizations() {
        return service.getOrganization();
    }

}
