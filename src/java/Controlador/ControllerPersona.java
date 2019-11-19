/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.datos.DatosPersona;
import Modelo.datos.DatosRol;
import Modelo.entidad.Correo;
import Modelo.entidad.Persona;
import Modelo.entidad.Rol;
import Modelo.entidad.Usuario;
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
@WebServlet(name = "ControllerPersona", urlPatterns = {"/ControllerPersona"})
public class ControllerPersona extends HttpServlet {
    DatosPersona dUsuario= new DatosPersona();
    DatosRol dRol = new DatosRol();
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
            out.println("<title>Servlet ControllerPersona</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerPersona at " + request.getContextPath() + "</h1>");
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
            case "ListarRoles": listarRoles(request,response);
            break;
        }
        
    }

    
     private void agregar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        
        String identifica = request.getParameter("txtIdentificacion");
        String Nombre = request.getParameter("txtNombre");
        String Apellido = request.getParameter("txtApellido");
        String correo = request.getParameter("txtCorreo");
        String celular = request.getParameter("txtCelular");
        
        String Contraseña = request.getParameter("txtContraseña");
        String sexo = request.getParameter("cbsexo");
        
        // crear la persona
        
         Persona unaPersona = new Persona(identifica, Nombre, Apellido, correo, celular, Contraseña, sexo);
        
        //crear un usuario
        
         Usuario unUsuario = new Usuario();
        unUsuario.setUnaPersona(unaPersona);
        unUsuario.setLogin(identifica);
        unUsuario.setPassword(Contraseña);
        
        //crea la lista de roles 
        
         ArrayList<Rol> roles = new ArrayList<>();
        int idRol = Integer.parseInt(request.getParameter("cbRol"));
        Rol unRol = new Rol();
        unRol.setIdRol(idRol);
        roles.add(unRol);
        
        unUsuario.setRoles(roles);
        
        //metodo para agregar la persona
        
        boolean agregado = dUsuario.agregarpersona(unUsuario);
        if(agregado){
            enviarDatosIngresoCorreoElectronico(unUsuario);
            PrintWriter out = response.getWriter();
            String json = new Gson().toJson(agregado);
            out.print(json);
        }
        
    }
     
        
    private void listarRoles(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        response.setContentType("application/json;charset=UTF-8");
        ArrayList<Rol> lista = dRol.listaRol();
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(lista);
        out.print(json);
    }
    
    private void enviarDatosIngresoCorreoElectronico(Usuario unUsuario){
         
         String nombreEmpleado= unUsuario.getUnaPersona().getNombre()+ " " +unUsuario.getUnaPersona().getApellido();
         String correo= unUsuario.getUnaPersona().getCorreo();
         String login= unUsuario.getLogin();
         String password= unUsuario.getPassword();
         String asunto = "Registro al Sistema Evensen";
         String mensaje = "Cordial saludo, <b>" + nombreEmpleado + "</b>, me permito"
                + " informale que ha sido rgistrado en el Sistema Evensen de la Empresa SENA."
                + "<br><br>Credenciales para el Ingreso: <br>"
                + "<br><b>Login: </b>" + login
                + "<br><b>Password: </b>" + password
                + "<br><br>Para Ingresar Al Sistema Dar Clic En http://Evensen-SENA.com"
                + "<br><br> Cualquier Inquietud, Comunicarse Con El Administrador."
                + "<br><br>Atentamente,"
                + "<br><br><br>Administrador Del Sistema: Abrahan Mateo"
                + "<br>Evensen System SENA"
                + "<br><br><img src = 'https://www.softwaresuggest.com/blog/wp-content/uploads"
                + "/2019/06/How-to-Improve-Customer-Service-with-a-Helpdesk-Software.png' with='100px' height='80px'/>";
        Correo.enviarCorreo(correo, asunto, mensaje);
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
