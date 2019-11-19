/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.datos.DatosRol;
import Modelo.datos.DatosUsuario;
import Modelo.entidad.Correo;
import Modelo.entidad.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Oscar Castro
 */
@WebServlet(name = "ControllerUsuario", urlPatterns = {"/ControllerUsuario"})
public class ControllerUsuario extends HttpServlet {
    DatosUsuario dUsuario= new DatosUsuario();
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
            out.println("<title>Servlet ControllerUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerUsuario at " + request.getContextPath() + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String tarea = request.getParameter("accion");
        switch(tarea){
                    
            case "IniciarSesion": iniciarSesion(request,response);
           break;
             case "ActualizarPassword": actualizarPassword(request,response);
           break;
          
        }  
        
        
    }
    
     private void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("txtLogin");
        String password= request.getParameter("txtPassword");
        Usuario unUsuario= new Usuario();
        unUsuario.setLogin(login);
        unUsuario.setPassword(password);
        Usuario user = dUsuario.iniciarSecion(unUsuario);
        if (user!=null){
            //se valida que el rol este activo
            if (user.getRoles().get(0).getEstado().equals("Activo")){
                        
            
                String rol= user.getRoles().get(0).getNombre();
                // se inicializa una session
                HttpSession session= request.getSession(true);
                // se crean unas variables de sesion
                session.setAttribute("idUsuario",user.getIDusuario());
                session.setAttribute("identificacion",user.getUnaPersona().getIdentificacion());
                session.setAttribute("idPersona",user.getUnaPersona().getIDpersona());
                session.setAttribute("nombre",user.getUnaPersona().getNombre() +
                        " " + user.getUnaPersona().getApellido());
                
                // deacuerdo al rol se direciona a la vista indicada
                
                switch(rol){
                    case "Administrador":
                        response.sendRedirect(request.getContextPath() + "/Vista/Rol_Administrador/MenuPrincipalAdm.jsp");
                        break;
                        
                    case "Apoyo":
                        response.sendRedirect(request.getContextPath() + "/Vista/Rol_Apoyo/MenuprincipalApo.jsp");
                        break;
                     
                }
                
                
            }else{
                // cuando el rol del usuario es inactivo
               response.sendRedirect(request.getContextPath() + "/Vista/Rol_Administrador/LoginAdmin.jsp?x=1");
            }
                    
            
        }else{
         //cuando las credenciales de ingreso no son validas 
         response.sendRedirect(request.getContextPath() + "/Vista/Rol_Administrador/LoginAdmin.jsp?x=2");
        }
    
    }
    
       private void actualizarPassword (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             
             String identifica = request.getParameter("identificacion");
             String correo = request.getParameter("correo");
             Usuario user = new Usuario();
             user.getUnaPersona().setCorreo(correo);
             user.getUnaPersona().setIdentificacion(identifica);
             user.genearPassword();
             boolean actualizado = dUsuario.actualizarPassword(user);
             
             if(actualizado){
                 enviarNuevoPasswordCorreoElectronico(user);
             }
             
             PrintWriter out = response.getWriter();
             String json = new Gson().toJson(actualizado);
             out.print(json);
         
         } 
         
         
      private void enviarNuevoPasswordCorreoElectronico(Usuario unUsuario){
         
         String correo = unUsuario.getUnaPersona().getCorreo();
         String login = unUsuario.getUnaPersona().getIdentificacion();
         String password = unUsuario.getPassword();
         String asunto = "Actualizacion De Password Sistema Evensen";
         String mensaje = "Cordial saludo me permito informarle que su constraseña a sido cambiada"
                + "<br><br>Sus nuevas credenciales para el Ingreso son: <br>"
                + "<br><b>Login: </b>" + login
                + "<br><b>Password: </b>" + password
                + "<br><br>Para Ingresar Al Sistema Dar Clic En: http://Evensen-Sena.com"
                + "<br><br> Cualquier Inquietud, Comunicarse Con El Administrador."
                + "<br><br>Atentamente,"
                + "<br><br><br>Administrador Del Sistema: Kevin Cutiva"
                + "<br>Evensen System Sena"
                + "<br><br><img src = 'https://www.softwaresuggest.com/blog/wp-content/uploads"
                + "/2019/06/How-to-Improve-Customer-Service-with-a-Helpdesk-Software.png' with='100px' height='80px'/>";
          Correo.enviarCorreo(correo, asunto, mensaje);
     }   
  
    
   

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
