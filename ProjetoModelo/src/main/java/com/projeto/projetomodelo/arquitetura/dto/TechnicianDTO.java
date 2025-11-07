package com.projeto.projetomodelo.arquitetura.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.projeto.projetomodelo.arquitetura.enums.Profile;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "DTO de entrada para cadastro de tecnico")
public class TechnicianDTO {
    //@NotNull
    private Integer id;
    //@NotNull
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    private String name;
    //@NotNull
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 caracteres")
    private String cpf;//
    @NotNull
    @Size(min = 5, max = 100, message = "O email deve ter entre 5 e 100 caracteres")
    private String email;
    //@NotNull
    @Size(min = 6, max = 18, message = "A senha deve ter entre 6 e 18 caracteres")
    private String password;
    //@NotNull
    private Profile profile;

    public TechnicianDTO() {
        super();
    }

    public TechnicianDTO(Integer id, String name, String cpf, String email, String password, Profile profile) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @PostMapping("/technician")
    public ResponseEntity<?> createTechnician(@Valid @RequestBody TechnicianDTO technicianDTO) {

        return ResponseEntity.status(HttpStatus.CREATED).body("Tecnico criado com sucesso");
    }
}
