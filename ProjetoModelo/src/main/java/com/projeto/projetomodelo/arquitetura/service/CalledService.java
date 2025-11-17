package com.projeto.projetomodelo.arquitetura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.projetomodelo.arquitetura.Repository.CalledRepository;
import com.projeto.projetomodelo.arquitetura.dto.CalledRequestDto;
import com.projeto.projetomodelo.arquitetura.entity.Called;
import com.projeto.projetomodelo.arquitetura.mapper.CalledMapper;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CalledService {
    @Autowired
    private CalledRepository repository;
    @Autowired
    private CalledMapper mapper;

    public Called create(CalledRequestDto dto) {
        return repository.save(mapper.toEntity(dto));
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
        return repository.save(called);
    }

    public void delete(Integer id) {
        repository.deleteById(findBy_Id(id).getId());
    }

}
