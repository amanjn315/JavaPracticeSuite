package main.java.modules.patterns.builder;

/**
 * @author amanjain
 **/
public class BuilderDemo {
    public static void main(String[] args){
        Student s1 = new Student.Builder("Aman")
                .age(22)
                .grade("A")
                .email("aman@example.com")
                .build();

        Student s2 = new Student.Builder("Tina")
                .grade("B")
                .build();

        System.out.println(s1);
        System.out.println(s2);
    }
}
