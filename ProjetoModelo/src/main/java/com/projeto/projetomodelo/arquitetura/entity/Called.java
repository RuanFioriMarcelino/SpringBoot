package com.projeto.projetomodelo.arquitetura.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import com.projeto.projetomodelo.arquitetura.enums.Priority;
import com.projeto.projetomodelo.arquitetura.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Called {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    protected Integer id;

    @Column(nullable = false, updatable = false)
    protected LocalDateTime openedAt;

    protected Date closedAt;

    @NotNull(message = "O campo prioridade é obrigatório")
    protected Priority priority;

    @NotNull(message = "O campo status é obrigatório")
    protected Status status;

    @NotBlank(message = "O título é um campo obrigatório")
    @Size(min = 5, message = "O título deve ter no mínimo 5 caracteres")
    protected String title;

    protected String observation;

    @PrePersist
    public void prePersist() {
        this.openedAt = LocalDateTime.now();
    }

    public Called() {
    }

    public Called(Integer id, LocalDateTime openedAt, Date closedAt, Priority priority, Status status, String title,
            String observation) {
        this.id = id;
        this.openedAt = openedAt;
        this.closedAt = closedAt;
        this.priority = priority;
        this.status = status;
        this.title = title;
        this.observation = observation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Called [id=" + id + ", openedAt=" + openedAt + ", closedAt=" +
                closedAt + ", priority=" + priority
                + ", status=" + status + ", title=" + title + ", observation=" + observation
                + "]";
    }

}
