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
public class Depense {
    private int id;
    private String datePaiement;
    private float montantRem;
    private boolean etat = false;
    private String dateValidation;
    private float montantDepense;

    public Depense(int id, String datePaiement, float montantRem, String dateValidation, float montantDepense) {
        this.id = id;
        this.datePaiement = datePaiement;
        this.montantRem = montantRem;
        this.dateValidation = dateValidation;
        this.montantDepense = montantDepense;
    }

    public Depense(String datePaiement, float montantRem, String dateValidation, float montantDepense) {
        this.datePaiement = datePaiement;
        this.montantRem = montantRem;
        this.dateValidation = dateValidation;
        this.montantDepense = montantDepense;
    }
    
    
    
    public Depense(String datePaiement, float montantRem, float montantDepense) {
        this.datePaiement = datePaiement;
        this.montantRem = montantRem;
        this.montantDepense = montantDepense;
    }

    
    
    

    
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

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
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
