/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.CommercialUser;
import Metier.EntrepriseUser;
import com.mysql.jdbc.Connection;
import graphic.Commercial;
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
    
    public CommercialUser authentificateUser(String userMail, String userMDP) throws SQLException{
        Statement transmission;
        ResultSet result;
        
        transmission = conn.createStatement();
        String SQL = "SELECT * FROM Utilisateur WHERE mailUtilisateur='"+userMail+"' AND mdpUtilisateur='"+userMDP+"' AND typeCompte = 'Commercial'";
        
        result = transmission.executeQuery(SQL);
        CommercialUser tmpUser = null;
        
        while(result.next()){
            tmpUser = new CommercialUser(result.getInt("idUtilisateur"), result.getString("mailUtilisateur"), result.getString("mdpUtilisateur"), result.getString("codePostalUtilisateur"), result.getString("villeUtilisateur"), result.getString("telUtilisateur"), result.getString("typeCompte"), result.getString("nomUtilisateur"), result.getString("prenomUtilisateur"));
            
        }
        
        return tmpUser;
    }
    
    
    public EntrepriseUser EnterpriseAuth(String userEmail, String userMDP) throws SQLException{
        Statement transmission;
        ResultSet result;
        
        transmission = conn.createStatement();
        String SQL = "SELECT * FROM Utilisateur WHERE mailUtilisateur='"+userEmail+"' AND mdpUtilisateur='"+userMDP+"' AND typeCompte='Entreprise'";
        
        result = transmission.executeQuery(SQL);
        EntrepriseUser tmpUser = null;
        
        while(result.next()){
            tmpUser = new EntrepriseUser(result.getInt("idUtilisateur"), result.getString("mailUtilisateur"), result.getString("mdpUtilisateur"),
            result.getString("raisonSociale"), result.getString("noSiret"),result.getString("codePostalUtilisateur"), 
            result.getString("villeUtilisateur"), result.getString("telUtilisateur"),
            result.getString("typeCompte"), result.getString("nomUtilisateur"), result.getString("prenomUtilisateur"));
        }
        
        return tmpUser;
    }
    
}
