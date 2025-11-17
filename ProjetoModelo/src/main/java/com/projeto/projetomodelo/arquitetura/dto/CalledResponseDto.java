package com.projeto.projetomodelo.arquitetura.dto;

import com.projeto.projetomodelo.arquitetura.entity.Called;
import java.time.LocalDateTime;
import java.util.Date;
import com.projeto.projetomodelo.arquitetura.enums.Priority;
import com.projeto.projetomodelo.arquitetura.enums.Status;

public class CalledResponseDto {

    private final Integer id;
    private final String title;
    private final Priority priority;
    private final Status status;
    private final LocalDateTime openedAt;
    private final Date closedAt;
    private final String observation;

    private final Integer clientId;
    private final String clientName;

    private final Integer technicianId;
    private final String technicianName;

    public CalledResponseDto(Integer id, String title, Priority priority, Status status, LocalDateTime openedAt,
            Date closedAt,
            String observation, Integer clientId, String clientName, Integer technicianId, String technicianName) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.status = status;
        this.openedAt = openedAt;
        this.closedAt = closedAt;
        this.observation = observation;
        this.clientId = clientId;
        this.clientName = clientName;
        this.technicianId = technicianId;
        this.technicianName = technicianName;
    }

    public static CalledResponseDto fromEntity(Called called) {

        Integer clientId = called.getClient().getId();
        String clientName = called.getClient().getName();

        Integer technicianId = called.getTechnician() != null ? called.getTechnician().getId() : null;
        String technicianName = called.getTechnician() != null ? called.getTechnician().getName() : null;

        return new CalledResponseDto(
                called.getId(),
                called.getTitle(),
                called.getPriority(),
                called.getStatus(),
                called.getOpenedAt(),
                called.getClosedAt(),
                called.getObservation(),
                clientId,
                clientName,
                technicianId,
                technicianName);
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getOpenedAt() {
        return openedAt;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    public String getObservation() {
        return observation;
    }

    public Integer getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public Integer getTechnicianId() {
        return technicianId;
    }

    public String getTechnicianName() {
        return technicianName;
    }
}