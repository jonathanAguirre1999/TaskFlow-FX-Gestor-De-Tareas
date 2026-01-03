# TaskFlow-FX: Gestión de Tareas con Estructuras de Datos

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-Material-2A4D69?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Active-success?style=for-the-badge)

Un sistema de gestión de tareas desarrollado como proyecto universitario para la asignatura de **Algoritmos y Estructuras de Datos**.

El objetivo es demostrar la implementación práctica de **Pilas (LIFO)** y **Colas (FIFO)** bajo una arquitectura MVC (Modelo-Vista-Controlador) limpia y moderna.

## ️Tecnologías y Arquitectura

* **Lenguaje:** Java 21
* **Interfaz Gráfica:** JavaFX + CSS (Estilo Material Design).
* **Patrón de Diseño:** MVC (Modelo - Vista - Controlador).
* **Build Tool:** Maven.
* **IDE:** IntelliJ IDEA.


## Estructuras de Datos Implementadas

Este proyecto no utiliza listas simples. La lógica de negocio (`GestorTareas.java`) se basa estrictamente en Tipos Abstractos de Datos (TAD):

| Funcionalidad | Estructura Lógica (TAD) | Implementación Java | Por qué se eligió |
| :--- | :--- | :--- | :--- |
| **Tareas Pendientes** | **Pila (Stack)** | `ArrayDeque<Tarea>` | Se requiere acceso LIFO (Last In, First Out). Se usó `Deque` en lugar de la clase legacy `Stack` por mayor eficiencia (no sincronizada). |
| **Historial Completadas** | **Cola (Queue)** | `LinkedList<Tarea>` | Se requiere comportamiento FIFO (First In, First Out) para mantener el orden cronológico de finalización. |

## Funcionalidades

1.  **Agregar Tarea:** Inserta una nueva tarea en la cima de la Pila (`push`).
2.  **Ver Próxima:** Visualiza la tarea prioritaria sin extraerla (`peek`).
3.  **Completar Tarea:** Extrae la tarea de la Pila (`pop`) y la encola en el Historial (`offer`).
4.  **Eliminar:** Descarta la tarea actual de la cima de la Pila.
5.  **Modo Oscuro:** Interfaz adaptable con paleta de colores Teal/Aqua.

## Cómo ejecutarlo

1.  Clonar el repositorio:
    ```bash
    git clone [https://github.com/](https://github.com/)[TU_USUARIO]/TaskFlow-FX.git
    ```
2.  Abrir con **IntelliJ IDEA**.
3.  Esperar a que Maven descargue las dependencias.
4.  Ejecutar la clase `MainApp.java`.

## Autor

**Jonathan Daniel Aguirre Coronado**
* Estudiante de Ingeniería de Software
* Universidad Politécnica Salesiana