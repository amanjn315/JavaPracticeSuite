package main.java.app;

import main.java.models.Student;
import main.java.modules.functional.StudentActionExecutor;
import main.java.modules.functional.StudentFactory;
import main.java.modules.functional.StudentFilterEngine;
import main.java.modules.functional.StudentMapper;
import main.java.modules.streams.StudentStreamService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

import static main.java.modules.streams.StudentStreamService.getGrade;

/**
 * @author amanjain
 **/
public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to Java Practice Suite!");
        if (args.length == 0) {
            System.out.println("Please provide a module name (e.g., streams, patterns)");
            return;
        }

        String module = args[0];
        System.out.println("Selected module: " + module);

        switch(module.toLowerCase()){
            case "streams":
                runStreamsModule();
                break;
            default:
                System.out.println("Unknow module: " + module);
        }
    }

    private static void runStreamsModule() {
        List<Student> students = Arrays.asList(
                new Student("Ravi", 95),
                new Student("Tanu", 91),
                new Student("Aman", 76),
                new Student("John", 85),
                new Student("Raj", 63),
                new Student("Simran", 48)
        );

        Map<String, List<String>> grouped = StudentStreamService.groupStudentsByGrade(students);
        grouped.forEach((grade, names) -> {
            System.out.println(grade + ": " + names);
        });

        Map<String, Double> avgScores = StudentStreamService.averageScoreByGrade(students);
        avgScores.forEach((grade, avg) -> System.out.println("Average for " + grade + ": " + avg));

        Map<String, Student> topScorer = StudentStreamService.topScorerByGrade(students);
        System.out.println("Top Scorer by Grade:");
        topScorer.forEach((grade, student) -> System.out.println(grade + ": " + student.getName()));

        List<Student> passed = StudentFilterEngine.filterStudents(students, s -> s.getScore() >= 60);
        System.out.println("Passed Students: " + passed);

        StudentActionExecutor.applyToAll(students,
                s -> System.out.println("🎓 " + s.getName() + " scored " + s.getScore()));

        List<String> summaries = StudentMapper.mapStudents(students,
                s -> s.getName() + " | Score: " + s.getScore() + " | Grade: " + getGrade(s.getScore()));
        summaries.forEach(System.out::println);

        Supplier<Student> randomStudentSupplier = () -> {
            String[] names = {"Aman", "Ravi", "Raj", "Simran", "Vikas"};
            int score = new Random().nextInt(101);
            String name = names[new Random().nextInt(names.length)];
            return new Student(name, score);
        };
        List<Student> generated = StudentFactory.generateStudents(5, randomStudentSupplier);
        generated.forEach(s -> System.out.println(s.getName() + " - " + s.getScore()));
    }
}
