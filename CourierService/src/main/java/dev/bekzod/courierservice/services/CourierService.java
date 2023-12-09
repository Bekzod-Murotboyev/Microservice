package dev.bekzod.courierservice.services;

import dev.bekzod.courierservice.dto.CourierCreateDTO;
import dev.bekzod.courierservice.dto.CourierDTO;
import dev.bekzod.courierservice.entity.CourierEntity;
import dev.bekzod.courierservice.entity.OrganizationHash;
import dev.bekzod.courierservice.exceptions.TargetNotFoundException;
import dev.bekzod.courierservice.mapper.CourierMapper;
import dev.bekzod.courierservice.repository.CourierRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record CourierService(
        OrganizationService organizationService,
        CourierRepository repository,
        CourierMapper mapper
) {
    public ResponseEntity<CourierDTO> createCourier(CourierCreateDTO dto) {
        organizationService
                .getOrganizations()
                .stream()
                .filter(it -> it.getId() == dto.organizationId())
                .findFirst()
                .orElseThrow(() -> new TargetNotFoundException("Organization not found!"));

        CourierEntity entity = repository.save(mapper.toEntity(dto));
        CourierDTO data = mapper.toDTO(entity, organizationService.getOrganizations());
        return ResponseEntity.ok(data);
    }

    public ResponseEntity<List<CourierDTO>> getCouriers() {
        List<OrganizationHash> organizations = organizationService.getOrganizations();
        return ResponseEntity.ok(
                repository
                        .findAll()
                        .stream()
                        .map(it -> mapper.toDTO(it, organizations))
                        .toList());
    }


}
