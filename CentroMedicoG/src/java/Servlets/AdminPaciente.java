/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.PacienteDAO;
import Entidades.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "AdminPaciente", urlPatterns = {"/AdminPaciente"})
public class AdminPaciente extends HttpServlet {
PacienteDAO  DAO= new PacienteDAO();
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
                    System.out.println("Estás registrando "+request.getParameter("DNI"));
                    registrar(request,response);
                    
                    break;
                case 2:
                    System.out.println("Estás obteniendo al paciente");
                    Obtener(request,response);
                    
                    break;
                case 3:
                    System.out.println("Estás mostrando la tabla Paciente");
                    mostrar(request,response);
                    
                    break;
                case 4:
                    System.out.println("Estás Actualizando al paciente con DNI: "+
                            request.getParameter("DNI"));
                    editar(request,response);
                    
                    break;
                case 5:
                    System.out.println("Estás eliminando a "+request.getParameter("DNI")+" "+request.getParameter("nombre")+" "+
                            request.getParameter("apellido"));
                    eliminar(request,response);
                    
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
		Paciente pc = new Paciente();
                String DNI= request.getParameter("DNI");
                String nombre= request.getParameter("nombre");
                String apellido= request.getParameter("apellido");
                String seguro= request.getParameter("seguro");
                String ecivil= request.getParameter("ecivil");
                String telefono= request.getParameter("telefono");
                String sexo= request.getParameter("sexo");
                String fechanac= request.getParameter("fechanac");
                String direccion= request.getParameter("direccion");
                String nhistmed= request.getParameter("nhistmed");
                System.out.println(""+request.getParameter("fechanac"));
		if(DAO.registrar(DNI, nombre, apellido, seguro,ecivil,telefono,sexo,fechanac,direccion,nhistmed))
                {
                    System.out.println("El paciente esta registrado");
                    mostrar(request,response);
                }else{
                    System.out.println("El paciente no está registrado");
                }
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/Recepcionista/PacienteMant.jsp");
		//dispatcher.forward(request, response);
	}
	
	
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("Recepcionista/PacienteMant.jsp");
		List<Paciente> listaPacientes= DAO.listarPacientes();
		request.setAttribute("lista", listaPacientes);
		dispatcher.forward(request, response);
	}	
	private void mostrarEditar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
                RequestDispatcher dispatcher = request.getRequestDispatcher("Recepcionista/PacienteMant.jsp");
                request.setAttribute("paciente", request.getAttribute("paciente"));
                dispatcher.forward(request,response);
        }
	private void Obtener(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		          System.out.println(""+request.getParameter("DNI"));
                Paciente paciente = DAO.obtenerPorId(request.getParameter("DNI"));
                System.out.println("Es es prueba de que llega a sacar el objeto : "+paciente.getNom_pac());
                List<Paciente> Apaciente=DAO.listarPacienteXdni(paciente);
                System.out.println("Esto es prueba de que está en el list "+Apaciente.size()+Apaciente.contains(paciente)+Apaciente.get(3));
		request.setAttribute("lista", Apaciente);
                
                //mostrarEditar(request,response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Recepcionista/PacienteMant.jsp");
		dispatcher.forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		          System.out.println(""+request.getParameter("fechanac")+" "+request.getParameter("nombre"));
                String DNI= request.getParameter("DNI");
                String nombre= request.getParameter("nombre");
                String apellido= request.getParameter("apellido");
                String direccion= request.getParameter("direccion");
                String sexo= request.getParameter("sexo");
                String telefono= request.getParameter("telefono");
                String ecivil= request.getParameter("ecivil");
                String nhistmed= request.getParameter("nhistmed");
                String fechanac= request.getParameter("fechanac").toString();
                String seguro= request.getParameter("seguro");
                Paciente paciente= new Paciente(DNI,nombre,apellido,direccion,sexo,telefono,
                        ecivil,nhistmed,fechanac,seguro);
		if(DAO.actualizar(paciente)){
                    System.out.println("El usuario está actualizado");
                }else{
                    System.out.println("El usuario no está actualizado");
                }
                mostrar(request,response);
                //RequestDispatcher dispatcher = request.getRequestDispatcher("Recepcionista/.jsp");
		//dispatcher.forward(request, response);
	}
	
	public void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		String DNI= request.getParameter("DNI");
                
                if(DAO.eliminarPaciente(DNI)){
                    System.out.println("Se ha eliminado al paciente : "+DNI);
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
