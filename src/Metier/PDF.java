/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;



/**
 *
 * @author ibragim.abubakarov
 */
public class PDF {
    private static String title;
    private Document doc;
    
    public PDF(String title){
        this.title = title;
        doc = new Document(PageSize.A4);
    }
    
    public void initTitle() throws FileNotFoundException{
        try{
            PdfWriter.getInstance(doc, new FileOutputStream(title));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void addParagraph(String text){
        doc.open();
        Paragraph paragraph = new Paragraph();
        paragraph.add(text);
        doc.close();
    }
    
    
    
}
