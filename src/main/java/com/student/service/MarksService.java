package com.student.service;

import com.student.model.Marks;

public interface MarksService {

	Marks getMarksByTeacherId(int teacherId);

	public boolean giveMarks(int id, Marks marks);

}
