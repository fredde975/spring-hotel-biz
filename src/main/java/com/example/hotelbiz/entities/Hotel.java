package com.example.hotelbiz.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private Integer classification;
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


