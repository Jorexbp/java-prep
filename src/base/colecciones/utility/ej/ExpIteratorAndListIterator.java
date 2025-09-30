package base.colecciones.utility.ej;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ExpIteratorAndListIterator {

    /*
        Iterator: interfaz para recorrer colecciones de forma segura.
        ListIterator: extensión de Iterator con recorrido bidireccional
        y capacidad de modificar la lista durante la iteración.
     */


    /*                             KEY FEATURES                            */

    /*
        - Iterator: hasNext(), next(), remove().
        - ListIterator: además tiene hasPrevious(), previous(),
          add(E), set(E), nextIndex(), previousIndex().
        - Evita ConcurrentModificationException si se modifica
          con sus propios métodos.
     */


    public static void main(String[] args) {

        List<String> lista = new ArrayList<>(List.of("Java", "Spring", "Hibernate"));

        // Iterator → solo hacia adelante
        var it = lista.iterator();
        while (it.hasNext()) {
            String elem = it.next();
            if (elem.equals("Spring")) {
                it.remove(); // elimina de forma segura
            }
        }
        System.out.println("Tras Iterator.remove(): " + lista);

        // ListIterator → bidireccional
        ListIterator<String> lit = lista.listIterator();

        // Recorriendo hacia adelante
        while (lit.hasNext()) {
            System.out.println("ListIterator forward: " + lit.next());
        }

        // Recorriendo hacia atrás
        while (lit.hasPrevious()) {
            System.out.println("ListIterator backward: " + lit.previous());
        }

        // Insertar en la posición actual
        lit.add("JPA");
        System.out.println("Tras ListIterator.add(\"JPA\"): " + lista);

        // Modificar último elemento retornado
        lit.previous(); // mueve cursor atrás a "JPA"
        lit.set("Jakarta");
        System.out.println("Tras ListIterator.set(\"Jakarta\"): " + lista);
    }
}
