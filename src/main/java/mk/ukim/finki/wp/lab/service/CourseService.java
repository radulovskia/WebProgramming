package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.exceptions.CourseAlreadyExistsException;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Grade;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.enumerations.Type;

import java.util.List;

public interface CourseService{
    List<Student> listStudentsByCourse(Long courseId);
    List<Course> listAll();
    List<Grade> getGradesByCourse(Long courseId);
    Course findById(Long courseId);
    void addStudentInCourse(String username, Long courseId);
    void addCourse(String name, String description, Long teacherId, Type type) throws CourseAlreadyExistsException;
    void editCourse(String name, String description, Long teacherId, Long courseId, Type type);
    void deleteCourse(Long courseId);

}
