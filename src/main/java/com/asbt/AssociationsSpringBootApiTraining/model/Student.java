package com.asbt.AssociationsSpringBootApiTraining.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Student extends Person{
    private String sNumber;

    public Student(String name, String lastName, String sNumber) {
        super(name, lastName);
        this.sNumber = sNumber;
    }
}
