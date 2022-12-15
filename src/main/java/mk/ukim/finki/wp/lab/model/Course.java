package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.wp.lab.model.enumerations.Type;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Course implements Comparable<Course>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    private Teacher teacher;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Student> students;
    
    @Enumerated(EnumType.STRING)
    private Type type;

    @Override
    public int compareTo(Course c){
        return this.name.compareTo(c.name);
    }
}