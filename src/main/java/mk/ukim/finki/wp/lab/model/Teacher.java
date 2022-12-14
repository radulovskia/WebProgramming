package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.wp.lab.converters.TeacherFullNameConverter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Random;

@Data
@Entity
@NoArgsConstructor
public class Teacher{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Convert(converter = TeacherFullNameConverter.class)
    @Embedded
    private TeacherFullName fullName;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfEmployment;

    public Teacher(String name, String surname) {
        Random random = new Random();
        this.id = random.nextLong(1000000000);
        this.fullName = new TeacherFullName(name, surname);
        this.dateOfEmployment = LocalDate.now();
    }
}