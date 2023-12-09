package dev.bekzod.springreactivesecondary.services;

import dev.bekzod.springreactivesecondary.dto.CourierCreateDTO;
import dev.bekzod.springreactivesecondary.dto.CourierDTO;
import dev.bekzod.springreactivesecondary.dto.OrganizationDTO;
import dev.bekzod.springreactivesecondary.entity.CourierEntity;
import dev.bekzod.springreactivesecondary.mapper.CourierMapper;
import dev.bekzod.springreactivesecondary.repository.CourierRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static dev.bekzod.springreactivesecondary.utils.Constants.SERVICE_REACTIVE;
import static dev.bekzod.springreactivesecondary.utils.Constants.SERVICE_REACTIVE_GET_ORGANIZATIONS;

@Service
public record CourierService(
        CourierRepository repository,
        CourierMapper mapper,

        WebClient.Builder webClientBuilder
) {
    public Mono<CourierDTO> createCourier(CourierCreateDTO dto) {
        CourierEntity entity = mapper.toEntity(dto);

        return process(
                SERVICE_REACTIVE,
                SERVICE_REACTIVE_GET_ORGANIZATIONS,
                OrganizationDTO.class,
                organizations -> repository
                        .save(entity)
                        .flux()
                        .zipWith(organizations, mapper::toDTO)
        ).next();
    }

    public Flux<CourierDTO> getCouriers() {
        return process(
                SERVICE_REACTIVE,
                SERVICE_REACTIVE_GET_ORGANIZATIONS,
                OrganizationDTO.class,
                organizations -> repository
                        .findAll()
                        .zipWith(organizations,mapper::toDTO));
    }


    private <T, R> Flux<R> process(String service, String url, Class<T> clazz, Function<Flux<T>, Flux<R>> function) {
        return function.apply(
                webClientBuilder
                        .baseUrl(service)
                        .build()
                        .get()
                        .uri(url)
                        .retrieve()
                        .bodyToFlux(clazz));
    }

}
