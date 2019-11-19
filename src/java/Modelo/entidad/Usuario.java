/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.entidad;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Oscar Castro
 */
public class Usuario{
    
    private int IDusuario;
    private Persona unaPersona;
    private String Login;
    private String password;
    private String estado;
    private ArrayList<Rol> roles;

    public Usuario(Persona unaPersona, String Login, String password, String estado, ArrayList<Rol> roles) {
        this.unaPersona = unaPersona;
        this.Login = Login;
        this.password = password;
        this.estado = estado;
        this.roles = roles;
    }

    

    public Usuario() {
        unaPersona= new Persona();
        roles= new ArrayList<>();
    }

    public int getIDusuario() {
        return IDusuario;
    }

    public void setIDusuario(int IDusuario) {
        this.IDusuario = IDusuario;
    }

    public Persona getUnaPersona() {
        return unaPersona;
    }

    public void setUnaPersona(Persona unaPersona) {
        this.unaPersona = unaPersona;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Rol> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Rol> roles) {
        this.roles = roles;
    }

    

   public String passwordEncriptado(){
       String encriptado="";
       try {
           MessageDigest md = MessageDigest.getInstance("MD5");
           byte[] digest=md.digest(this.password.getBytes());
           BigInteger number = new BigInteger(1,digest);
           encriptado= number.toString(16);
           while (encriptado.length()<32) {
              encriptado="0"+ encriptado;
              
               
           } 
       } catch (NoSuchAlgorithmException ex) {
           System.out.println(ex.getMessage());
       }
       return encriptado;
   }
    
    public void genearPassword(){
        String minusculas= "abcdefghijklmnopqrstuvwxyz";
        String mayusculas="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String dijitos="0123456789";
        String especiales="@#$%&?";
        String passwordGenerado="";
        for(int i=0;i<2;i++){
            Random aleatorio= new Random();
            int posmin= aleatorio.nextInt(minusculas.length());
            int posmay=aleatorio.nextInt(mayusculas.length());
            int posDigitos= aleatorio.nextInt(dijitos.length());
            int posEspeciales= aleatorio.nextInt(especiales.length());
            
            passwordGenerado+=minusculas.substring(posmin,posmin+1)+
                    mayusculas.substring(posmay,posmay+1)+
                    dijitos.substring(posDigitos,posDigitos+1)+
                    especiales.substring(posEspeciales,posEspeciales+1);
        }
        this.password=passwordGenerado;
    }
    
    
    
    
}
