package dev.bekzod.springreactivesecondary.mapper;

import dev.bekzod.springreactivesecondary.dto.CourierCreateDTO;
import dev.bekzod.springreactivesecondary.dto.CourierDTO;
import dev.bekzod.springreactivesecondary.dto.OrganizationDTO;
import dev.bekzod.springreactivesecondary.entity.CourierEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import reactor.core.publisher.Flux;

@Mapper(componentModel = "spring")
public abstract class CourierMapper {

//    @Mapping(target = "organization", expression = "java(organizations.filter(it-> it.id()==entity.getOrganizationId()).next())")
//    abstract public CourierDTO toDTO(CourierEntity entity, Flux<OrganizationDTO> organizations);

    @Mapping(source="entity.id",target = "id")
    @Mapping(source="entity.name",target = "name")
    @Mapping(source="organization",target = "organization")
    abstract public CourierDTO toDTO(CourierEntity entity, OrganizationDTO organization);

    abstract public CourierEntity toEntity(CourierCreateDTO dto);

}
