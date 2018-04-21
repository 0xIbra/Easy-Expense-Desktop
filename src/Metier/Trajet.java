/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

/**
 *
 * @author ibragim.abubakarov
 */
public class Trajet extends Depense{
    private String libelleTrajet;
    private double dureeTrajet;
    private String villeDepart;
    private String villeArrivee;
    private String dateAller;
    private String dateRetour;
    private double distanceKM;

    public Trajet(int id, String datePaiement, float montantRem, String dateValidation, float montantDepense, String etat, String libelleTrajet, double dureeTrajet, String villeDepart, String villeArrivee, String dateAller, String dateRetour, double distanceKM) {
        super(id, datePaiement, montantRem, dateValidation, montantDepense, etat);
        this.libelleTrajet = libelleTrajet;
        this.dureeTrajet = dureeTrajet;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.dateAller = dateAller;
        this.dateRetour = dateRetour;
        this.distanceKM = distanceKM;
    }

    public Trajet(String libelleTrajet, double dureeTrajet, String villeDepart, String villeArrivee, String dateAller, String dateRetour, double distanceKM, String datePaiement, float montantRem, String dateValidation, float montantDepense, String etat) {
        super(datePaiement, montantRem, dateValidation, montantDepense, etat);
        this.libelleTrajet = libelleTrajet;
        this.dureeTrajet = dureeTrajet;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.dateAller = dateAller;
        this.dateRetour = dateRetour;
        this.distanceKM = distanceKM;
    }
    
    
    public String toString(){
        return this.libelleTrajet;
    }
    

    public String getLibelleTrajet() {
        return libelleTrajet;
    }

    public void setLibelleTrajet(String libelleTrajet) {
        this.libelleTrajet = libelleTrajet;
    }

    public double getDureeTrajet() {
        return dureeTrajet;
    }

    public void setDureeTrajet(double dureeTrajet) {
        this.dureeTrajet = dureeTrajet;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public String getDateAller() {
        return dateAller;
    }

    public void setDateAller(String dateAller) {
        this.dateAller = dateAller;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }

    public double getDistanceKM() {
        return distanceKM;
    }

    public void setDistanceKM(double distanceKM) {
        this.distanceKM = distanceKM;
    }

    @Override
    public String getTypeDepense() {
        return "Trajet";
    }
    
    
    
    
    
    
}
