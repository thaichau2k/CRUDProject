package com.rikkei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rikkei.entity.Person;

@Repository  
public interface PersonRepository extends JpaRepository<Person, Long> {};