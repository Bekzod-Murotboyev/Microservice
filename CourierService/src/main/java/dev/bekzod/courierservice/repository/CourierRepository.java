package dev.bekzod.courierservice.repository;

import dev.bekzod.courierservice.entity.CourierEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourierRepository extends JpaRepository<CourierEntity, Integer> {
}
