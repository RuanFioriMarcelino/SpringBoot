package com.projeto.projetomodelo.arquitetura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.projetomodelo.arquitetura.Repository.ClientRepository;
import com.projeto.projetomodelo.arquitetura.dto.ClientRequestDto;
import com.projeto.projetomodelo.arquitetura.entity.Client;
import com.projeto.projetomodelo.arquitetura.mapper.ClientMapper;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    @Autowired
    private ClientMapper mapper;

    public Client create(ClientRequestDto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    public List<Client> listAll() {
        return repository.findAll();
    }

    public Client findBy_Id(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + id));
    }

    public Client update(Integer id, ClientRequestDto dto) {
        Client client = findBy_Id(id);
        mapper.updateEntityFromDto(dto, client);
        return repository.save(client);
    }

    public void delete(Integer id) {
        repository.deleteById(findBy_Id(id).getId());
    }

}
