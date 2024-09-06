package com.systemSudent.dao;

import com.systemSudent.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static com.systemSudent.conexion.Conexion.getConexion;

//DAO - DATA Access Object
public class StudentDAO {
    public List<Student> listarStudents(){
        List<Student> estudiantes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM student ORDER BY id_student";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                var student = new Student();
                student.setIdStudent(rs.getInt("id_student"));
                student.setNombre(rs.getString("nombre"));
                student.setApellido(rs.getString("apellido"));
                student.setTelefono(rs.getString("telefono"));
                student.setEmail(rs.getString("email"));
                estudiantes.add(student);
            }
        }catch (Exception e){
            System.out.println("Ocurrio un errir al seleccion datos: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerra conexion: " + e.getMessage());
            }
        }
        return estudiantes;

    }

    public boolean findById(Student student){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM student WHERE id_student = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, student.getIdStudent());
            rs = ps.executeQuery();
            if(rs.next()){
                student.setNombre(rs.getString("nombre"));
                student.setApellido(rs.getString("apellido"));
                student.setTelefono(rs.getString("telefono"));
                student.setEmail(rs.getString("email"));
                return true;
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error al buscar estudiantes: " +e.getMessage());
        }finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerra conexion: " + e.getMessage());
            }
        }
        return false;
    }

    public boolean  addStudent(Student student){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO student(nombre, apellido, telefono, email) " +
                "VALUES (?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,student.getNombre());
            ps.setString(2, student.getApellido());
            ps.setString(3, student.getTelefono());
            ps.setString(4, student.getEmail());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al agregar estudiantes: " + e.getMessage());
        }finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;

    }

    public boolean updateStudent(Student student){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE student SET nombre = ?, apellido = ?, telefono = ?, email = ?" +
                "WHERE id_student = ?";

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, student.getNombre());
            ps.setString(2, student.getApellido());
            ps.setString(3, student.getTelefono());
            ps.setString(4, student.getEmail());
            ps.setInt(5, student.getIdStudent());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al actualizar estudiante: " +e.getMessage());
        }finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }

        return false;
    }

    public boolean deleteStudent(Student student){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM student WHERE id_student = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, student.getIdStudent());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al eliminar estudiante " + e.getMessage());
        }finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var estudiantesDAO = new StudentDAO();

        //agregar estudiante
//        var newStudent = new Student("Jose", "tinta", "4444444", "jose@mail.com");
//        var agregardo = estudiantesDAO.addStudent(newStudent);
//        if(agregardo){
//            System.out.println("Estudiante añadido con exito " + newStudent);
//        }else{
//            System.out.println("no se añadio el estudiante: " + newStudent);
//        }

        //modificar estudiante
//        var student = new Student(3, "Juan carlo", "vasquez", "555555", "juanc@mail.com");
//        var modificado = estudiantesDAO.updateStudent(student);
//        if (modificado){
//            System.out.println("Estudiante modificado con exito " + modificado);
//        }else {
//            System.out.println("Estudiante no modificado " + modificado);
//        }

        //eliminar estudiante
        var student = new Student(3);
        var eliminado = estudiantesDAO.deleteStudent(student);
        if(eliminado){
            System.out.println("Estudiante eliminado con exito " + student);
        }else{
            System.out.println("No se elimino studiante " + student);
        }


        //listar los estudiantes
        System.out.println("Listado de estudiantes");
        List<Student> estudiantes = estudiantesDAO.listarStudents();
        estudiantes.forEach(System.out::println);

        //buscar por id
//        var student = new Student(3);
//        System.out.println("Estudiante antes de la busqueda: " + student);
//        var encontrado = estudiantesDAO.findById(student);
//        if(encontrado){
//            System.out.println("Estudiante encontrado: " + student);
//        }else {
//            System.out.println("No se encontro estudiantes: " + student.getIdStudent());
//        }
    }
}
