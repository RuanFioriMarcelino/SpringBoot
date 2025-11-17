package com.projeto.projetomodelo.arquitetura.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.validator.constraints.br.CPF;

import com.projeto.projetomodelo.arquitetura.enums.Profile;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    protected String name;

    @NotBlank(message = "O CPF é obrigatório")
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 caracteres (somente números)")
    @CPF(message = "CPF inválido")
    protected String cpf;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "E-mail inválido")
    @Size(min = 5, max = 100, message = "O email deve ter entre 5 e 100 caracteres")
    protected String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    protected String password;

    @NotNull(message = "O perfil é obrigatório")
    protected Profile profile;

    @Column(nullable = false, updatable = false)
    protected LocalDateTime creationDate;


    @PrePersist    // Chamado automaticamente antes de persistir (sem precisar de auditoria)
    public void prePersist() {
        this.creationDate = LocalDateTime.now();
    }

    public Person() {
    }

    public Person(Integer id, String name, String cpf, String email, String password, Profile profile) {
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Person))
            return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", cpf=" + cpf +
                ", email=" + email + ", profile=" + profile +
                ", creationDate=" + creationDate + "]";
    }
}
