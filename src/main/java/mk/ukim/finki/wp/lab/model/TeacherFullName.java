package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class TeacherFullName implements Serializable{
    private String name;
    private String surname;

    @Override
    public String toString(){
        return name+' '+surname;
    }
}
