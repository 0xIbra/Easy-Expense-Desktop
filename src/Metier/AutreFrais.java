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
public class AutreFrais extends Depense {
    private String details;

    public AutreFrais(int id, String datePaiement, float montantRem, String dateValidation, float montantDepense, String details) {
        super(id, datePaiement, montantRem, dateValidation, montantDepense);
        this.details = details;
    }

    public AutreFrais(String datePaiement, float montantRem, String dateValidation, float montantDepense, String details) {
        super(datePaiement, montantRem, dateValidation, montantDepense);
        this.details = details;
    }
    
    public AutreFrais(String datePaiement, float montantRem, float montantDepense, String details) {
        super(datePaiement, montantRem, montantDepense);
        this.details = details;
    }
    
    

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
    
    
    
    
}
