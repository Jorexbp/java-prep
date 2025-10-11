package solid.interfacesegregation;

/*
   I → Interface Segregation Principle (ISP)

   ► "Ningún cliente debe depender de métodos que no usa".
   - Es mejor tener interfaces pequeñas y específicas que interfaces grandes.

   Ejemplo malo: una interfaz Worker con métodos work() y eat(), obligando
   a robots a implementar eat() aunque no lo necesitan.
*/

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human implements Workable, Eatable {
    public void work() { System.out.println("El humano trabaja"); }
    public void eat() { System.out.println("El humano come"); }
}

class Robot implements Workable {
    public void work() { System.out.println("El robot trabaja"); }
}

public class InterfaceSegregation {
    public static void main(String[] args) {
        Human h = new Human();
        h.work();
        h.eat();

        Robot r = new Robot();
        r.work();
    }
}
