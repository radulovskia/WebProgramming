package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepository{

    public List<Course> findAllCourses(){
        return DataHolder.courses;
    }

    public Course findById(Long CourseId){
        return DataHolder.courses.stream().filter(c->Long.compare(CourseId,c.getCourseId())==0)
                .findFirst().orElse(null);
    }

    public List<Student> findAllStudentByCourse(Long courseId){
        return findById(courseId).getStudents();
    }

    public Course addStudentToCourse(Student student, Course course){

        Course c = findById(course.getCourseId());
        if(c != null){
            c.getStudents().add(student);
        }
        return course;
    }
}
