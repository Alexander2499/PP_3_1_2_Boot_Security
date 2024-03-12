package ru.kata.spring.boot_security.demo.model;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Set;


@Entity
@Table(name = "users")
@Component
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
//    @OneToMany(mappedBy = "roles",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private String name;


    @Column
    private int salary;

    @Column
    private String password;

    @OneToMany(mappedBy = "roles",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Role> roles;

    public User(String name, int salary, String password) {
        this.name = name;
        this.salary = salary;
        this.password = password;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", password='" + password + '\'' +
                '}';
    }
}
