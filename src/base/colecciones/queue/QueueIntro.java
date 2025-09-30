package base.colecciones.queue;

public class QueueIntro {

    /*
        En este paquete se encuentra la introducción a las colas (Queue) junto a todas sus
        implementaciones más relevantes, con explicaciones y ejemplos.
        No se incluirán todos los métodos de cada implementación, pero sí los más importantes.
     */


    /*                              QUEUE IMPLEMENTATIONS                              */

    /*
        Una Queue representa una colección diseñada para mantener elementos en un orden
        específico para su procesamiento, generalmente FIFO (First-In, First-Out),
        aunque algunas implementaciones cambian este orden (ej: PriorityQueue).

        INTERFACE BASE
        - Queue              → define operaciones básicas de cola (offer, poll, peek).

        IMPLEMENTACIONES ABSTRACTAS
        - AbstractQueue      → clase base para implementar colas personalizadas.

        IMPLEMENTACIONES COMUNES
        - PriorityQueue      → cola basada en heap binario; ordena por prioridad natural o Comparator.
        - ConcurrentLinkedQueue → implementación concurrente (thread-safe) basada en nodos enlazados.
        - ArrayDeque         → doble extremo, soporta tanto cola (FIFO) como pila (LIFO).

        También existen variantes más específicas:
        - Deque              → cola de doble extremo (extendida por ArrayDeque).
        - BlockingQueue (subinterfaz en java.util.concurrent) → soporta operaciones bloqueantes para concurrencia.

        En este paquete encontrarás clases de ejemplo con uso y diferencias:
        - ExpAbstractQueue        (clase abstracta base)
        - ExpPriorityQueue        (ordenación por prioridad)
        - ExpConcurrentLinkedQueue (cola concurrente, no bloqueante)
        - ExpArrayDeque           (doble extremo, pila/cola)
    */
}
