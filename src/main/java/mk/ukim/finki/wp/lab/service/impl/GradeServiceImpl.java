package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Grade;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.jpa.CourseRepository;
import mk.ukim.finki.wp.lab.repository.jpa.GradeRepository;
import mk.ukim.finki.wp.lab.repository.jpa.StudentRepository;
import mk.ukim.finki.wp.lab.service.GradeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GradeServiceImpl implements GradeService{
    private final GradeRepository gradeRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public GradeServiceImpl(GradeRepository gradeRepository, CourseRepository courseRepository, StudentRepository studentRepository){
        this.gradeRepository = gradeRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void addGrade(String grade, String username, String courseId, String timestamp){
        Long cid = Long.parseLong(courseId);
        Course c = courseRepository.findById(cid).orElseThrow();
        Student s = studentRepository.findByUsername(username);
        Character gchar = grade.charAt(0);
        LocalDateTime t = LocalDateTime.parse(timestamp);
        Grade g = new Grade(gchar,s,c,t);
        gradeRepository.save(g);
    }
}
