/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.datos;

import Modelo.entidad.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Oscar Castro
 */
public class DatosPersona {
      private Connection miConexion;
    private String mensaje;
    private ResultSet rs;
    private PreparedStatement ps;

    public DatosPersona() {
        miConexion = Conexion.getConexion();
        
    }

    public String getMensaje() {
        return mensaje;
    }
    public boolean agregarpersona(Usuario unUsuario){
         boolean agregado = false;
         this.mensaje = null;
         try{
             this.miConexion.setAutoCommit(false);
             //agregar persona
             String consulta = "insert into persona values (null,?,?,?,?,?,?)";
             ps = miConexion.prepareStatement(consulta);
             ps.setString(1, unUsuario.getUnaPersona().getIdentificacion());
             ps.setString(2, unUsuario.getUnaPersona().getNombre());
             ps.setString(3, unUsuario.getUnaPersona().getApellido());
             ps.setString(4, unUsuario.getUnaPersona().getCorreo());
             ps.setString(5, unUsuario.getUnaPersona().getCelular());
             ps.setString(6, unUsuario.getUnaPersona().getSexo());
             ps.executeUpdate();
             
             //obtener el id de las personas
             
             consulta = "select idPersona from persona where perIdentificacion=?";
             ps = miConexion.prepareStatement(consulta);
             ps.setString(1, unUsuario.getUnaPersona().getIdentificacion());
             rs = ps.executeQuery();
             int idPersona = 0;
             if(rs.next()){
                 idPersona = rs.getInt("idPersona");
             }
             
             
             //agregar tabla usuario
             
             consulta = "insert into usuario values (null,?,?,?)";
             ps = miConexion.prepareStatement(consulta);             
             ps.setString(1, unUsuario.getLogin());
             ps.setString(2, unUsuario.getPassword());             
             ps.setInt(3, idPersona);
             ps.executeUpdate();
             
             
             // obtener el id del usuario 
             
             consulta = " select max(idUsuario) as idUsuario from usuario";
             ps = miConexion.prepareStatement(consulta);
             rs = ps.executeQuery();
             int idUsuario = 0;
             if(rs.next()){
                 idUsuario = rs.getInt("idUsuario");
             }
             
             //agregar usuario roles
             int cantidadroles = unUsuario.getRoles().size();
             consulta = "insert into usuarioroles values (null,?,'Activo',?)";
             ps = miConexion.prepareStatement(consulta);
             for (int i = 0; i < cantidadroles; i++) {
                 ps.setInt(1, idUsuario);                 
                 ps.setInt(2, unUsuario.getRoles().get(i).getIdRol());
                 ps.executeUpdate();
             }
             this.miConexion.commit();
             this.mensaje = "Persona agregada correctamente";
             agregado = true;
         }catch(SQLException ex){
             try{
                 this.miConexion.rollback();
                 this.mensaje = ex.getMessage();
             }catch(SQLException ex1){
                 this.mensaje = ex1.getMessage();
             }
         }
        return agregado;

    }
   
}
