package com.projeto.projetomodelo.arquitetura.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.projetomodelo.arquitetura.Repository.CalledRepository;
import com.projeto.projetomodelo.arquitetura.entity.Called;

import java.util.Optional;


@Service
public class CalledService {


private final CalledRepository repo;


public CalledService(CalledRepository repo) {
this.repo = repo;
}


@Transactional
public Called save(Called called) {
return repo.save(called);
}


public Optional<Called> findById(Long id) { return repo.findById(id); }


}