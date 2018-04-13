package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vince
 */
public class GestionConnection {

    //Declaration des variables utiles à la Connexion
    private static final String url = "jdbc:mysql://e91099-mysql.services.easyname.eu/u143944db1";   //Utilisation de l'API JBDC et le nom du serveur MySQL , l'adresse et le nom de la BD
    private static final String login = "u143944db1";
    private static final String mdp = "12345678*";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static Connection laConnection = null;

    public GestionConnection() {
        /*Pour se connecter à une base de données, il faut charger le driver (et l'importer dans la librarie)
        qui fait le lien entre le programme et la base de données
         */
        try {
            Class.forName(driver); //Charger et tester le driver (inmporter la class try catch)
        } catch (ClassNotFoundException ex) {
            System.out.println("Problème de driver" + ex.getMessage()); // Retour message erreur
        }

        /*On charge et on configure le driver de la base de données à l'aide de
        classe DriveManager. On insert les informations de Connexion ici.
        url=chemin d'accès à la base
        login= utilisateur
        mdp=le mot de passe
         */
        try {
            laConnection = DriverManager.getConnection(url, login, mdp);
        } catch (SQLException ex) {
            System.out.println("Problème de BDD " + ex.getMessage());
        }
    }

    //INTEGER UN GETCONNECTION
    public static Connection getLaConnection() {
        if (laConnection == null) {
            new GestionConnection();
        }
        return laConnection;
    }

    public static void liberer() throws SQLException {
        laConnection.close();
        laConnection = null;
    }

}
