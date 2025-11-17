package com.projeto.projetomodelo.arquitetura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.projeto.projetomodelo.arquitetura.dto.TechnicianRequestDto;
import com.projeto.projetomodelo.arquitetura.entity.Technician;
import com.projeto.projetomodelo.arquitetura.service.TechnicianService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tech")
public class TechnicianController {

    @Autowired
    private TechnicianService service;

    @PostMapping
    public ResponseEntity<Technician> create(@RequestBody TechnicianRequestDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Technician>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technician> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findBy_Id(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Technician> update(@PathVariable Integer id, @RequestBody TechnicianRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
