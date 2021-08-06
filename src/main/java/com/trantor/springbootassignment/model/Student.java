package com.trantor.springbootassignment.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModelProperty;

/**
 * Student JPA Entity represents the data of a student to store in the database.
 * 
 * @author Sahil Sharma
 */
@Entity
@Table(name = "student_db")
public class Student {
	@Id
	@NotNull(message = "Id is mandatory")
	@ApiModelProperty(value = "id is mandatory and should be greater than or equal to 0")
	@Range(min = 0, message = "Id should be greater than or equal to 0")
	private Integer id;

	@NotBlank(message = "Name is mandatory")
	@ApiModelProperty(value = "name is mandatory")
	private String name;

	@NotNull(message = "Age is mandatory")
	@ApiModelProperty(value = "age is mandatory and should be in range (1-100)")
	@Range(max = 100, min = 1, message = "Age should be in range (1-100)")
	private Integer age;

	@Range(max = 100, min = 1, message = "Grade should be in range (1-100)")
	@ApiModelProperty(value = "grade should be in range (1-100)")
	private Integer grade;

	private String address;

	public Student(Integer id, String name, Integer age, Integer grade, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.address = address;
	}

	public Student() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
