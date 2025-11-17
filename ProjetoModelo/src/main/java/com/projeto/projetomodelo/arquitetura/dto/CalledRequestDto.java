package com.projeto.projetomodelo.arquitetura.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import com.projeto.projetomodelo.arquitetura.enums.Priority;
import com.projeto.projetomodelo.arquitetura.enums.Status;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de entrada para cadastro de chamado")
public class CalledRequestDto {
    private LocalDateTime openedAt;
    private Date closedAt;
    private Priority priority;
    private Status status;
    private String title;
    private String observation;

    public CalledRequestDto(LocalDateTime openedAt, Date closedAt, Priority priority, Status status, String title,
            String observation) {
        this.openedAt = openedAt;
        this.closedAt = closedAt;
        this.priority = priority;
        this.status = status;
        this.title = title;
        this.observation = observation;
    }

    public LocalDateTime getOpenedAt() {
        return openedAt;
    }

    public void setOpenedAt(LocalDateTime openedAt) {
        this.openedAt = openedAt;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}