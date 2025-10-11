package designpatterns.strategy;

/*
   Strategy (Comportamiento)
   ► Define una familia de algoritmos, los encapsula y los hace intercambiables.
   ► Problema que resuelve: if/else gigantes para elegir “cómo” hacer algo.
   ► Beneficio: elegir la estrategia en tiempo de ejecución.
*/
public class StrategyDemo {

    interface PaymentStrategy {
        String pay(int amount);
    }

    static class CardPayment implements PaymentStrategy {
        public String pay(int amount) {
            return "Pago con tarjeta: " + amount + "€";
        }
    }

    static class PaypalPayment implements PaymentStrategy {
        public String pay(int amount) {
            return "Pago con PayPal: " + amount + "€";
        }
    }

    static class Checkout {
        private PaymentStrategy strategy;

        public void setStrategy(PaymentStrategy s) {
            this.strategy = s;
        }

        public void process(int amount) {
            System.out.println(strategy.pay(amount));
        }
    }

    public static void main(String[] args) {
        Checkout co = new Checkout();
        co.setStrategy(new CardPayment());
        co.process(50);
        co.setStrategy(new PaypalPayment());
        co.process(75);
    }
}
