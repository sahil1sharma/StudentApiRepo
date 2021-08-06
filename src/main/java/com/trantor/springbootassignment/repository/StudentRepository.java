package com.trantor.springbootassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trantor.springbootassignment.model.Student;

/**
 * Student JPA Repository. This is created using Spring Data JpaRepository.
 * 
 * @author Sahil Sharma
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
