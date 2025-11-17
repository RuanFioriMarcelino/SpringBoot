package com.projeto.projetomodelo.arquitetura.entity;

import com.projeto.projetomodelo.arquitetura.dto.ClientRequestDto;
import com.projeto.projetomodelo.arquitetura.enums.Profile;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends Person {

    public Client() {
    }

    public Client(Integer id, String name) {
        super(id, name, null, null, null, null);

    }

    public Client(Integer id, String name, String cpf, String email, String password, Profile profile) {
        super(id, name, cpf, email, password, profile);
    }

    public void updateWithDTO(ClientRequestDto dto) {
        this.name = dto.getName();

    }

    public static Client fromDto(Integer id, ClientRequestDto dto) {
        return new Client(id, dto.getName());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Client {" + super.toString() + "}";
    }
}
