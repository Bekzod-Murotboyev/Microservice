package dev.bekzod.courierservice.mapper;

import dev.bekzod.courierservice.dto.CourierCreateDTO;
import dev.bekzod.courierservice.dto.CourierDTO;
import dev.bekzod.courierservice.entity.CourierEntity;
import dev.bekzod.courierservice.entity.OrganizationHash;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourierMapper {

    @Mapping(target = "organization", expression = "java(organizations.stream().filter(it-> it.getId()==entity.getOrganizationId()).findFirst().orElse(null))")
    CourierDTO toDTO(CourierEntity entity, List<OrganizationHash> organizations);


    CourierEntity toEntity(CourierCreateDTO dto);

}
