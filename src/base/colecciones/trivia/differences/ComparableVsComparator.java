package base.colecciones.trivia.differences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableVsComparator {

/*
    - Comparable es una interfaz que obliga a implementar el metodo .compareTo(E obj),
    con esto puedes definir su orden natural, lo que significa el como se ordenara
    - Comparator es otra manera de definir orden sin modificar la clase original
    mediante .compare(E obj1, E obj2) o con Comparator.comparing()

    Si usas Comparator.comparing() o algun metodo similar sobre un objeto con Comparable
    implementado, usara el .compareTo() como metodo de ordenacion. Aun asi, dentro de
    Collectors.comparing() puedes definir tu propio orden de ordenacion
*/

    static class Persona implements Comparable<Persona> {
        String nombre;
        int edad;

        Persona(String n, int e) {
            this.nombre = n;
            this.edad = e;
        }

        // Comparable: el ORDEN NATURAL será por edad ascendente
        @Override
        public int compareTo(Persona otra) {
            return Integer.compare(this.edad, otra.edad);
        }

        @Override
        public String toString() {
            return nombre + "(" + edad + ")";
        }
    }


    public static void main(String[] args) {

        List<Persona> personas = new ArrayList<>(List.of(
                new Persona("Ana", 30),
                new Persona("Luis", 25),
                new Persona("Marta", 35),
                new Persona("Alba", 25)
        ));

        // ========= Ejemplo con Comparable =========
        // Comparable se implementa en la clase → orden natural por edad
        Collections.sort(personas);
        System.out.println("Comparable (orden natural - edad asc): " + personas);

        // ========= Ejemplo con Comparator =========

        // Comparator externo: ordenar por nombre alfabéticamente
        personas.sort(Comparator.comparing(p -> p.nombre));
        System.out.println("Comparator (nombre asc): " + personas);

        // Comparator por longitud del nombre
        personas.sort(Comparator.comparingInt(p -> p.nombre.length()));
        System.out.println("Comparator (longitud del nombre): " + personas);

        // Comparator compuesto: primero por edad y luego por nombre
        personas.sort(
                Comparator.comparingInt((Persona p) -> p.edad)
                        .thenComparing(p -> p.nombre)
        );
        System.out.println("Comparator compuesto (edad, luego nombre): " + personas);

        // Comparator.reverseOrder(): invierte el orden natural (Comparable)
        personas.sort(Comparator.reverseOrder());
        System.out.println("ReverseOrder (edad desc): " + personas);

        // Comparator.comparing + reverseOrder en clave nombre
        personas.sort(Comparator.comparing((Persona p) -> p.nombre, Comparator.reverseOrder()));
        System.out.println("Comparator (nombre desc): " + personas);

        // ========= Ejemplo rápido con Strings =========
        List<String> textos = new ArrayList<>(List.of("java", "Spring", "hibernate", "JPA"));

        // Orden natural (alfabético sensible a mayúsculas)
        Collections.sort(textos);
        System.out.println("Orden natural de Strings: " + textos);

        // Orden ignorando mayúsculas con Comparator.comparing
        textos.sort(Comparator.comparing(String::toLowerCase));
        System.out.println("Orden case-insensitive: " + textos);
    }


}
