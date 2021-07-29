package com.rikkei.service;

import java.util.List;  
import java.util.Optional;

import com.rikkei.entity.Person;  

public interface PersonService {  
  List<Person> getAllPerson();  

  void savePerson(Person person);  

  void deletePerson(Long id);  

  Optional<Person> findPersonById(Long id);  
}