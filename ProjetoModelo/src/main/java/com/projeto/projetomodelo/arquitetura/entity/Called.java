package com.projeto.projetomodelo.arquitetura.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Called {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    protected Integer id;
    //@NotNull
    protected Date openedAt;
    //@NotNull
    protected Date closedAt;
    //@NotNull
    protected String priority;
    //@NotNull
    protected String status;
    //@NotNull
    protected String title;
    protected String observation;

    public Called() {
    }

    public Called(Integer id, Date openedAt, Date closedAt, String priority, String status, String title,
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

    public Date getOpenedAt() {
        return openedAt;
    }

    public void setOpenedAt(Date openedAt) {
        this.openedAt = openedAt;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
