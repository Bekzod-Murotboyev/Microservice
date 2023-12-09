package dev.bekzod.courierservice.services;

import dev.bekzod.courierservice.entity.OrganizationHash;
import dev.bekzod.courierservice.feignclients.OrganizationFeign;
import dev.bekzod.courierservice.repository.OrganizationHashRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationHashRepository repository;
    private final OrganizationFeign feign;


    public List<OrganizationHash> getOrganizations() {
        var hash = repository.findAll();
        if (hash.isEmpty()) {
            hash = feign.getOrganizations();
            repository.saveAll(hash);
        }
        return hash;
    }

    public void reload() {
        List<OrganizationHash> organizations = feign.getOrganizations();
        repository.saveAll(organizations);
    }

}
