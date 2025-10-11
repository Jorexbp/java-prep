package base.concurrency.types;

import java.util.LinkedList;
import java.util.Queue;

public class ExpWaitNotify {

    /*
       wait()/notify()/notifyAll() coordinan hilos usando el MONITOR de un objeto.
       - wait(): suelta el lock y espera señal.
       - notify(): despierta UN hilo esperando.
       - notifyAll(): despierta TODOS los hilos esperando.
       SIEMPRE deben usarse dentro de bloques synchronized sobre el MISMO monitor.
    */

    /*                             KEY FEATURES                            */
    /*
        - Coordinación productor/consumidor sin librerías externas.
        - wait libera el lock mientras espera; notify/noifyAll señalan cambios.
        - Debe verificarse la condición en un bucle (spurious wakeups).
    */

    /*                              VENTAJAS                               */
    /*
        - Muy flexible y sin dependencias.
        - Base de muchos patrones de concurrencia clásicos.
    */

    private final Queue<Integer> cola = new LinkedList<>();
    private final int CAPACIDAD = 5;

    public void producir(int valor) throws InterruptedException {
        synchronized (cola) {
            while (cola.size() == CAPACIDAD) {     // usar while, no if
                cola.wait();                       // espera a que haya hueco
            }
            cola.add(valor);
            cola.notifyAll();                      // señal: hay datos nuevos
        }
    }

    public int consumir() throws InterruptedException {
        synchronized (cola) {
            while (cola.isEmpty()) {
                cola.wait();                       // espera a que haya datos
            }
            int v = cola.remove();
            cola.notifyAll();                      // señal: hay hueco
            return v;
        }
    }

    public static void main(String[] args) {
        ExpWaitNotify pc = new ExpWaitNotify();

        Thread productor = new Thread(() -> {
            try {
                for (int i = 1; i <= 20; i++) {
                    pc.producir(i);
                    System.out.println("Producido: " + i);
                }
            } catch (InterruptedException ignored) {
            }
        });

        Thread consumidor = new Thread(() -> {
            try {
                for (int i = 1; i <= 20; i++) {
                    int v = pc.consumir();
                    System.out.println("Consumido: " + v);
                }
            } catch (InterruptedException ignored) {
            }
        });

        productor.start();
        consumidor.start();
    }
}
