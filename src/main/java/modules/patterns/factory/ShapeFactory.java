package main.java.modules.patterns.factory;

/**
 * @author amanjain
 **/
public class ShapeFactory {
    public static Shape getShape(String type){
        switch (type.toLowerCase()){
            case "circle": return new Circle();
            case "rectangle": return new Rectangle();
            default: throw new IllegalArgumentException("Unknown shape: " + type);
        }
    }
}
