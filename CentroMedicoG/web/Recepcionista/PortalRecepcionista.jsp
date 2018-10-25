<%-- 
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Title and meta tag -->
    <title>Portal</title>
    <!-- StyleSheets -->
    
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
     
     <script>
         
     </script>
    </head>
    
    <body>
        <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Portal WEB</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="">Mantenimiento
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="<%=request.getContextPath()%>/AdminPaciente?opcion=3">Paciente</a></li>
          <li><a href="<%=request.getContextPath()%>/AdminEmpleado?opcion=3">Empleado</a></li>
          <li><a href="<%=request.getContextPath()%>/AdminMedicamentos?opcion=3">Medicamentos</a></li>
        </ul>
      </li>
      <li><a class="dropdown-toggle" data-toggle="dropdown" href="#">Proceso
            <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Vista de Pacientes</a></li>
        </ul>
      </li>
      <li><a class="dropdown-toggle" data-toggle="dropdown" href="#">Reporte
      <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="newjspmenu.jsp">Listado de Pacientes</a></li>
        </ul>
      </li>
      <li><a class="dropdown-toggle" data-toggle="dropdown" href="#">Cuenta
      <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Cerrar Sesión</a></li>
          <li><a href="#">Configuración</a></li>
        </ul>
      </li>
    </ul>
  </div>
      
</nav>
    <div>
          <img src="<%=request.getContextPath()%>/Posta_1.jpg" width="100%" height="100%">
    </div>
        
         
        </body>
        
        
</html>