package com.projeto.projetomodelo.arquitetura.dto;

import com.projeto.projetomodelo.arquitetura.entity.Called;

public class CalledResponseDto {
    private final Integer id;
    private final String title;

    public CalledResponseDto(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public static CalledResponseDto fromEntity(Called called) {
        return new CalledResponseDto(called.getId(), called.getTitle());
    }
}
