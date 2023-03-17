package com.asbt.AssociationsSpringBootApiTraining.repository;

import com.asbt.AssociationsSpringBootApiTraining.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject getSubjectById(Long subjectId);
}
