package com.projeto.projetomodelo.arquitetura.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

import com.projeto.projetomodelo.arquitetura.dto.ClientRequestDto;
import com.projeto.projetomodelo.arquitetura.dto.ClientResponseDto;
import com.projeto.projetomodelo.arquitetura.entity.Client;
import com.projeto.projetomodelo.arquitetura.entity.Person;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    //Person toPerson(ClientRequestDto dto);

    //@InheritConfiguration(name = "toPerson")
    Client toEntity(ClientRequestDto dto);

    List<Client> toEntityList(List<ClientRequestDto> dtos);

    ClientResponseDto toResponseDto(Client client);

    List<ClientResponseDto> toResponseDtoList(List<Client> clients);

    //@Mapping(target = "id", ignore = true)
    //@Mapping(target = "creationDate", ignore = true)

    void updateEntityFromDto(ClientRequestDto dto, @MappingTarget Client client);
}