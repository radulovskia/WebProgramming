package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.exceptions.CourseAlreadyExistsException;
import mk.ukim.finki.wp.lab.exceptions.CourseNotFoundException;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.repository.CourseRepository;
import mk.ukim.finki.wp.lab.repository.StudentRepository;
import mk.ukim.finki.wp.lab.repository.TeacherRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public CourseServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository,
                             TeacherRepository teacherRepository){
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId){
        return courseRepository.findAllStudentByCourse(courseId);
    }

    @Override
    public void addStudentInCourse(String username, Long courseId){
        Course course = courseRepository.findById(courseId);
        Student student = studentRepository.findByUsername(username);
        courseRepository.addStudentToCourse(student, course);
    }

    @Override
    public List<Course> listAll(){
        return courseRepository.findAllCourses().stream().sorted(Comparator.comparing(Course::getName)).toList();
    }

    @Override
    public Course findById(Long courseId){
        return courseRepository.findById(courseId);
    }

    @Override
    public void addCourse(String name, String description, Long teacherId) throws CourseAlreadyExistsException{
        if(courseRepository.findCourseByName(name) != null)
            throw new CourseAlreadyExistsException(name);
        Teacher t = teacherRepository.findById(teacherId);
        Course c = new Course(name, description, t);
        courseRepository.addCourse(c);
    }

    @Override
    public void editCourse(String name, String description, Long teacherId, Long courseId){
        Teacher t = teacherRepository.findById(teacherId);
        Course c = new Course(name,description,t);
        courseRepository.delete(courseId);
        courseRepository.addCourse(c);
    }

    @Override
    public void deleteCourse(Long courseId){
        courseRepository.delete(courseId);
    }
}
