package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Integer>{

}
