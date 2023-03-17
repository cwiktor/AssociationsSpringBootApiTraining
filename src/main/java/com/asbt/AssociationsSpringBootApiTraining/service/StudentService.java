package com.asbt.AssociationsSpringBootApiTraining.service;

import com.asbt.AssociationsSpringBootApiTraining.model.Student;
import com.asbt.AssociationsSpringBootApiTraining.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
    public Student getStudentById(Long StudentId){
        return studentRepository.getStudentById(StudentId);
    }
    public List<Student> getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }
    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }
    public void deleteStudentById(Long studentId){
        studentRepository.deleteById(studentId);
    }


}
