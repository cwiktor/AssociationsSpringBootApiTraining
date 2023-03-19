package com.asbt.AssociationsSpringBootApiTraining.repository;

import com.asbt.AssociationsSpringBootApiTraining.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> getTeacherById(Long teacherId);
}
