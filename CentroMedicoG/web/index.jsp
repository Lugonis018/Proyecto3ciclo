<%-- 
    Document   : index
    Created on : 13/07/2018, 03:45:59 PM
    Author     : ANDRES
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME</title>
    </head>
    <body>
        <nav class=" navbar navbar-default">
            <div class="container-fluid">
                
                <div class="row">
                    <div class="col-sm-4"><img src="Esta.png" width="350" height="45"></div>
                    <div class="col-sm-2"><a href=""><h3>Inicio</h3></a></div>
                    <div class="col-sm-2"><a href=""><h3>Quienes somos</h3></a></div>
                    <div class="col-sm-2"><a href=""><h3>Contactos</h3></a></div>
                    <div class="col-sm-2"><a href="<%=request.getContextPath()%>/Login.jsp"><h3>Inicar Sesión</h3></a></div>
                </div>
                
             </div>
        </nav>
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="images/slider/atencion02.png" alt="Image" width="1600" height="350">
            <div class="carousel-caption">
            <h3>Centro de Salud Julio C. Tello</h3>
            <p>Distrito de Lurín</p>
            </div>
            </div>
        </div>
    <div class="container text-center">    
  <h3>Acerca de Nosotros</h3><br>
  <div class="row">
    <div class="col-sm-4" >
        <h4>Realizar una posta médica que este optimizada para que los pacientes
realizen sus consultas mas rapidas.
Asimismo implementar una base de datos que la posta utilizara 
para mejorar el redimientos de sus empleados</h4>
        <p><h2>Mision</h2></p>
    </div>
    <div class="col-sm-4"> 
        <h4>La empresa planea ser completamente reconocida a nivel nacional,
conocida por su optimizacion en la atencion al cliente.
Esto se planea de tal modo que revoluciona el modo en el que las
postas en los sectores pobres son vistos</h4>
        <p><h2>Visión</h2></p>    
    </div>
    <div class="col-sm-4">
      <div class="well">
          <p><h3>Centro de Salud Julio C. Tello</h3></p>
      </div>
      <div class="well">
       <p><h5>El centro medico "Julio C. Tello" es un centro de salud que beneficia,
actualmente con los servicios que presta a cerca de 18000 habitantes
de la zona Julio C. Tello - Lurin </h5></p>
      </div>
    </div>
  </div>
</div><br>
<footer class="container-fluid text-center">
    <p><h1>EQUIPO DE LA UNIVERSIDAD AUTONOMA DEL PERÚ</h1></p>

    </body>
</html>
