package main.java.modules.functional;

import main.java.models.Student;

import java.util.List;
import java.util.function.Function;

/**
 * @author amanjain
 **/
public class StudentMapper {
    public static List<String> mapStudents(List<Student> students, Function<Student, String> mapper){
        return students.stream()
                .map(mapper)
                .toList();
    }
}
