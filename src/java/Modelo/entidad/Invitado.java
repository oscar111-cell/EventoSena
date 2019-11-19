/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.entidad;

/**
 *
 * @author TOBBY
 */
public class Invitado {
    private int idInvitado;
    private Persona unaPersona;
    private String empresa;
    private Evento unEvento;
    private String fecha;

    public Invitado(Persona unaPersona, String empresa, Evento unEvento, String fecha) {
        this.unaPersona = unaPersona;
        this.empresa = empresa;
        this.unEvento = unEvento;
        this.fecha = fecha;
    }

   

    public Invitado() {
        unaPersona= new Persona();
        unEvento= new Evento();
    }

    public int getIdInvitado() {
        return idInvitado;
    }

    public void setIdInvitado(int idInvitado) {
        this.idInvitado = idInvitado;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Persona getUnaPersona() {
        return unaPersona;
    }

    public void setUnaPersona(Persona unPersona) {
        this.unaPersona = unPersona;
    }

    public Evento getUnEvento() {
        return unEvento;
    }

    public void setUnEvento(Evento unEvento) {
        this.unEvento = unEvento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
   
    
  
}
