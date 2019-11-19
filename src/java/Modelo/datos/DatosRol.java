package Modelo.datos;

import Modelo.entidad.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin Cutiva
 */
public class DatosRol {
    private final  Connection miConexion;
    private PreparedStatement ps; 
    private ResultSet rs;
    private String mensaje;

    public DatosRol() {
        this.miConexion = Conexion.getConexion();
    }

    public String getMensaje() {
        return mensaje;
    }
    
    public  ArrayList<Rol> listaRol(){
         this.mensaje=null;
       ArrayList<Rol> lista = new ArrayList<>();
       String consulta = "select * from rol";
        try {
            ps= miConexion.prepareStatement(consulta);
            rs=ps.executeQuery();
            while (rs.next()) {
                Rol unRol= new Rol(rs.getString("rolNombre"),"Activo");
                unRol.setIdRol(rs.getInt("idRol"));
                lista.add(unRol);
            }
            rs.close();
        } catch (SQLException ex) {
            this.mensaje=ex.getMessage();
        }
        
        return lista;
    }
            
            
}
