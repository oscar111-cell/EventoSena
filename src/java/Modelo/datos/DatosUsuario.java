/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.datos;

import Modelo.entidad.Rol;
import Modelo.entidad.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Oscar Castro
 */
public class DatosUsuario {
    private Connection miConexion;
    private String mensaje;
    private ResultSet rs;
    private PreparedStatement ps;

    public DatosUsuario() {
        miConexion = Conexion.getConexion();
        
    }

    public String getMensaje() {
        return mensaje;
    }
    
 public Usuario iniciarSecion(Usuario unUsuario){
        Usuario user=null;
        this.mensaje=null;
        
        String consulta = " select usuario.*, persona.*, usuarioroles.*, rol.*"
                + " from usuario inner join persona on usuario.usuPersona = persona.idPersona "
                + " inner join usuarioroles on usuarioroles.usuUsuario = usuario.idUsuario "
                + " inner join rol on usuarioroles.usuRol= rol.idRol "
                + " where usuLogin=? and usupassword=?";
        
        try {
            ps= miConexion.prepareStatement(consulta);
            ps.setString(1, unUsuario.getLogin());
            ps.setString(2,unUsuario.getPassword());
            rs=ps.executeQuery();
            if (rs.next()){
                user= new Usuario();
                user.setLogin(rs.getString("usuLogin"));
                user.setPassword(rs.getString("usuPassword"));
                user.setIDusuario(rs.getInt("idUsuario"));
                user.getUnaPersona().setIDpersona(rs.getInt("idPersona"));
                user.getUnaPersona().setIdentificacion(rs.getString("perIdentificacion"));
                user.getUnaPersona().setNombre(rs.getString("PerNombre"));
                user.getUnaPersona().setApellido(rs.getString("PerApellido"));                
                user.getUnaPersona().setCorreo(rs.getString("PerCorreo"));
                user.getUnaPersona().setCelular(rs.getString("PerCelular"));
                 user.getUnaPersona().setSexo(rs.getString("PerSexo"));
                ArrayList<Rol> listaRoles = new ArrayList<>();
                Rol unRol=new Rol();
                unRol.setIdRol(rs.getInt("idRol"));
                unRol.setNombre(rs.getString("rolNombre"));
                unRol.setEstado(rs.getString("usuEstado"));
                listaRoles.add(unRol);
                user.setRoles(listaRoles);
            }
            rs.close();
        } catch (SQLException ex) {
            this.mensaje= ex.getMessage();
        }
        return user;
    }
    
  public boolean actualizarPassword(Usuario unUsuario){
    boolean actualizado = false;
    this.mensaje=null;
    String Consulta = "update usuario inner join persona on"
            + " usuario.usuPersona = persona.idPersona set usuario.usuPassword=?"
            + " where persona.perIdentificacion=? and persona.perCorreo=?";
    
    try{
        ps=miConexion.prepareStatement(Consulta);
        ps.setString(1, unUsuario.getPassword());
        ps.setString(2, unUsuario.getUnaPersona().getIdentificacion());
        ps.setString(3, unUsuario.getUnaPersona().getCorreo());
        if(ps.executeUpdate()==1){
            actualizado=true;
        }
    }catch(SQLException ex){
        this.mensaje=ex.getMessage();
    }
         return actualizado;
    }  

    
     
}

