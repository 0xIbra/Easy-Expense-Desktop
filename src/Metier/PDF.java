/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;


import DAO.DepenseDAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author ibragim.abubakarov
 */
public class PDF {

    private ArrayList<Depense> montantTotal;
    
    public void generatePDF(User user, NoteFrais note) throws ClassNotFoundException, SQLException{
        Document doc = new Document();
        System.out.println(user.toString());
        
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(note.getLibelle() + " de "+user.toString()+".pdf"));
            doc.open();
            Image img;
            img = Image.getInstance("images/easy_expense_logo_round.png");
            img.scaleAbsolute(154, 94);
            img.scalePercent(50);
            img.setAlignment(Element.ALIGN_CENTER);
            doc.add(img);
            Paragraph parag = new Paragraph(note.getLibelle()+" de "+user.toString());
            parag.setSpacingBefore(40);
            parag.setSpacingAfter(40);
            parag.setAlignment(Element.ALIGN_CENTER);
            doc.add(parag);
            
            Paragraph p1 = new Paragraph("Vos dépenses");
            p1.setAlignment(Element.ALIGN_CENTER);
            p1.setSpacingAfter(30);
            doc.add(p1);
            
            PdfPTable tab1 = new PdfPTable(6);
            tab1.setWidthPercentage(100);
            PdfPCell cell2tab1 = new PdfPCell(new Phrase("Libellé"));
            PdfPCell cell3tab1 = new PdfPCell(new Phrase("Date"));
            PdfPCell cell4tab1 = new PdfPCell(new Phrase("Ville"));
            PdfPCell cell5tab1 = new PdfPCell(new Phrase("Date soumission"));
            PdfPCell cell6tab1 = new PdfPCell(new Phrase("Commentaire"));
            PdfPCell cell7tab1 = new PdfPCell(new Phrase("Etat"));

            PdfPTable tab = new PdfPTable(6);
            tab.setWidthPercentage(100);
            PdfPCell cell2 = new PdfPCell(new Paragraph(note.getLibelle()));
            PdfPCell cell3 = new PdfPCell(new Paragraph(note.getDate()));
            PdfPCell cell4 = new PdfPCell(new Paragraph(note.getVille()));
            PdfPCell cell5 = new PdfPCell(new Paragraph(note.getDateSoumission()));
            PdfPCell cell6 = new PdfPCell(new Paragraph(note.getCommentaire()));
            PdfPCell cell7 = new PdfPCell(new Paragraph(note.getEtat()));
            
            tab.addCell(cell2tab1);
            tab.addCell(cell3tab1);
            tab.addCell(cell4tab1);
            tab.addCell(cell5tab1);
            tab.addCell(cell6tab1);
            tab.addCell(cell7tab1);
          
            tab.addCell(cell2);
            tab.addCell(cell3);
            tab.addCell(cell4);
            tab.addCell(cell5);
            tab.addCell(cell6);
            tab.addCell(cell7);
            
            
            
            doc.add(tab1);
            doc.add(tab);
            
            
            
            DepenseDAO montant = new DepenseDAO();
            montantTotal = montant.getDepensesByID(user.getId());
 

            
            
            Paragraph p2 = new Paragraph("Montant total de la note de frais : "+ montantTotal);
            p2.setSpacingBefore(30);
            p2.setSpacingAfter(30);
            p2.setAlignment(Element.ALIGN_CENTER);
            doc.add(p2);
            
            PdfPTable tabSignature = new PdfPTable(1);
            tabSignature.setWidthPercentage(30);

            PdfPCell cellTab = new PdfPCell(new Phrase("Signature"));
            cellTab.setHorizontalAlignment(cellTab.ALIGN_LEFT);
            cellTab.setVerticalAlignment(cellTab.ALIGN_CENTER);
            cellTab.setMinimumHeight(36f);
            tabSignature.addCell(cellTab);
  
            doc.add(tabSignature);
            
            
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        doc.close();
        try {
            Runtime.getRuntime().exec("explorer.exe "+note.getLibelle() + " de "+user.toString()+".pdf");
            
        } catch (IOException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
