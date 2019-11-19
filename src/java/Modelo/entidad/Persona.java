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
public class Persona {
    private int IDpersona;
    private String Identificacion;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Celular;
    private String Password;
    private String sexo;
    private String empresa;

    public Persona(String Identificacion, String Nombre, String Apellido, String Correo, String Celular, String Password, String sexo) {
        this.Identificacion = Identificacion;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Celular = Celular;
        this.Password = Password;
        this.sexo = sexo;
    }

    public Persona(String Identificacion, String Nombre, String Apellido, String Correo, String Celular, String sexo) {
        this.Identificacion = Identificacion;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Celular = Celular;
        this.sexo = sexo;
    }
 
   

    public Persona() {
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
 
    
    public int getIDpersona() {
        return IDpersona;
    }

    public void setIDpersona(int IDpersona) {
        this.IDpersona = IDpersona;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

  

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
