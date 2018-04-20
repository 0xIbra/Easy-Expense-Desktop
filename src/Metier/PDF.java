/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author ibragim.abubakarov
 */
public class PDF {
    
    public void generatePDF(User user, NoteFrais note){
        Document doc = new Document();
        System.out.println(user.toString());
        
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(note.getLibelle() + " de "+user.toString()+".pdf"));
            doc.open();
            Image img;
            img = Image.getInstance("images/applogo2.0.png");
            img.setWidthPercentage(-20);
            img.setAlignment(Element.ALIGN_CENTER);
            doc.add(img);
            Paragraph parag = new Paragraph(note.getLibelle()+" de "+user.toString());
            parag.setSpacingAfter(25);
            parag.setAlignment(Element.ALIGN_CENTER);
            doc.add(parag);
            
            Paragraph p1 = new Paragraph("Vos dépenses");
            p1.setAlignment(Element.ALIGN_CENTER);
            p1.setSpacingAfter(25);
            doc.add(p1);
            
            PdfPTable tab = new PdfPTable(6);
            
            PdfPCell cell1 = new PdfPCell(new Paragraph(note.getLibelle()));
            PdfPCell cell2 = new PdfPCell(new Paragraph(note.getDate()));
            PdfPCell cell3 = new PdfPCell(new Paragraph(note.getVille()));
            PdfPCell cell4 = new PdfPCell(new Paragraph(note.getDateSoumission()));
            PdfPCell cell5 = new PdfPCell(new Paragraph(note.getCommentaire()));
            PdfPCell cell6 = new PdfPCell(new Paragraph(note.getEtat()));
            
            tab.addCell(cell1);
            tab.addCell(cell2);
            tab.addCell(cell3);
            tab.addCell(cell4);
            tab.addCell(cell5);
            tab.addCell(cell6);
            
            doc.add(tab);
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
