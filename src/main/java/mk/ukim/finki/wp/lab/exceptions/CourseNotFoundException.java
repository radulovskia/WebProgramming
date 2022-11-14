package mk.ukim.finki.wp.lab.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends Exception{
    public CourseNotFoundException(){
        super("Course not found.");
    }
}
