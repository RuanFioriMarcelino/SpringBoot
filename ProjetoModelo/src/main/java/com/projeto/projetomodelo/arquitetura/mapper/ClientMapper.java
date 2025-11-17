package com.projeto.projetomodelo.arquitetura.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

import com.projeto.projetomodelo.arquitetura.dto.ClientRequestDto;
import com.projeto.projetomodelo.arquitetura.dto.ClientResponseDto;
import com.projeto.projetomodelo.arquitetura.entity.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "profile", source = "profile")

    Client toEntity(ClientRequestDto dto);

    List<Client> toEntityList(List<ClientRequestDto> dtos);

    ClientResponseDto toResponseDto(Client client);

    List<ClientResponseDto> toResponseDtoList(List<Client> clients);

    void updateEntityFromDto(ClientRequestDto dto, @MappingTarget Client client);
}