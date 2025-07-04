package main.java.modules.patterns.factory;

/**
 * @author amanjain
 **/
public class FactoryDemo {
    public static void main(String[] args){
        Shape s1 = ShapeFactory.getShape("circle");
        s1.draw();

        Shape s2 = ShapeFactory.getShape("rectangle");
        s2.draw();
    }
}
