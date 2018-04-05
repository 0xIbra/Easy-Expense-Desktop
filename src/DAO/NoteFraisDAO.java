/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.CommercialUser;
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
    
    
    
    public ArrayList<NoteFrais> getNoteFraisByCommercial(CommercialUser c) throws SQLException{
        Statement transmission;
        ResultSet result;
        
        transmission = conn.createStatement();
        String SQL = "SELECT codeFrais, libelle, dateFrais, dateSoumission, commentaireFrais FROM NoteDeFrais, Utilisateur "
                + "WHERE NoteDeFrais.idUtilisateur = Utilisateur.idUtilisateur AND NoteDeFrais.idUtilisateur = "+c.getId();
        
        result = transmission.executeQuery(SQL);
        
        ArrayList<NoteFrais> tmpHolder = null;
        
        while(result.next()){
            
            tmpHolder.add(new NoteFrais(result.getInt("codeFrais"), result.getString("libelle"), result.getString("dateFrais"), result.getString("dateSoumission"), 
            result.getString("commentaireFrais")));
        }
        return tmpHolder;
    }
    
}
