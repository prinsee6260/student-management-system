package com.student.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student2")
public class Student {
	private String name;
	@Id
	private int id;
	private int rollNumber;

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

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", rollNumber=" + rollNumber + "]";
	}

	public Student(String name, int id, int rollNumber) {
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
