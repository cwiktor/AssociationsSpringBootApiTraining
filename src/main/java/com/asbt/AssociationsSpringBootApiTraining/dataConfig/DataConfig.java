package com.asbt.AssociationsSpringBootApiTraining.dataConfig;

import com.asbt.AssociationsSpringBootApiTraining.model.Address;
import com.asbt.AssociationsSpringBootApiTraining.model.Student;
import com.asbt.AssociationsSpringBootApiTraining.model.Subject;
import com.asbt.AssociationsSpringBootApiTraining.model.Teacher;
import com.asbt.AssociationsSpringBootApiTraining.repository.AddressRepository;
import com.asbt.AssociationsSpringBootApiTraining.repository.StudentRepository;
import com.asbt.AssociationsSpringBootApiTraining.repository.SubjectRepository;
import com.asbt.AssociationsSpringBootApiTraining.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class DataConfig { //seed database
    @Bean
    CommandLineRunner commandLineRunner(AddressRepository addressRepository,
                                        StudentRepository studentRepository,
                                        SubjectRepository subjectRepository,
                                        TeacherRepository teacherRepository){
        return args -> {
            Address a1 = new Address("USA", "NY", "1212", "Broadway", "1");
            Address a2 = new Address("USA", "LA", "321321", "GroveStreet", "1");
            Address a3 = new Address("USA", "LA", "45555", "GroveStreet", "2");
            Address a4 = new Address("USA", "LA", "555444", "GroveStreet", "3");
            Student s1 = new Student("Peter", "Parker", "s21291");
            Student s2 = new Student("Jessica", "Nowak", "s123123");
            Student s3 = new Student("John", "Kowalski", "s434343");
            Teacher t1 = new Teacher("Steve", "Rogers", new Date());
            Teacher t2 = new Teacher("Steve", "Rogers", new Date());
            Subject sub1 = new Subject("Math");
            Subject sub2 = new Subject("Science");

            addressRepository.saveAll(List.of(
                    a1,a2,a3,a4
            ));
            studentRepository.saveAll(List.of(
                    s1,s2,s3
            ));
            teacherRepository.saveAll(List.of(
                    t1,t2
            ));
            subjectRepository.saveAll(List.of(
                    sub1,sub2
            ));

        };
    }
}