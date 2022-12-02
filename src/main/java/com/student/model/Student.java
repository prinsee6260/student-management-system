package com.student.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student2")
public class Student {
	private String name;
	@Id
	@GeneratedValue
	private int id;
	private Integer rollNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", rollNumber=" + rollNumber + "]";
	}

	public Student(String name, int id, Integer rollNumber) {
		super();
		this.name = name;
		this.id = id;
		this.rollNumber = rollNumber;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	

} 
