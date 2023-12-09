package dev.bekzod.organizationservice.service;

import dev.bekzod.organizationservice.dto.OrganizationCreateDTO;
import dev.bekzod.organizationservice.dto.OrganizationDTO;
import dev.bekzod.organizationservice.entity.OrganizationEntity;
import dev.bekzod.organizationservice.events.OrganizationOutEvent;
import dev.bekzod.organizationservice.mapper.OrganizationMapper;
import dev.bekzod.organizationservice.repository.OrganizationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record OrganizationService(
        OrganizationRepository repository,
        OrganizationMapper mapper,

        OrganizationOutEvent event
) {

    public ResponseEntity<OrganizationDTO> createOrganization(OrganizationCreateDTO dto) {
        OrganizationEntity entity = repository.save(mapper.toEntity(dto));
        event.publishOrganizationChanges(entity.getName());
        return ResponseEntity.ok(mapper.toDTO(entity));
    }

    public ResponseEntity<List<OrganizationDTO>> getOrganizations() {
        return ResponseEntity.ok(repository
                .findAll()
                .stream()
                .map(mapper::toDTO)
                .toList());
    }
}
