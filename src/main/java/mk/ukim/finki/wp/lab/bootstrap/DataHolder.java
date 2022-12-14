//package mk.ukim.finki.wp.lab.bootstrap;
//
//import lombok.Getter;
//import mk.ukim.finki.wp.lab.model.Course;
//import mk.ukim.finki.wp.lab.model.Student;
//import mk.ukim.finki.wp.lab.model.Teacher;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DataHolder{
//    public static List<Student> students;
//    public static List<Course> courses;
//    public static List<Teacher> teachers;
//
//    @PostConstruct
//    public void init(){
//        students = new ArrayList<>();
//        courses = new ArrayList<>();
//        teachers = new ArrayList<>();
//        teachers.add(new Teacher("teacher1", "surname1"));
//        teachers.add(new Teacher("teacher2", "surname2"));
//        teachers.add(new Teacher("teacher3", "surname3"));
//        teachers.add(new Teacher("teacher4", "surname4"));
//        teachers.add(new Teacher("teacher5", "surname5"));
//
//        students.add(new Student("petar.petrov", "111","Petar","Petrov"));
//        students.add(new Student("mila.mileva", "222","Mila","Mileva"));
//        students.add(new Student("spiro.spirov","333","Spiro","Spirov"));
//        students.add(new Student("pero.antic","444","Pero","Antic"));
//        students.add(new Student("stole.stoilov","555","Stole","Stoilov"));
//
//        courses = new ArrayList<>();
//        courses.add(new Course("Algorithms and Data Structures","mandatory course", teachers.get(0)));
//        courses.add(new Course("Advanced Programming","elective course", teachers.get(1)));
//        courses.add(new Course("Operating Systems","mandatory course", teachers.get(2)));
//        courses.add(new Course("Databases","mandatory course", teachers.get(3)));
//        courses.add(new Course("Web Programming","elective course", teachers.get(4)));
//    }
//}