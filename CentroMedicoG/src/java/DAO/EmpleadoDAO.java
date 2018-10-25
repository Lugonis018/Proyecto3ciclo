
package DAO;

import Entidades.Empleado;

import UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadoDAO extends ConexionBD{
    Connection cn;
    PreparedStatement pt;
    ResultSet rs;
    ArrayList<Empleado> lista;
    Empleado objEmpleado;

        public boolean registrar(String nombre, String apellido, String direccion, String sueldo, String dni, String telefono, String fecha_entrada, String fecha_salida, String usuario, String contra) throws SQLException
      {
        PreparedStatement pst=null;
        try{
        String consulta= "insert into Empleado (nom_emple, ape_emple, dir_emple, suel_emple, dni_emple, tel_emple, fech_entra_emp, fech_sali_emp, usu_emple, contra_emple) values(?,?,?,?,?,?,?,?,?,?)";
        pst= getConexion().prepareStatement(consulta); 
        pst.setString(1, nombre);
        pst.setString(2, apellido);
        pst.setString(3, direccion);
        pst.setString(4, sueldo);
        pst.setString(5, dni);
        pst.setString(6, telefono);
        pst.setString(7, fecha_entrada);
        pst.setString(8, fecha_salida);
        pst.setString(9, usuario );
        pst.setString(10, contra );
        pst.executeUpdate();
        
        
    }catch(Exception ex){
        System.out.println("error "+ex);
        
        return false;
    }
    pst.close();    
    getConexion().close();
    return true;
      }
    public ArrayList<Empleado> listarEmpleados(){
        try{
            ConexionBD conex = new ConexionBD();
            cn = conex.getConexion();
            pt = cn.prepareStatement("select * from Empleado");
            rs = pt.executeQuery();
            lista = new ArrayList<Empleado>();
            while(rs.next()){
                objEmpleado = new Empleado();
                objEmpleado.setCodigo(rs.getString(1));
                objEmpleado.setNombre(rs.getString(2));
                objEmpleado.setApellido(rs.getString(3));
                objEmpleado.setDireccion(rs.getString(4));
                objEmpleado.setSueldo(rs.getString(5));
                objEmpleado.setDni(rs.getString(6));
                objEmpleado.setTelefono(rs.getString(7));
                objEmpleado.setFecha_entrada(rs.getString(8));
                objEmpleado.setFecha_salida(rs.getString(9));
                objEmpleado.setUsuario(rs.getString(10));
                objEmpleado.setContraseña(rs.getString(11));  
                lista.add(objEmpleado);
            }
            pt.close();
            rs.close();
            cn.close();
        }catch(Exception e){
            
        }
        return lista;
    }
        public Empleado obtenerPorId(String codigo) throws SQLException {
		Empleado emp = null;
                ConexionBD conex = new ConexionBD();
                cn = conex.getConexion();
		String sql = "SELECT * FROM Empleado WHERE cod_emple= ? ";
		PreparedStatement statement = cn.prepareStatement(sql);
		statement.setString(1, codigo);
 
		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			emp = new Empleado(rs.getString("cod_emple"),
                                rs.getString("nom_emple"),
                                rs.getString("ape_emple"),
				rs.getString("dir_emple"),
                                rs.getString("suel_emple"),
                                rs.getString("dni_emple"),
                                rs.getString("tel_emple"),
                                rs.getString("fech_entra_emple"),
                                rs.getString("fech_sali_emple"),
                                rs.getString("usu_emple"),
                                rs.getString("contra_emple"));
                        
		}
		rs.close();
		cn.close();
 
		return emp;
	}
        
            public boolean actualizar(Empleado emp) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE Empleado set nom_emple=?, ape_emple=? , dir_emple=?, suel_emple=?, dni_emple=?, tel_emple=?, fech_entra_emple=?, fech_sali_emple=?, usu_emple=?, contra_emple=? where  cod_emple=?";
		ConexionBD conex = new ConexionBD();
		cn=conex.getConexion();
		PreparedStatement statement = cn.prepareStatement(sql);
                
		statement.setString(1, emp.getNombre());
		statement.setString(2, emp.getApellido());
		statement.setString(3, emp.getDireccion());
		statement.setString(4, emp.getSueldo());
		statement.setString(5, emp.getDni());
                statement.setString(6, emp.getTelefono());
                statement.setString(7, emp.getFecha_entrada());
                statement.setString(8, emp.getFecha_salida());
                statement.setString(9, emp.getUsuario());
                statement.setString(10, emp.getContraseña());
                statement.setString(11, emp.getCodigo());
                
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		cn.close();
		return rowActualizar;
                
	}
            
         public  boolean  eliminarEmpleado(String codigo)
    {
        PreparedStatement pst=null;
        
        try
        {
            String consulta= "delete Empleado where cod_emple=?";
            pst= getConexion().prepareStatement(consulta); 
            pst.setString(1, codigo);
            pst.executeUpdate();
            pst.close();
            getConexion().close();
        } catch (Exception e)
        {
            System.out.println("error "+e);
            return false;
        }
        return  true;
    }           
    public boolean autenticacion(String usuario, String contra){
        PreparedStatement pst=null;
        ResultSet rs = null;
        try{
            String consulta= "select * from Empleado where usu_emple = ? and contra_emple = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contra);
            rs= pst.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch (Exception e){
            System.err.println("error " + e);
        }
        return false;
    }        
}
