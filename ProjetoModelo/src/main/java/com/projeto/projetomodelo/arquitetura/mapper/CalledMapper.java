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
    @Mapping(target = "priority", source = "priority")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "observation", source = "observation")

    Called toEntity(CalledRequestDto dto);

    List<Called> toEntityList(List<CalledRequestDto> dtos);

    CalledResponseDto toResponseDto(Called called);

    List<CalledResponseDto> toResponseDtoList(List<Called> calleds);

    void updateEntityFromDto(CalledRequestDto dto, @MappingTarget Called called);
}