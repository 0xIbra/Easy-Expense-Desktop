/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.User;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ibrah
 */
public class LoginDAO {
    private Connection conn;
    
    public LoginDAO() throws ClassNotFoundException{
        this.conn = ConnexionDB.getConnexion();
    }
    
    public User authentificateCommercial(String userMail, String userMDP) throws SQLException{
        Statement transmission;
        ResultSet result;
        
        transmission = conn.createStatement();
        String SQL = "SELECT * FROM Utilisateur WHERE mailUtilisateur='"+userMail+"' AND mdpUtilisateur='"+userMDP+"' AND typeCompte = 'Commercial'";
        
        result = transmission.executeQuery(SQL);
        User tmpUser = null;
        
        while(result.next()){
            tmpUser = new User(result.getInt("idUtilisateur"), result.getString("mailUtilisateur"), result.getString("mdpUtilisateur"), result.getString("codePostalUtilisateur"), result.getString("villeUtilisateur"), result.getString("telUtilisateur"), result.getString("adresseUtilisateur"), result.getString("typeCompte"), result.getString("nomUtilisateur"), result.getString("prenomUtilisateur"), result.getInt("idEntreprise"));
            
        }
        
        return tmpUser;
    }
    
    
    public User authentificateComptable(String userEmail, String userMDP) throws SQLException{
        Statement transmission;
        ResultSet result;
        
        transmission = conn.createStatement();
        String SQL = "SELECT * FROM Utilisateur WHERE mailUtilisateur='"+userEmail+"' AND mdpUtilisateur='"+userMDP+"' AND typeCompte='Comptable'";
        
        result = transmission.executeQuery(SQL);
        User tmpUser = null;
        
         while(result.next()){
            tmpUser = new User(result.getInt("idUtilisateur"), result.getString("mailUtilisateur"), result.getString("mdpUtilisateur"), result.getString("codePostalUtilisateur"), result.getString("villeUtilisateur"), result.getString("telUtilisateur"), result.getString("adresseUtilisateur"), result.getString("typeCompte"), result.getString("nomUtilisateur"), result.getString("prenomUtilisateur"), result.getInt("idEntreprise"));
            
        }
        
        return tmpUser;
    }
    
}
