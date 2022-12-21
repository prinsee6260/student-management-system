package com.student.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "student2")
public class Student {
	private String name;
	@Id
	@GeneratedValue
	private int id;
	private String classs;
	private Integer rollNumber;
	private int age;
	@ManyToMany
	@JoinTable(name = "Student_Teacher", joinColumns = { @JoinColumn(name = "Student_Id") }, inverseJoinColumns = {
			@JoinColumn(name = "Teacher_Id") })
	private Set<Teacher> teachers;
	@OneToMany(mappedBy ="student")
	private Set<Marks>marks;

	
	public Set<Marks> getMarks() {
		return marks;
	}

	public void setMarks(Set<Marks> marks) {
		this.marks = marks;
	}

	public int getAge() {
		return age;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public void setAge(int age) {
		this.age = age;
	}

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

	public String getClasss() {
		return classs;
	}

	public void setClasss(String classs) {
		this.classs = classs;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", classs=" + classs + ", rollNumber=" + rollNumber + ", age="
				+ age + ", teachers=" + teachers + ", marks=" + marks + "]";
	}

	public Student(String name, String classs, int id, Integer rollNumber, int age, Set<Teacher> teachers) {
		super();
		this.name = name;
		this.classs = classs;
		this.id = id;
		this.rollNumber = rollNumber;
		this.age = age;
		this.teachers = teachers;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
