package com.asbt.AssociationsSpringBootApiTraining.service;

import com.asbt.AssociationsSpringBootApiTraining.exceptions.SubjectNotFoundException;
import com.asbt.AssociationsSpringBootApiTraining.model.Subject;
import com.asbt.AssociationsSpringBootApiTraining.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }
    public Subject addSubject(Subject subject){
        return subjectRepository.save(subject);
    }
    public Subject getSubjectById(Long subjectId){
        return subjectRepository.getSubjectById(subjectId).orElseThrow(()-> new SubjectNotFoundException("Subject not found"));
    }
    public List<Subject> getAllSubjects(){
        List<Subject> subjectList = subjectRepository.findAll();
        return subjectList;
    }
    public Subject updateSubject(Subject subject){
        return subjectRepository.save(subject);
    }
    public void deleteSubjectById(Long subjectId){
        subjectRepository.deleteById(subjectId);
    }

}
