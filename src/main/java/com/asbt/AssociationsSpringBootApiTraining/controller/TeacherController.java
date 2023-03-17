package com.asbt.AssociationsSpringBootApiTraining.controller;

import com.asbt.AssociationsSpringBootApiTraining.model.Teacher;
import com.asbt.AssociationsSpringBootApiTraining.service.TeacherService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Teacher>> getAllTeachers(){
        List<Teacher> teacherList = teacherService.getAllTeachers();
        return new ResponseEntity<>(teacherList, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") Long id){
        Teacher teacher= teacherService.getTeacherById(id);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher){
        teacherService.updateTeacher(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<Teacher> deleteTeacherById(@PathVariable("id") Long id){
        teacherService.deleteTeacherById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
