package base.colecciones.trivia.differences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IterableVSIterator {
    /*
        - Iterable es una representacion de una serie de elementos iterables, no tiene un
        estado como elemento actual iterado, solo tiene un metodo que devuelve un Iterator
        - Iterator es un objeto en estado iterable, puedes verificar este estado con .hasNext() o
        pasar al siguiente elemento con .next()
    */

    public static void main(String[] args) {

        List<String> lista = new ArrayList<>(List.of("Java", "Spring", "Hibernate"));

        // ========= Iterable: gracias a esto funciona el for-each =========
        // for-each usa internamente lista.iterator()
        for (String elem : lista) {
            // Recorre sin necesidad de manejar un cursor manual
            System.out.println("for-each → " + elem);
        }

        // ========= Iterator: cursor manual, con control total =========
        Iterator<String> it = lista.iterator(); // obtiene el cursor

        while (it.hasNext()) {                  // ¿hay más elementos?
            String valor = it.next();           // avanza y devuelve el siguiente
            System.out.println("Iterator → " + valor);

            // remove(): elimina el último devuelto por next() de forma segura
            if ("Spring".equals(valor)) {
                it.remove();                    // elimina "Spring" sin C.M.E.
            }
        }
        System.out.println("Lista tras remove en Iterator: " + lista); // [Java, Hibernate]

        // ========= ListIterator: bidireccional y con mutación en medio =========
        // (Lo incluimos aquí por ser la “versión extendida” más útil en listas)
        ListIterator<String> lit = lista.listIterator();

        // Hacia adelante
        while (lit.hasNext()) {
            int idx = lit.nextIndex();  // índice del siguiente elemento
            String val = lit.next();    // avanza y obtiene
            System.out.println("ListIterator forward idx " + idx + " → " + val);
        }

        // Insertar en la posición actual del cursor
        lit.add("JPA"); // inserta después del último leído
        System.out.println("Tras add con ListIterator: " + lista);

        // Mover atrás y modificar el último retornado
        if (lit.hasPrevious()) {
            String previo = lit.previous(); // retrocede el cursor y obtiene
            System.out.println("ListIterator previous → " + previo);
            lit.set(previo.toUpperCase());  // reemplaza el elemento actual
        }
        System.out.println("Lista tras set en ListIterator: " + lista);
    }
}