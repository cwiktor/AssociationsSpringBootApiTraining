package com.asbt.AssociationsSpringBootApiTraining.repository;

import com.asbt.AssociationsSpringBootApiTraining.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> getSubjectById(Long subjectId);
}
