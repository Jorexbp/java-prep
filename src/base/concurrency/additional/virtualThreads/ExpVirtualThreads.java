package base.concurrency.additional.virtualThreads;

import java.util.concurrent.*;

public class ExpVirtualThreads {

    public static void main(String[] args) throws Exception {

        // ========== 1) Crear un Virtual Thread directamente ==========
        Thread vt = Thread.ofVirtual().start(() -> {
            System.out.println("VT name: " + Thread.currentThread());
            dormir(100);
        });
        vt.join();

        // ========== 2) Executor de virtual threads por tarea ==========
        try (ExecutorService vexec = Executors.newVirtualThreadPerTaskExecutor()) {
            var f1 = vexec.submit(() -> {
                dormir(50);
                return "uno";
            });
            var f2 = vexec.submit(() -> {
                dormir(80);
                return "dos";
            });

            System.out.println("Resultados VT: " + f1.get() + ", " + f2.get());
        }

        // ========== 3) Escalar muchas tareas I/O-like ==========
        long inicio = System.currentTimeMillis();
        try (ExecutorService vexec = Executors.newVirtualThreadPerTaskExecutor()) {
            int N = 10_000;
            CompletableFuture<?>[] cfs = new CompletableFuture[N];
            for (int i = 0; i < N; i++) {
                int id = i;
                cfs[i] = CompletableFuture.runAsync(() -> {
                    // simular I/O
                    dormir(5);
                }, vexec);
            }
            CompletableFuture.allOf(cfs).join();
        }
        long fin = System.currentTimeMillis();
        System.out.println("10k tareas (I/O simulado) con VT en " + (fin - inicio) + " ms");
    }

    static void dormir(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}
