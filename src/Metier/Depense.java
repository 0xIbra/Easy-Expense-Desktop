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
public abstract class Depense {
    private int id;
    private String datePaiement;
    private float montantRem;
    private String etat;
    private String dateValidation;
    private float montantDepense;
    
    public static final int TYPE_FRAIS = 1;
    public static final int TYPE_TRAJET = 2;

    public int getTYPE_FRAIS() {
        return TYPE_FRAIS;
    }

    public int getTYPE_TRAJET() {
        return TYPE_TRAJET;
    }

    public Depense(int id, String datePaiement, float montantRem, String dateValidation, float montantDepense, String etat) {
        this.id = id;
        this.datePaiement = datePaiement;
        this.montantRem = montantRem;
        this.dateValidation = dateValidation;
        this.montantDepense = montantDepense;
        this.etat = etat;
    }

    public Depense(String datePaiement, float montantRem, String dateValidation, float montantDepense, String etat) {
        this.datePaiement = datePaiement;
        this.montantRem = montantRem;
        this.dateValidation = dateValidation;
        this.montantDepense = montantDepense;
        this.etat = etat;
    }
    
    
    
    public Depense(String datePaiement, float montantRem, float montantDepense) {
        this.datePaiement = datePaiement;
        this.montantRem = montantRem;
        this.montantDepense = montantDepense;
    }

    public abstract int getTypeDepense();
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(String datePaiement) {
        this.datePaiement = datePaiement;
    }

    public float getMontantRem() {
        return montantRem;
    }

    public void setMontantRem(float montantRem) {
        this.montantRem = montantRem;
    }

    public String isEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(String dateValidation) {
        this.dateValidation = dateValidation;
    }

    public float getMontantDepense() {
        return montantDepense;
    }

    public void setMontantDepense(float montantDepense) {
        this.montantDepense = montantDepense;
    }
    
    
    
    
}
