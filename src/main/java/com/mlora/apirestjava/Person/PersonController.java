package com.mlora.apirestjava.Person;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    public final PersonService personService;
    @GetMapping
    public String hello() {
        return "Hello World";
    }
    @GetMapping("/allPersons")
    public ResponseEntity<Iterable<Person>> getAllPersons() {
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Integer id) {
        Person person = personService.getPersonById(id);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    @PostMapping("/create")
    public void createPerson(@RequestBody Person person ) {
        
        personService.createPerson(person);
    }
   @PutMapping("/{id}")
   public ResponseEntity<Void> updatePerson(@PathVariable Integer id, @RequestBody Person person) {

    Person existingPerson = personService.getPersonById(id);
    if (existingPerson == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    person.setId(id);
    personService.updatePerson(person);
    return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Integer id) {
        Person existingPerson = personService.getPersonById(id);
        if (existingPerson == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
