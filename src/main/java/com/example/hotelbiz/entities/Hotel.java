package com.example.hotelbiz.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "classification", nullable = false)
    private Integer classification;


    @Column(name = "open", nullable = false)
    private Boolean open;

    public Hotel() {
        //empty constructor required by jpa
    }

    public Hotel(String name, Integer classification, Boolean open) {
        this.name = name;
        this.classification = classification;
        this.open = open;
    }

}


