package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.Teacher;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher,Integer>{

    Optional<Teacher> findByTeacherId(String id);
}
