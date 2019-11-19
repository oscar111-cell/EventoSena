<%-- 
    Document   : MenuPrincipal
    Created on : 18/10/2019, 09:01:31 AM
    Author     : Kevin Cutiva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pagina Principal</title>
       <%@ include file="../PaginaPrincipal/Rutas-Head.jsp" %> 
        <%@ include file="../PaginaPrincipal/Rutas-Head-Principal.jsp" %> 
        <script src="../Js/jsListarEventos.js" type="text/javascript"></script>
    </head>

    <body>
        <!--Aca Esta Nuestro Menu-->
        <header class="headerPrincipal">
      <div class="menu-toggle" id="hamburger" onclick="mostrar()">
            <i class="fas fa-bars"></i>
      </div>
            <div class="overlay"></div>
        <div class="container1" >
            <nav>
                <div class="logo1"><span> <img src="../imagenes/EveSen.png" alt=""/></span></div>
                <ul>
                    <li><a href="../PaginaPrincipal/frmConsularCertificado.jsp">Certificados</a></li>
                    <li><a href="../Contacto/frmContactoMaps.jsp">Contacto</a></li>
                    <li><a href="../Rol_Administrador/LoginAdmin.jsp">Iniciar</a></li>
                </ul>
            </nav>
        </div>
           <!-- <video src="../Recursos/../imagenes/videoplayback.mp4" autoplay loop muted></video>    -->
        <form>    
            <!--Aca se encuentra nuestro carrusel de imagenes-->
            <div class="slider">
                <ul>
                    <li><img src="../imagenes/Carrusel/22367f_dde37ab30e50420d80877494a38afeff~mv2.jpg" alt=""></li>
                    <li><img src="../imagenes/Carrusel/sena5.jpg" alt=""></li>
                    <li><img src="../imagenes/Carrusel/SENA2.jpg" alt=""></li>
                    <li><img src="../imagenes/Carrusel/pic01.JPG" alt=""></li>
                </ul>
            </div>
         </form>  
            
     <!--ACA SE ENCUENTRA NUESTRO CARTAS DE PRESENTACION CARDS-->  
     
    <h1 class="title">EVENTOS PROXIMOS</h1>
    
    <div class="container"id="containerr">
       
       
        
      
    </div>
    </header>
        
        <!--Aca Ponemos Nuestro Contenido-->
        <section>
        </section> 
        <!--Aca Esta Nuestro Pie De Pagina-->
        <footer>
         
             <%@ include file="../PaginaPrincipal/footer.jsp" %> 
        </footer>
        
    </body>
</html>
