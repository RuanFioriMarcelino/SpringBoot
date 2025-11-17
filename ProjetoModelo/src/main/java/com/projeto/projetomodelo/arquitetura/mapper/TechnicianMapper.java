package com.projeto.projetomodelo.arquitetura.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

import com.projeto.projetomodelo.arquitetura.dto.TechnicianRequestDto;
import com.projeto.projetomodelo.arquitetura.dto.TechnicianResponseDto;
import com.projeto.projetomodelo.arquitetura.entity.Technician;

@Mapper(componentModel = "spring")
public interface TechnicianMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "profile", source = "profile")

    Technician toEntity(TechnicianRequestDto dto);

    List<Technician> toEntityList(List<TechnicianRequestDto> dtos);

    TechnicianResponseDto toResponseDto(Technician technician);

    List<TechnicianResponseDto> toResponseDtoList(List<Technician> technicians);

    void updateEntityFromDto(TechnicianRequestDto dto, @MappingTarget Technician technician);
}