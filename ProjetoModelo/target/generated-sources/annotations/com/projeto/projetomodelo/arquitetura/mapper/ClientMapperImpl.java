package com.projeto.projetomodelo.arquitetura.mapper;

import com.projeto.projetomodelo.arquitetura.dto.ClientRequestDto;
import com.projeto.projetomodelo.arquitetura.dto.ClientResponseDto;
import com.projeto.projetomodelo.arquitetura.entity.Client;
import com.projeto.projetomodelo.arquitetura.enums.Profile;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-17T14:41:28-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251023-0518, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client toEntity(ClientRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Client client = new Client();

        client.setName( dto.getName() );
        client.setCpf( dto.getCpf() );
        client.setEmail( dto.getEmail() );
        client.setPassword( dto.getPassword() );
        if ( dto.getProfile() != null ) {
            client.setProfile( Enum.valueOf( Profile.class, dto.getProfile() ) );
        }

        return client;
    }

    @Override
    public List<Client> toEntityList(List<ClientRequestDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( dtos.size() );
        for ( ClientRequestDto clientRequestDto : dtos ) {
            list.add( toEntity( clientRequestDto ) );
        }

        return list;
    }

    @Override
    public ClientResponseDto toResponseDto(Client client) {
        if ( client == null ) {
            return null;
        }

        Integer id = null;
        String name = null;

        id = client.getId();
        name = client.getName();

        ClientResponseDto clientResponseDto = new ClientResponseDto( id, name );

        return clientResponseDto;
    }

    @Override
    public List<ClientResponseDto> toResponseDtoList(List<Client> clients) {
        if ( clients == null ) {
            return null;
        }

        List<ClientResponseDto> list = new ArrayList<ClientResponseDto>( clients.size() );
        for ( Client client : clients ) {
            list.add( toResponseDto( client ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(ClientRequestDto dto, Client client) {
        if ( dto == null ) {
            return;
        }

        client.setName( dto.getName() );
        client.setCpf( dto.getCpf() );
        client.setEmail( dto.getEmail() );
        client.setPassword( dto.getPassword() );
        if ( dto.getProfile() != null ) {
            client.setProfile( Enum.valueOf( Profile.class, dto.getProfile() ) );
        }
        else {
            client.setProfile( null );
        }
    }
}
