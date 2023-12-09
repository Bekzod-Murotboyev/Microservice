package dev.bekzod.courierservice.dto;

import dev.bekzod.courierservice.entity.OrganizationHash;

public record CourierDTO(int id, String name, OrganizationHash organization) {
}
