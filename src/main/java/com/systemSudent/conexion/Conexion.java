package com.systemSudent.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion(){
        Connection conexion = null;
        var dataBase = "students_db";
        var url = "jdbc:mysql://localhost:3306/" + dataBase;
        var user = "root";
        var password = "admin";
        //Cargamos la clase del driver de mysql en memoria
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);

        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Ocurrio un error en la conexion: " + e.getMessage());
        }


        return conexion;
    }

}
