<%-- 
    Document   : Menu
    Created on : 11/09/2019, 11:28:46 AM
    Author     : TOBBY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">


<link href="Css/menu2.css" rel="stylesheet" type="text/css"/>
<script src="../Js/menu.js" type="text/javascript"></script>
<link href="Css/Pie De Pagina.css" rel="stylesheet" type="text/css"/>
<header>
    <div class="menu-toggle" id="hamburger" onclick="mostrar()">
            <i class="fas fa-bars"></i>
        </div>
        <div class="overlay"></div>
        <div class="container">
            <nav>
                <div class="logo"><span> <img src="../imagenes/EveSen.png" alt=""/></span></div>
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Services</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
            </nav>
        </div>
</header>
        <footer>
             <%@ include file="../PaginaPrincipal/footer.jsp" %> 
        </footer>
        
        