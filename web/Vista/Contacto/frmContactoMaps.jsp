<%-- 
    Document   : frmContactoMaps
    Created on : 5/10/2019, 10:58:11 AM
    Author     : Kevin Cutiva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Contacto</title>
        <%@ include file="../PaginaPrincipal/Rutas-Head.jsp" %> 
    </head>
    <body>
      <header>
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
            <p class="texdireccion">SENA INDUSTRIAL, Carrera 9, Huila</p>
            <p class="texcorreo">
                <a href="mailto:servicioalciudadano@sena.edu.co">Contactenos</a>
            </p>
        </header>

        <form class="Tabla3">
            <iframe class="maps" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3984.486780644574!2d-75.28780198574192!3d2.9623458978425004!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8e3b746668a5f7f7%3A0x3fcec03b9c2c0e85!2sSENA%20INDUSTRIAL!5e0!3m2!1ses-419!2sco!4v1570892536645!5m2!1ses-419!2sco" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen=""></iframe>
        </form>
      
        <footer>
            <%@ include file="../PaginaPrincipal/footer.jsp" %> 
        </footer>
    </body>
</html>
