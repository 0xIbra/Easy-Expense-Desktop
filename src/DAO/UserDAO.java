/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connexion.GestionConnection;
import Metier.User;
import java.sql.Connection;
import Metier.User;
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

    public UserDAO() {
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
            listeCommerciaux.add(new User(leResultat.getInt("idUtilisateur"), leResultat.getString("nomUtilisateur"), leResultat.getString("prenomUtilisateur")));
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
            u = (new User(leResultat.getInt("idUtilisateur"), leResultat.getString("mailUtilisateur"), leResultat.getString("mdpUtilisateur"), leResultat.getString("codePostalUtilisateur"), leResultat.getString("villeUtilisateur"), leResultat.getString("telUtilisateur"), leResultat.getString("adresseUtilisateur"), leResultat.getString("typeCompte"), leResultat.getString("nomUtilisateur"), leResultat.getString("prenomUtilisateur"), leResultat.getInt("idEntreprise")));

        }
        return u;

    }

    public void updateUser(User user) throws SQLException {
        int id = user.getId();
        //String nom = user.getLastName();
        //String prenom = user.getFirstName();
        String mail = user.getEmail();
        String tel = user.getTelephone();
        String ville = user.getVille();
        String cp = user.getCode_postal();
        //String type = user.getAccountType();
        String sql = "UPDATE Utilisateur SET   mailUtilisateur = '" + mail + "', telUtilisateur = '" + tel + "', villeUtilisateur = '" + ville + "', codePostalUtilisateur = '" + cp + "' WHERE idUtilisateur = " + id + "";
        System.out.println(sql);
        transmission.executeUpdate(sql);           //UTILSATION DE LA CLASSE STATEMENT (executeUpdate)
    }
    
    
    
    
    public ArrayList<User> getUsersFromEnterprise(User comptable) throws SQLException{
        Statement transmission;
        ResultSet result;
        
        ArrayList<User> tmpHolder = new ArrayList<User>();
        
        transmission = laConnection.createStatement();
        String SQL = "SELECT * FROM Utilisateur WHERE idEntreprise ="+comptable.getIdEntreprise();
        
        
        result = transmission.executeQuery(SQL);
        
        while(result.next()){
            tmpHolder.add(new User(result.getInt("idUtilisateur"), result.getString("mailUtilisateur"),
                    result.getString("mdpUtilisateur"), result.getString("codePostalUtilisateur"), result.getString("villeUtilisateur"),
                    result.getString("telUtilisateur"), result.getString("adresseUtilisateur"), result.getString("typeCompte"), result.getString("nomUtilisateur"),
                    result.getString("prenomUtilisateur"), result.getInt("idEntreprise")));
        }
        
        return tmpHolder;
    }



}