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
public class Evento {
    private int idEvento;
    private String nombre;
    private String fecha;
    private String descripcion;
    private String lugar;
    private String estado;

    public Evento(String nombre, String fecha, String descripcion, String lugar, String estado) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.estado = estado;
    }
    public Evento(String nombre) {
        this.nombre = nombre;
    }

    public Evento() {
    }
    

    public int getidEvento() {
        return idEvento;
    }

    public void setidEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
        
}
