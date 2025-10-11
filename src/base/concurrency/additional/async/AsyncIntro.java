package base.concurrency.additional.async;

public class AsyncIntro {

    /*
       ► ExecutorService
         - Abstracción de pools de hilos: envías tareas (Runnable/Callable) y gestionas su ciclo de vida.
         - Métodos: submit, invokeAll, shutdown, shutdownNow.
         - Implementaciones: newFixedThreadPool, newCachedThreadPool, newScheduledThreadPool.

       ► CompletableFuture
         - Composición asíncrona: supplyAsync, runAsync.
         - Encadenado: thenApply, thenAccept, thenCompose, thenCombine.
         - Orquestación: allOf, anyOf.
         - Manejo de errores: exceptionally, handle, whenComplete.
         - Puede usar el ForkJoinPool común o un Executor propio.
    */

    /*                             KEY FEATURES                            */

    /*
        - Separan producción de tareas (tu código) de su ejecución (pool).
        - Permiten construir pipelines asíncronos legibles y composables.
        - Facilidad para timeouts, combinación de tareas, y recuperación ante fallos.
    */

    /*                            VENTAJAS                                 */

    /*
        - Mejor aprovechamiento de CPU en I/O-bound y tareas paralelizables.
        - Menos boilerplate que gestionar Threads manualmente.
        - Modelo declarativo para dependencias entre tareas.
    */

    /*                            EJEMPLOS (idea)                          */

    /*
        ExecutorService pool = Executors.newFixedThreadPool(4);
        Future<Integer> f = pool.submit(() -> 42);
        Integer v = f.get(); // bloquea hasta completar
        pool.shutdown();

        CompletableFuture.supplyAsync(() -> "hola")
            .thenApply(String::toUpperCase)
            .thenAccept(System.out::println);
    */
}
