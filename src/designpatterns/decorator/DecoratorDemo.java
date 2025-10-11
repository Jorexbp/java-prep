package designpatterns.decorator;

/*
   Decorator (Estructural)
   ► Añade responsabilidades (comportamiento) dinámicamente a un objeto sin modificar su código.
   ► Problema: extender funcionalidad sin herencia rígida ni explosión de subclases.
   ► Idea: un envoltorio que implementa la misma interfaz, delega y añade comportamiento.
*/
public class DecoratorDemo {

    interface Notifier { void send(String msg); }

    static class EmailNotifier implements Notifier {
        public void send(String msg) { System.out.println("Email: " + msg); }
    }

    // Decorador base
    static abstract class NotifierDecorator implements Notifier {
        protected final Notifier wrappee;
        protected NotifierDecorator(Notifier n){ this.wrappee = n; }
    }

    // Decoradores concretos
    static class SmsDecorator extends NotifierDecorator {
        public SmsDecorator(Notifier n){ super(n); }
        public void send(String msg) {
            wrappee.send(msg);
            System.out.println("SMS: " + msg);
        }
    }

    static class SlackDecorator extends NotifierDecorator {
        public SlackDecorator(Notifier n){ super(n); }
        public void send(String msg) {
            wrappee.send(msg);
            System.out.println("Slack: " + msg);
        }
    }

    public static void main(String[] args) {
        Notifier base = new EmailNotifier();
        Notifier sms  = new SmsDecorator(base);
        Notifier full = new SlackDecorator(sms);

        base.send("Hola solo email");
        sms.send("Hola email + sms");
        full.send("Hola email + sms + slack");
    }
}
