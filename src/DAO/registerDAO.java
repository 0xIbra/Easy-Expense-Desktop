/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.ComptableUser;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ibragim.abubakarov
 */
public class registerDAO {
    
    private Connection conn;
    
    public registerDAO() throws ClassNotFoundException{
        this.conn = ConnexionDB.getConnexion();
    }
    
    public boolean RegisterEnterprise(ComptableUser user) throws SQLException{
        Statement transmission;
        
        transmission = conn.createStatement();
        
        String SQL = "INSERT INTO Utilisateur (mailUtilisateur, mdpUtilisateur, codePostalUtilisateur, villeUtilisateur, telUtilisateur"
                + ", typeCompte, nomUtilisateur, prenomUtilisateur, noSiret, raisonSociale) VALUES ('"+user.getEmail()+"', '"+user.getPassword()+"', '"+user.getCode_postal()+"'"
                + ", '"+user.getVille()+"', '"+user.getTelephone()+"', 'Entreprise', '"+user.getLastName()+"', '"+user.getFirstName()+"', '"+user.getSIRET()+"', '"+user.getRaisonSocial()+"')";
        
        int res = transmission.executeUpdate(SQL);
        
        if(res == 1){
            return true;
        }else{
            return false;
        }
        
    }
    
}
