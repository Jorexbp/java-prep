package base.concurrency.additional.virtualThreads;

public class VirtualThreadsIntro {

    /*
       Los Virtual Threads (Java 21+) son hilos *ligeros* gestionados por la JVM,
       no mapeados 1:1 a hilos del SO. Permiten escalar a miles/millones de tareas
       bloqueantes (I/O) sin el coste de los hilos de plataforma.

       ► Idea clave:
         - Mismo modelo de programación (Thread/Runnable), pero mucho más baratos.
         - Scheduling cooperativo por la JVM; el bloqueo I/O desparquea el VT.
    */

    /*                             KEY FEATURES                            */

    /*
        - Creación masiva y barata de hilos.
        - API familiar:
            * Thread.ofVirtual().start(runnable)
            * Executors.newVirtualThreadPerTaskExecutor()
        - Excelente para I/O-bound (HTTP, DB), donde los hilos se bloquean.
        - No sustituyen a los pools tradicionales en CPU-bound intensivos.
    */

    /*                            VENTAJAS                                 */

    /*
        - Simplifican código asíncrono: puedes escribir estilo bloqueante sin penalizar escalabilidad.
        - Reducen la necesidad de callbacks y pirámides de CompletableFuture para I/O.
        - Integración con Structured Concurrency (JEPs relacionadas).
    */

    /*                            EJEMPLOS (idea)                          */

    /*
        Thread.ofVirtual().start(() -> hacerHttp());
        try (var exec = Executors.newVirtualThreadPerTaskExecutor()) {
            exec.submit(() -> llamarServicio());
        }
    */

    /*                         NOTA DE COMPATIBILIDAD                       */

    /*
        - Requiere Java 21+ para uso estable.
        - En versiones anteriores existía como preview/incubating.
    */
}
