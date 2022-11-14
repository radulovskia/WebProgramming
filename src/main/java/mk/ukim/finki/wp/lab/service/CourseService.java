package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.exceptions.CourseAlreadyExistsException;
import mk.ukim.finki.wp.lab.exceptions.CourseNotFoundException;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;

import java.util.List;

public interface CourseService{
    List<Student> listStudentsByCourse(Long courseId);
    List<Course> listAll();
    void addStudentInCourse(String username, Long courseId);
    Course findById(Long courseId);
    void addCourse(String name, String description, Long teacherId) throws CourseAlreadyExistsException;
    void editCourse(String name, String description, Long teacherId, Long courseId) throws CourseNotFoundException;
    void deleteCourse(Long courseId);
}
