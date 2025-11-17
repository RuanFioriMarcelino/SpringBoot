package com.projeto.projetomodelo.arquitetura.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

import com.projeto.projetomodelo.arquitetura.dto.CalledRequestDto;
import com.projeto.projetomodelo.arquitetura.dto.CalledResponseDto;
import com.projeto.projetomodelo.arquitetura.entity.Called;

@Mapper(componentModel = "spring")
public interface CalledMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "openedAt", ignore = true)
    @Mapping(target = "closedAt", ignore = true)
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "technician", ignore = true)
    Called toEntity(CalledRequestDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "openedAt", ignore = true)
    @Mapping(target = "closedAt", ignore = true)
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "technician", ignore = true)
    void updateEntityFromDto(CalledRequestDto dto, @MappingTarget Called called);

    List<Called> toEntityList(List<CalledRequestDto> dtos);

    CalledResponseDto toResponseDto(Called called);

    List<CalledResponseDto> toResponseDtoList(List<Called> calleds);

}