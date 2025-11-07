package com.projeto.projetomodelo.arquitetura.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.CreatedDate;

import com.projeto.projetomodelo.arquitetura.enums.Profile;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@MappedSuperclass
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    // @NotBlank(message = "O nome é obrigatório na Entidade Person")
    protected String name;

    // @NotBlank(message = "O CPF é obrigatório na Entidade Person")
    protected String cpf;

    // @NotBlank(message = "O email é obrigatório na Entidade Person")
    protected String email;

    // @NotBlank(message = "A senha é obrigatória na Entidade Person")
    protected String password;

    // @NotNull(message = "O perfil é obrigatório na Entidade Person")
    protected Profile profile;

    @CreatedDate
    // @NotNull
    protected LocalDateTime creationDate;

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

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", cpf=" + cpf + ", email=" + email + ", password=" + password
                + ", profile=" + profile + ", creationDate=" + creationDate + "]";
    }

}
