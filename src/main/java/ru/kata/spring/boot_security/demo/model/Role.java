package ru.kata.spring.boot_security.demo.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "roles")
@Component
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private  String role;

    @ManyToOne
    private User user;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
