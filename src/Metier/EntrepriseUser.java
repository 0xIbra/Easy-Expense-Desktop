/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

/**
 *
 * @author ibrah
 */
public class EntrepriseUser {
    private int id;
    private String email;
    private String password;
    
    private String raisonSocial;
    private String SIRET;
    private String code_postal;
    private String ville;
    private String telephone;
    private String accountType;
    private String LastName;
    private String FirstName;

    public EntrepriseUser(int id, String email, String password, String raisonSocial, String SIRET, String code_postal, String ville, String telephone, String accountType, String LastName, String FirstName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.raisonSocial = raisonSocial;
        this.SIRET = SIRET;
        this.code_postal = code_postal;
        this.ville = ville;
        this.telephone = telephone;
        this.accountType = accountType;
        this.LastName = LastName;
        this.FirstName = FirstName;
    }

    public EntrepriseUser(String email, String password, String raisonSocial, String SIRET, String code_postal, String ville, String telephone, String accountType, String LastName, String FirstName) {
        this.email = email;
        this.password = password;
        this.raisonSocial = raisonSocial;
        this.SIRET = SIRET;
        this.code_postal = code_postal;
        this.ville = ville;
        this.telephone = telephone;
        this.accountType = accountType;
        this.LastName = LastName;
        this.FirstName = FirstName;
    }
    
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public String getSIRET() {
        return SIRET;
    }

    public void setSIRET(String SIRET) {
        this.SIRET = SIRET;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    
    
    
    
}
