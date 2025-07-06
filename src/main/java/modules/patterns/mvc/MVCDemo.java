package main.java.modules.patterns.mvc;

/**
 * @author amanjain
 **/
public class MVCDemo {
    public static void main(String[] args){
        Student model = new Student("Aman", "2025CS001");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();
        controller.setStudentName("Tanu");
        controller.updateView();
    }
}
