/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ibrah
 */
public class ConnexionDB {
    private static final String url = "jdbc:mysql://e91099-mysql.services.easyname.eu/u143944db1";
    private static final String login = "u143944db1";
    private static final String mdp = "12345678*";
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static Connection conn = null;
    
    public ConnexionDB() throws ClassNotFoundException{
        try{
            Class.forName(Driver);
        } catch(ClassNotFoundException e){
            System.out.println("Probleme de Driver " + e.getMessage());
        }
        try{
            conn = (Connection) DriverManager.getConnection(url, login, mdp);
        } catch(SQLException ex){
            System.out.println("Probleme de BDD " + ex.getMessage());
        }
    }
    
    public static Connection getConnexion() throws ClassNotFoundException{
        if(conn == null){
            new ConnexionDB();
        }
        return conn;
    }
    
    public static void closeConn() throws SQLException{
        conn.close();
        conn = null;
    }
    
}
