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

/**
 *
 * @author ibrah
 */
public class NoteFraisDAO {
    private Connection conn;
    
    public NoteFraisDAO() throws ClassNotFoundException{
        this.conn = ConnexionDB.getConnexion();
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
    
    
    public ArrayList<NoteFrais> getNoteFraisByUserAndMonth(User user, int mois) throws SQLException{
        Statement transmission;
        ResultSet result;
        
        transmission = conn.createStatement();
        String SQL = "SELECT * FROM NoteDeFrais WHERE idUtilisateur = "+user.getId()+" AND dateSoumission LIKE '2018-0"+mois+"%'";
        
        result = transmission.executeQuery(SQL);
        ArrayList<NoteFrais> notes = new ArrayList<NoteFrais>();
        
        while(result.next()){
            notes.add(new NoteFrais(result.getInt("codeFrais"), result.getString("libelleNote"), result.getString("dateFrais"),
                                    result.getString("dateSoumission"), result.getString("villeFrais"), result.getString("commentaireFrais"),
                                    result.getString("etat")));
        }
        
        return notes;
    }
    
    
    
    public boolean validateNoteFraisAndDepenses(int id) throws SQLException{
        Statement transmission;
        
        transmission = conn.createStatement();
        String SQL = "UPDATE Depense SET Depense.etatValidation = 'Validé' WHERE Depense.codeFrais = "+id;
        int res = 0;
        res = transmission.executeUpdate(SQL);
        
        if(res != 0){
            transmission = conn.createStatement();
            res = 0;
            SQL = "UPDATE NoteDeFrais SET NoteDeFrais.etat = 'Validé' WHERE NoteDeFrais.codeFrais = "+id;
            res = transmission.executeUpdate(SQL);
            if(res != 0){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    
    public boolean refuseNoteFraisAndDepenses(NoteFrais note) throws SQLException{
        Statement transmission;
        
        transmission = conn.createStatement();
        String SQL = "UPDATE NoteDeFrais SET etat = 'Refusé' WHERE codeFrais ="+note.getId();
        
        int res = 0;
        
        res = transmission.executeUpdate(SQL);
        
        if(res != 0){
            transmission = conn.createStatement();
            res = 0;
            SQL = "UPDATE Depense SET etatValidation = 'Refusé' WHERE Depense.codeFrais = "+note.getId();
            res = transmission.executeUpdate(SQL);
            if(res != 0){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
}
