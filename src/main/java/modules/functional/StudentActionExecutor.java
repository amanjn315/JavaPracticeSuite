package main.java.modules.functional;

import main.java.models.Student;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author amanjain
 **/
public class StudentActionExecutor {
    public static void applyToAll(List<Student> students, Consumer<Student> action){
        students.stream()
                .forEach(action);
    }
}
