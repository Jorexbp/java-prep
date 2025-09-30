package base.colecciones.map;

public class MapIntro {

    /*
        En este paquete se encuentra la introducción a los Map junto a todas sus
        implementaciones más relevantes, con explicaciones y ejemplos.
        No se incluirán todos los métodos de cada implementación, pero sí los más importantes.
     */


    /*                              MAP IMPLEMENTATIONS                              */

    /*
        Un Map representa una colección de pares clave-valor (key → value). 
        Cada clave debe ser única, mientras que los valores pueden repetirse.
        Permiten búsquedas rápidas por clave.

        INTERFACE BASE
        - Map<K,V>            → contrato general para mapas (put, get, remove, etc.).

        IMPLEMENTACIONES COMUNES
        - HashMap             → tabla hash, no garantiza orden.
        - LinkedHashMap       → tabla hash + lista enlazada; mantiene orden de inserción.
        - TreeMap             → basado en árbol rojo-negro; mantiene claves ordenadas.
        - WeakHashMap         → usa referencias débiles en claves; útil para cachés.
        - IdentityHashMap     → compara claves con == en vez de equals().
        - Hashtable           → similar a HashMap, pero sincronizado (legacy).

        CLASES ABSTRACTAS
        - AbstractMap         → clase base para crear implementaciones personalizadas.

        En este paquete encontrarás clases de ejemplo con uso y diferencias:
        - ExpHashMap
        - ExpLinkedHashMap
        - ExpTreeMap
        - ExpWeakHashMap
        - ExpIdentityHashMap
        - ExpHashtable
    */
}
