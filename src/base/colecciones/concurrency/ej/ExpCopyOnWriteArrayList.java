package base.colecciones.concurrency.ej;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ExpCopyOnWriteArrayList {

    /*
        CopyOnWriteArrayList es una lista thread-safe donde cada operación de escritura
        (add, set, remove) crea una COPIA del array subyacente.
        Muy útil cuando hay MUCHAS lecturas y pocas escrituras.
     */

    /*                             KEY FEATURES                            */

    /*
        - Lecturas sin bloqueo (iteradores sobre snapshot inmutable).
        - Escrituras costosas (copia del array).
        - Iteradores no reflejan cambios hechos después de su creación.
        - No lanza ConcurrentModificationException al iterar y modificar.
     */

    /*                            VENTAJAS                                 */

    /*
        - Iteración segura y muy rápida en escenarios read-mostly.
        - Sencillez para leer sin sincronización explícita.
     */

    /*                           DESVENTAJAS                               */

    /*
        - Coste alto en memoria/tiempo por copia en cada escritura.
        - No apta si hay muchas escrituras.
     */

    public static void main(String[] args) {

        CopyOnWriteArrayList<String> lista = new CopyOnWriteArrayList<>(List.of("Java", "Spring", "Hibernate"));

        // add(E): añade elemento (crea nueva copia internamente)
        lista.add("JPA");
        System.out.println("Tras add → " + lista);

        // iterator(): snapshot inmutable del estado en el momento de creación
        Iterator<String> it = lista.iterator();
        lista.add("Micronaut"); // se añade DESPUÉS de crear el iterador

        // El iterador NO verá "Micronaut"
        while (it.hasNext()) {
            System.out.println("Iterando snapshot → " + it.next());
        }
        System.out.println("Estado actual lista → " + lista);

        // set(int, E): reemplaza valor (copia interna)
        lista.set(0, "Jakarta");
        System.out.println("Tras set(0,'Jakarta') → " + lista);

        // remove(Object): elimina primera ocurrencia (copia interna)
        lista.remove("Spring");
        System.out.println("Tras remove('Spring') → " + lista);

        // contains / size
        System.out.println("contains('JPA') → " + lista.contains("JPA"));
        System.out.println("size → " + lista.size());

        // clear(): borra todos (copia a array vacío)
        lista.clear();
        System.out.println("Tras clear → size: " + lista.size());

        // ========= MÉTODOS QUE SOLO MENCIONO / MATICES IMPORTANTES =========
        // - addAll(Collection): también copia; agrupa escrituras.
        // - subList(): crea vista; ojo a semántica snapshot/actualizaciones.
    }
}
