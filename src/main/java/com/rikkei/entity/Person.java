package com.rikkei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* Mục đích class: Tạo ra các đối tượng phục vụ cho phần CRUD. */
/* Một class tương ứng với một table trong database được gọi là entity. */
@Entity  //Giúp spring xác định class này là một entity. 
@Table(name = "person")  //Xác định tên bảng ánh xạ từ Database
public class Person {  
	@Id  //Xác định thuộc tính này là id trong bảng CSDL
	@GeneratedValue(strategy = GenerationType.IDENTITY)   //Xác định kiểu sinh khóa chính là Auto_increment
	private Long id;  

	@Column(name = "name")  //Xác định thuộc tính này là một cột trong bảng CSDL
	private String name;  

	@Column(name = "email")  
	private String email;  

	@Column(name = "phone")  
	private String phone;  

	public Person() {}  

	public Person(String name, String email, String phone) {  
		this.name = name;  
		this.email = email;  
		this.phone = phone;  
	}  

	public Long getId() {  
		return id;  
	}  

	public void setId(Long id) {  
		this.id = id;  
	}  

	public String getName() {  
		return name;  
	}  

	public void setName(String name) {  
		this.name = name;  
	}  

	public String getEmail() {  
		return email;  
	}  

	public void setEmail(String email) {  
		this.email = email;  
	}  

	public String getPhone() {  
		return phone;  
	}  

	public void setPhone(String phone) {  
		this.phone = phone;  
	}  
}