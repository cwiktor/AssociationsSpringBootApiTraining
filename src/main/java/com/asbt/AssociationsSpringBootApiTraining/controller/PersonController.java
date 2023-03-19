package com.asbt.AssociationsSpringBootApiTraining.controller;

import com.asbt.AssociationsSpringBootApiTraining.model.Address;
import com.asbt.AssociationsSpringBootApiTraining.model.Person;
import com.asbt.AssociationsSpringBootApiTraining.service.AddressService;
import com.asbt.AssociationsSpringBootApiTraining.service.PersonService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;
    private final AddressService addressService;
    public PersonController(PersonService personService, AddressService addressService) {
        this.personService = personService;
        this.addressService = addressService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Person>> getAllPersons(){
        List<Person> personList = personService.getAllPersons();
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id){
        Person person = personService.getPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        personService.addPerson(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){
        personService.updatePerson(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<Person> deletePersonById(@PathVariable("id") Long id){
        personService.deletePersonById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update/{personId}/address/{addressId}")
    public ResponseEntity<Person> addAddressToPerson(
            @PathVariable("personId") Long personId,
            @PathVariable("addressId") Long addressId){
        Person person = personService.getPersonById(personId);
        Address address = addressService.getAddressById(addressId);
        person.setAddress(address);
        personService.updatePerson(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
