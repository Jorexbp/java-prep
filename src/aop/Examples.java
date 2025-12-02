package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
    Ejemplos prácticos de AOP en Spring:

       1. Logging antes de ejecutar métodos (@Before)
       2. Medir tiempo de ejecución (@Around)
       3. Interceptar excepciones (@AfterThrowing)

    Nota importante:
      - Para que funcione, las clases interceptadas deben ser beans gestionados por Spring.
      - Las clases con @Aspect también deben estar registradas en el contexto.
*/

@Aspect
@Component
public class Examples {

    // ==============================================================
    // 1. Logging básico antes de ejecutar cualquier métod0 de service
    // ==============================================================

    @Before("execution(* solid.*.*(..))")
    public void logAntesDeMetodo() {
        System.out.println("[AOP] Ejecutando método del servicio...");
    }

    // ====================================================================
    // 2. Ejemplo @Around: medir tiempo de ejecución de métodos del service
    // ====================================================================

    @Around("execution(* solid.*.*(..))")
    public Object medirTiempo(ProceedingJoinPoint pjp) throws Throwable {

        long inicio = System.currentTimeMillis();

        Object resultado = pjp.proceed(); // ejecuta el métod0 original

        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;

        System.out.println("[AOP] Tiempo de ejecución de " +
                pjp.getSignature().getName() + ": " + tiempo + " ms");

        return resultado;
    }

    // ==============================================================
    // 3. Interceptar excepciones lanzadas por métodos del service
    // ==============================================================

    @AfterThrowing(
            pointcut = "execution(* solid.*.*(..))",
            throwing = "ex"
    )
    public void manejarExcepciones(Exception ex) {
        System.out.println("[AOP] Se lanzó una excepción: " + ex.getMessage());
    }
}
