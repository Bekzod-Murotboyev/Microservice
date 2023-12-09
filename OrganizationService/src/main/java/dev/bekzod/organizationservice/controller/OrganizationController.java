package dev.bekzod.organizationservice.controller;

import dev.bekzod.organizationservice.dto.OrganizationCreateDTO;
import dev.bekzod.organizationservice.dto.OrganizationDTO;
import dev.bekzod.organizationservice.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService service;

    @PostMapping
    ResponseEntity<OrganizationDTO> createOrganization(@RequestBody OrganizationCreateDTO dto) {
        return service.createOrganization(dto);
    }


    @GetMapping
//    @PreAuthorize("hasAuthority('SCOPE_profile')")
    ResponseEntity<List<OrganizationDTO>> getOrganizations() {
        return service.getOrganizations();
    }

    @GetMapping("/free")
    ResponseEntity<String> freeData() {
        return ResponseEntity.ok("free");
    }
}
