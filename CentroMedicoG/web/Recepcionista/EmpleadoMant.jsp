<%-- 
    Document   : EmpleadoMant
    Created on : 15/07/2018, 11:40:32 AM
    Author     : Sulca
--%>

<%@page import="Entidades.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
    	ArrayList<Empleado>  listReg;
        Empleado empleado;
%>

<%
        empleado = (Empleado)request.getAttribute("empleado");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-3.3.1.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/BuscadorTabla.js" type="text/javascript"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script>
            function actualizar(){
                        var cod1 = document.getElementById("codigo").value;
                        var nom1 = document.getElementById("nombre").value;
                        var ape1 = document.getElementById("apellido").value;
                        var dir1 = document.getElementById("direccion").value;
                        var sue1 = document.getElementById("sueldo").value;
                        var dni1 = document.getElementById("dni").value;
                        var tel1 = document.getElementById("telefono").value;
                        var fen1 = document.getElementById("fechaen").value;
                        var fsa1 = document.getElementById("fechasal").value;
                        var usu1 = document.getElementById("usu").value;
                        var contra1 = document.getElementById("contra").value ;
                        document.formR.action = "<%=request.getContextPath()%>/AdminPaciente?opcion=4&cod1="+cod1+
                    "&nombre="+nom1+"&apellido="+ape1+"&direccion="+dir1+"&sueldo="+sue1+"&dni="+dni1+"&telefono="+tel1+
                    "&fechaentrada="+fen1+"&fechasalida="+fsa1+"&usuario="+usu1+"&contraseña"+contra1;
                    
                        
                        alert("Sé está pidiendo actualizar al usuario "+dni1);
                        document.formR.submit();
                }
            
        </script>
        <script>
             function ver1(nom,ape,dir,suel,dni,tel,fechaen,fechasal,usu,contra){
                 alert("entra a ver"+nom+ape+dir+suel+dni+tel+fechaen+fechasal+usu+contra);
                
                document.getElementById("nombre").value =nom;
                document.getElementById("apellido").value=ape;
                document.getElementById("direccion").value =dir;
                document.getElementById("sueldo").value=suel;
                document.getElementById("dni").value=dni;
                document.getElementById("telefono").value=tel;
                document.getElementById("fechaen").value=fechaen;
                document.getElementById("fechasal").value=fechasal;
                document.getElementById("usu").value=usu;
                document.getElementById("contra").value=contra;
            }
        </script>
        <script> 
        
        function eliminar(codigo)
        {
            
            document.formu.action="<%=request.getContextPath()%>/AdminEmpleado?opcion=5&codigo="+codigo;
            document.formu.submit();
            alert("Has eliminado al usuario "+codigo);
        }
        </script>
        
        <title>JSP Page</title>
    </head>
    <body>
        <div class="text-primary text-center bg-success col-lg-push-10"><h1>Mantenimiento de Empleados</h1></div>
    <!--         Aquí empieza la tabla de ingresar datos --->
    <center>
        <div class="container">    
                <form input type="submit" name="formR" action="<%=request.getContextPath()%>/AdminEmpleado" method="post">
                <div class="container">
                    <div class="text-justify">
                        <input id="codigo" type="hidden" name="codigo" value="">
                        <label class="control-label text-right">Nombres:</label>
                        <input class="form-control text-justify" id="nombre" type="text" name="nombre" value="" placeholder="nom"/>
                        <label class="control-label text-right">Apellidos:</label>
                        <input class="form-control text-justify" id="apellido" type="text" name="apellido" value="" placeholder="ape" />
                        <label class="control-label text-right">Direccion:</label>
                        <input class="form-control text-justify" id="direccion" type="text" name="direccion" value="" placeholder="dir"/>
                        <label class="control-label text-right">Sueldo:</label>
                        <input class="form-control text-justify" id="sueldo" type="text" name="sueldo" value="" placeholder="suel" />
                        <label class="control-label text-right">DNI:</label>
                        <input class="form-control text-justify" id="dni" type="text" name="dni" value="" placeholder="dni" />
                        <label class="control-label text-right">Telefono:</label>
                        <input class="form-control text-justify" id="telefono" type="text" name="telefono" value="" placeholder="tel"/>
                        <label class="control-label text-right">Hora Entrada:</label>
                        <input class="form-control text-justify" id="fechaen" type="time" name="fechaentrada" value="" placeholder="fechen">
                        <label class="control-label text-right">Hora Salida:</label>
                        <input class="form-control text-justify" id="fechasal" type="time" name="fechasalida" value="" placeholder="fechsal" />
                        <label class="control-label text-right">Usuario:</label>
                        <input class="form-control text-justify" id="usu" type="text" name="usuario" value="" placeholder="usu"/>
                        <label class="control-label text-right">Password:</label>
                        <input class="form-control text-justify" id="contra" type="password" name="contra" value="" placeholder="con" />
                        <input type="hidden" name="opcion" value="1">
                        <br>
                        <div class="container text-center">
                        <td><input class="btn-success" type="submit" value="Registrar" /></td>
                        <td><input class="btn-primary" type="button" value="Modificar" onclick="actualizar()"></td>
                        <td><input class="btn-danger" type="reset" value="Borrar"/></td>
                        </div>
                    </div>
                </div>
                       
        </form>
        </div>    
            <!--         Aquí empieza la tabla de LISTADO--->
        <form name="formu" method="post">
            <!--<input type="hidden" name= "opcion" value="3">-->
            <div class="container text-justify">
            <label class="control-label text-justify">Buscar:</label>
            <input class="form-control" id="TerminoXbusqueda" type="text" onkeyup="doSearch()" />
            </div>
            <br>
            <div class="container">
            <table id="datosr" class="table table-bordered table-hover">
                <thead>
                    <!--<td width="100">Codigo</td>-->
                    <tr class="warning">
                    <th class="text-center">Nombre</th>
                    <th class="text-center">Apellido</th>
                    <th class="text-center">Direccion</th>
                    <th class="text-center">Sueldo</th>
                    <th class="text-center">DNI</th>
                    <th class="text-center">Telefono</th>
                    <th class="text-center">Fecha_entrada</th>
                    <th class="text-center">Fecha_salida</th>
                    <th class="text-center">usuario</th>
                    <th class="text-center">contraseña</th>
                    <th class="text-center">Ver</th>
                    <th class="text-center">Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                <%if((listReg= (ArrayList<Empleado>)request.getAttribute("lista"))!=null){
                    for(Empleado u:listReg)
                    {
                %>
                <tr>
                    <!--<td></td>-->
                    <td><%=u.getNombre()%></td>
                    <td><%=u.getApellido()%></td>
                    <td><%=u.getDireccion() %></td>
                    <td><%=u.getSueldo()%></td>
                    <td><%=u.getDni()%></td>
                    <td><%=u.getTelefono()%></td>
                    <td><%=u.getFecha_entrada()%></td>
                    <td><%=u.getFecha_salida()%></td>
                    <td><%=u.getUsuario()%></td>
                    <td><%=u.getContraseña()%></td>
                    <td align="center"><input class="btn-primary" type="button" value="Ver" onclick="ver1('<%=u.getNombre()%>','<%=u.getApellido()%>',
                                '<%=u.getDireccion()%>','<%=u.getSueldo()%>','<%=u.getDni()%>','<%=u.getTelefono()%>',
                                '<%=u.getFecha_entrada()%>','<%=u.getFecha_salida()%>','<%=u.getUsuario()%>','<%=u.getContraseña()%>')" ></td>
                    <td align="center"><input class="btn-danger" type="button" value="Eliminar" onclick="eliminar('<%=u.getCodigo()%>')" ></td>        
                </tr>
                <%
                    }
                    }
                %>
              </tbody>                  
            </table>
        </div>        
        </form>
                    
                    
    </center>
</body>           
</html>
