/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.util.ArrayList;

/**
 *
 * @author ibrah
 */
public class NoteFrais {
    private int id;
    private String libelle;
    private String date;
    private String dateSoumission;
    private String ville;
    private String commentaire;
    private String etat;
    private ArrayList<Depense> depenses;

    
    public NoteFrais(int id, String libelle, String date, String dateSoumission, String ville, String commentaire, String etat) {
        this.id = id;
        this.libelle = libelle;
        this.date = date;
        this.dateSoumission = dateSoumission;
        this.ville = ville;
        this.commentaire = commentaire;
        this.etat = etat;
    }
    
    public NoteFrais(String libelle, String date, String dateSoumission, String ville, String commentaire, String etat) {
        this.libelle = libelle;
        this.date = date;
        this.dateSoumission = dateSoumission;
        this.ville = ville;
        this.commentaire = commentaire;
        this.etat = etat;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    
    
    
    public void addDepense(Depense d){
        this.depenses.add(d);
    }
    
    public void removeDepense(Depense d){
        this.depenses.remove(d);
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateSoumission() {
        return dateSoumission;
    }

    public void setDateSoumission(String dateSoumission) {
        this.dateSoumission = dateSoumission;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public ArrayList<Depense> getDepenses() {
        return depenses;
    }

    public void setDepenses(ArrayList<Depense> depenses) {
        this.depenses = depenses;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
