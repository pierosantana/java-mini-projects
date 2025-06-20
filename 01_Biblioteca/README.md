# Biblioteca POO

Un pequeño sistema de gestión de biblioteca en Java, diseñado para practicar los principios de Programación Orientada a Objetos, manejo de excepciones, logging y pruebas unitarias con JUnit 5.

---

## Estructura del proyecto

```
src/
├─ main/
│   └─ java/
│      └─ es/example/
│          ├─ app/
│          │   └─ BibliotecaApp.java
│          ├─ exception/
│          │   └─ RecursoNoDisponibleException.java
│          ├─ model/
│          │   ├─ Publicacion.java
│          │   ├─ Libro.java
│          │   └─ Revista.java
│          └─ service/
│              ├─ PublicacionService.java
│              └─ PublicacionServiceImpl.java
└─ test/
   └─ java/
      ├─ es/example/model/
      │   ├─ LibroTest.java
      │   └─ RevistaTest.java
      └─ es/example/service/
          └─ PublicacionServiceImplTest.java

.gitignore
pom.xml (o build.gradle)
```

---

## Descripción

* **Publicacion** (abstracta): título, autor y estado de préstamo.
* **Libro** y **Revista**: heredan de `Publicacion`.
* **Prestable** (interfaz): define `prestar()` y `devolver()`.
* **RecursoNoDisponibleException**: excepción personalizada para intentos inválidos.
* **PublicacionService**: contrato para obtener, prestar y devolver publicaciones.
* **PublicacionServiceImpl**: implementación de PublicacionService.
* **BibliotecaApp**: orquesta el flujo como ejemplos -> (prestar el primero, devolver el último, mostrar inventario).

---

## Cómo ejecutar

1. Clona el repositorio:

   ```bash
   git clone https://github.com/pierosantana/java-mini-projects.git
   cd 01_Biblioteca
   ```
2. Compila y ejecuta:

   * Con **Maven**:

     ```bash
     mvn clean compile exec:java -Dexec.mainClass="es.example.Main"
     ```
   * Con **Gradle**:

     ```bash
     ./gradlew run
     ```

Verás en consola los logs de cada operación y el inventario al final.

---

## Pruebas

Para ejecutar los tests (JUnit 5):

* **Maven**:

  ```bash
  mvn test
  ```
* **Gradle**:

  ```bash
  ./gradlew test
  ```

---

## Logging

* Usa `java.util.logging`.
* **INFO** para operaciones exitosas.
* **SEVERE** para excepciones.

---

## Principios de diseño

* **SRP (Single Responsibility)**

  * `Main` monta los componentes.
  * `BibliotecaApp` orquesta el flujo.

* **DIP (Dependency Inversion)**

  * `BibliotecaApp` depende de la interfaz `PublicacionService`, no de la implementación.

---

