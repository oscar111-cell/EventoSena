/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.datos.DatosInvitado;


import Modelo.entidad.Evento;
import Modelo.entidad.Invitado;

import Modelo.entidad.Persona;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TOBBY
 */
@WebServlet(name = "ControllerInvitado", urlPatterns = {"/ControllerInvitado"})
public class ControllerInvitado extends HttpServlet {
    DatosInvitado dInvitado= new DatosInvitado();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerInvitado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerInvitado at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
          String tarea = request.getParameter("accion");
        switch(tarea){
            
            case "Agregar": agregar(request,response);
            break;
           case "Consultar": consultar(request,response);
            break;
                       
        }
    }

    
    
    private void agregar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        
        String identificacion= request.getParameter("txtIdentificacion");
        Persona unPersona= dInvitado.obtenerPersonaPorIdentificacion1(identificacion);
        
        if (unPersona!=null){
        String empresa = request.getParameter("txtEmpresa").toUpperCase();    
        String idEvento=request.getParameter("idEvento");
        String fecha=obtenerFechaActual();
             //creo un evento
        int evento=Integer.parseInt(idEvento);
        Evento unEvento = new Evento();
        unEvento.setidEvento(evento);
      
        //crear un invitado
        
        Invitado unInvitado = new Invitado();
        unInvitado.setUnaPersona(unPersona);
        unInvitado.setEmpresa(empresa);
        unInvitado.setUnEvento(unEvento);
        unInvitado.setFecha(fecha); 
        
        //metodo para agregar el invitado
        
        boolean agregado = dInvitado.agregarInvitado1(unInvitado);
        if(agregado){
            PrintWriter out = response.getWriter();
            String json = new Gson().toJson(agregado);
            out.print(json);
        }
        }else{
        String identifica = request.getParameter("txtIdentificacion");
        String nombre = request.getParameter("txtNombre");
        String Apellido = request.getParameter("txtApellido");
        String correo = request.getParameter("txtCorreo");
        String celular = request.getParameter("txtCelular");        
        String empresa = request.getParameter("txtEmpresa").toUpperCase();
        String sexo = request.getParameter("cbsexo");
        String idEvento=request.getParameter("idEvento");
        String fecha=obtenerFechaActual();
        // crear la persona
        
         Persona unaPersona = new Persona(identifica, nombre, Apellido, correo, celular, sexo);
        
        //creo un evento
        int evento=Integer.parseInt(idEvento);
        Evento unEvento = new Evento();
        unEvento.setidEvento(evento);
        //crear un invitado
        
        Invitado unInvitado = new Invitado();
        unInvitado.setUnaPersona(unaPersona);
        unInvitado.setEmpresa(empresa);
        unInvitado.setUnEvento(unEvento);
        unInvitado.setFecha(fecha);
            
        //metodo para agregar la persona
        
        boolean agregado = dInvitado.agregarInvitado(unInvitado);
        if(agregado){
            PrintWriter out = response.getWriter();
            String json = new Gson().toJson(agregado);
            out.print(json);
        }
      }
    }
    
     private void consultar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException { 
        
        String identifica= request.getParameter("identificacion").trim();
        Persona unPersona= dInvitado.obtenerPersonaPorIdentificacion(identifica);
        if (unPersona==null){       
                Persona unPersonas= dInvitado.obtenerPersonaPorIdentificacion1(identifica); 
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out= response.getWriter();
                String json= new Gson().toJson(unPersonas);
                out.print(json);       
        }else{       
         response.setContentType("application/json;charset=UTF-8");
         PrintWriter out= response.getWriter();
         String json= new Gson().toJson(unPersona);
         out.print(json);
        }        
    }
     
      private String obtenerFechaActual(){
          Calendar miCalendario = Calendar.getInstance();
           int dia = miCalendario.get(Calendar.DAY_OF_MONTH);
           int mes = miCalendario.get(Calendar.MONTH) + 1;
           int year = miCalendario.get(Calendar.YEAR);
           String fecha = year + "/" + mes + "/" + dia ;
           return fecha;
     }
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
