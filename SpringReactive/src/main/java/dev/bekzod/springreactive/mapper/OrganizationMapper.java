package dev.bekzod.springreactive.mapper;

import dev.bekzod.springreactive.dto.OrganizationCreateDTO;
import dev.bekzod.springreactive.dto.OrganizationDTO;
import dev.bekzod.springreactive.entity.OrganizationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    OrganizationDTO toDTO(OrganizationEntity entity);

    OrganizationEntity toEntity(OrganizationCreateDTO dto);

}
