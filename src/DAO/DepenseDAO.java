/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.Depense;
import Metier.Frais;
import Metier.NoteFrais;
import Metier.Trajet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ibragim.abubakarov
 */
public class DepenseDAO {
    private Connection conn;
    
    public DepenseDAO() throws ClassNotFoundException{
        this.conn = ConnexionDB.getConnexion();
    }
    
    
    public boolean validateDepense(Depense depense) throws SQLException{
        Statement transmission;
        
        transmission = conn.createStatement();
        String SQL = "UPDATE Depense SET etatValidation = 'Validé' WHERE idDepense = "+depense.getId();
        int callBack = 0;
        callBack = transmission.executeUpdate(SQL);
        
        if(callBack != 0){
            return true;
        }else{
            return false;
        }
    }
    
    
    public boolean refuseDepense(Depense depense) throws SQLException{
        Statement transmission;
        
        transmission = conn.createStatement();
        String SQL = "UPDATE Depense SET etatValidation = 'Refusé' WHERE idDepense = "+depense.getId();
        int callBack = 0;
        callBack = transmission.executeUpdate(SQL);
        
        if(callBack != 0){
            return true;
        }else{
            return false;
        }
    }
    
    
    public ArrayList<Depense> getDepensesByID(int id) throws SQLException{
        Statement transmission;
        ResultSet result;
        ArrayList<Depense> depenseHolder = new ArrayList<Depense>();
        
        transmission = conn.createStatement();
        String SQL = "SELECT * FROM Depense, Frais WHERE Depense.idDepense = Frais.idDepense AND Depense.codeFrais ="+id;
        result = transmission.executeQuery(SQL);
        while(result.next()){
            depenseHolder.add(new Frais(result.getInt("idDepense"), result.getString("dateDepense"), result.getFloat("montantRemboursement"),result.getString("dateValidation"),
            result.getFloat("montantDepense"), result.getString("etatValidation"), result.getString("libelleFrais"), result.getString("detailsFrais"), result.getString("dateFrais")));
        }
        
        transmission = conn.createStatement();
        SQL = "SELECT * FROM Depense, Trajet WHERE Depense.idDepense = Trajet.idDepense AND Depense.codeFrais = "+id;
        result = transmission.executeQuery(SQL);
        while(result.next()){
            depenseHolder.add(new Trajet(result.getInt("idDepense"), result.getString("dateDepense"), 
                    result.getFloat("montantRemboursement"), result.getString("dateValidation"),
            result.getFloat("montantDepense"), result.getString("etatValidation"), result.getString("libelleTrajet"), 
                    result.getDouble("dureeTrajet"), 
            result.getString("villeDepart"), result.getString("villeArrivee"), result.getString("dateAller"),
                    result.getString("dateRetour"), result.getDouble("distanceKilometres")));
        }
        
        return depenseHolder;
        
    }
    
    
    
    
    public boolean validateDepensesAndNoteFrais(int id) throws SQLException{
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
    
    
    
    public boolean refuseDepenseAndNoteFrais(int id) throws SQLException{
        Statement transmission;
        
        transmission = conn.createStatement();
        String SQL = "UPDATE Depense SET Depense.etatValidation = 'Refusé' WHERE Depense.codeFrais = "+id;
        int res = 0;
        res = transmission.executeUpdate(SQL);
        
        if(res != 0){
            transmission = conn.createStatement();
            res = 0;
            SQL = "UPDATE NoteDeFrais SET NoteDeFrais.etat = 'Refusé' WHERE NoteDeFrais.codeFrais = "+id;
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
