package devops.docker;


public class Intro {
/*
    DOCKER — Contenedores, imágenes, redes y volúmenes

    ► ¿Qué es Docker?
      Docker es una plataforma de virtualización ligera que permite empaquetar,
      distribuir y ejecutar aplicaciones en contenedores.  
      Un *contenedor* es una unidad aislada que incluye tod0 lo necesario para
      ejecutar una aplicación: código, dependencias, librerías y entorno.

      A diferencia de una máquina virtual, un contenedor no requiere un sistema
      operativo completo; comparte el kernel del host, lo que lo hace mucho más
      ligero y rápido.

    ► Objetivos principales
      - Estandarizar entornos de ejecución (misma app = mismo resultado en cualquier lugar).
      - Facilitar el despliegue y la portabilidad entre entornos (dev, test, prod).
      - Permitir escalabilidad, aislamiento y automatización de despliegues.

    ► Conceptos básicos
      1. Imagen (Image):
         Plantilla inmutable que contiene el sistema base y el entorno necesario
         para ejecutar una aplicación (por ejemplo, una imagen con Java 21 + Spring Boot).

         Las imágenes se construyen a partir de un *Dockerfile*.
         Ejemplo:
           FROM openjdk:21
           COPY target/app.jar app.jar
           ENTRYPOINT ["java", "-jar", "app.jar"]

         Una imagen es solo lectura; los contenedores son instancias en ejecución
         de esas imágenes.

      2. Contenedor (Container):
         Instancia en ejecución de una imagen. Cada contenedor tiene su propio
         sistema de archivos, red y configuración de entorno, pero comparte el
         kernel del host.

         Comandos comunes:
           docker run imagen         → ejecuta un contenedor
           docker ps                 → lista contenedores en ejecución
           docker stop <id>          → detiene un contenedor
           docker rm <id>            → elimina un contenedor detenido

      3. Volumen (Volume):
         Espacio de almacenamiento persistente fuera del ciclo de vida del contenedor.
         Se usa para mantener datos (por ejemplo, bases de datos) aunque el contenedor
         se elimine.

         Ejemplo:
           docker volume create datos
           docker run -v datos:/var/lib/mysql mysql

      4. Red (Network):
         Permite la comunicación entre contenedores.  
         Docker crea redes virtuales aisladas que conectan varios contenedores.

         Tipos de red:
           - bridge (por defecto) → conecta contenedores dentro del mismo host
           - host → comparte la red del host
           - none → sin conexión
           - overlay → conecta contenedores en distintos hosts (Swarm)

         Ejemplo:
           docker network create mi_red
           docker run -d --name app --network mi_red myapp
           docker run -d --name db --network mi_red mysql

      5. Docker Hub:
         Registro público de imágenes (repositorio oficial de Docker).
         Permite subir y descargar imágenes con:
           docker pull nombre_imagen
           docker push usuario/imagen

    ► Arquitectura de Docker
      Docker se compone de tres elementos principales:
        - **Docker Client** → CLI que usa el usuario (`docker run`, `docker build`…)
        - **Docker Daemon (dockerd)** → servicio que gestiona contenedores e imágenes
        - **Docker Registry** → almacén de imágenes (Docker Hub, GitHub Packages, etc.)

    ► Flujo de trabajo típico
      1. Crear un Dockerfile → define cómo construir la imagen.
      2. Construir la imagen → `docker build -t miapp:1.0 .`
      3. Ejecutar el contenedor → `docker run -d -p 8080:8080 miapp:1.0`
      4. Verificar ejecución → `docker ps`
      5. Parar o eliminar → `docker stop <id>` / `docker rm <id>`

    ► Ventajas principales
      - Ligero y rápido (usa el kernel del sistema operativo).
      - Reproducible: “funciona igual en todos los entornos”.
      - Portátil entre sistemas operativos y nubes.
      - Facilita CI/CD, escalabilidad y despliegues automatizados.
      - Compatible con Kubernetes para orquestación.

    Para poder usar el ejemplo del Dockerfile de este paquete usa estos comandos:

    # Compilar la app
    mvn clean package -DskipTests

    # Construir la imagen Docker
    docker build -t miapp:1.0 .

    # Ejecutar el contenedor
    docker run -d -p 8080:8080 miapp:1.0

    # Ver logs
    docker logs -f <container_id>


*/
}
