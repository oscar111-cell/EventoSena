/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.datos;

import Modelo.entidad.Expositor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TOBBY
 */
public class DatosExpositor {
      private final  Connection miConexion;
    private PreparedStatement ps; 
    private ResultSet rs;
    private String mensaje;

    public DatosExpositor() {
        this.miConexion = Conexion.getConexion();
    }

    public String getMensaje() {
        return mensaje;
    }
    
        
    public boolean agregarExpositor(Expositor unExpositor){
        boolean agregado= false;
        this.mensaje=null;
        
        try {
            this.miConexion.setAutoCommit(false);
            
            //agregar tabla persona
            String consulta ="insert into persona values (null,?,?,?,?,?,?)";
            ps=miConexion.prepareStatement(consulta);
            ps.setString(1,unExpositor.getUnPersona().getIdentificacion());
            ps.setString(2,unExpositor.getUnPersona().getNombre());
            ps.setString(3,unExpositor.getUnPersona().getApellido());
            ps.setString(4,unExpositor.getUnPersona().getCorreo());
            ps.setString(5,unExpositor.getUnPersona().getCelular());
            ps.setString(6,unExpositor.getUnPersona().getSexo());
            ps.executeUpdate();
            
            //obtener id personas
            consulta="select idPersona from persona where perIdentificacion=?";
            ps=miConexion.prepareStatement(consulta);
            ps.setString(1,unExpositor.getUnPersona().getIdentificacion());
            rs=ps.executeQuery();
            int idPersona=0;
            if (rs.next()){
                idPersona=rs.getInt("idPersona");
            }
                       
            //agregar tabla Expositor
            
           consulta="insert into expositor values(null,?,?,?)";
           ps=miConexion.prepareStatement(consulta);           
           ps.setString(1,unExpositor.getTema());
           ps.setInt(2, idPersona);           
           ps.setString(3, unExpositor.getDescripcionhv());
           ps.executeUpdate();
            
            //obtener el id del Expositor
            
            consulta= "select max(idExpositor) as idExpositor from expositor";
            ps=miConexion.prepareStatement(consulta);
            rs=ps.executeQuery();
            int idExpositor=0;
            if (rs.next()){
                idExpositor=rs.getInt("idExpositor");
            }
          
            
            
            
            //insertar a la tabla eventoExpositor
              
         
           
               //agregar usuario eventoExpositor
             int cantidadEventos = unExpositor.getEventos().size();
             consulta="insert into expositor_evento values(null,?,?,?)";
             ps = miConexion.prepareStatement(consulta);
             for (int i = 0; i < cantidadEventos; i++) {
                 ps.setInt(1,idExpositor);
                 ps.setInt(2, unExpositor.getEventos().get(i).getidEvento());
                 ps.setString(3, unExpositor.getHorario());
                 ps.executeUpdate();
             }
            
            this.miConexion.commit(); //acepta todas laoperaciones anteriores 
            this.mensaje="Expositor agregado correctamente ";
            agregado= true;
            
        } catch (Exception ex) {
            try {
                this.miConexion.rollback();
                this.mensaje=ex.getMessage();
            } catch (SQLException ex1) {
                this.mensaje=ex1.getMessage();
            }
        }
        
        return agregado;
    }
}
