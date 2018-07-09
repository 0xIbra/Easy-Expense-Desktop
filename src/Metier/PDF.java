/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import DAO.DepenseDAO;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author ibragim.abubakarov
 */
public class PDF {
    
    public void generatePDF(User user, NoteFrais note) throws ClassNotFoundException, SQLException{
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
            
            PdfPTable tab = new PdfPTable(6);
            
            PdfPCell cell1 = new PdfPCell(new Paragraph(note.getLibelle()));
            PdfPCell cell2 = new PdfPCell(new Paragraph(note.getDate()));
            PdfPCell cell4 = new PdfPCell(new Paragraph(note.getDateSoumission()));
            PdfPCell cell5 = new PdfPCell(new Paragraph(note.getCommentaire()));
            PdfPCell cell6 = new PdfPCell(new Paragraph(note.getEtat()));
            
            tab.addCell(cell1);
            tab.addCell(cell2);
            tab.addCell(cell4);
            tab.addCell(cell5);
            tab.addCell(cell6);
            
            Paragraph p2 = new Paragraph("Vos dépenses");
            p2.setAlignment(Element.ALIGN_CENTER);
            p2.setSpacingAfter(25);
            doc.add(p2);
            
            ArrayList<Depense> depenses = new ArrayList<Depense>();
            DepenseDAO conn = new DepenseDAO();
            depenses = conn.getDepensesByID(note.getId());
            
            for (Depense depense : depenses) {
                int type = depense.getTypeDepense();
                switch (type) {
                    case Depense.TYPE_FRAIS:
                        PdfPTable fraistab = new PdfPTable(3);
                        PdfPCell fraiscell1 = new PdfPCell(new Paragraph(((Frais) depense).getLibelleFrais()));
                        PdfPCell fraiscell2 = new PdfPCell(new Paragraph(((Frais) depense).getDetailsFrais()));
                        PdfPCell fraiscell3 = new PdfPCell(new Paragraph(((Frais) depense).getDateFrais()));
                        fraistab.addCell(fraiscell1);
                        fraistab.addCell(fraiscell2);
                        fraistab.addCell(fraiscell3);
                        doc.add(fraistab);
                        break;
                    case Depense.TYPE_TRAJET:
                         PdfPTable trajettab = new PdfPTable(3);
                        PdfPCell trajetcell1 = new PdfPCell(new Paragraph(((Trajet) depense).getLibelleTrajet()));
                        PdfPCell trajetcell2 = new PdfPCell(new Paragraph(((Trajet) depense).getDistanceKM() + " KM"));
                        PdfPCell trajetcell3 = new PdfPCell(new Paragraph(((Trajet) depense).getDateAller()));
                        
                        
                        trajettab.addCell(trajetcell1);
                        trajettab.addCell(trajetcell2);
                        trajettab.addCell(trajetcell3);
                        doc.add(trajettab);
                        break;
                }
            }
            
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
