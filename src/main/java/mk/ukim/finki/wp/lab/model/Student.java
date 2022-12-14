package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Student implements Comparable<Student>{
    @Id
    private String username;

    private String password;

    private String name;

    private String surname;

    public Student(String username, String password, String name, String surname){
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Student(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    @Override
    public int compareTo(Student o){
        return this.name.compareTo(o.name);
    }
}