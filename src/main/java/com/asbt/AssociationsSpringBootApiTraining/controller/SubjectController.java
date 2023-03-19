package com.asbt.AssociationsSpringBootApiTraining.controller;

import com.asbt.AssociationsSpringBootApiTraining.model.Student;
import com.asbt.AssociationsSpringBootApiTraining.model.Subject;
import com.asbt.AssociationsSpringBootApiTraining.model.Teacher;
import com.asbt.AssociationsSpringBootApiTraining.service.StudentService;
import com.asbt.AssociationsSpringBootApiTraining.service.SubjectService;
import com.asbt.AssociationsSpringBootApiTraining.service.TeacherService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectService subjectService;
    private final TeacherService teacherService;
    private final StudentService studentService;
    public SubjectController(SubjectService subjectService, TeacherService teacherService, StudentService studentService) {
        this.subjectService = subjectService;
        this.teacherService = teacherService;
        this.studentService = studentService;
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
    @PutMapping("/update/{subjectId}/teacher/{teacherId}")
    public ResponseEntity<Subject> addTeacherToSubject(@PathVariable Long subjectId, @PathVariable Long teacherId){
        Subject subject = subjectService.getSubjectById(subjectId);
        Teacher teacher = teacherService.getTeacherById(teacherId);
        subject.setTeacher(teacher);
        subjectService.updateSubject(subject);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }
    @PutMapping("/update/{subjectId}/students/{studentId}")
    public ResponseEntity<Subject> addStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId){
        Subject subject = subjectService.getSubjectById(subjectId);
        Student student = studentService.getStudentById(studentId);
        subject.addStudent(student);
        subjectService.updateSubject(subject);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }
}
