package base.streams;

public class Intro {

    /*
       En Java, los Streams fueron introducidos en Java 8 como una API para procesar
       colecciones de datos de forma declarativa y funcional. Permiten trabajar con
       secuencias de elementos mediante operaciones como filter, map, reduce, collect, etc.

       Un Stream no almacena datos por sí mismo, sino que se apoya en una fuente 
       (colección, array, I/O, generador…) y describe un "pipeline" de operaciones.

       Personalmente creo que traducirlo hace que tenga mas sentido; flujo de datos,
       asi es como actua
    */


    /*                             KEY FEATURES                            */

    /*
        - API introducida en Java 8.
        - Permite trabajar con colecciones de manera declarativa.
        - Basado en el patrón "pipeline": se encadenan operaciones.
        - Las operaciones pueden ser (IMPORTANTE CONOCER DIFERENCIA):
            * Intermedias: devuelven otro Stream (lazy).
              Ej: filter, map, sorted, distinct, limit.
            * Terminales: cierran el stream y producen un resultado.
              Ej: collect, reduce, forEach, count, anyMatch.
        - Son "lazy": las operaciones intermedias no se ejecutan hasta que
          aparece una operación terminal.
        - Soporta procesamiento paralelo con parallelStream().
    */


    /*                            VENTAJAS                                 */

    /*
        - Código más conciso y legible.
        - Permite programación funcional en Java.
        - Facilita operaciones complejas sobre colecciones (map, filter, reduce).
        - Optimización interna: el framework decide cómo iterar eficientemente.
        - Se puede ejecutar en paralelo fácilmente.
    */
}
