package com.trantor.springbootassignment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trantor.springbootassignment.model.Student;
import com.trantor.springbootassignment.service.StudentService;

import io.swagger.annotations.ApiOperation;

/**
 * Spring Rest Controller exposing all services on the student resource.
 * 
 * @author Sahil Sharma
 * 
 */
@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService service;

	@ApiOperation(value = "Retrieve all Students")
	@GetMapping
	public ResponseEntity<Object> retrieveAllStudents() {
		return service.retrieveAllStudents();
	}

	@ApiOperation(value = "Create a new student")
	@PostMapping
	public ResponseEntity<Object> createStudent(@Valid @RequestBody Student student) {
		return service.createStudent(student);
	}

	@ApiOperation(value = "Retrieve details of specific student")
	@GetMapping("/{id}")
	public ResponseEntity<Object> retrieveStudentById(@Valid @PathVariable Integer id) {
		return service.retrieveStudentById(id);
	}

	@ApiOperation(value = "Update student details")
	@PutMapping(path = "/{id}")
	public ResponseEntity<Object> updateStudent(@Valid @PathVariable Integer id, @Valid @RequestBody Student student) {
		return service.updateStudent(id, student);
	}

	@ApiOperation(value = "Delete a student")
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteStudent(@Valid @PathVariable Integer id) {
		return service.deleteStudent(id);
	}

}
