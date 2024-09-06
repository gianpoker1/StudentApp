# Sistema de Gestión de Estudiantes en Java

Este proyecto es una aplicación de consola en Java que permite gestionar estudiantes en una base de datos MySQL. La aplicación ofrece un menú de opciones para listar, buscar, agregar, modificar y eliminar estudiantes, ejecutando operaciones CRUD en la base de datos.

## Características

- Interfaz de consola amigable.
- Manejo de excepciones para entradas inválidas.
- Menú de opciones para listar, buscar, agregar, modificar y eliminar estudiantes.
- Uso de JDBC para interactuar con la base de datos MySQL.
- Implementación de operaciones CRUD en la clase `StudentDAO`.

## Tecnologías Utilizadas

- Java
- JDBC para la conexión y operaciones en la base de datos MySQL.
- MySQL como sistema de gestión de bases de datos.

## Instrucciones de Uso

1. Clona el repositorio:

    ```bash
    git clone https://github.com/gianpoker1/StudentApp.git
    cd StudentApp
    ```

2. Configura la base de datos MySQL:

    - Crea una base de datos llamada `students_db`.
    - Crea una tabla llamada `student` con los siguientes campos:
        ```sql
        CREATE TABLE student (
            id_student INT AUTO_INCREMENT PRIMARY KEY,
            nombre VARCHAR(50),
            apellido VARCHAR(50),
            telefono VARCHAR(20),
            email VARCHAR(50)
        );
        ```

3. Modifica el archivo de conexión con los datos de conexión a la base de datos

4. Compila los archivos Java:

    ```bash
    javac com/systemSudent/conexion/Conexion.java com/systemSudent/model/Student.java com/systemSudent/dao/StudentDAO.java com/systemSudent/view/SystemStudentApp.java
    ```

5. Ejecuta el programa:

    ```bash
    java com.systemSudent.view.SystemStudentApp
    ```

## Estructura del Proyecto

- `com/systemSudent/conexion/Conexion.java`: Clase que maneja la conexión a la base de datos MySQL.
- `com/systemSudent/model/Student.java`: Clase que representa un estudiante.
- `com/systemSudent/dao/StudentDAO.java`: Clase que implementa las operaciones CRUD para gestionar estudiantes en la base de datos.
- `com/systemSudent/view/SystemStudentApp.java`: Clase principal que contiene el menú y la lógica para interactuar con el usuario.

## Ejemplo de Uso

Sistema de Estudiantes

1. Listar Estudiantes

2. Buscar Estudiante

3. Agregar Estudiante
   
4. Modificar Estudiante

5. Eliminar Estudiante
   
6. Salir

Elige una opcion:
