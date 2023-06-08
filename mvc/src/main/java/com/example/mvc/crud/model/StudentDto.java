package com.example.mvc.crud.model;

public class StudentDto {
    // DTO? (Data Transfer Object - 데이터를 주고 받는 용도의 의미임[네이밍은 규칙])
    // DAO? (Data Access Object - )
    private Long id;
    private String name;
    private String email;

    public StudentDto() {
    }

    public StudentDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
