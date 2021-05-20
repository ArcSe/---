package com.example.JPA.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Developers {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String speciality;
    private long salary;

    @OneToMany(mappedBy = "developers", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Application> application;

    public Developers(String name, String speciality, long salary) {
        this.name = name;
        this.speciality = speciality;
        this.salary = salary;
    }
}
