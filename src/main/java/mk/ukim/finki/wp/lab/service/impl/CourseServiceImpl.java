package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.exceptions.CourseAlreadyExistsException;
import mk.ukim.finki.wp.lab.model.*;
import mk.ukim.finki.wp.lab.model.enumerations.Type;
import mk.ukim.finki.wp.lab.repository.jpa.CourseRepository;
import mk.ukim.finki.wp.lab.repository.jpa.GradeRepository;
import mk.ukim.finki.wp.lab.repository.jpa.StudentRepository;
import mk.ukim.finki.wp.lab.repository.jpa.TeacherRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final GradeRepository gradeRepository;

    public CourseServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository,
                             TeacherRepository teacherRepository, GradeRepository gradeRepository){
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.gradeRepository = gradeRepository;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId){
        return courseRepository.findById(courseId).get().getStudents().stream().toList();
    }

    @Override
    @Transactional
    public void addStudentInCourse(String username, Long courseId){
        Course c = courseRepository.findById(courseId).orElseThrow();
        Student s = studentRepository.findByUsername(username);
        c.getStudents().add(s);
        courseRepository.save(c);
    }

    @Override
    public List<Course> listAll(){
        return courseRepository.findAll().stream().sorted().toList();
    }

    @Override
    public List<Course> deepSearchCourses(String text){
        return courseRepository.findAllByNameContains(text);
    }

    @Override
    public List<Grade> getGradesByCourse(Long courseId){
        return gradeRepository.findByCourse_Id(courseId);
    }

    @Override
    @Transactional
    public Course findById(Long courseId){
        return courseRepository.findById(courseId).orElseThrow();
    }

    @Override
    public void addCourse(String name, String description, Long teacherId, Type type) throws CourseAlreadyExistsException{
        if(courseRepository.existsByName(name))
            throw new CourseAlreadyExistsException(name);
        Teacher t = teacherRepository.findById(teacherId).orElseThrow();
        Course c = new Course();
        c.setName(name);
        c.setDescription(description);
        c.setTeacher(t);
        c.setType(type);
        courseRepository.save(c);
    }

    @Override
    public void editCourse(String name, String description, Long teacherId, Long courseId, Type type){
        Teacher t = teacherRepository.findById(teacherId).orElseThrow();
        Course c = courseRepository.findById(courseId).orElseThrow();
        c.setName(name);
        c.setDescription(description);
        c.setTeacher(t);
        c.setType(type);
        courseRepository.save(c);
    }

    @Override
    public void deleteCourse(Long courseId){
        courseRepository.deleteById(courseId);
    }


}
