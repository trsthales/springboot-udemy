package com.thales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thales.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
