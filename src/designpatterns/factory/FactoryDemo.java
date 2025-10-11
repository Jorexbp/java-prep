package designpatterns.factory;

/*
   Factory (Creacional)
   ► Centraliza la creación de objetos y esconde la lógica de instanciación.
   ► Problema que resuelve: evitar “new” repartidos por tod0 el código y decisiones condicionales.
   ► Variantes: Simple Factory, Factory Method, Abstract Factory (familias de productos).
*/
public class FactoryDemo {

    interface Bot {
        String reply();
    }

    static class SupportBot implements Bot {
        public String reply() {
            return "Soporte: ¿en qué puedo ayudarte?";
        }
    }

    static class SalesBot implements Bot {
        public String reply() {
            return "Ventas: ¡tengo una oferta para ti!";
        }
    }

    static class BotFactory {
        public static Bot create(String type) {
            return switch (type) {
                case "support" -> new SupportBot();
                case "sales" -> new SalesBot();
                default -> throw new IllegalArgumentException("Tipo no soportado: " + type);
            };
        }
    }

    public static void main(String[] args) {
        Bot b1 = BotFactory.create("support");
        Bot b2 = BotFactory.create("sales");
        System.out.println(b1.reply());
        System.out.println(b2.reply());
    }
}
