package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Optional<Student> findByRollNumber(String rollNumber);

}
