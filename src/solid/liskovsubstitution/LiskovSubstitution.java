package solid.liskovsubstitution;

/*
   L → Liskov Substitution Principle (LSP)

   ► "Los objetos de una subclase deben poder sustituir a los de su superclase
      sin alterar el comportamiento esperado".
   - Una subclase no debe romper la lógica de la clase base.

   Ejemplo malo: un Pingüino no debería heredar de Ave que vuela.
*/

class Bird {
    void eat() { System.out.println("El ave está comiendo"); }
}

class FlyingBird extends Bird {
    void fly() { System.out.println("Estoy volando"); }
}

class Sparrow extends FlyingBird { }
class Penguin extends Bird { }

public class LiskovSubstitution {
    public static void main(String[] args) {
        Bird b1 = new Sparrow(); // sustituible
        b1.eat();

        Bird b2 = new Penguin(); // sustituible sin romper lógica
        b2.eat();
    }
}
