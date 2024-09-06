package com.systemSudent.view;

import com.systemSudent.dao.StudentDAO;
import com.systemSudent.model.Student;

import java.util.Scanner;


public class SystemStudentApp {
    public static void main(String[] args) {
        var salir = false;
        var consola= new Scanner(System.in);
        //crear una instancia de la clase servicio
        var studentDao = new StudentDAO();
        while (!salir){
            try{
                mostrarMenu();
                salir = ejecutarOpciones(consola, studentDao);
            }catch (Exception e){
                System.out.println("Error al ejecutar operacion:  " + e.getMessage());
            }
            System.out.println();

        }

    }

    private static void mostrarMenu(){
        System.out.print("""
                ****Sistema de Estudiantes****
                1. Listar Estudiantes
                2. Buscar Estudiante
                3. Agregar Estudiante
                4. Modificar Estudiante
                5. Eliminar Estudiante
                6. Salir
                Elige una opcion:
                """);
    }

    private static boolean ejecutarOpciones(Scanner consola, StudentDAO studentDao){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 -> {//listar estudiantes
                System.out.println("Listado de estudiantes: ");
                var students = studentDao.listarStudents();
                students.forEach(System.out::println);
            }
            case 2 ->{//buscar estudiante por id
                System.out.print("Introduce el id del estudiante: ");
                var idStudent = Integer.parseInt(consola.nextLine());
                var student = new Student(idStudent);
                var encontrado = studentDao.findById(student);
                if (encontrado){
                    System.out.println("Estudiante encontrado: " + student);
                }else{
                    System.out.println("Estudiante no encontrado: " + student);
                }
            }
            case 3 ->{//agregar estudiante
                System.out.println("Añadir estudiante: ");
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Email: ");
                var email = consola.nextLine();
                //crear el objeto estudiante
                var student = new Student(nombre, apellido, telefono, email);
                var agregado= studentDao.addStudent(student);
                if(agregado){
                    System.out.println("Estudiante añadido con exito " + student);
                }else{
                    System.out.println("Estudiante no añadido " + student);
                }
            }
            case 4 ->{//modificar estudiante
                System.out.println("Actualizar estudiante: ");
                System.out.print("Id estudiante: ");
                var idStudent = Integer.parseInt(consola.nextLine());
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Email: ");
                var email = consola.nextLine();
                var student = new Student(idStudent, nombre, apellido, telefono, email);
                var modificado = studentDao.updateStudent(student);
                if (modificado){
                    System.out.println("Estudiante actualizado con exito " + student);
                }else {
                    System.out.println("Estudiante no actualizado " + student);
                }

            }
            case 5 -> {//eliminar estudiante
                System.out.println("Eliminar estudiante:");
                System.out.print("id estudiante: ");
                var idStudent = Integer.parseInt(consola.nextLine());
                var student = new Student(idStudent);
                var eliminado = studentDao.deleteStudent(student);
                if (eliminado){
                    System.out.println("Estudiante eliminado con exito " + student);
                }else{
                    System.out.println("Estudiante no eliminado " + student);
                }
            }
            case 6 -> {
                System.out.println("Hasta pronto.");
                salir = true;
            }
            case 7 -> System.out.println("Opcion erronea.");

        }
        return salir;

    }
}