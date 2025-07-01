package main.java.modules.functional;

import main.java.models.Student;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * @author amanjain
 **/
public class StudentFactory {
    public static List<Student> generateStudents(int count, Supplier<Student> generator){
        return IntStream.range(0, count)
                .mapToObj(i -> generator.get())
                .toList();
    }
}
