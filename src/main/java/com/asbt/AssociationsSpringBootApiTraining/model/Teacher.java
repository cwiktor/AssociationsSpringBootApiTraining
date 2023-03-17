package com.asbt.AssociationsSpringBootApiTraining.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Teacher extends Person{
    private Date employmentDate;

    public Teacher(String name, String lastName, Date employmentDate) {
        super(name, lastName);
        this.employmentDate = employmentDate;
    }
}
