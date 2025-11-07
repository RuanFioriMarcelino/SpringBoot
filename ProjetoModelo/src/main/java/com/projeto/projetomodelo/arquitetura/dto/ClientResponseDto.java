package com.projeto.projetomodelo.arquitetura.dto;

import com.projeto.projetomodelo.arquitetura.entity.Client;

public class ClientResponseDto {
    private final Integer id;
    private final String name;

    public ClientResponseDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static ClientResponseDto fromEntity(Client client) {
        return new ClientResponseDto(client.getId(), client.getName());
    }
}
