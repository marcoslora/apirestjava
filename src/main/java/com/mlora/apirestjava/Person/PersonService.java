package com.mlora.apirestjava.Person;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {
    
    private final PersonRepository personRepo;

    public void createPerson(Person person) {
        personRepo.save(person);
    }

}
