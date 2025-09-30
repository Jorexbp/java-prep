package base.colecciones.utility;

public class UtilityIntro {

    /*
        En este paquete se encuentran las clases e interfaces de soporte del 
        Java Collections Framework. No son colecciones en sí mismas, sino 
        utilidades que permiten trabajar con ellas de manera más flexible.

        Incluyen herramientas para iteración, ordenación, comparaciones 
        y operaciones sobre colecciones.
     */


    /*                              UTILITY & SUPPORT CLASSES                              */

    /*
        - Collections Class
            Clase de utilidades con métodos estáticos para operar sobre colecciones:
            ordenación, búsqueda, sincronización, colecciones inmutables, etc.

        - Iterable interface
            Superinterfaz de todas las colecciones. Define el métod0 iterator()
            y permite usar foreach sobre cualquier colección.

        - Iterator
            Interfaz para recorrer colecciones de manera segura, con métodos 
            hasNext(), next() y remove().

        - ListIterator
            Extiende Iterator y añade recorrido bidireccional (anterior y siguiente),
            además de inserciones y reemplazos en medio de una lista.

        - Enumeration
            Interfaz más antigua para recorrer colecciones (pre-JCF). 
            Usada en legacy como Vector y Hashtable.

        - Comparator
            Interfaz funcional usada para definir criterios de ordenación personalizados
            en colecciones (ej: orden descendente, por campo específico, etc.).

        - Comparable
            Interfaz que implementan las clases cuyos objetos tienen un orden natural,
            mediante compareTo().
     */


    /*                           IMPORTANCIA EN EL JCF                           */

    /*
        - Hacen posible la iteración uniforme (Iterable, Iterator).
        - Proveen flexibilidad en ordenaciones y búsquedas (Comparator, Comparable).
        - Permiten trabajar con colecciones de forma más segura y consistente
          (Collections class).
        - Mantienen compatibilidad con código antiguo (Enumeration).
     */
}
