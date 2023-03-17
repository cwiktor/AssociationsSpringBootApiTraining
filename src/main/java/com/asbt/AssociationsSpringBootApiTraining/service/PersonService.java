package com.asbt.AssociationsSpringBootApiTraining.service;

import com.asbt.AssociationsSpringBootApiTraining.model.Person;
import com.asbt.AssociationsSpringBootApiTraining.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    //@Autowired ?????
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public Person addPerson(Person person){
        return personRepository.save(person);
    }
    public Person getPersonById(Long personId){
        return personRepository.getPersonById(personId);
    }
    public List<Person> getAllPersons(){
        List<Person> personList = personRepository.findAll();
        return personList;
    }
    public Person updatePerson(Person person){
        return personRepository.save(person);
    }
    public void deletePersonById(Long personId){
        personRepository.deleteById(personId);
    }
}
