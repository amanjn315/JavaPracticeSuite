package main.java.modules.streams;

import main.java.models.Student;

import javax.swing.text.html.Option;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
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

    public static Map<String, Double> averageScoreByGrade(List<Student> students){
        return students.stream()
                .collect(Collectors.groupingBy(
                        s -> getGrade(s.getScore()),
                        Collectors.averagingInt(s -> s.getScore())
                ));
    }

    public static Map<String, Student> topScorerByGrade(List<Student> students){
        return students.stream()
                .collect(Collectors.groupingBy(
                        s -> getGrade(s.getScore()),
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Student::getScore)),
                                Optional::get
                        )
                ));
    }
}
