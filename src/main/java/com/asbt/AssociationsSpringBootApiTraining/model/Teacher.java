package com.asbt.AssociationsSpringBootApiTraining.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Teacher extends Person{
    private Date employmentDate;
    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjectList = new ArrayList<>();
    public Teacher(String name, String lastName, Date employmentDate) {
        super(name, lastName);
        this.employmentDate = employmentDate;
    }
}
