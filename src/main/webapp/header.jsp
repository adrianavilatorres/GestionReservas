<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Reserva online</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 
        <script src="/js/jquery.min.js"></script>
        <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <script src="/js/bootstrap.min.js" ></script>
        <script src="/js/bootstrap3-floating-labels.js" type="text/javascript"></script>
        <link href="/css/bootstrap3-floating-labels.css" rel="stylesheet" type="text/css"/> 
    -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" 
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 
    integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" 
    crossorigin="anonymous">
    <link href="../css/estilos.css" rel="stylesheet">
    <!--<link href="css/estilos.css" rel="stylesheet">-->
    </head>
    <body>
       
        <!-- Static navbar -->            
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class=" navbar-brand">
                <img class=" navbar-brand" src="../img/profile.png" width="30px">
                <% 
                
                    Cookie loginCookie = null;
                    String userName = "";
                    Cookie[] cookies = request.getCookies();
                    if (cookies != null) {
                        for (Cookie cookie : cookies) {
                            if (cookie.getName().equals("ges_res.user")) {
                                loginCookie = cookie;
                                userName = loginCookie.getValue();
                                break;
                            }
                        }
                        if (loginCookie!=null) {
                            
                        }else{
                            userName = "Login";
                        }
                        
                    }
                %>
                
                <a class=" navbar-brand" href=""><%= userName%></a>
            </div>
            <a class="navbar-brand" href="/">Reservas OnLine</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="nav navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Usuarios <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-item"><a href="/privado/userRead.jsp">Listado</a></li>
                            <li class="dropdown-item"><a href="/privado/userCreate.jsp">Alta</a></li>
                            <li class="dropdown-item" ><a href="/privado/userUpdate.jsp">Modificación</a></li>
                            <li class="dropdown-item"><a href="/privado/userDelete.jsp">Borrado</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Instalaciones <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-item"><a href="/privado/instalacionRead.jsp">Listar</a></li>
                            <li class="dropdown-item"><a href="/privado/instalacionCreate.jsp">Alta</a></li>
                            <li class="dropdown-item"><a href="/privado/instalacionUpdate.jsp">Modificación</a></li>
                            <li class="dropdown-item"><a href="/privado/instalacionDelete.jsp">Borrado</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Horarios <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-item" ><a href="/privado/horarioRead.jsp">Listar</a></li>
                            <li class="dropdown-item"><a href="/privado/horarioCreate.jsp">Alta</a></li>
                            <li class="dropdown-item"><a href="/privado/horarioUpdate.jsp">Modificación</a></li>
                            <li class="dropdown-item"><a href="/privado/horarioDelete.jsp">Borrado</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Reservas <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-item" ><a href="/privado/reservas.jsp">Listar</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="card">