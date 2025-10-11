package base.concurrency.types;

import java.util.concurrent.Semaphore;

public class ExpSemaphore {

    /*
       Semaphore controla el número de hilos que pueden acceder simultáneamente
       a un recurso (permits). Muy útil para limitar concurrencia (ej: pool de conexiones).
    */

    /*                             KEY FEATURES                            */
    /*
        - acquire() toma un permiso (bloquea si no hay).
        - release() devuelve un permiso.
        - Puede ser justo (fair=true) para atender en orden de llegada.
    */

    /*                              VENTAJAS                               */
    /*
        - Fácil de limitar el paralelismo en secciones o recursos.
        - Útil para throttling, rate-limiting, o pools sencillos.
    */

    private static final Semaphore sem = new Semaphore(3, true); // 3 permisos, justo

    private static void tarea(int id) {
        try {
            sem.acquire(); // si no hay permiso, espera
            System.out.println("Tarea " + id + " ENTRA");
            Thread.sleep(100); // simulamos trabajo
            System.out.println("Tarea " + id + " SALE");
        } catch (InterruptedException ignored) {
        } finally {
            sem.release(); // devuelve el permiso
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            final int id = i;
            new Thread(() -> tarea(id)).start();
        }
    }
}
