package base.streams.exercises.hard;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Ex6 {

    public static void main(String[] args) {

        List<LogEntry> logs = List.of(
                new LogEntry(EventType.INFO, "Inicio"),
                new LogEntry(EventType.INFO, "Petición"),
                new LogEntry(EventType.WARN, "Memoria"),
                new LogEntry(EventType.ERROR, "NPE"),
                new LogEntry(EventType.ERROR, "IOB"),
                new LogEntry(EventType.ERROR, "Fallo"),
                new LogEntry(EventType.INFO, "OK"),
                new LogEntry(EventType.WARN, "CPU"),
                new LogEntry(EventType.INFO, "Petición"),
                new LogEntry(EventType.INFO, "Petición")
        );

        Map<EventType, Long> counts = logs.stream()
                .collect(Collectors.groupingBy(LogEntry::getType, Collectors.counting()));

        Optional<Map.Entry<EventType, Long>> mostFrequent =
                counts.entrySet().stream()
                        .max(Map.Entry.comparingByValue(Comparator.naturalOrder()));

        counts.forEach((t, c) -> System.out.println(t + " -> " + c));
        mostFrequent.ifPresent(e ->
                System.out.println("Más frecuente: " + e.getKey() + " (" + e.getValue() + ")")
        );
    }

    enum EventType { INFO, WARN, ERROR }

    static class LogEntry {
        private final EventType type;
        private final String message;

        public LogEntry(EventType type, String message) {
            this.type = type;
            this.message = message;
        }

        public EventType getType() {
            return type;
        }

        @Override
        public String toString() {
            return "[" + type + "] " + message;
        }
    }
}
