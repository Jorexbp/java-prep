package base.colecciones.set;

public class SetIntro {

    /*                              SET IMPLEMENTATIONS & INTERFACES                              */

    /*
        Un Set representa una colección que NO permite valores duplicados.
        A diferencia de List, no ofrece acceso posicional. El orden depende
        de la implementación concreta:

        IMPLEMENTACIONES BÁSICAS
        - HashSet              → Basado en hash table; sin orden definido.
        - LinkedHashSet        → Hash table + lista doblemente enlazada; mantiene orden de inserción.
        - TreeSet              → Basado en árbol rojo-negro; mantiene orden ASC por Comparable/Comparator.
        - EnumSet              → Especializado para enums; muy eficiente (bitset).
        - AbstractSet          → Clase base para crear Sets personalizados (abstracta).

        INTERFACES ORDENADAS
        - SortedSet            → Contrato para conjuntos ordenados ascendentemente (por Comparable/Comparator).
        - NavigableSet         → Extiende SortedSet con navegación (lower, floor, ceiling, higher, vistas inversas).

        IMPLEMENTACIÓN CONCURRENTE
        - ConcurrentSkipListSet → Implementación de NavigableSet basada en Skip List; thread-safe, O(log n).

        En este paquete encontrarás clases de ejemplo con uso y diferencias:
        - ExpHashSet              (hash, sin orden)
        - ExpLinkedHashSet        (orden de inserción)
        - ExpTreeSet              (ordenado por clave, rango)
        - ExpEnumSet              (para enums, factorías: of, range, allOf, complementOf)
        - ExpSortedSet            (interfaz y operaciones: headSet, tailSet, subSet, first/last)
        - ExpNavigableSet         (lower, floor, higher, ceiling, pollFirst/Last, descendingSet)
        - ExpConcurrentSkipListSet (concurrencia y orden; skip list)
    */
}
