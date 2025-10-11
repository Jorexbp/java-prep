package designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/*
   Observer (Comportamiento)
   ► Define relación sujeto–observadores: cuando el sujeto cambia, notifica a los observadores.
   ► Problema: desacoplar emisores de eventos de suscriptores.
   ► Usos: UI, eventos de dominio, buses de mensajes.
*/
public class ObserverDemo {

    interface Observer {
        void update(String msg);
    }

    static class ConsoleObserver implements Observer {
        private final String name;

        ConsoleObserver(String n) {
            this.name = n;
        }

        public void update(String msg) {
            System.out.println(name + " recibió: " + msg);
        }
    }

    static class Subject {
        private final List<Observer> observers = new ArrayList<>();

        public void subscribe(Observer o) {
            observers.add(o);
        }

        public void unsubscribe(Observer o) {
            observers.remove(o);
        }

        public void publish(String msg) {
            observers.forEach(o -> o.update(msg));
        }
    }

    public static void main(String[] args) {
        Subject news = new Subject();
        Observer a = new ConsoleObserver("Suscriptor A");
        Observer b = new ConsoleObserver("Suscriptor B");

        news.subscribe(a);
        news.subscribe(b);
        news.publish("Nueva noticia: ¡Patrón Observer!");
        news.unsubscribe(a);
        news.publish("Solo B verá este mensaje");
    }
}
