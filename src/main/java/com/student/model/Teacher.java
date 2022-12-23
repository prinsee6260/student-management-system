package com.student.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Teacher2")
public class Teacher {
	private String name;

	private String teacherId;
	private Integer age;
	private String subject;
	@jakarta.persistence.Id
	@GeneratedValue
	private int Id;
	@ManyToMany
	
	private Set<Student> students;

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Teacher(String name, Integer age, String subject, int id, Set<Student> students) {
		super();
		this.name = name;
		this.age = age;
		this.subject = subject;
		Id = id;
		this.students = students;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + ", subject=" + subject + ", Id=" + Id + ", students="
				+ students + "]";
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

}
