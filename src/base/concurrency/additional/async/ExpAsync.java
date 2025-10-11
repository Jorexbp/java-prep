package base.concurrency.additional.async;

import java.util.concurrent.*;
import java.util.*;
import java.util.stream.Collectors;

public class ExpAsync {

    public static void main(String[] args) throws Exception {

        // ========== ExecutorService básico ==========
        ExecutorService pool = Executors.newFixedThreadPool(4);

        Future<Integer> res = pool.submit(() -> {
            TimeUnit.MILLISECONDS.sleep(100);
            return 42;
        });

        System.out.println("Future.get() -> " + res.get()); // bloquea hasta tener resultado

        // invokeAll: ejecutar varias Callables y esperar todos
        List<Callable<String>> tareas = List.of(
                () -> "A", () -> "B", () -> "C"
        );
        List<Future<String>> resultados = pool.invokeAll(tareas);
        System.out.println("invokeAll -> " + resultados.stream()
                .map(f -> {
                    try { return f.get(); } catch (Exception e) { return "err"; }
                })
                .collect(Collectors.toList()));

        // ========== CompletableFuture: pipeline asíncrono ==========
        CompletableFuture<String> cf =
                CompletableFuture.supplyAsync(() -> {
                    dormir(80);
                    return "java";
                }, pool) // usar el pool explícito
                .thenApply(String::toUpperCase)       // transforma
                .thenCompose(s ->                      // encadena otra tarea asíncrona
                        CompletableFuture.supplyAsync(() -> s + " ROCKS!", pool))
                .exceptionally(ex -> "RECUPERADO: " + ex.getMessage());

        System.out.println("CompletableFuture -> " + cf.get());

        // Combinar dos tareas independientes
        CompletableFuture<Integer> a = CompletableFuture.supplyAsync(() -> {
            dormir(50); return 10;
        }, pool);

        CompletableFuture<Integer> b = CompletableFuture.supplyAsync(() -> {
            dormir(60); return 32;
        }, pool);

        CompletableFuture<Integer> suma = a.thenCombine(b, Integer::sum);
        System.out.println("thenCombine -> " + suma.get());

        // Coordinar varias: allOf
        CompletableFuture<Void> all = CompletableFuture.allOf(
                tarea("T1", 40),
                tarea("T2", 70),
                tarea("T3", 20)
        );
        all.join(); // esperar a todos (no arroja resultado)

        pool.shutdown();
    }

    static void dormir(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }

    static CompletableFuture<Void> tarea(String nombre, long ms) {
        return CompletableFuture.runAsync(() -> {
            dormir(ms);
            System.out.println(nombre + " ok");
        });
    }
}
