package com.student.repository;

import com.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.Marks;

import java.util.Optional;
import java.util.Set;

public interface MarksRepository extends JpaRepository<Marks, Integer> {

    Optional<Marks> findByExaminationAndSubjectAndStudent(String examination, String subject, Student student);

}
