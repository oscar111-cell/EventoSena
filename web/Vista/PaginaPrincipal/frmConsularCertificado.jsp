<%-- 
    Document   : frmConsularCertificado
    Created on : 25/09/2019, 04:44:52 PM
    Author     : Kevin Cutiva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Certificados</title>
        <%@ include file="Rutas-Head.jsp" %> 
    </head>
    <body>
        
    <header class="">
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
        <form class="Tabla2" id="frmRegistrarPersonal" method="POST" action="../ControllerUsuario">
             <input type="hidden" name="accion" id="accion" value="Agregar">
              <input type="hidden"name="" id="" value="">
        <h2 class="Ini3">Consultar certificados</h2>
            <select id="cbsexo" name="cbsexo">
                <option>Cédula de Ciudadanía</option>
                <option>Tarjeta de Identidad</option>
                <option>Cédula de Extranjería</option>
                <option>Número ciego Sena</option>
                <option>Número de Identificación Tributaria</option>
                <option>Pasaporte</option>
                <option>PEP - RAMV</option>
                <option>Documento Nacional de Identificación</option>
            </select>   
        
            <input type="text" id="txtIdentificacion" placeholder="&#127380; Número de documento" name="txtIdentificacion" >
            <input class="boton" type="submit" value="Consultar" id="btnRegistrar">
           
            <div id="mensaje" style="text-align: center">
               ${mensaje}
            </div>
        </form>
   
        <footer>
             <%@ include file="../PaginaPrincipal/footer.jsp" %> 
        </footer>
    </body>
</html>
