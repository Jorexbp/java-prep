package designpatterns;

public class Intro {
    /*
       Los patrones de diseño son soluciones probadas a problemas comunes en el
       desarrollo de software orientado a objetos. No son código concreto, sino
       guías reutilizables que ayudan a estructurar el diseño.

       En este paquete veremos los siguientes patrones fundamentales:
       - Singleton
       - Factory
       - Builder
       - Strategy
       - Observer
       - Adapter
       - Decorator
    */

    /*                             KEY FEATURES                            */
    /*
        - Proporcionan soluciones estándar a problemas de diseño.
        - Mejoran la reutilización, extensibilidad y mantenibilidad del código.
        - Se dividen en tres grandes grupos (GoF):
            * Creacionales → creación de objetos (Singleton, Factory, Builder).
            * Estructurales → composición de clases/objetos (Adapter, Decorator).
            * De comportamiento → interacción y responsabilidad entre objetos
              (Strategy, Observer).
    */


    /*                            PATRONES CLAVE                           */

    /*
        ► Singleton (Creacional)
          - Asegura que una clase tenga solo una instancia global y accesible.
          - Útil para manejadores de configuración, logs, conexiones.

        ► Factory (Creacional)
          - Centraliza la lógica de creación de objetos.
          - Permite crear objetos sin exponer la lógica de instanciación al cliente.

        ► Builder (Creacional)
          - Separa la construcción compleja de un objeto de su representación final.
          - Facilita la creación de objetos inmutables con muchos parámetros opcionales.

        ► Strategy (Comportamiento)
          - Define una familia de algoritmos, los encapsula y los hace intercambiables.
          - El cliente elige la estrategia en tiempo de ejecución.

        ► Observer (Comportamiento)
          - Define una relación de suscripción entre objetos.
          - Cuando un objeto cambia de estado, notifica automáticamente a sus observadores.

        ► Adapter (Estructural)
          - Permite que dos interfaces incompatibles trabajen juntas.
          - Actúa como un traductor entre una clase y otra.

        ► Decorator (Estructural)
          - Añade dinámicamente responsabilidades a un objeto sin modificar su código.
          - Alternativa flexible a la herencia para extender funcionalidades.
    */


    /*                              VENTAJAS                               */
    /*
        - Favorecen buenas prácticas de diseño OOP.
        - Mejoran la extensibilidad y la legibilidad.
        - Reducen duplicación de código.
        - Son preguntas frecuentes en entrevistas técnicas.
    */
}
