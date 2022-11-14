package mk.ukim.finki.wp.lab.exceptions;

public class CourseAlreadyExistsException extends Exception{
    public CourseAlreadyExistsException(String name){
        super("Course " + name + " already exists.");
    }
}
