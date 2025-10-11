package designpatterns.singleton;

/*
   Singleton (Creacional)
   ► Garantiza que exista UNA sola instancia de una clase y acceso global a ella.
   ► Problema que resuelve: coordinar un único recurso compartido (config, logger, etc.).
   ► Puntos clave:
     - Constructor privado
     - Punto de acceso estático
     - Thread-safe (Holder idiom o enum)

   Nota: El “Initialization-on-demand holder” es perezoso, simple y thread-safe sin synchronized.
*/
public class SingletonDemo {

    static class ConfigService {
        private ConfigService() { }

        // Holder idiom: inicialización perezosa y segura
        private static class Holder {
            private static final ConfigService INSTANCE = new ConfigService();
        }
        public static ConfigService getInstance() {
            return Holder.INSTANCE;
        }

        public String get(String key) { return switch (key) {
            case "env" -> "prod";
            default -> "n/a";
        }; }
    }

    public static void main(String[] args) {
        ConfigService a = ConfigService.getInstance();
        ConfigService b = ConfigService.getInstance();
        System.out.println("Misma instancia? " + (a == b)); // true
        System.out.println("env=" + a.get("env"));
    }
}
