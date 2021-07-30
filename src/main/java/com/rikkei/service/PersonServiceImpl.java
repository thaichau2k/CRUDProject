package com.rikkei.service;

import java.util.List;  
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rikkei.entity.Person;
import com.rikkei.repository.PersonRepository;  

/* Class này là để ta implement lại interface PersonService
 * và định nghĩa các method đã tạo ở interface
 */

@Service  // Giúp spring xác định đây là một lớp service xử lý logic nghiệp vụ
public class PersonServiceImpl implements PersonService {  
  @Autowired 
  private PersonRepository personRepository;  

  @Override  
  public List<Person> getAllPerson() {  
    return (List<Person>) personRepository.findAll();  
  }  

  @Override  
  public void savePerson(Person person) {  
    personRepository.save(person);  
  }  

  @Override  
  public void deletePerson(Long id) {  
    personRepository.deleteById(id);  
  }  

  @Override  
  public Optional<Person> findPersonById(Long id) {  
    return personRepository.findById(id);  
  }  
}