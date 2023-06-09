package com.example.mvc.model;

public class Student {
    // Member Field
    private String name;
    private String email;

    // Constructor
    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getter
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
