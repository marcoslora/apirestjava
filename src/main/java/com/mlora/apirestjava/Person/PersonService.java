package com.mlora.apirestjava.Person;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {
    
    private final PersonRepository personRepo;
    public Iterable<Person> getAllPersons() {
        return personRepo.findAll();
    }

    public void createPerson(Person person) {
        personRepo.save(person);
    }
    public Person getPersonById(Integer id) {
        return personRepo.findById(id).orElse(null);
    }
    public void updatePerson(Person person) {

        Person existingPerson = personRepo.findById(person.getId())
                                        .orElseThrow(() -> new RuntimeException("Person not found"));
      
        if(person.getFirtsName() != null) {
          existingPerson.setFirtsName(person.getFirtsName());
        }
      
        if(person.getLastName() != null) {
          existingPerson.setLastName(person.getLastName());
        }
        if(person.getEmail() != null) {
            existingPerson.setEmail(person.getEmail()); 
        }
      
        personRepo.save(existingPerson);
      
      }
    public void deletePerson(Integer id) {
        personRepo.deleteById(id);
    }


}
