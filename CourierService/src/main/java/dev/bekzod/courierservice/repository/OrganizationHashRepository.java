package dev.bekzod.courierservice.repository;

import dev.bekzod.courierservice.entity.OrganizationHash;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

public interface OrganizationHashRepository extends KeyValueRepository<OrganizationHash, Integer> {

}
