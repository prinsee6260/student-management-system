package com.student.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Marks")
public class Marks {
	@Id
	@GeneratedValue
	private int id;
	private int marksObtained;
	private int maximumMarks;
	private String subject;
	private String examination;
	@ManyToOne
	@JoinColumn(name = "Student_Id")
	@JsonIgnore
	private Student student;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

	public int getMaximumMarks() {
		return maximumMarks;
	}

	public void setMaximumMarks(int maximumMarks) {
		this.maximumMarks = maximumMarks;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getExamination() {
		return examination;
	}

	public void setExamination(String examination) {
		this.examination = examination;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Marks [id=" + id + ", marksObtained=" + marksObtained + ", maximumMarks=" + maximumMarks + ", subject="
				+ subject + ", examination=" + examination + ", student=" + student + "]";
	}

	public Marks(int id, int marksObtained, int maximumMarks, String subject, String examination, Student student) {
		super();
		this.id = id;
		this.marksObtained = marksObtained;
		this.maximumMarks = maximumMarks;
		this.subject = subject;
		this.examination = examination;
		this.student = student;
	}

	public Marks() {
		super();
		// TODO Auto-generated constructor stub
	}

}
