package com.projeto.projetomodelo.arquitetura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projeto.projetomodelo.arquitetura.dto.CalledRequestDto;
import com.projeto.projetomodelo.arquitetura.entity.Called;
import com.projeto.projetomodelo.arquitetura.service.CalledService;

@RestController
@RequestMapping("/called")
public class CalledController {

    @Autowired
    private CalledService service;

    @PostMapping
    public ResponseEntity<Called> create(@RequestBody CalledRequestDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Called>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Called> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findBy_Id(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Called> update(@PathVariable Integer id, @RequestBody CalledRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
