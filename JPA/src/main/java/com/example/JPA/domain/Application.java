package com.example.JPA.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;
    @ManyToOne
    @JoinColumn(name = "developer_id",
            referencedColumnName ="id")
    private Developers developers;

    public Application(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Application(String name, String country, Developers developers) {
        this.name = name;
        this.country = country;
        this.developers = developers;
    }
}
