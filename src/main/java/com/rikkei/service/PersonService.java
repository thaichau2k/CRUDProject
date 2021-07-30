package com.rikkei.service;

import java.util.List;  
import java.util.Optional;

import com.rikkei.entity.Person;  


/* Service là nơi xử lý các logic nghiệp vụ tùy theo dự án
 * Nghiệp vụ của CRUD:
 * 	Thêm: savePerson 
 * 	Đọc: getAllPerson
 * 	Sửa: findPersonById và savePerson
 * 	Xóa: deletePerson
 */

public interface PersonService {  
  List<Person> getAllPerson();  

  void savePerson(Person person);  

  void deletePerson(Long id);  

  Optional<Person> findPersonById(Long id);  
}