package Servlets;

import DAO.MedicamentosDAO;
import Entidades.Medicamentos;
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


@WebServlet(name = "AdminMedicamentos", urlPatterns = {"/AdminMedicamentos"})
public class AdminMedicamentos extends HttpServlet {
MedicamentosDAO DAO=new MedicamentosDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("Hola Servlet");
        int accion=Integer.parseInt(request.getParameter("opcion"));
        
        System.out.println(accion);
        try{
            switch(accion){
                case 1:
                    System.out.println("Estás registrando "+request.getParameter("COD"));
                    registrar(request,response);
                    
                    break;
                case 2:
                    System.out.println("Estás obteniendo el medicamento");
                    Obtener(request,response);
                    
                    break;
                case 3:
                    System.out.println("Estás mostrando la tabla Medicamentos");
                    mostrar(request,response);
                    
                    break;
                case 4:
                    System.out.println("Estás Actualizando el medicamento con COD: "+
                            request.getParameter("COD"));
                    editar(request,response);
                    
                    break;
                case 5:
                    System.out.println("Estás eliminando a "+request.getParameter("COD")+" "+request.getParameter("nombre"));
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


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Medicamentos med = new Medicamentos();
                String Codigo_enfermera= request.getParameter("Codigo_enfermera");
                String nombre= request.getParameter("nombre");
                String Precio_unitario= request.getParameter("precio_unitario");
                String descripcion= request.getParameter("descripcion");
                String stock= request.getParameter("stock");
		if(DAO.registrar(Codigo_enfermera,nombre,Precio_unitario,descripcion,stock))
                {
                    System.out.println("El medicamento esta registrado");
                    mostrar(request,response);
                }else{
                    System.out.println("El medicamento no está registrado");
                }
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/Recepcionista/PacienteMant.jsp");
		//dispatcher.forward(request, response);
	}
    private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Enfermera/MedicamentoMant.jsp");//Recepcionista/PacienteMant.jsp
		List<Medicamentos> listaMedicamentos= DAO.listarMedicamentos();
		request.setAttribute("lista", listaMedicamentos);
		dispatcher.forward(request, response);
	}
        
    private void Obtener(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		          System.out.println(""+request.getParameter("COD"));
                Medicamentos medicamentos = DAO.obtenerPorId(request.getParameter("COD"));
                System.out.println("Es una prueba de que llega a sacar el objeto : "+medicamentos.getNom_meds());
                List<Medicamentos> Amedicamentos=DAO.listarMedicamentosesXCod_meds(medicamentos);
                System.out.println("Esto es prueba de que está en el list "+Amedicamentos.size()+Amedicamentos.contains(medicamentos)+Amedicamentos.get(3));
		request.setAttribute("lista", Amedicamentos);
                
                //mostrarEditar(request,response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("");//Recepcionista/PacienteMant.jsp
		dispatcher.forward(request, response);
	}
    private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		          System.out.println(""+request.getParameter("descripcion")+" "+request.getParameter("nombre"));
                int Codigo_medicamento=Integer.parseInt(request.getParameter("COD"));
                int Codigo_enfermera= Integer.parseInt(request.getParameter("Codigo_enf"));
                String nombre= request.getParameter("nombre");
                double Precio_unitario= Double.parseDouble(request.getParameter("preunit"));
                String descripcion= request.getParameter("descripcion");
                int stock= Integer.parseInt(request.getParameter("stock"));
                Medicamentos medicamentos= new Medicamentos(Codigo_medicamento,Codigo_enfermera,nombre,Precio_unitario,descripcion,stock);
		if(DAO.actualizar(medicamentos)){
                    System.out.println("El medicamento está actualizado");
                    
                }else{
                    System.out.println("El medicamento no está actualizado");
                }
                mostrar(request,response);
                //RequestDispatcher dispatcher = request.getRequestDispatcher("Recepcionista/.jsp");
		//dispatcher.forward(request, response);
	}
    public void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		String COD= request.getParameter("COD");
                
                if(DAO.eliminarMedicamentos(COD)){
                    System.out.println("Se ha eliminado el medicamento : "+COD);
                }else{
                    System.out.println("Ha ocurrido un error al elimnar");
                }
		mostrar(request,response);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("Recepcionista/PacienteMant.jsp");
		//dispatcher.forward(request, response);
		
	}
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
