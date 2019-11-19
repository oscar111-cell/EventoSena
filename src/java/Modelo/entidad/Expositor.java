/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.entidad;

import java.util.ArrayList;

/**
 *
 * @author Oscar Castro
 */
public class Expositor extends Persona{
    private int idExpositor;
    private String tema;
    private Persona unPersona;
    private String horario;
    private String Descripcionhv;
    private ArrayList<Evento> Eventos;

    public Expositor(String tema, Persona unPersona, String horario, String Descripcionhv, ArrayList<Evento> Eventos) {
        this.tema = tema;
        this.unPersona = unPersona;
        this.horario = horario;
        this.Descripcionhv = Descripcionhv;
        this.Eventos = Eventos;
    }

 

    public Expositor() {
      unPersona= new Persona();
      Eventos= new ArrayList<>();
    }

    public int getIdExpositor() {
        return idExpositor;
    }

    public void setIdExpositor(int idExpositor) {
        this.idExpositor = idExpositor;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Persona getUnPersona() {
        return unPersona;
    }

    public void setUnPersona(Persona unPersona) {
        this.unPersona = unPersona;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDescripcionhv() {
        return Descripcionhv;
    }

    public void setDescripcionhv(String Descripcionhv) {
        this.Descripcionhv = Descripcionhv;
    }

    public ArrayList<Evento> getEventos() {
        return Eventos;
    }

    public void setEventos(ArrayList<Evento> Eventos) {
        this.Eventos = Eventos;
    }

  
  
    
    
}
