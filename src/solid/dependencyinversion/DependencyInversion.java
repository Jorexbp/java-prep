package solid.dependencyinversion;

/*
   D → Dependency Inversion Principle (DIP)

   ► "Depende de abstracciones, no de implementaciones".
   - Las clases de alto nivel no deben depender de clases de bajo nivel,
     ambas deben depender de abstracciones.

   Ejemplo: un interruptor controla un dispositivo genérico, no directamente una lámpara.
*/

interface Switchable {
    void turnOn();
}

class Lamp implements Switchable {
    public void turnOn() { System.out.println("La lámpara está encendida"); }
}

class Fan implements Switchable {
    public void turnOn() { System.out.println("El ventilador está encendido"); }
}

class Switch {
    private Switchable device;
    public Switch(Switchable device) { this.device = device; }
    public void toggle() { device.turnOn(); }
}

public class DependencyInversion {
    public static void main(String[] args) {
        Switchable lamp = new Lamp();
        Switchable fan = new Fan();

        Switch s1 = new Switch(lamp);
        Switch s2 = new Switch(fan);

        s1.toggle();
        s2.toggle();
    }
}
