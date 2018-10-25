/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTIL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ANDRES
 */
public class ConexionBD {

    public Connection  getConexion()
       {
              Connection  cn=null;
              try
              {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    cn=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-N1PND1Q\\LUGONIS;databaseName=BDCentroMedico","sa","123");
                    System.out.println("Se conecto a la BD");
              } catch (Exception e)
              {
                      System.out.println("No se conecto a la BD");
              }
             return  cn;
      }
    public static void main(String[] args) {
        ConexionBD objeto= new ConexionBD();
        objeto.getConexion();
    }
    
}
