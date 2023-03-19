package com.asbt.AssociationsSpringBootApiTraining.repository;

import com.asbt.AssociationsSpringBootApiTraining.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> getStudentById(Long studentId);
}
