package com.trantor.springbootassignment.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trantor.springbootassignment.model.Response;
import com.trantor.springbootassignment.model.Student;
import com.trantor.springbootassignment.repository.StudentRepository;

/**
 * StudentService class file is used to write business logic in a different
 * layer separated from @RestController StudentController class file.
 * 
 * @author Sahil Sharma
 *
 */
@Service
public class StudentService {
	private static final Logger lOGGER = LoggerFactory.getLogger(StudentService.class.getName());
	@Autowired
	private StudentRepository repository;
	@Autowired
	private Response response;
	private ResponseEntity<Object> responseEntity;
	private String responseMessage;

	public ResponseEntity<Object> retrieveAllStudents() {
		List<Student> list = repository.findAll();
		if (list == null || list.isEmpty()) {
			responseMessage = "No Records available.";
			response.setStatus("DATA_NOT_AVAILABLE");
			response.setData(null);
			response.setMessage(responseMessage);

			responseEntity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		} else {
			responseMessage = "All records has successfull been fetched.";
			response.setStatus("DATA_AVAILABLE");
			response.setData(list);
			response.setMessage(responseMessage);
			responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
		}
		lOGGER.debug(responseMessage);
		return responseEntity;
	}

	public ResponseEntity<Object> retrieveStudentById(Integer id) {
		Optional<Student> studentOptional = repository.findById(id);
		if (studentOptional != null && studentOptional.isPresent()) {
			responseMessage = "Record for Student Id :  " + id + " has been successfully fetched.";
			response.setStatus("DATA_AVAILABLE");
			response.setMessage(responseMessage);
			response.setData(studentOptional.get());
			responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			responseMessage = "Record for Student Id : " + id + " is not found.";
			response.setStatus("DATA_NOT_AVAILABLE");
			response.setMessage(responseMessage);
			response.setData(null);
			responseEntity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		lOGGER.debug(responseMessage);
		return responseEntity;
	}

	public ResponseEntity<Object> createStudent(Student student) {
		Student savedEntity = repository.save(student);
		responseMessage = "Record has been successfully added.";
		response.setStatus("SUCCESS");
		response.setMessage(responseMessage);
		response.setData(savedEntity);
		lOGGER.debug(responseMessage);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	public ResponseEntity<Object> deleteStudent(Integer id) {
		Optional<Student> studentOptional = repository.findById(id);
		if (studentOptional.isPresent()) {
			repository.deleteById(id);
			responseMessage = "Record has been successfully deleted.";
			response.setStatus("SUCCESS");
			response.setMessage(responseMessage);
			responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			responseMessage = "Record with Student Id : " + id + " is not present.";
			response.setStatus("FAILED");
			response.setData(null);
			response.setMessage(responseMessage);
			responseEntity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		lOGGER.debug(responseMessage);
		return responseEntity;
	}

	public ResponseEntity<Object> updateStudent(Integer id, Student student) {
		Optional<Student> studentOptional = repository.findById(id);
		if (studentOptional.isPresent()) {
			responseMessage = "Successfull! Record for Student Id : " + id + " has been updated.";
			student.setId(id);
			repository.save(student);
			response.setStatus("SUCCESS");
			response.setMessage(responseMessage);
			response.setData(student);
			responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			responseMessage = "Record for Student Id : " + id + " not found.";
			response.setStatus("DATA_NOT_AVAILABLE");
			response.setMessage(responseMessage);
			responseEntity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		lOGGER.debug(responseMessage);
		return responseEntity;
	}

}
