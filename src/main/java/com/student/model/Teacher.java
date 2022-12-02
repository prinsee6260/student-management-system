package com.student.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

@Entity
@Table(name="Teacher2")
public class Teacher {
	private String name;
	private Integer age;
	private String subject;
	@jakarta.persistence.Id
	@GeneratedValue
	private int Id;
	

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

	@Override
	public String toString() {
		return "Teacher [Id="+Id+",name=" + name + ", age=" + age + ", subject=" + subject + "]";
	}


	
	
	public Teacher(String name, int age, String subject,int Id) {
		super();
		this.name = name;
		this.age = age;
		this.subject = subject;
		this.Id = Id;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

}
