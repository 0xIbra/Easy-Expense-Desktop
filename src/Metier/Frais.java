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
public class Frais extends Depense {
    private String libelleFrais;
    private String detailsFrais;
    private String dateFrais;

    public Frais(int id, String datePaiement, float montantRem, String dateValidation, float montantDepense, String etat, String libelleFrais, String detailsFrais, String dateFrais) {
        super(id, datePaiement, montantRem, dateValidation, montantDepense, etat);
        this.libelleFrais = libelleFrais;
        this.detailsFrais = detailsFrais;
        this.dateFrais = dateFrais;
    }

    public Frais(String libelleFrais, String detailsFrais, String dateFrais, String datePaiement, float montantRem, String dateValidation, float montantDepense, String etat) {
        super(datePaiement, montantRem, dateValidation, montantDepense, etat);
        this.libelleFrais = libelleFrais;
        this.detailsFrais = detailsFrais;
        this.dateFrais = dateFrais;
    }
    
    
    public String toString(){
        return this.libelleFrais;
    }
    

    public String getLibelleFrais() {
        return libelleFrais;
    }

    public void setLibelleFrais(String libelleFrais) {
        this.libelleFrais = libelleFrais;
    }

    public String getDetailsFrais() {
        return detailsFrais;
    }

    public void setDetailsFrais(String detailsFrais) {
        this.detailsFrais = detailsFrais;
    }

    public String getDateFrais() {
        return dateFrais;
    }

    public void setDateFrais(String dateFrais) {
        this.dateFrais = dateFrais;
    }
    
    
    

    @Override
    public int getTypeDepense() {
        return super.getTYPE_FRAIS();
    }
    
    
    
    
    
    
    
    
}
