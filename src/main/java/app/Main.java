package main.java.app;

import main.java.models.Student;
import main.java.modules.streams.StudentStreamService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    }
}
