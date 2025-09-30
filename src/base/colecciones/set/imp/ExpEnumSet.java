package base.colecciones.set.imp;

import java.util.EnumSet;

public class ExpEnumSet {

    // Enum de ejemplo para las operaciones con EnumSet
    enum Dia {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }

    /*
        En Java, los EnumSet son una implementación de Set especializada para tipos enum.
        Internamente usa una representación muy eficiente (bitset), lo que hace que
        sea extremadamente rápido en memoria y tiempo para operaciones de conjuntos.

        Reglas importantes:
        - Solo admite elementos de un MISMO tipo enum.
        - No permite null (NullPointerException).
        - Mantiene el orden natural del enum (el orden de declaración de las constantes).
        - No está sincronizado.
     */


    /*                           "CONSTRUCTORES"                            */

    /*
        EnumSet no tiene constructores públicos → se crea mediante métodos de fábrica:

        - EnumSet.noneOf(Class<E> elementType)
            → Crea un EnumSet vacío para el tipo enum indicado.

        - EnumSet.allOf(Class<E> elementType)
            → Crea un EnumSet con TODAS las constantes del enum.

        - EnumSet.of(E e, E... others)
            → Crea un EnumSet con los elementos especificados.

        - EnumSet.range(E from, E to)
            → Crea un EnumSet con todas las constantes en el rango [from, to].

        - EnumSet.copyOf(Collection<E> c)
            → Crea un EnumSet a partir de otra colección de elementos del mismo enum.

        - EnumSet.complementOf(EnumSet<E> s)
            → Crea un EnumSet con el complemento (todos los elementos que NO están en s).
     */


    /*                             KEY FEATURES                            */

    /*
        - Especializado para enums (un único tipo enum por conjunto).
        - Muy eficiente en memoria y operaciones (bitset).
        - Orden natural por declaración del enum.
        - No permite null.
        - No está sincronizado (usar Collections.synchronizedSet si necesitas seguridad de hilos).
     */


    /*                            VENTAJAS                                 */

    /*
        - Rendimiento excelente (operaciones de conjunto muy rápidas).
        - Sintaxis clara con métodos de fábrica.
        - Ideal para flags/roles/estados representados por enums.
     */


    /*                           DESVENTAJAS                               */

    /*
        - Solo funciona con enums.
        - No permite null.
        - No está sincronizado.
     */


    public static void main(String[] args) {

        // EnumSet.noneOf(Class): crea un EnumSet vacío para el tipo enum dado
        EnumSet<Dia> diasVacios = EnumSet.noneOf(Dia.class);
        System.out.println("noneOf → " + diasVacios); // []

        // add(E e): añade un elemento (si ya existe, no lo duplica)
        diasVacios.add(Dia.LUNES);
        System.out.println("add(LUNES) → " + diasVacios); // [LUNES]

        // EnumSet.of(E...): crea un EnumSet con elementos específicos
        EnumSet<Dia> finde = EnumSet.of(Dia.SABADO, Dia.DOMINGO);
        System.out.println("of(SABADO, DOMINGO) → " + finde); // [SABADO, DOMINGO]

        // EnumSet.allOf(Class): contiene todas las constantes del enum
        EnumSet<Dia> todos = EnumSet.allOf(Dia.class);
        System.out.println("allOf(Dia) → " + todos); // [LUNES, ..., DOMINGO]

        // contains(Object o): true si el elemento está presente
        System.out.println("todos.contains(MIERCOLES) → " + todos.contains(Dia.MIERCOLES)); // true

        // remove(Object o): elimina el elemento si existe
        todos.remove(Dia.DOMINGO);
        System.out.println("remove(DOMINGO) → " + todos);

        // size() / isEmpty(): tamaño actual y si está vacío
        System.out.println("size() → " + todos.size() + ", isEmpty() → " + todos.isEmpty());

        // EnumSet.range(from, to): conjunto con el rango [from, to] en orden de declaración
        EnumSet<Dia> laborables = EnumSet.range(Dia.LUNES, Dia.VIERNES);
        System.out.println("range(LUNES, VIERNES) → " + laborables); // [LUNES, ..., VIERNES]

        // addAll(Collection): añade todos los elementos de otra colección
        diasVacios.addAll(laborables);
        System.out.println("addAll(laborables) → " + diasVacios); // [LUNES, ..., VIERNES]

        // EnumSet.complementOf(set): todos los elementos del enum que no están en 'laborables'
        EnumSet<Dia> noLaborables = EnumSet.complementOf(laborables);
        System.out.println("complementOf(laborables) → " + noLaborables); // [SABADO, DOMINGO]

        // iterator(): recorrer elementos (en orden natural del enum)
        System.out.print("Iterando noLaborables: ");
        for (Dia d : noLaborables) {
            System.out.print(d + " ");
        }
        System.out.println();

        // toArray(): convierte el set a un array Object[]
        Object[] arreglo = noLaborables.toArray();
        System.out.println("toArray().length → " + arreglo.length);

        // clear(): elimina todos los elementos
        noLaborables.clear();
        System.out.println("clear() → vacío=" + noLaborables.isEmpty() + ", size=" + noLaborables.size());


        // ========= MÉTODOS QUE SOLO MENCIONO / MATICES IMPORTANTES =========
        // - removeAll(Collection c): elimina todos los que estén en 'c'.
        // - retainAll(Collection c): mantiene solo los que estén en 'c'.
        // - clone(): copia superficial del EnumSet.
        // - of(E e1, E e2, E e3, ...): sobrecargas prácticas hasta varios elementos.
        // - Nota: EnumSet NO permite null → NullPointerException.
        // - Nota: Todos los elementos deben ser del mismo enum (mismo tipo).
    }
}
