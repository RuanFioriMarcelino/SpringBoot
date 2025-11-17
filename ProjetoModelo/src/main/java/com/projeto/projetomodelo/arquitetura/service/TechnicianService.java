package com.projeto.projetomodelo.arquitetura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.projetomodelo.arquitetura.Repository.TechnicianRepository;
import com.projeto.projetomodelo.arquitetura.dto.TechnicianRequestDto;
import com.projeto.projetomodelo.arquitetura.entity.Technician;
import com.projeto.projetomodelo.arquitetura.mapper.TechnicianMapper;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TechnicianService {
    @Autowired
    private TechnicianRepository repository;
    @Autowired
    private TechnicianMapper mapper;

    public Technician create(TechnicianRequestDto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    public List<Technician> listAll() {
        return repository.findAll();
    }

    public Technician findBy_Id(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tech não encontrado com ID: " + id));
    }

    public Technician update(Integer id, TechnicianRequestDto dto) {
        Technician Technician = findBy_Id(id);
        mapper.updateEntityFromDto(dto, Technician);
        return repository.save(Technician);
    }

    public void delete(Integer id) {
        repository.deleteById(findBy_Id(id).getId());
    }

}
