package mk.ukim.finki.wp.lab.bootstrap;

import lombok.Getter;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder{
    public static List<Student> students = new ArrayList<>();
    public static List<Course> courses = new ArrayList<>();

    @PostConstruct
    public void init(){
        students.add(new Student("petar.petrov", "111","Petar","Petrov"));
        students.add(new Student("mila.mileva", "222","Mila","Mileva"));
        students.add(new Student("spiro.spirov","333","Spiro","Spirov"));
        students.add(new Student("pero.antic","444","Pero","Antic"));
        students.add(new Student("stole.stoilov","555","Stole","Stoilov"));

        courses.add(new Course(444444L,"Algorithms and Data Structures","mandatory course"));
        courses.add(new Course(222222L,"Advanced Programming","elective course"));
        courses.add(new Course(555555L,"Operating Systems","mandatory course"));
        courses.add(new Course(111111L,"Databases","mandatory course"));
        courses.add(new Course(333333L,"Web Programming","elective course"));
    }
}
