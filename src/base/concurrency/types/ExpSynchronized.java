package base.concurrency.types;

public class ExpSynchronized {

    /*
       synchronized asegura exclusión mutua: solo un hilo a la vez entra en
       una sección crítica (métod0 o bloque sincronizado) sobre el MISMO monitor/lock.
    */

    /*                             KEY FEATURES                            */
    /*
        - Se puede aplicar a métodos o a bloques: synchronized (obj).
        - Garantiza: exclusión mutua + visibilidad (flush de memoria al entrar/salir).
        - El “monitor” es el lock implícito del objeto (this) o de la clase (para static).
    */

    /*                              VENTAJAS                               */
    /*
        - Sintaxis simple, integrada en el lenguaje.
        - Suficiente para muchos casos de exclusión mutua.
    */

    private int contador = 0;

    // Métod0 sincronizado (lock: this)
    // Prueba a quitar syncronized y ejecutar
    public synchronized void incMetodo() {
        contador++;
    }

    // Bloque sincronizado (lock: this)
    public void incBloque() {
        synchronized (this) {
            contador++;
        }
    }

    public int getContador() { return contador; }

    public static void main(String[] args) throws InterruptedException {
        ExpSynchronized demo = new ExpSynchronized();

        Runnable tarea = () -> {
            for (int i = 0; i < 100_000; i++) {
                demo.incMetodo(); // o demo.incBloque();
            }
        };

        Thread t1 = new Thread(tarea);
        Thread t2 = new Thread(tarea);
        t1.start(); t2.start();
        t1.join();  t2.join();

        System.out.println("contador = " + demo.getContador()); // esperado 200_000
    }
}
