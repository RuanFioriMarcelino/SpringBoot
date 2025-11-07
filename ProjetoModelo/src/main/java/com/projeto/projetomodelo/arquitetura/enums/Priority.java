package com.projeto.projetomodelo.arquitetura.enums;

public enum Priority {
    LOW(1, "Low"), MEDIUM(2, "Medium"), HIGH(3, "High");

    private final int id;
    private final String description;

    Priority(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static Priority toEnum(Integer id) {
        if (id == null) {
            return null;
        }
        for (Priority priority : Priority.values()) {
            if (id.equals(priority.getId())) {
                return priority;
            }
        }
        throw new IllegalArgumentException("Invalid ID: " + id);
    }

    public static String getDescriptionId(Integer id) {
        Priority priority = toEnum(id);
        return priority != null ? priority.getDescription() : null;
    }
}
