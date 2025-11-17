package com.projeto.projetomodelo.arquitetura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.projetomodelo.arquitetura.Repository.CalledRepository;
import com.projeto.projetomodelo.arquitetura.Repository.ClientRepository;
import com.projeto.projetomodelo.arquitetura.Repository.TechnicianRepository;
import com.projeto.projetomodelo.arquitetura.dto.CalledRequestDto;
import com.projeto.projetomodelo.arquitetura.entity.Called;
import com.projeto.projetomodelo.arquitetura.entity.Client;
import com.projeto.projetomodelo.arquitetura.entity.Technician;
import com.projeto.projetomodelo.arquitetura.mapper.CalledMapper;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class CalledService {
    @Autowired
    private CalledRepository repository;
    @Autowired
    private CalledMapper mapper;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private TechnicianRepository technicianRepository;

    public Called create(CalledRequestDto dto) {
        Called called = mapper.toEntity(dto);

        if (dto.getClient() == null || dto.getClient().getId() == null) {
            throw new IllegalArgumentException("O Cliente (ID) é obrigatório para abrir um chamado.");
        }

        Integer clientId = dto.getClient().getId();
        Client cliente = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + clientId));
        called.setClient(cliente);

        if (dto.getTechnician() != null && dto.getTechnician().getId() != null) {
            Integer technicianId = dto.getTechnician().getId();
            Technician technician = technicianRepository.findById(technicianId)
                    .orElseThrow(
                            () -> new EntityNotFoundException("Técnico não encontrado com ID: " + technicianId));
            called.setTechnician(technician);
        } else {
            called.setTechnician(null);
        }

        return repository.save(called);
    }

    public List<Called> listAll() {
        return repository.findAll();
    }

    public Called findBy_Id(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Chamado não encontrado com ID: " + id));
    }

    public Called update(Integer id, CalledRequestDto dto) {
        Called called = findBy_Id(id);
        mapper.updateEntityFromDto(dto, called);

        if (dto.getClient() != null && !dto.getClient().equals(called.getClient().getId())) {
            Client novoCliente = clientRepository.findById(dto.getClient().getId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Novo Cliente não encontrado com ID: " + dto.getClient()));
            called.setClient(novoCliente);
        }

        if (dto.getTechnician() != null) {
            Technician newTechnician = technicianRepository.findById(dto.getTechnician().getId())
                    .orElseThrow(
                            () -> new EntityNotFoundException("Técnico não encontrado com ID: " + dto.getTechnician()));
            called.setTechnician(newTechnician);
        } else if (called.getTechnician() != null) {
            called.setTechnician(null);
        }

        return repository.save(called);
    }

    public void delete(Integer id) {
        Called called = findBy_Id(id);
        repository.delete(called);
    }
}