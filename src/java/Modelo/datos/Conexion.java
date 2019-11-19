/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Oscar Castro
 */
public class Conexion {
    private static Connection conexion;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String usuario = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/db_proyectofinal";
    private static String mensaje;
    
    
    public static Connection getConexion(){
        
        if(conexion != null){
            return conexion;
        }
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, password);
            mensaje = "conectado a la base de datos";
            return conexion;
        }catch(ClassNotFoundException | SQLException e){
            mensaje = "Error en la conexion a la base de datos" + e.getMessage();
            return null;
        }
    }
    
    
    public static void cerrar(){
        try{
            conexion.close();
            mensaje ="Conexion Cerrada";
        }catch(SQLException ex){
            mensaje = "Problemas al intentar cerrar la conexion" + ex.getMessage();
        }
    }
    
    public static String getMensaje(){
    return mensaje;}
    
}
