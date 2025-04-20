package model;

import enums.UserRole;

import java.util.UUID;

public abstract class User {
    protected final String id;
    protected String name;
    protected String email;

    protected User(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }

    public abstract UserRole getRole();

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
