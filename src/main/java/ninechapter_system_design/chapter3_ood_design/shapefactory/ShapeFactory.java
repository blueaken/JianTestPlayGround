package ninechapter_system_design.chapter3_ood_design.shapefactory;

/**
 * Author: blueaken
 * Date: 3/22/16 3:39 AM
 */
/**
 * Your object will be instantiated and called as such:
 * ShapeFactory sf = new ShapeFactory();
 * Shape shape = sf.getShape(shapeType);
 * shape.draw();
 */
interface Shape {
    void draw();
}

class Rectangle implements Shape {
    // Write your code here
    @Override
    public void draw() {
        System.out.println(" ---- ");
        System.out.println("|    |");
        System.out.println("|    |");
        System.out.println(" ---- ");
    }
}

class Square implements Shape {
    // Write your code here
    @Override
    public void draw() {
        System.out.println(" ---- ");
        System.out.println("|    |");
        System.out.println(" ---- ");
    }
}

class Triangle implements Shape {
    // Write your code here
    @Override
    public void draw() {
        System.out.println("   /\\");
        System.out.println("  /  \\ ");
        System.out.println(" /____\\ ");
    }
}

public class ShapeFactory {
    /**
     * @param shapeType a string
     * @return Get object of type Shape
     */
    public Shape getShape(String shapeType) {
        // Write your code here
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equals("Square")) {
            return new Square();
        }
        if (shapeType.equals("Triangle")) {
            return new Triangle();
        }
        if (shapeType.equals("Rectangle")) {
            return new Rectangle();
        }
        return null;
    }
}