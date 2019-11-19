<%-- 
    Document   : frmAgregarInvitado
    Created on : 22/09/2019, 07:16:36 PM
    Author     : Kevin Cutiva
--%>

 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registrar Invitados</title>
        
        <%@ include file="../PaginaPrincipal/Rutas-Head.jsp" %> 
         <script src="../Js/jsInscribirInvitado.js" type="text/javascript"></script>
         <script src="../Js/jsAutocomplete.js" type="text/javascript"></script>
    </head>
    <body>
       
    <header class="headerAgrInvitado">
        <div class="menu-toggle" id="hamburger" onclick="mostrar()">
            <i class="fas fa-bars"></i>
        </div>
        <div class="overlay"></div>
        <div class="container">
            <nav>
                <h1 class="brand"><a href="../PaginaPrincipal/MenuPrincipal.jsp">Eve<span>S</span>en</a></h1>
                <ul>
                    <li><a href="../PaginaPrincipal/MenuPrincipal.jsp">Regresar</a></li>
                </ul>
            </nav>
        </div>
    </header>
        <form class="Tabla4" id="frmRegistrarInvitado" method="POST">
             <input type="hidden" name="accion" id="accion" value="Agregar">
              <input type="hidden"name="" id="" value="">
               <input type="hidden" name="idEvento" id="accion" value="<%
            try {
                    String valor = request.getParameter("valor");
                    out.print(valor);
                } catch (Exception e) {
                   
                }
        %>">
        <h2 class="Ini2">Registro Invitado</h2>
        <input type="text" onkeyup="consultarpersona1()" id="txtIdentificacion" placeholder="&#127380; Identificacion" name="txtIdentificacion" autocomplete="off">
            <div id="mensajes" style="text-align:center">                    
            </div>
        <input type="text" id="txtNombre" placeholder="👤 Nombre" name="txtNombre" >
            <input type="text" id="txtApellido" placeholder="👥 Apellido" name="txtApellido">
            <input type="text" id="txtCorreo" placeholder="&#128386; Correo Electronico" name="txtCorreo">
            <input type="number"  id="txtCelular" placeholder="📲 Celular" name="txtCelular">         
            
            <input size="12" type="text"id="txtEmpresa"   placeholder="&#127963; Empresa" name="txtEmpresa" >
            
            <select id="cbsexo" name="cbsexo">
                <option>seleccionar</option>
                <option>Masculino</option>
                <option>Femenino</option>
                <option>Otro</option>
            </select>
           
            <input class="boton1" type="button" value="Registrar" id="btnRegistrarInvitado">
           
            <div id="mensaje" style="text-align: center">
               ${mensaje}
            </div>    
    
        </form>
  
        <footer>
               <%@ include file="../PaginaPrincipal/footer.jsp" %> 
        </footer>   
    </body>
</html>
