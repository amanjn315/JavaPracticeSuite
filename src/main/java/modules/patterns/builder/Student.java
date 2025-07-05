package main.java.modules.patterns.builder;

/**
 * @author amanjain
 **/
public class Student {
    private String name;
    private int age;
    private String grade;
    private String email;

    private Student(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.grade = builder.grade;
        this.email = builder.email;
    }

    public static class Builder {
        private String name;
        private int age;
        private String grade;
        private String email;

        public Builder(String name){
            this.name = name;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder grade(String grade){
            this.grade = grade;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return name + ", " + age + ", " + grade + ", " + email;
    }
}
