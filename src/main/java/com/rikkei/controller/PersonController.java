package com.rikkei.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestParam;  

import com.rikkei.entity.Person;
import com.rikkei.service.PersonService;

/* Các lớp controller có tác dụng kết nối 
 * giữa phần giao diện với phần xử lý logic nghiệp vụ service
 */

@Controller //Giúp Spring xác định lớp hiện tại là controller
public class PersonController {  
	  @Autowired 
	  private PersonService personService;  
	  
	  /* Một số HTTP method:
	   * 	GET: được sử dụng để lấy thông tin từ sever theo URI đã cung cấp.
	   * 	POST: gửi thông tin tới sever thông qua các biểu mẫu http.
	   * 	PUT: ghi đè tất cả thông tin của đối tượng với những gì được gửi lên.
	   * 	DELETE: xóa tài nguyên trên server.
	   */
	  
	  /* xác định phương thức index() sẽ đón nhận các request 
	   * có HTTP method là GET và URI pattern là "/" hoặc "/index"
	   * (Do method mặc định nếu không khai báo là GET)
	   */	  
	  @RequestMapping(value = {"/", "/index"})  
	  public String index(Model model) {  //Object model có nhiệm vụ truyền dữ liệu từ controller đến view.
	    List<Person> persons = personService.getAllPerson();   
	    model.addAttribute("person", persons); 
	    return "index";  //String "index" giúp spring hiểu view là file index.html.
	  }  

	  @RequestMapping(value = "/add")  
	  @Secured("ROLE_ADMIN") //Annotation phục vụ cho authorization của spring security
	  						 //chỉ những user được phân quyền admin mới có thể request đến phương thức này.
	  public String addPerson(Model model) {  
	    model.addAttribute("person", new Person());  
	    return "addPerson";  
	  }  

	  @RequestMapping(value = "/edit", method = RequestMethod.GET)  
	  @Secured("ROLE_ADMIN") 						 
	  public String editPerson(@RequestParam("id") Long personId, Model model) {  
	    Optional<Person> personEdit = personService.findPersonById(personId);  
	    personEdit.ifPresent(person -> model.addAttribute("person", person));  
	    return "editPerson";  
	  }  

	  @RequestMapping(value = "save", method = RequestMethod.POST)  
	  public String save(Person person) {  
	    personService.savePerson(person);  
	    return "redirect:/";  
	  }  

	  @RequestMapping(value = "/delete", method = RequestMethod.GET) 
	  @Secured("ROLE_ADMIN")
	  public String deleteUser(@RequestParam("id") Long personId, Model model) {  
	    personService.deletePerson(personId);  
	    return "redirect:/";  
	  }  
	}