/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.EmpleadoDAO;
import DAO.PacienteDAO;
import Entidades.Empleado;
import Entidades.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ANDRES
 */
@WebServlet(name = "AdminEmpleado", urlPatterns = {"/AdminEmpleado"})
public class AdminEmpleado extends HttpServlet {
EmpleadoDAO  DAO= new EmpleadoDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("Hola Servlet");
        int accion=Integer.parseInt(request.getParameter("opcion"));
        
        System.out.println(accion);
        try{
            switch(accion){
                case 1:
                    registrar(request,response);
                    System.out.println("Estás registrando "+request.getParameter("contra"));
                    break;
                case 2:
                    Obtener(request,response);
                    System.out.println("Estás obteniendo al paciente");
                    break;
                case 3:
                    mostrar(request,response);
                    System.out.println("Estás mostrando la tabla Paciente");
                    break;
                case 4:
                    editar(request,response);
                    System.out.println("Estás Actualizando al paciente con DNI: "+
                            request.getParameter("dni"));
                    break;
                case 5:
                    eliminar(request,response);
                    System.out.println("Estás eliminando a "+request.getParameter("codigo")+" "+request.getParameter("nombre")+" "+
                            request.getParameter("apellido"));
                    break;
                default:
                    System.out.println("No se ha enviado ningún caso");
                    break;
            
            }
        }catch(Exception e){
            System.out.println(""+e);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    public void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Empleado emp = new Empleado();
                System.out.println(""+request.getParameter("contra"));
                String nombre= request.getParameter("nombre");
                String apellido= request.getParameter("apellido");
                String direccion= request.getParameter("direccion");
                String sueldo= request.getParameter("sueldo");
                String dni= request.getParameter("dni");
                String telefono= request.getParameter("telefono");
                String fecha_entrada= request.getParameter("fechaentrada");
                String fecha_salida= request.getParameter("fechasalida");
                String usuario= request.getParameter("usuario");
                String contra= request.getParameter("contra");
		if(DAO.registrar(nombre, apellido, direccion, sueldo , dni,telefono,fecha_entrada,fecha_salida,usuario,contra ))
                {
                    System.out.println("El paciente esta registrado");
                    mostrar(request,response);
                }else{
                    System.out.println("El paciente no está registrado");
                }
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/Recepcionista/PacienteMant.jsp");
		//dispatcher.forward(request, response);
	}
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Recepcionista/testregistro.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("Recepcionista/EmpleadoMant.jsp");
		ArrayList<Empleado> listaEmpleados= DAO.listarEmpleados();
		request.setAttribute("lista", listaEmpleados);
		dispatcher.forward(request, response);
	}	
	private void mostrarEditar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
                RequestDispatcher dispatcher = request.getRequestDispatcher("Recepcionista/EmpleadoMant.jsp");
                request.setAttribute("paciente", request.getAttribute("paciente"));
                dispatcher.forward(request,response);
        }
	private void Obtener(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Empleado empleado = DAO.obtenerPorId(request.getParameter("codigo"));
		request.setAttribute("empleado", empleado);
                mostrarEditar(request,response);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("Recepcionista/testregistro.jsp");
		//dispatcher.forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		
                String codigo= request.getParameter("codigo");
                String nombre= request.getParameter("nombre");
                String apellido= request.getParameter("apellido");
                String direccion= request.getParameter("direccion");
                String sueldo= request.getParameter("sueldo");
                String dni= request.getParameter("dni");
                String telefono= request.getParameter("telefono");
                String fecha_entrada= request.getParameter("fechaentrada");
                String fecha_salida= request.getParameter("fechasalida");
                String usuario= request.getParameter("usuario");
                String contraseña= request.getParameter("contraseña");
                Empleado empleado= new Empleado(codigo,nombre,apellido,direccion,sueldo,dni,
                        telefono,fecha_entrada,fecha_salida,usuario, contraseña);
		if(DAO.actualizar(empleado)){
                    System.out.println("El usuario está actualizado");
                    mostrar(request,response);
                }else{
                    System.out.println("El usuario no está actualizado");
                }
                
	}
	
	public void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		String codigo= request.getParameter("codigo");
                
                if(DAO.eliminarEmpleado(codigo)){
                    System.out.println("Se ha eliminado al paciente : "+codigo);
                }else{
                    System.out.println("HA ocurrido un error al elimnar");
                }
		mostrar(request,response);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("Recepcionista/PacienteMant.jsp");
		//dispatcher.forward(request, response);
		
	}
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
