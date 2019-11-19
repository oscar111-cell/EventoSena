/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.datos.DatosEvento;
import Modelo.entidad.Evento;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TOBBY
 */
@WebServlet(name = "ControllerEvento", urlPatterns = {"/ControllerEvento"})
public class ControllerEvento extends HttpServlet {
    
    DatosEvento dEvento= new DatosEvento();

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
            out.println("<title>Servlet ControllerEvento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerEvento at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
          String tarea = request.getParameter("accion");
        switch(tarea){
            
            case "Agregar": agregar(request,response);
            break;
            
            case "ListarEvento": listarEvento(request,response);
            break;
            
        }
        
    }
    
    
    private void listarEvento(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        response.setContentType("application/json;charset=UTF-8");
         ArrayList<Evento> lista = dEvento.listarEvento();
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(lista);
        out.print(json);
    }
    
     private void agregar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        
        String Nombre = request.getParameter("txtNombreEvento");
        String fecha = request.getParameter("txtFecha");
        String descripcion = request.getParameter("txtDesCripcion");   
        String lugar = request.getParameter("txtLugar");
        // crear un evento
        
         Evento unEvento = new Evento();
        
         unEvento.setNombre(Nombre);
         unEvento.setFecha(fecha);
         unEvento.setDescripcion(descripcion);
         unEvento.setLugar(lugar);
        
        
        //metodo para agregar el evento
        
        boolean agregado = dEvento.agregarEvento(unEvento);
        if(agregado){
            PrintWriter out = response.getWriter();
            String json = new Gson().toJson(agregado);
            out.print(json);
        }
        
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
