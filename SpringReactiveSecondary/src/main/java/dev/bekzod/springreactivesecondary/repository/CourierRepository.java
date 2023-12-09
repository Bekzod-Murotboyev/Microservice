package dev.bekzod.springreactivesecondary.repository;

import dev.bekzod.springreactivesecondary.entity.CourierEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends R2dbcRepository<CourierEntity, Integer> {
}
