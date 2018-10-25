/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Paciente;
import UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ANDRES
 */
public class PacienteDAO extends ConexionBD{
    Connection cn;
    PreparedStatement pt;
    ResultSet rs;
    ArrayList<Paciente> lista;
    Paciente objPaciente;
    public boolean registrar(String DNI, String nombre, String apellido,
            String seguro, String ecivil, String telefono, String sexo,
            String fechanac, String direccion,  String nhistmed)
      {
        PreparedStatement pst=null;
        try{
        String consulta= "insert into Paciente values(?,?,?,?,?,?,?,?,?,?)";
        pst= getConexion().prepareStatement(consulta); 
        pst.setString(1, DNI);
        pst.setString(2, nombre);
        pst.setString(3, apellido);
        pst.setString(4, seguro);
        pst.setString(5, ecivil);
        pst.setString(6, telefono);
        pst.setString(7, sexo);
        pst.setString(8, fechanac);
        pst.setString(9, direccion);
        pst.setString(10, nhistmed );
        pst.executeUpdate();
        
        
    }catch(Exception ex){
        System.out.println("error "+ex);
        
        return false;
    }
    return true;
     
    }  
    public ArrayList<Paciente> listarPacientes(){
        try{
            ConexionBD conex = new ConexionBD();
            cn = conex.getConexion();
            pt = cn.prepareStatement("select * from Paciente");
            rs = pt.executeQuery();
            lista = new ArrayList<Paciente>();
            while(rs.next()){
                objPaciente = new Paciente();
                objPaciente.setDni_pac(rs.getString(1));
                objPaciente.setNom_pac(rs.getString(2));
                objPaciente.setApe_pac(rs.getString(3));
                objPaciente.setSeg_pac(rs.getString(4));
                objPaciente.setEstci_pac(rs.getString(5));
                objPaciente.setTel_pac(rs.getString(6));
                objPaciente.setSex_pac(rs.getString(7));
                objPaciente.setFechanac_pac(rs.getString(8));
                objPaciente.setDir_pac(rs.getString(9));
                objPaciente.setNhistmed_pac(rs.getString(10));               
                lista.add(objPaciente);
            }
            pt.close();
            rs.close();
            cn.close();
        }catch(Exception e){
            
        }
        return lista;
    }
    public ArrayList<Paciente> listarPacienteXdni(Paciente pc){
        try{
            lista = new ArrayList<Paciente>();
            while((pc)!=null){
                Paciente paciente = new Paciente();
                paciente.setDni_pac(pc.getDni_pac());
                paciente.setNom_pac(pc.getNom_pac());
                paciente.setApe_pac(pc.getApe_pac());
                paciente.setSeg_pac(pc.getSeg_pac());
                paciente.setEstci_pac(pc.getEstci_pac());
                paciente.setTel_pac(pc.getTel_pac());
                paciente.setSex_pac(pc.getSex_pac());
                paciente.setFechanac_pac(pc.getFechanac_pac());
                paciente.setDir_pac(pc.getDir_pac());
                paciente.setNhistmed_pac(pc.getNhistmed_pac());               
                lista.add(paciente);
            }
        }catch(Exception e){
            System.out.println("Ocurrió un error bien prron.. + 10 lince :"+e);
        }
        return lista;
    }
    public Paciente obtenerPorId(String dni) throws SQLException {
		Paciente Pc = null;
                ConexionBD conex = new ConexionBD();
                cn = conex.getConexion();
		String sql = "SELECT * FROM Paciente WHERE dni_pac=?";
		PreparedStatement statement = cn.prepareStatement(sql);
		statement.setString(1, dni);
 
		rs = statement.executeQuery();
		if (rs.next()) {
			Pc = new Paciente(rs.getString("dni_pac"),
                                rs.getString("nom_pac"),
                                rs.getString("ape_pac"),
				rs.getString("dir_pac"),
                                rs.getString("sex_pac"),
                                rs.getString("tel_pac"),
                                rs.getString("estci_pac"),
                                rs.getString("nhistmed_pac"),
                                rs.getString("fechanac_pac"),
                                rs.getString("seg_pac"));
		}
                statement.close();       
		rs.close();
		cn.close();
		return Pc;
	}
    
    public boolean actualizar(Paciente pc) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE Paciente set nom_pac=?,ape_pac=?,seg_pac=?,estci_pac=?,tel_pac=?,sex_pac=?,fechanac_pac=?,dir_pac=?,nhistmed_pac=? where  dni_pac=?";
		ConexionBD conex = new ConexionBD();
		cn=conex.getConexion();
		PreparedStatement statement = cn.prepareStatement(sql);
                
		statement.setString(1, pc.getNom_pac());
		statement.setString(2, pc.getApe_pac());
		statement.setString(3, pc.getSeg_pac());
		statement.setString(4, pc.getEstci_pac());
		statement.setString(5, pc.getTel_pac());
                statement.setString(6, pc.getSex_pac());
                statement.setString(7, pc.getFechanac_pac());
                statement.setString(8, pc.getDir_pac());
                statement.setString(9, pc.getNhistmed_pac());
                statement.setString(10, pc.getDni_pac());
                
                
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		cn.close();
		return rowActualizar;
	}
        public  boolean  eliminarPaciente(String DNI)
    {
        PreparedStatement pst=null;
        
        try
        {
            String consulta= "delete Paciente where dni_pac=?";
            pst= getConexion().prepareStatement(consulta); 
            pst.setString(1, DNI);
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
}
