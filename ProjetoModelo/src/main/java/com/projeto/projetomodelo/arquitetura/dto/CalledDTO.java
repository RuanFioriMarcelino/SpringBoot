package com.projeto.projetomodelo.arquitetura.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CalledDTO {

    private Long id;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(min = 5, max = 300, message = "Descrição deve ter entre 5 e 300 caracteres")
    private String description;


    //@NotNull(message = "Status é obrigatório")
    private Integer statusId;

    public CalledDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
}