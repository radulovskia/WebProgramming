//package mk.ukim.finki.wp.lab.repository.impl;
//
//import mk.ukim.finki.wp.lab.model.Course;
//import mk.ukim.finki.wp.lab.model.Student;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//import static mk.ukim.finki.wp.lab.bootstrap.DataHolder.courses;
//
//@Repository
//public class InMemoryCourseRepository{
//
//    public List<Course> findAllCourses(){
//        return courses;
//    }
//
//    public Course findById(Long CourseId){
//        return courses.stream().filter(c-> CourseId.equals(c.getId())).findFirst().orElse(null);
//    }
//
//    public List<Student> findAllStudentByCourse(Long courseId){
//        return findById(courseId).getStudents();
//    }
//
//    public Course addStudentToCourse(Student student, Course course){
//
//        Course c = findById(course.getId());
//        if(c != null){
//            c.getStudents().add(student);
//        }
//        return course;
//    }
//
//    public Course addCourse(Course course){
//        courses.add(course);
//        return course;
//    }
//
//    public void delete(Long id) {
//        courses.removeIf(c->c.getId().equals(id));
//    }
//
//    public Course findCourseByName(String name){
//        return courses.stream().filter(c->c.getName().equals(name)).findFirst().orElse(null);
//    }
//}
