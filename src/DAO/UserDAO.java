/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

<<<<<<< HEAD
import Connexion.GestionConnection;
import Metier.User;
import java.sql.Connection;
=======
import Metier.NoteFrais;
>>>>>>> ibragim
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
<<<<<<< HEAD

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
=======
    private Connection laConnection;
    
    public UserDAO() throws ClassNotFoundException{
        this.laConnection = ConnexionDB.getConnexion();
>>>>>>> ibragim
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
<<<<<<< HEAD
        String SQL = "SELECT * FROM Utilisateur WHERE idEntreprise ="+comptable.getIdEntreprise();
=======
        String SQL = "SELECT * FROM Utilisateur WHERE typeCompte = 'Commercial' AND idEntreprise ="+comptable.getIdEntreprise();
>>>>>>> ibragim
        
        
        result = transmission.executeQuery(SQL);
        
        while(result.next()){
            tmpHolder.add(new User(result.getInt("idUtilisateur"), result.getString("mailUtilisateur"),
                    result.getString("mdpUtilisateur"), result.getString("codePostalUtilisateur"), result.getString("villeUtilisateur"),
                    result.getString("telUtilisateur"), result.getString("adresseUtilisateur"), result.getString("typeCompte"), result.getString("nomUtilisateur"),
                    result.getString("prenomUtilisateur"), result.getInt("idEntreprise")));
        }
        
        return tmpHolder;
    }
<<<<<<< HEAD



}
=======
    
    
    
    
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
        //System.out.println(user.getId());
        sql = "SELECT * FROM Utilisateur WHERE idUtilisateur=" + user.getId() + "";
        //System.out.println(sql);
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
    
    
    public void getCommercialByMonth(User comptable, int mois) throws SQLException{
        Statement transmission;
        ResultSet result;
        
        transmission = laConnection.createStatement();
        String SQL = "SELECT * FROM NoteDeFrais, Utilisateur WHERE idEntreprise = "+comptable.getIdEntreprise()+" AND NoteDeFrais.idUtilisateur = Utilisateur.idUtilisateur AND dateFrais LIKE '2018-0"+mois+"%'";
        
        result = transmission.executeQuery(SQL);
        
        ArrayList<User> commerciaux = new ArrayList<User>();
        ArrayList<NoteFrais> notesFrais = new ArrayList<NoteFrais>();
        
        while(result.next()){
            commerciaux.add(new User(result.getInt("idUtilisateur"), result.getString("mailUtilisateur"), result.getString("mdpUtilisateur"),
                                    result.getString("codePostalUtilisateur"), result.getString("villeUtilisateur"),
                                    result.getString("telUtilisateur"), result.getString("adresseUtilisateur"), result.getString("typeCompte"),
                                    result.getString("nomUtilisateur"), result.getString("prenomUtilisateur"), result.getInt("idEntreprise")));
            
            
            notesFrais.add(new NoteFrais(result.getInt("codeFrais"), result.getString("libelleNote"), result.getString("dateFrais"), result.getString("villeFrais"), 
                                        result.getString("dateSoumission"), result.getString("commentaireFrais"), result.getString("etat")));
        }
        
        
    }
    
    
    public ArrayList<User> getUserByMonth(int mois) throws SQLException{
        Statement transmission;
        ResultSet result;
        
        transmission = laConnection.createStatement();
        String SQL = "SELECT DISTINCT Utilisateur.idUtilisateur, mailUtilisateur, mdpUtilisateur, adresseUtilisateur, "
                + "codePostalUtilisateur, villeUtilisateur, telUtilisateur, typeCompte, nomUtilisateur, prenomUtilisateur, "
                + "idEntreprise FROM Utilisateur, NoteDeFrais WHERE Utilisateur.idUtilisateur = NoteDeFrais.idUtilisateur AND "
                + "NoteDeFrais.dateSoumission LIKE '2018-0"+mois+"%'";
        
        result = transmission.executeQuery(SQL);

        ArrayList<User> list = new ArrayList<User>();

        while(result.next()){
            list.add(new User(result.getInt("idUtilisateur"), result.getString("mailUtilisateur"), result.getString("mdpUtilisateur"), 
                    result.getString("codePostalUtilisateur"), result.getString("villeUtilisateur"), result.getString("telUtilisateur"), 
                    result.getString("adresseUtilisateur"), result.getString("typeCompte"), result.getString("nomUtilisateur"),
                    result.getString("prenomUtilisateur"),
                    result.getInt("idEntreprise")));
        }
        
        return list;
    }
    
    
}
>>>>>>> ibragim
