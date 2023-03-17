package com.asbt.AssociationsSpringBootApiTraining.controller;

import com.asbt.AssociationsSpringBootApiTraining.model.Subject;
import com.asbt.AssociationsSpringBootApiTraining.service.SubjectService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectService subjectService;
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Subject>> getAllSubjectes(){
        List<Subject> subjectList = subjectService.getAllSubjects();
        return new ResponseEntity<>(subjectList, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable("id") Long id){
        Subject subject= subjectService.getSubjectById(id);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Subject> addSubject(@RequestBody Subject subject){
        subjectService.addSubject(subject);
        return new ResponseEntity<>(subject, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject){
        subjectService.updateSubject(subject);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<Subject> deleteSubjectById(@PathVariable("id") Long id){
        subjectService.deleteSubjectById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
