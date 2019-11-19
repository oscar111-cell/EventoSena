/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.entidad;

/**
 *
 * @author Oscar Castro
 */
public class Rol {
    private int IdRol;
    private String Nombre;
    private String estado;

    public Rol(String Nombre,String estado) {
        this.Nombre = Nombre;
        this.estado = estado;
    }

    public Rol() {
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getIdRol() {
        return IdRol;
    }

    public void setIdRol(int IdRol) {
        this.IdRol = IdRol;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    
}
