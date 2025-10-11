package base.concurrency.types;

public class ExpVolatile {

    /*
       volatile garantiza VISIBILIDAD entre hilos: cuando un hilo escribe en la
       variable, otros hilos leen el valor actualizado. NO da exclusión mutua.
    */

    /*                             KEY FEATURES                            */
    /*
        - Lecturas/escrituras van directo a memoria principal (no solo caché de hilo).
        - Ideal para flags de parada o estados que se leen mucho y se escriben poco.
        - No sirve para operaciones compuestas (x = x + 1) → usar synchronized/locks.
    */

    /*                              VENTAJAS                               */
    /*
        - Muy barato para comunicación simple (sin bloqueos).
        - Fácil de usar para señales (stop flags).
    */

    private volatile boolean running = true; // flag visible a todos los hilos

    public void stop() { running = false; }

    public void doWork() {
        while (running) {
            // trabajo
            System.out.println("Corriendo");
        }
        System.out.println("Hilo se detuvo con volatile");
    }

    public static void main(String[] args) throws InterruptedException {
        ExpVolatile demo = new ExpVolatile();

        Thread worker = new Thread(demo::doWork);
        worker.start();

        Thread.sleep(100);      // simulamos tiempo de trabajo
        demo.stop();            // otro hilo cambia el flag
        worker.join();          // el worker ve el cambio y termina
    }
}
