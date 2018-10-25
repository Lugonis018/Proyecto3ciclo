package DAO;

import Entidades.Medicamentos;
import UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MedicamentosDAO extends ConexionBD{
    Connection cn;
    PreparedStatement pt;
    ResultSet rs;
    ArrayList<Medicamentos> lista;
    Medicamentos objMedicamentos;
    public boolean registrar(String cod_enf, String nom_meds,
            String preunit_meds, String desc_meds, String stock_meds){
        PreparedStatement pst=null;
        try{
         String consulta= "insert into Medicamentos(cod_enf,nom_meds,preunit_meds,desc_meds,stock_meds) values(?,?,?,?,?)";
        pst= getConexion().prepareStatement(consulta); 
        
        pst.setString(1, cod_enf);
        pst.setString(2, nom_meds);
        pst.setString(3, preunit_meds);
        pst.setString(4, desc_meds);
        pst.setString(5, stock_meds);
        pst.executeUpdate();   
        }catch(Exception ex){
            System.out.println("error "+ex);
            return false;
        }
        return true;
    }
    public ArrayList<Medicamentos> listarMedicamentos(){
        try{
            ConexionBD conex = new ConexionBD();
            cn = conex.getConexion();
            pt = cn.prepareStatement("select * from Medicamentos");
            rs = pt.executeQuery();
            lista = new ArrayList<Medicamentos>();
            while(rs.next()){
                objMedicamentos = new Medicamentos();
                objMedicamentos.setCod_meds(rs.getInt(1));
                objMedicamentos.setCod_enf(rs.getInt(2));
                objMedicamentos.setNom_meds(rs.getString(3));
                objMedicamentos.setPreunit_meds(rs.getDouble(4));
                objMedicamentos.setDesc_meds(rs.getString(5));
                objMedicamentos.setStock_meds(rs.getInt(6));             
                lista.add(objMedicamentos);
            }
            pt.close();
            rs.close();
            cn.close();
        }catch(Exception e){
            
        }
        return lista;
    }
    public ArrayList<Medicamentos> listarMedicamentosesXCod_meds(Medicamentos med){
        try{
            lista = new ArrayList<Medicamentos>();
            while((med)!=null){
                Medicamentos medicamentos = new Medicamentos();
                medicamentos.setCod_meds(med.getCod_meds());
                medicamentos.setCod_enf(med.getCod_enf());
                medicamentos.setNom_meds(med.getNom_meds());
                medicamentos.setPreunit_meds(med.getPreunit_meds());
                medicamentos.setDesc_meds(med.getDesc_meds());
                medicamentos.setStock_meds(med.getStock_meds());              
                lista.add(medicamentos);
            }
        }catch(Exception e){
            System.out.println("Ocurrió un error bien prron.. + 10 lince :"+e);
        }
        return lista;
    }
     public Medicamentos obtenerPorId(String cod_meds) throws SQLException {
		Medicamentos Med = null;
                ConexionBD conex = new ConexionBD();
                cn = conex.getConexion();
		String sql = "SELECT * FROM Medicamentos WHERE cod_meds=?";
		PreparedStatement statement = cn.prepareStatement(sql);
		statement.setString(1, cod_meds);
 
		rs = statement.executeQuery();
		if (rs.next()) {
			Med = new Medicamentos(rs.getInt("cod_meds"),
                                rs.getInt("cod_enf"),
                                rs.getString("nom_meds"),
				rs.getDouble("preunit_meds"),
                                rs.getString("desc_meds"),
                                rs.getInt("stock_meds"));

		}
                statement.close();       
		rs.close();
		cn.close();
		return Med;
	}
     public boolean actualizar(Medicamentos med) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE Medicamentos set cod_enf=?,nom_meds=?,preunit_meds=?,desc_meds=?,stock_meds=? where  cod_meds=?";
		ConexionBD conex = new ConexionBD();
		cn=conex.getConexion();
		PreparedStatement statement = cn.prepareStatement(sql);
                
		
		statement.setInt(1, med.getCod_enf());
		statement.setString(2, med.getNom_meds());
		statement.setDouble(3, med.getPreunit_meds());
		statement.setString(4, med.getDesc_meds());
                statement.setInt(5, med.getStock_meds());
                statement.setInt(6, med.getCod_meds());
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		cn.close();
		return rowActualizar;
	}
      public  boolean  eliminarMedicamentos(String COD)
    {
        PreparedStatement pst=null;
        
        try
        {
            String consulta= "delete Medicamentos where cod_meds=?";
            pst= getConexion().prepareStatement(consulta); 
            pst.setString(1, COD);
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
