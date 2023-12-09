package dev.bekzod.organizationservice.mapper;

import dev.bekzod.organizationservice.dto.OrganizationCreateDTO;
import dev.bekzod.organizationservice.dto.OrganizationDTO;
import dev.bekzod.organizationservice.entity.OrganizationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    OrganizationDTO toDTO(OrganizationEntity entity);

    OrganizationEntity toEntity(OrganizationCreateDTO dto);

}
