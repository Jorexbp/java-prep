package solid.openclosed;

/*
   O → Open/Closed Principle (OCP)

   ► "Las clases deben estar abiertas a extensión pero cerradas a modificación".
   - Puedes añadir nuevas funcionalidades extendiendo el código, sin modificar el existente.
   - Se logra mediante abstracciones (interfaces, clases abstractas).
*/

interface Shape {
    double area();
}

class Circle implements Shape {
    double radius;
    Circle(double r) { this.radius = r; }
    public double area() { return Math.PI * radius * radius; }
}

class Square implements Shape {
    double side;
    Square(double s) { this.side = s; }
    public double area() { return side * side; }
}

public class OpenClosed {
    public static void main(String[] args) {
        Shape c = new Circle(5);
        Shape s = new Square(4);

        System.out.println("Área círculo: " + c.area());
        System.out.println("Área cuadrado: " + s.area());
    }
}
