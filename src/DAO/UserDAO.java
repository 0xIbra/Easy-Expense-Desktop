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
import java.util.ArrayList;

/**
 *
 * @author ibragim.abubakarov
 */
public class UserDAO {
    private Connection laConnection;
    
    public UserDAO() throws ClassNotFoundException{
        this.laConnection = ConnexionDB.getConnexion();
    }
    
    
    public ArrayList<User> getUsersFromEnterprise(User comptable) throws SQLException{
        Statement transmission;
        ResultSet result;
        
        ArrayList<User> tmpHolder = new ArrayList<User>();
        
        transmission = laConnection.createStatement();
        String SQL = "SELECT * FROM Utilisateur WHERE typeCompte = 'Commercial' AND idEntreprise ="+comptable.getIdEntreprise();
        
        
        result = transmission.executeQuery(SQL);
        
        while(result.next()){
            tmpHolder.add(new User(result.getInt("idUtilisateur"), result.getString("mailUtilisateur"),
                    result.getString("mdpUtilisateur"), result.getString("codePostalUtilisateur"), result.getString("villeUtilisateur"),
                    result.getString("telUtilisateur"), result.getString("adresseUtilisateur"), result.getString("typeCompte"), result.getString("nomUtilisateur"),
                    result.getString("prenomUtilisateur"), result.getInt("idEntreprise")));
        }
        
        return tmpHolder;
    }
    
    
    
    
    public ArrayList<User> chargerCommerciaux() throws SQLException {
        Statement transmission;
        
        ArrayList<User> listeCommerciaux = new ArrayList<User>();
        transmission = laConnection.createStatement();
        ResultSet leResultat;
        String sql = "SELECT * FROM Utilisateur WHERE typeCompte='Commercial'";   //AFFICHAGE
        leResultat = transmission.executeQuery(sql);
        while (leResultat.next()) {
            listeCommerciaux.add(new User(leResultat.getInt("idUtilisateur"), leResultat.getString("mailUtilisateur"), leResultat.getString("mdpUtilisateur"), leResultat.getString("codePostalUtilisateur"), leResultat.getString("villeUtilisateur"), leResultat.getString("telUtilisateur"), leResultat.getString("adresseUtilisateur"), leResultat.getString("typeCompte"), leResultat.getString("nomUtilisateur"), leResultat.getString("prenomUtilisateur"), leResultat.getInt("idEntreprise")));
        }
        return listeCommerciaux;
    }
    
    
    
    
    
    public User rechercherUser(User user) throws SQLException {
        Statement transmission;
        boolean encore = false;
        transmission = laConnection.createStatement();
        String sql;
        ResultSet leResultat;
        User u = null;
        System.out.println(user.getId());
        sql = "SELECT * FROM Utilisateur WHERE idUtilisateur=" + user.getId() + "";
        System.out.println(sql);
        leResultat = transmission.executeQuery(sql);
        encore = leResultat.next();
        if (encore) {
            u = (new User(leResultat.getInt("idUtilisateur"), leResultat.getString("mailUtilisateur"), leResultat.getString("mdpUtilisateur"), leResultat.getString("codePostalUtilisateur"), leResultat.getString("villeUtilisateur"), leResultat.getString("telUtilisateur"), leResultat.getString("adresseUtilisateur"), leResultat.getString("typeCompte"), leResultat.getString("nomUtilisateur"), leResultat.getString("prenomUtilisateur"), leResultat.getInt("idEntreprise")));
            
        }
        return u;

    }
    
    
    
     public boolean updateUser(User user) throws SQLException {
        Statement transmission;
        int id = user.getId();
        //String nom = user.getLastName();
        //String prenom = user.getFirstName();
        String mail = user.getEmail();
        String tel = user.getTelephone();
        String ville = user.getVille();
        String cp = user.getCode_postal();
        //String type = user.getAccountType();
        transmission = laConnection.createStatement();
        String sql = "UPDATE Utilisateur SET   mailUtilisateur = '" + mail + "', telUtilisateur = '" + tel + "', villeUtilisateur = '" + ville + "', codePostalUtilisateur = '" + cp + "' WHERE idUtilisateur = " + id + "";
        //System.out.println(sql);
        int callBack = 0;
        callBack = transmission.executeUpdate(sql);           //UTILSATION DE LA CLASSE STATEMENT (executeUpdate)
        
        if(callBack != 0){
            return true;
        }else{
            return false;
        }
    }
    
    
    
    
}
