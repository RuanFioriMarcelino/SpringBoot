package com.projeto.projetomodelo.arquitetura.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.projetomodelo.arquitetura.entity.Technician;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Integer> {

}
