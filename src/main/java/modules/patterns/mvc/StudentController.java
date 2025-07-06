package main.java.modules.patterns.mvc;

/**
 * @author amanjain
 **/
public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view){
        this.model = model;
        this.view = view;
    }

    public void updateView(){
        view.displayStudent(model.getName(), model.getRollNo());
    }

    public void setStudentName(String name){
        model.setName(name);
    }
}
