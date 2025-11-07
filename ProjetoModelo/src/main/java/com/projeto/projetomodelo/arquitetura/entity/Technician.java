package com.projeto.projetomodelo.arquitetura.entity;

import com.projeto.projetomodelo.arquitetura.enums.Profile;
import jakarta.persistence.Entity;


@Entity
public class Technician extends Person {
    
    public Technician() {
        super();
        super.setProfile(Profile.TECHNICIAN);
    }

    public Technician(Integer id, String name, String cpf, String email, String password, Profile profile) {
        super(id, name, cpf, email, password, Profile.TECHNICIAN);
    }

    @Override
    public String toString() {
        return "Technician {} " + super.toString();
    }

}
/* 
public Technician() {
    super();
    super.setProfile(com.projeto.projetomodelo.arquitetura.enums.Profile.TECHNICIAN);
} */