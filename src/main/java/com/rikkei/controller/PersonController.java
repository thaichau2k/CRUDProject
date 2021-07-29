package com.rikkei.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestParam;  

import com.rikkei.entity.Person;
import com.rikkei.service.PersonService;

@Controller  
public class PersonController {  
	  @Autowired private PersonService personService;  
	  
	  @RequestMapping("/")  
	  public String index(Model model) {  
	    List<Person> persons = personService.getAllPerson();  

	    model.addAttribute("person", persons);  

	    return "index";  
	  }  

	  @RequestMapping(value = "/add")  
	  public String addPerson(Model model) {  
	    model.addAttribute("person", new Person());  
	    return "addPerson";  
	  }  

	  @RequestMapping(value = "/edit", method = RequestMethod.GET)  
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
	  public String deleteUser(@RequestParam("id") Long personId, Model model) {  
	    personService.deletePerson(personId);  
	    return "redirect:/";  
	  }  
	}