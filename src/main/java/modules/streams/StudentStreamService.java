package main.java.modules.streams;

import main.java.models.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
@author amanjain
**/
public class StudentStreamService {
    public static Map<String, List<String>> groupStudentsByGrade(List<Student> students){
        return students.stream()
                .collect(Collectors.groupingBy(
                        s -> getGrade(s.getScore()),
                        Collectors.mapping(Student::getName, Collectors.toList())
                ));
    }

    private static String getGrade(int score){
        if(score >= 90) return "A";
        else if(score >= 75) return "B";
        else if(score >= 60) return "C";
        else return "F";
    }
}
