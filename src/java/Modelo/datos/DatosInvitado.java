/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.datos;


import Modelo.entidad.Invitado;
import Modelo.entidad.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TOBBY
 */
public class DatosInvitado {
       private Connection miConexion;
    private String mensaje;
    private ResultSet rs;
    private PreparedStatement ps;
    
    
    public DatosInvitado() {
        miConexion = Conexion.getConexion();        
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    
     public boolean agregarInvitado(Invitado unInvitado){
         boolean agregado = false;
         this.mensaje = null;
         try{
             this.miConexion.setAutoCommit(false);
             //agregar persona
             String consulta = "insert into persona values (null,?,?,?,?,?,?)";
             ps = miConexion.prepareStatement(consulta);
             ps.setString(1, unInvitado.getUnaPersona().getIdentificacion());
             ps.setString(2, unInvitado.getUnaPersona().getNombre());
             ps.setString(3, unInvitado.getUnaPersona().getApellido());
             ps.setString(4, unInvitado.getUnaPersona().getCorreo());
             ps.setString(5, unInvitado.getUnaPersona().getCelular());
             ps.setString(6, unInvitado.getUnaPersona().getSexo());
             ps.executeUpdate();
             
             //obtener el id de las personas
             
             consulta = "select idPersona from persona where perIdentificacion=?";
             ps = miConexion.prepareStatement(consulta);
             ps.setString(1, unInvitado.getUnaPersona().getIdentificacion());
             rs = ps.executeQuery();
             int idPersona = 0;
             if(rs.next()){
                 idPersona = rs.getInt("idPersona");
             }
                         
             //agregar tabla perevento
             
             consulta = "insert into perevento values (null,?,?,?,?)";
             ps = miConexion.prepareStatement(consulta);    
             ps.setInt(1, idPersona);
             ps.setInt(2, unInvitado.getUnEvento().getidEvento());
             ps.setString(3, unInvitado.getEmpresa());  
             ps.setString(4,unInvitado.getFecha());             
             ps.executeUpdate();
             
             
           
             this.miConexion.commit();
             this.mensaje = "Invitado agregada correctamente";
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
     
      public boolean agregarInvitado1(Invitado unInvitado){
         boolean agregado = false;
         this.mensaje = null;
         try{
             this.miConexion.setAutoCommit(false);
             //agregar persona
            
             ps.setString(1, unInvitado.getUnaPersona().getIdentificacion());
             rs = ps.executeQuery();
             int idPersona = 0;
             if(rs.next()){
                 idPersona = rs.getInt("idPersona");
             }
                         
             //agregar tabla perevento
             
             String consulta = "insert into perevento values (null,?,?,?,?)";
             ps = miConexion.prepareStatement(consulta);    
              ps.setInt(1, idPersona);
             ps.setInt(2, unInvitado.getUnEvento().getidEvento());
             ps.setString(3, unInvitado.getEmpresa());   
             ps.setString(4,unInvitado.getFecha());
             ps.executeUpdate();
             
             
           
             this.miConexion.commit();
             this.mensaje = "Invitado agregada correctamente";
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
       public ArrayList<String> obtenerempresas(String empresa){
        ps=null;
        rs=null;
       
       ArrayList<String>lista= new ArrayList<>();
       
         try {
             String consulta="SELECT DISTINCT perevento_empresa FROM `perevento` where perevento_empresa like ? limit 10   " ;
              ps=miConexion.prepareStatement(consulta);   
              ps.setString(1, empresa+"%");
              rs=ps.executeQuery();
              while (rs.next()) {
                lista.add(rs.getString("perevento_empresa"));                 
             }          
            
               
         } catch (SQLException e) {
             
              mensaje=e.getMessage();
         }
      
       
       return lista;
     }
       
       
     public Persona obtenerPersonaPorIdentificacion(String identificacion){
      Persona unaPersona=null;
        
      mensaje=null;
              
       String consulta = "SELECT persona.*, perevento.perevento_empresa FROM "
               + " persona INNER JOIN perevento ON persona.idPersona = perevento.idPersona "
               + " WHERE perIdentificacion = ? AND perevento_fecharegistro =( SELECT MAX(perevento_fecharegistro) FROM perevento ) ";
        try {
            ps=miConexion.prepareStatement(consulta);
            ps.setString(1,identificacion);
            rs=ps.executeQuery();
            if (rs.next()){
                unaPersona= new Persona();               
                unaPersona.setIDpersona(rs.getInt("idPersona"));
                unaPersona.setIdentificacion(rs.getString("perIdentificacion"));
                unaPersona.setNombre(rs.getString("perNombre"));
                unaPersona.setApellido(rs.getString("perApellido"));
                unaPersona.setCorreo(rs.getString("perCorreo"));
                unaPersona.setCelular(rs.getString("perCelular"));
                unaPersona.setSexo(rs.getString("perSexo"));
                unaPersona.setEmpresa(rs.getString("perevento_empresa")); 
               
            }
            rs.close();
        } catch (Exception ex) {
            mensaje="No existe persona con esa identificacion";
            
        }
      return  unaPersona;
    }
     
      public Persona obtenerPersonaPorIdentificacion1(String identificacion){
      Persona unaPersona=null;
        
      mensaje=null;
              
       String consulta =" select * from  persona where perIdentificacion=? ";      
      
        try {
            ps=miConexion.prepareStatement(consulta);
            ps.setString(1,identificacion);
            rs=ps.executeQuery();
            if (rs.next()){
                unaPersona= new Persona();               
                unaPersona.setIDpersona(rs.getInt("idPersona"));
                unaPersona.setIdentificacion(rs.getString("perIdentificacion"));
                unaPersona.setNombre(rs.getString("perNombre"));
                unaPersona.setApellido(rs.getString("perApellido"));
                unaPersona.setCorreo(rs.getString("perCorreo"));
                unaPersona.setCelular(rs.getString("perCelular"));
                unaPersona.setSexo(rs.getString("perSexo"));
            }
            rs.close();
        } catch (Exception ex) {
            mensaje="No existe persona con esa identificacion";
            
        }
      return  unaPersona;
    }
}


