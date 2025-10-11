package base.streams.ej;

import java.util.*;
import java.util.stream.Collectors;

public class ExpStreams {

    public static void main(String[] args) {
        List<String> nombres = List.of("Ana", "Luis", "Marta", "Alba", "Jorge");

        // filter: quedarse solo con los que empiezan con "A"
        // ponemos un lambda que devuelve un boolean, quien devuelve false se quita
        List<String> conA = nombres.stream()
                .filter(n -> n.startsWith("A"))
                .toList();
        System.out.println("filter -> empiezan con A: " + conA);

        // map: transformar cada String a mayúsculas
        // como indica, mapea valores
        List<String> mayus = nombres.stream()
                .map(String::toUpperCase) // usando method reference
                .toList();
        System.out.println("map -> mayúsculas: " + mayus);

        // sorted: ordenar ignorando mayúsculas/minúsculas
        // ordena con el Comparator(lambda) que digamos
        List<String> ordenados = nombres.stream()
                .sorted((a, b) -> a.compareToIgnoreCase(b)) // Se podria poner un method reference
                .toList();
        System.out.println("sorted -> ordenados: " + ordenados);

        // reduce: concatenar todos los nombres en una sola cadena con guiones
        String concatenado = nombres.stream()
                .reduce("", (a, b) -> a.isEmpty() ? b : a + "-" + b);
        System.out.println("reduce -> concatenado: " + concatenado);

        // count: contar elementos
        long cuantos = nombres.stream().count();
        System.out.println("count -> número de elementos: " + cuantos);

        // anyMatch: comprobar si alguno cumple la condición
        // Cualquiera que cumpla la condicion y devuelve boolean,
        // existe findFirst que devuelve el primero que cumpla
        boolean hayAna = nombres.stream().anyMatch(n -> n.equals("Ana"));
        System.out.println("anyMatch -> ¿Está Ana? " + hayAna);

        // distinct + sorted: eliminar duplicados y ordenar números
        // sorted usa comparator si queremos poner un orden que
        // no sea el natural
        List<Integer> numeros = List.of(5, 1, 2, 2, 3, 5, 4);
        List<Integer> sinDuplicados = numeros.stream()
                .distinct()
                .sorted()
                // .sorted((o1, o2) -> (o1 * 2) < o2 ? o1 : o2 ) // valido, comparator personalizado
                .toList();
        System.out.println("distinct + sorted -> " + sinDuplicados);

        // limit: quedarse con los primeros 3
        List<String> primeros3 = nombres.stream()
                .limit(3)
                .toList();
        System.out.println("limit -> primeros 3: " + primeros3);

        // skip: saltar los primeros 2
        List<String> saltar2 = nombres.stream()
                .skip(2)
                .toList();
        System.out.println("skip -> después de 2: " + saltar2);

        // forEach: recorrer e imprimir cada elemento
        System.out.print("forEach -> ");
        nombres.stream().forEach(n -> System.out.print(n + " "));
    }
}
