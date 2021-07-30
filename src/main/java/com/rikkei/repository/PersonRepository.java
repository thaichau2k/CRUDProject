package com.rikkei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rikkei.entity.Person;

/* 	@Repository - Dùng để đánh dấu các class, interface 
 * thuộc tầng giao tiếp với database. 
 */
@Repository  
public interface PersonRepository extends JpaRepository<Person, Long> {};

/* 	Spring Data JPA cung cấp sẵn cho ta 3 interface để thao tác với database:
 * 		CrudRepository: có các phương thức CRUD như findAll(), save(), deleteById(),...
 * 		PagingAndSortingRepository extends từ CrudRepository: thêm các phương thức phân trang, sắp xếp,...
 * 		JpaRepository extends từ PagingAndSortingRepository: thêm các phương thức xóa theo lô,...
 * 	Các tham số của 3 interface này là tên Entity và kiểu làm khóa chính.
 */

/*	Trong interface PersonRepository này ta có thể thêm một số phương thức 
 * 	như findByName(),... tuy nhiên đây là project CRUD đơn giản nên chỉ cần
 * 	các phương thức có sẵn. 
 */
 