package main.java.modules.functional;

/**
 * @author amanjain
 **/

import main.java.models.Student;

import java.util.List;
import java.util.function.Predicate;

public class StudentFilterEngine {
    public static List<Student> filterStudents(List<Student> students, Predicate<Student> condition){
        return students.stream().filter(condition).toList();
    }
}
