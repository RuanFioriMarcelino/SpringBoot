package com.projeto.projetomodelo.arquitetura.enums;

public enum Status {
    OPEN(1, "Open"), IN_PROGRESS(2, "In Progress"), CLOSED(3, "Closed");

    private final int id;
    private final String description;

    Status(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static Status toEnum(Integer id) {
        if (id == null) {
            return null;
        }
        for (Status status : Status.values()) {
            if (id.equals(status.getId())) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid ID: " + id);
    }

    public static String getDescriptionId(Integer id) {
        Status status = toEnum(id);
        return status != null ? status.getDescription() : null;
    }
}
