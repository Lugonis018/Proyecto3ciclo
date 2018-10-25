<%@page import="Entidades.Medicamentos"%>
<%@page import ="java.util.ArrayList"%>

<%!
    	ArrayList<Medicamentos>  listReg2;
%>


<html>
    <head>
        <script src="js/jquery-3.3.1.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/BuscadorTabla.js" type="text/javascript"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento Medicamentos</title>
        <script>
            function actualizar(){
                        var cod_meds1 = document.getElementById("COD").value;
                        var cod_enf1 = document.getElementById("COD_enfermera").value;
                        var noml = document.getElementById("nombre").value;
                        var preunitl = document.getElementById("precio_unitario").value;
                        var descl = document.getElementById("descripcion").value;
                        var stockl = document.getElementById("stock").value;
                    
                        document.formR.action = "<%=request.getContextPath()%>/AdminMedicamentos?opcion=4&COD="+cod_meds1+
                    "&COD_enf="+cod_enf1+"&nombre="+noml+"&preunit="+preunitl+"&descripcion="+descl+"&stock="+stockl;
                    
                        
                        alert("Sé está pidiendo actualizar medicamentos "+cod_meds1+cod_enf1+""+noml+preunitl+descl+stockl);
                        document.formR.submit();
                }
            
        </script>
        <script>
             function ver(cod,cod_enf,nom,preunit,desc,stock){
             alert("entra a ver"+cod+cod_enf+nom+preunit+desc+stock);
                document.getElementById("COD").value =cod;
                document.getElementById("COD_enfermera").value =cod_enf;
                document.getElementById("nombre").value=nom;
                document.getElementById("precio_unitario").value=preunit;
                document.getElementById("descripcion").value=desc;
                document.getElementById("stock").value=stock;
                
            }
        </script>
        <script> 
        
        function eliminar(cod)
        {
            
            document.formu.action="<%=request.getContextPath()%>/AdminMedicamentos?opcion=5&COD="+cod;
            document.formu.submit();
            alert("Has eliminado el medicamento "+cod);
        }
        </script>
    </head>
    <body>
    <center> 
<!--         Aquí empieza la tabla de ingresar datos                   --->
<div class="container">
        <form input type="submit" name="formR" action="<%=request.getContextPath()%>/AdminMedicamentos" method="post">
            
                <div class="container">
                    <div class="text-justify">    
                    
                        <input type="hidden" id="COD" name="COD_meds" value=""><br>
                        <label class="control-label text-right">Codigo de la Enfermera:</label>
                        <input class="form-control text-justify" type="text" id="COD_enfermera" name="COD_enfermera" value=""/>
                        <br>
                        <label class="control-label text-right">Nombre del Medicamento:</label>
                        <input class="form-control text-justify " type="text" id="nombre" name="nombre" value=""/>
                        <br>
                        <label class="control-label text-right">Precio Unitario:</label>
                        <input class="form-control text-justify" type="text" id="precio_unitario" name="precio_unitario" value=""/>
                        <br>
                        <label class="control-label text-right">Descripción del Medicamento:</label>
                        <input class="form-control text-justify" type="text" id="descripcion" name="descripcion" value=""  />
                        <br>
                        <label class="control-label text-right">Stock:</label>
                        <input class="form-control text-justify" type="text" id="stock" name="stock" value="" />
                        <br>
                        <div class="container text-center">    
                        <input type="hidden" name="opcion" value="1">
                        <input class="btn-success" type="submit" value="Registrar" />
                        <input class="btn-primary" type="button" value="Modificar" onclick="actualizar()">
                        <input class="btn-danger" type="reset" value="Borrar"/>
                        </div>   
                    </div>
                </div>    
            
                       
        </form>
</div>            
            
<!--              Aquí empieza la tabla de mostrar 
-->            
        <form name="formu" method="post">
            <br>
            <div class="container text-justify">
            <label class="control-label text-justify">Buscar:</label>
            <input class="form-control" id="TerminoXbusqueda" type="text" onkeyup="doSearch()" />
            </div>
            <br>
            <br>
            <!--<input type="hidden" name= "opcion" value="3">-->
            <div class="container">
            <table id="datosr" class="table table-bordered table-hover">
                <thead>
                    <tr class="danger">
                    <th class="text-center">Codigo Medicamento</th>
                    <!--<td width="100">Codigo Enfermera</td>-->
                    <th class="text-center">Nombre Medicamento</th>
                    <th class="text-center">Precio Unitario</th>
                    <th class="text-center">Descripcion</th>
                    <th class="text-center">Stock</th>
                    <th class="text-center">Seleccionar</th>
                    <th class="text-center">Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                <%if((listReg2= (ArrayList<Medicamentos>)request.getAttribute("lista"))!=null){
                    for(Medicamentos u:listReg2)
                    {
                %>
                <tr>
                    <td><%=u.getCod_meds()%></td>
                    <!--<td></td>-->
                    <td><%=u.getNom_meds()%></td>
                    <td><%=u.getPreunit_meds()%></td>
                    <td><%=u.getDesc_meds()%></td>
                    <td><%=u.getStock_meds()%></td>
                    
                    
          
                    <td align="center"><input class="btn-primary" type="button" value="Ver" onclick="ver('<%=u.getCod_meds()%>','<%=u.getCod_enf()%>',
                                '<%=u.getNom_meds()%>','<%=u.getPreunit_meds()%>','<%=u.getDesc_meds()%>','<%=u.getStock_meds()%>')" ></td>
                    <td align="center"><input class="btn-danger" type="button" value="Eliminar" onclick="eliminar('<%=u.getCod_meds()%>')" ></td>        
                </tr>
                <%
                    }

                
                }%>
               </tbody>     
            </table>
            </div>
        </form>                                      
    </center>
    </body>
</html>