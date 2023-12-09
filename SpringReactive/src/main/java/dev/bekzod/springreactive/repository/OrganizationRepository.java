package dev.bekzod.springreactive.repository;

import dev.bekzod.springreactive.entity.OrganizationEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends R2dbcRepository<OrganizationEntity, Integer> {
}
