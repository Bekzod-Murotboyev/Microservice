package dev.bekzod.springreactivesecondary.dto;

import reactor.core.publisher.Mono;

public record CourierDTO(int id, String name, OrganizationDTO organization) {
}
