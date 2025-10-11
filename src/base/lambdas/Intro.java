package base.lambdas;

public class Intro {

    /*
       En Java, las Lambdas fueron introducidas en Java 8 y representan funciones
       anónimas, es decir, bloques de código que pueden ser tratados como valores,
       asignados a variables o pasados como argumentos a métodos.

       Su mayor utilidad está en reemplazar clases anónimas que implementaban 
       interfaces funcionales (interfaces con un único métod0 abstracto).

       Ejemplo clásico: Runnable, Comparator<T>, Predicate<T>, Function<T,R>, Consumer<T>.
    */


    /*                             KEY FEATURES                            */

    /*
        - Son funciones anónimas que se pueden pasar como parámetro.
        - Se apoyan en interfaces funcionales (un solo métod0 abstracto).
        - Sintaxis: (parametros) -> { cuerpo } (existen alternativas)
        - Tipos de parámetros pueden inferirse automáticamente.
        - Soportan expresiones simples o bloques múltiples.
        - Pueden usarse con referencias a métodos (::) como atajo (Ver ejemplo, que esta curioso)

          Los method reference (::) son una manera compacta de llamar a un métod0 de una clase.
          Esta llamada se podrá hacer si el lambda recibe exactamente el mismo número y tipo de
          parámetros que el métod0 de esa clase acepta, y además devuelve el mismo tipo.

          Ejemplo con lambda:
                Function<String, String> mayus = s -> s.toUpperCase();

          Esto es sustituible por un method reference:
                Function<String, String> mayus = String::toUpperCase;

          ¿Por qué es sustituible?

          Porque el métod0 toUpperCase() de la clase String:
              - No recibe parámetros (igual que el cuerpo de la lambda, que ignora s y llama a s.toUpperCase()).
              - Devuelve un String, exactamente lo que Function<String, String> espera.

          Entonces el compilador ve que la firma de toUpperCase() encaja con la "plantilla"
          Function<String, String> → (String) -> String y hace la sustitución automáticamente
    */


    /*                            VENTAJAS                                 */

    /*
        - Reducen código repetitivo frente a clases anónimas.
        - Hacen más legible el código, especialmente en colecciones.
        - Base de la API de Streams (Esto tiene mucha chicha, preparate xD)
        - Permiten programación declarativa/funcional en Java.
    */
}
