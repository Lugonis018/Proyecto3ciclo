<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       	<title>JSP Page</title>
        	
    </head>
              <body>
       	<center>
            		<form name="formu" action="<%=request.getContextPath()%>/AdminPaciente" >
                			
                                        <font color="white"> <h2>MANTENIMIENTO DE TABLAS</h2> </font>
                    <table>
                    	<tr>
                        <td>
                         <input type="hidden" name="opcion" value="3">
                            <input type="submit" value="Mantenimiento tabla de Usuarios">
                        </td>
                    	</tr>
                    </table>
            	</form>
           </center>
       </body>
</html>