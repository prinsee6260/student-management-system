package com.student.service.impl;

import com.student.model.Marks;
import com.student.model.Student;
import com.student.model.Teacher;
import com.student.repository.MarksRepository;
import com.student.repository.StudentRepository;
import com.student.repository.TeacherRepository;
import com.student.service.MarksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class MarksServiceImpl implements MarksService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MarksRepository marksRepository;

    Logger logger = LoggerFactory.getLogger(MarksService.class);

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Marks getMarksByTeacherId(int teacherId){
        Marks marks = new Marks();
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        String sub = teacher.get().getSubject();
        marks.setSubject(sub);
        marks.setMaximumMarks(100);
        return marks;
    }

    @Override
    public boolean giveMarks(int studentId, Marks marks) {

        logger.info("giveMarks started");
        try {
            Optional<Student> byId = studentRepository.findById(studentId);
            if (!byId.isPresent()) {

                logger.info("giveMarks student not found");
                return false;
            }
            logger.info("giveMarks student found");
            Student student = byId.get();
            Optional<Marks> byExaminationAndSubject = marksRepository.findByExaminationAndSubjectAndStudent(marks.getExamination(), marks.getSubject(),student);
            if(byExaminationAndSubject.isPresent()){
                Marks mark = byExaminationAndSubject.get();
                mark.setMarksObtained(marks.getMarksObtained());
                marks = mark;
            }else {
                marks.setStudent(student);
            }
            logger.info("giveMarks saving marks");
            marksRepository.save(marks);
        } catch (Exception e) {
            logger.error("giveMarks exception:{}", e);
            return false;
        }
        logger.info("giveMarks ended");
        return true;
    }
}
