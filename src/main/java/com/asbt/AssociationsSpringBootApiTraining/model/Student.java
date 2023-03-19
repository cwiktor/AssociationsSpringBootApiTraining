package com.asbt.AssociationsSpringBootApiTraining.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Student extends Person{
    private String sNumber;
    @JsonIgnore
    @ManyToMany(mappedBy = "studentsList")
    private List<Subject> subjectsList = new ArrayList<>();

    public Student(String name, String lastName, String sNumber) {
        super(name, lastName);
        this.sNumber = sNumber;
    }
}
