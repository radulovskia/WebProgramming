package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Grade{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Character grade;

    @OneToOne
    private Student student;

    @OneToOne
    private Course course;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    public Grade(Character grade, Student student, Course course, LocalDateTime timestamp){
        this.grade = grade;
        this.student = student;
        this.course = course;
        this.timestamp = timestamp;
    }
}