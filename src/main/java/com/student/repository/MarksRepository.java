package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.Marks;

public interface MarksRepository extends JpaRepository<Marks, Integer> {

}
