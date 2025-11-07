package com.projeto.projetomodelo.arquitetura.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.projetomodelo.arquitetura.entity.Called;


public interface CalledRepository extends JpaRepository<Called, Long> {

}