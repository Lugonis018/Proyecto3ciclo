<%-- 
    Document   : Login.jsp
    Created on : 15/07/2018, 12:15:51 PM
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script rel="stylesheet" href="/css/boostrap.min.css"></script>
        <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>

    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>CENTRO DE SALUD</title>
    </head>
    <body background="images/Posta_1.jpg">
    <center>
    <div class="Login login-card">   
        <div class="container">
            <h2>Julio C. Tello</h2>
        <form action="<%=request.getContextPath()%>/Sesion" method="post">
            <div class="form-group">
                <label for="email">Usuario</label>
                <input type="text" name="usuario" value="" placeholder="Usuario">
            </div>
            <div class="form-group">
                <label for="pwd">Contraseña</label>
                <input type="password" name="contra" value="" placeholder="contraseña">
            </div>
                <input class="login login-submit" type="submit" value="Entrar">
                </div>
     
        </form>       
    </div>
    </center>
            <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>
  </body>
</html>
