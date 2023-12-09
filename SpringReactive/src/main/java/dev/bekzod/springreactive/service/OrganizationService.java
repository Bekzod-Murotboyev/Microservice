package dev.bekzod.springreactive.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import dev.bekzod.springreactive.dto.OrganizationCreateDTO;
import dev.bekzod.springreactive.dto.OrganizationDTO;
import dev.bekzod.springreactive.entity.OrganizationEntity;
import dev.bekzod.springreactive.mapper.OrganizationMapper;
import dev.bekzod.springreactive.repository.OrganizationRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;

@Service
public record OrganizationService(
        OrganizationRepository repository,
        OrganizationMapper mapper
) {


    public Mono<OrganizationDTO> createOrganization(OrganizationCreateDTO dto) {
        OrganizationEntity entity = mapper.toEntity(dto);
        return repository
                .save(entity)
                .log()
                .map(mapper::toDTO);
    }

    @HystrixCommand
    public Flux<OrganizationDTO> getOrganization() {
        return repository
                .findAll()
                .log()
                .map(mapper::toDTO);
    }
}
