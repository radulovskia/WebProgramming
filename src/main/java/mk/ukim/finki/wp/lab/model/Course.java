package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Course{
    private Long id;
    private String name;
    private String description;
    private Teacher teacher;
    private List<Student> students;

    public Course(String name, String description, Teacher teacher){
        this.id = new Random().nextLong(10000);
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }
}
