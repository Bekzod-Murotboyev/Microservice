package dev.bekzod.courierservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CourierCreateDTO(
        String name,
        @JsonProperty("organization_id")
        int organizationId
) {
}
