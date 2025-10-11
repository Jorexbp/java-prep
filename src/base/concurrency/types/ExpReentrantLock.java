package base.concurrency.types;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class ExpReentrantLock {

    /*
       ReentrantLock es un lock explícito con más control que synchronized:
       try/finally, tryLock (no bloqueante), lockInterruptibly, y métricas (isLocked, etc.).
    */

    /*                             KEY FEATURES                            */
    /*
        - Admite reentrancia (el mismo hilo puede relockear).
        - Métodos: lock(), unlock(), tryLock(), lockInterruptibly().
        - Úsalo SIEMPRE con try/finally para soltar el lock.
    */

    /*                              VENTAJAS                               */
    /*
        - Más flexible que synchronized (intentos no bloqueantes, interrupciones).
        - Útil para evitar deadlocks con timeouts/tryLock.
    */

    private final Lock lock = new ReentrantLock();
    private int saldo = 0;

    public void ingresar(int cantidad) {
        lock.lock();
        try {
            saldo += cantidad;
        } finally {
            lock.unlock();
        }
    }

    public boolean retirarConTimeout(int cantidad, long millis) throws InterruptedException {
        if (lock.tryLock()) { // también se podría usar tryLock(timeout, unit)
            try {
                if (saldo >= cantidad) {
                    saldo -= cantidad;
                    return true;
                } else {
                    return false;
                }
            } finally {
                lock.unlock();
            }
        } else {
            // no se obtuvo el lock ahora mismo
            return false;
        }
    }

    public int getSaldo() { return saldo; }

    public static void main(String[] args) throws InterruptedException {
        ExpReentrantLock cuenta = new ExpReentrantLock();

        Runnable r = () -> {
            for (int i = 0; i < 100_000; i++) cuenta.ingresar(1);
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start(); t2.start();
        t1.join();  t2.join();

        System.out.println("Saldo tras ingresos: " + cuenta.getSaldo());

        boolean ok = cuenta.retirarConTimeout(50, 10);
        System.out.println("Retiro ok? " + ok + " | saldo=" + cuenta.getSaldo());
    }
}
