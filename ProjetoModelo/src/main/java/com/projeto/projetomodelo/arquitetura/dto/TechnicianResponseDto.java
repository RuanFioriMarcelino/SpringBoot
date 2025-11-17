package com.projeto.projetomodelo.arquitetura.dto;

import com.projeto.projetomodelo.arquitetura.entity.Technician;

public class TechnicianResponseDto {
    private final Integer id;
    private final String name;

    public TechnicianResponseDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static TechnicianResponseDto fromEntity(Technician technician) {
        return new TechnicianResponseDto(technician.getId(), technician.getName());
    }
}
