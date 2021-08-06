package com.trantor.springbootassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.trantor.springbootassignment.controller.StudentController;
import com.trantor.springbootassignment.model.Student;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class SpringBootAssignmentApplicationTests {
	@Autowired
	StudentController controller;

	@Order(1)
	@Test
	public void testCreate() {
		Student s = new Student();
		s.setId(99);
		s.setAge(99);
		s.setName("Test Name");
		s.setGrade(99);
		s.setAddress("Chandigarh");
		assertEquals((HttpStatus.CREATED), controller.createStudent(s).getStatusCode());
	}

	@Order(2)
	@Test
	public void testRetrieveAllStudents() {
		assertEquals((HttpStatus.OK), controller.retrieveAllStudents().getStatusCode());
	}

	@Order(3)
	@Test
	public void testRetrieveStudentById() {
		Integer studentId = 99;
		assertEquals((HttpStatus.OK), controller.retrieveStudentById(studentId).getStatusCode());
	}

	@Order(4)
	@Test
	public void testUpdateStudent() {
		Integer studentId = 99;
		Student s = new Student();
		s.setId(99);
		s.setAge(99);
		s.setName("Test Name Updated");
		s.setGrade(99);
		s.setAddress("Chandigarh");
		assertEquals((HttpStatus.OK), controller.updateStudent(studentId, s).getStatusCode());
	}

	@Order(5)
	@Test
	public void testDeleteStudent() {
		Integer studentId = 99;
		assertEquals((HttpStatus.OK), controller.deleteStudent(studentId).getStatusCode());
	}

}
