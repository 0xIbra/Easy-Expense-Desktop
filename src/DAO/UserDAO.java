/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connexion.GestionConnection;
import Metier.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



/**
 *
 * @author Vince
 */
public class UserDAO {

    private static Connection laConnection;
    private static Statement transmission;

    public UserDAO(){
        laConnection = GestionConnection.getLaConnection();
    }

    public void afficherListeCommerciaux() throws SQLException {
        transmission = laConnection.createStatement();
        ResultSet leResultat;
        String sql = "SELECT * FROM Utilisateur";   //AFFICHAGE
        leResultat = transmission.executeQuery(sql);
        while (leResultat.next()) {
            System.out.println(" ID : " + leResultat.getInt("id") + " Nom : " + leResultat.getString("nom") + " et le prenom est : " + leResultat.getString("prenom"));
        }
    }
    
    public ArrayList<User> chargerCommerciaux() throws SQLException {
        ArrayList<User> listeCommerciaux = new ArrayList<User>();
        transmission = laConnection.createStatement();
        ResultSet leResultat;
        String sql = "SELECT * FROM Utilisateur WHERE typeCompte='Commercial'";   //AFFICHAGE
        leResultat = transmission.executeQuery(sql);
        while (leResultat.next()) {
            listeCommerciaux.add(new User(leResultat.getInt("idUtilisateur"),leResultat.getString("nomUtilisateur"), leResultat.getString("prenomUtilisateur")));
        }
        return listeCommerciaux;
    }
    
        public void afficherUser(User user) throws SQLException {
        transmission = laConnection.createStatement();
        String nom = user.getLastName();
        String prenom = user.getFirstName();

  
        ResultSet leResultat;
        int id = user.getId();
        String sql = "SELECT * FROM Utilisateur WHERE id = " + id + "";   //AFFICHAGE
        leResultat = transmission.executeQuery(sql);

        while (leResultat.next()) {
            System.out.println("Nom : " + leResultat.getString("nom") + " et le prenom est : " + leResultat.getString("prenom"));
        }
    }
        
        public User rechercherUser(User user) throws SQLException {
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
            u = (new User(leResultat.getString("mailUtilisateur"),leResultat.getString("mdpUtilisateur"),leResultat.getString("codePostalUtilisateur"),leResultat.getString("villeUtilisateur"),leResultat.getString("telUtilisateur"),leResultat.getString("adresseUtilisateur"),leResultat.getString("typeCompte"),leResultat.getString("nomUtilisateur"), leResultat.getString("prenomUtilisateur")));

        }
        return u;
       
    }

}
