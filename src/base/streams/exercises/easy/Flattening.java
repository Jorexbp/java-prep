package base.streams.exercises.easy;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Flattening {

    static List<Persona> people = List.of(
            new Persona("Jorge", List.of("Amazon", "Oracle")),
            new Persona("Luis", List.of("BytesColaborativos", "Oracle")),
            new Persona("David", List.of("Microsoft", "Red Hat")),
            new Persona("Juan", List.of("Amazon", "Google")),
            new Persona("Ana", List.of("Google", "BytesColaborativos")),
            new Persona("Izaro", List.of("Amazon", "Microsoft")));

    public static void main(String[] args) {
        people.stream()
                .map(Persona::getTitles)
                .flatMap(List::stream)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                ))
                .entrySet()
                .stream()
                // Para ordenar de manera reversa un map
                // .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .forEach(System.out::println);
    }

    static class Persona {
        private final List<String> titles;

        Persona(String nombre, List<String> titles) {
            this.titles = titles;
        }

        public List<String> getTitles() {
            return titles;
        }
    }
}