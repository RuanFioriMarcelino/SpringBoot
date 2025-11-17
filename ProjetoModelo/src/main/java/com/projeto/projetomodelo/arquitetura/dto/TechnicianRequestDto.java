package com.projeto.projetomodelo.arquitetura.dto;

import com.projeto.projetomodelo.arquitetura.enums.Profile;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de entrada para cadastro de técnico")
public class TechnicianRequestDto {
    private String name;
    private String cpf;
    private String email;
    private String password;
    private Profile profile;

    public TechnicianRequestDto(String name, String cpf, String email, String password, Profile profile) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.profile = profile;

    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

}
