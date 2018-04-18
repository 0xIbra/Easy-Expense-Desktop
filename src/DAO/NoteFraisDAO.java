/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.User;
import Metier.NoteFrais;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Connexion.GestionConnection;

/**
 *
 * @author ibrah
 */
public class NoteFraisDAO {
    private Connection conn;
    
    public NoteFraisDAO() throws ClassNotFoundException{
        this.conn = GestionConnection.getLaConnection();
    }
    
    
    
    
    public void insertNoteFrais(NoteFrais note) throws SQLException{
        Statement transmission;
        
        String dateFrais = note.getDate();
        String dateSoumission = note.getDateSoumission();
        String comment = note.getCommentaire();
        
        transmission = conn.createStatement();
        String SQL = "INSERT INTO NoteDeFrais (dateFrais, dateSoumission, commentaireFrais) VALUES ('"+dateFrais+"','"+dateSoumission+"','"+comment+"')";
        
        transmission.executeUpdate(SQL);
    }
    
    
    
    public ArrayList<NoteFrais> getNotesFraisByUserID(int UserID) throws SQLException{
        Statement transmission;
        ResultSet result;
        
        transmission = conn.createStatement();
        
        String SQL = "SELECT * FROM NoteDeFrais WHERE idUtilisateur = "+UserID;
        
        result = transmission.executeQuery(SQL);
        ArrayList<NoteFrais> list = new ArrayList<NoteFrais>();
        while(result.next()){
            list.add(new NoteFrais(result.getInt("codeFrais"), result.getString("libelleNote"), result.getString("dateFrais"), result.getString("dateSoumission"), result.getString("villeFrais"), result.getString("commentaireFrais"), result.getString("etat")));
        }
        
        return list;
    }
    
}
