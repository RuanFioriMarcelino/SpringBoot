package com.projeto.projetomodelo.arquitetura.enums;

public enum Profile {

    ADMIN(1, "Administrator"), CLIENT(2, "Client"), TECHNICIAN(3, "Technician");

    private int id;
    private String description;

    Profile(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static Profile toEnum(Integer id) {
        if (id == null) {
            return null;
        }
        for (Profile profile : Profile.values()) {
            if (id.equals(profile.getId())) {
                return profile;
            }
        }
        throw new IllegalArgumentException("Invalid ID: " + id);
    }

    public static String getDescriptionId(Integer id) {
        Profile profile = toEnum(id);
        return profile != null ? profile.getDescription() : null;
    }
}