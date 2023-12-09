package dev.bekzod.organizationservice.repository;

import dev.bekzod.organizationservice.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Integer> {
}
