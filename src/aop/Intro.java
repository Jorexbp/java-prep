package aop;

public class Intro {

/*
    AOP — Aspect Oriented Programming (Programación Orientada a Aspectos)

    ► ¿Qué es AOP?
      AOP es un paradigma de programación cuyo objetivo es separar la lógica
      transversal del resto de la aplicación. Un "aspecto transversal" es una
      funcionalidad que afecta a varias capas o módulos, como:

        - Logging
        - Manejo de excepciones
        - Seguridad y validaciones
        - Métricas y auditoría
        - Transacciones (@Transactional)

      Estas funcionalidades no forman parte de la lógica de negocio, pero
      se repiten en muchos métodos. AOP permite centralizarlas en un único lugar.

    ► ¿Qué problema resuelve?
      Evita que el código transversal esté duplicado en servicios o controladores.

      Sin AOP:
         métod0 → logs → validaciones → auditoría → lógica → logs → métricas…

      Con AOP:
         métod0 → lógica
         y el resto se aplica automáticamente en un aspecto separado.

      Así se cumple el principio:
         “Separa lo que cambia de lo que permanece constante”.

    ► Conceptos clave en AOP

      1. Aspect
         Clase que contiene código transversal. En Spring se define con @Aspect.

      2. Join Point
         Punto específico durante la ejecución de un programa donde se puede aplicar AOP.
         Ejemplos: antes de un métod0, después, al lanzar una excepción…

      3. Pointcut
         Expresión que selecciona qué métodos serán interceptados por el aspecto.
         Ejemplo:
            execution(* com.miapp.service.*.*(..))

      4. Advice
         Código que se ejecuta en los Join Points seleccionados.
         Tipos de advice:
           - @Before       → antes del métod0
           - @After        → después del métod0 (siempre)
           - @AfterReturning → después de devolver un valor
           - @AfterThrowing  → si lanza excepción
           - @Around        → rodea la ejecución (control total)

      5. Weaving
         Proceso de aplicar aspectos al código. En Spring, se hace en tiempo de ejecución.

    ► AOP y Spring
      Spring incluye su propio framework AOP basado en proxies.
      Permite interceptar llamadas a métodos de beans administrados por Spring
      sin modificar el código fuente.

      Activación:
        - @EnableAspectJAutoProxy
        - o automáticamente en Spring Boot

    ► Caso de uso típico: Logging en servicios
      En vez de añadir System.out.println en cada métod0, creas un @Aspect:

        @Before("execution(* com.miapp.service.*.*(..))")
        public void log() {
            System.out.println("Ejecutando métod0...");
        }

      Ahora todos los métodos de service imprimirán el log sin escribir nada adicional allí.

    ► Ventajas de usar AOP
      - Reduce duplicación de código.
      - Separa responsabilidades (SRP de SOLID).
      - Facilita auditorías, métricas, seguridad y manejo de errores.
      - Código más limpio y enfocado en lógica de negocio.

    ► Limitaciones
      - Solo funciona en métodos gestionados por Spring.
      - No intercepta llamadas internas dentro del mismo bean.
      - Puede dificultar el debugging si se abusa.

    En resumen:
      AOP permite modularizar comportamientos transversales y aplicarlos
      automáticamente a métodos seleccionados sin ensuciar la lógica de negocio.
*/
}
