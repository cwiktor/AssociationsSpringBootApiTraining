package com.asbt.AssociationsSpringBootApiTraining.service;

import com.asbt.AssociationsSpringBootApiTraining.model.Teacher;
import com.asbt.AssociationsSpringBootApiTraining.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher addTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
    public Teacher getTeacherById(Long teacherId){
        return teacherRepository.getTeacherById(teacherId);
    }
    public List<Teacher> getAllTeachers(){
        List<Teacher> teacherList = teacherRepository.findAll();
        return teacherList;
    }
    public Teacher updateTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
    public void deleteTeacherById(Long teacherId){
        teacherRepository.deleteById(teacherId);
    }
}
