package base.concurrency;

public class ConcurrencyIntro {

    /*
       En Java, la concurrencia permite ejecutar múltiples tareas de forma
       simultánea o paralela, optimizando el uso de recursos y mejorando
       el rendimiento en aplicaciones con muchas operaciones (I/O, CPU, etc.).

       El modelo de concurrencia en Java está basado en hilos (Threads),
       sincronización de acceso a recursos compartidos y utilidades de alto
       nivel como ExecutorService, CompletableFuture o las APIs de java.util.concurrent.
    */


    /*                             KEY FEATURES                            */

    /*
        - Basado en hilos (Thread) y el paquete java.util.concurrent.
        - Permite multitarea: varias operaciones se ejecutan "al mismo tiempo".
        - Importante para aprovechar procesadores multinúcleo.
        - Herramientas principales:
            * synchronized: bloquea acceso concurrente a secciones críticas.
            * volatile: asegura visibilidad de variables entre hilos.
            * wait(), notify(), notifyAll(): coordinación básica entre hilos.
            * Locks y Semaphores: control de acceso más flexible.
            * ExecutorService: manejo avanzado de pools de hilos.
            * CompletableFuture: programación asíncrona basada en futuros.
            * Virtual Threads (Project Loom, Java 21+): hilos ligeros a gran escala.
    */


    /*                            VENTAJAS                                 */

    /*
        - Mejor rendimiento en tareas pesadas (CPU-bound).
        - Mayor capacidad de respuesta en tareas bloqueantes (I/O).
        - Divide problemas grandes en tareas concurrentes más pequeñas.
    */


    /*                            PROBLEMAS COMUNES                        */

    /*
        - Race conditions: dos hilos acceden/modifican un recurso al mismo tiempo.
        - Deadlocks: dos hilos esperan indefinidamente por recursos bloqueados.
        - Starvation: un hilo nunca obtiene acceso a CPU o recursos.
        - Problemas de visibilidad: cambios en memoria no visibles entre hilos
          sin sincronización o volatile.
    */
}
