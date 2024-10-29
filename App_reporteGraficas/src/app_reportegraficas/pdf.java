package app_reportegraficas;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jfree.chart.JFreeChart;

public class pdf {
    
     public void exportarPDF(JFreeChart chart,String texto,String cuerpo){
        try {
            //usamos un filechooser para seleccionar la ruta donde guardaremos el archivo
            JFileChooser jfc = new JFileChooser();
            jfc.showSaveDialog(null);
            File file = jfc.getSelectedFile();
            if (!file.getName().endsWith(".pdf")) {
                file = new File(file.getAbsolutePath() + ".pdf");
            }
            OutputStream outStr = new FileOutputStream(file);
            Document document = new Document();
            
            //procedemos a pasar la informacion al pdf
            PdfWriter writer = PdfWriter.getInstance(document, outStr);
            document.open();
            PdfContentByte pdfCont = writer.getDirectContent();
            PdfTemplate template = pdfCont.createTemplate(PageSize.A4.getWidth(), PageSize.A4.getHeight());
            
            //añadimos titulo
            pdfCont.beginText();
            pdfCont.setFontAndSize(BaseFont.createFont(), 24);
            pdfCont.showTextAligned(Element.ALIGN_CENTER, texto, PageSize.A4.getWidth()/2, 750,0);
            pdfCont.setFontAndSize(BaseFont.createFont(), 14);
            ColumnText column = new ColumnText(pdfCont);
            column.setSimpleColumn(30, 700, 580, 50);
            column.setAlignment(Element.ALIGN_JUSTIFIED);
            column.addText(new Chunk(cuerpo));
            column.go();
            pdfCont.endText();
            
            //pasamos el objeto jfreechart a uno compatible y lo añadimos al pdf
            Graphics2D g2D = template.createGraphics(500, 500);
            Rectangle2D r2D = new Rectangle2D.Double(0,0, 500, 500);
            chart.draw(g2D, r2D, null);
            g2D.dispose();
            pdfCont.addTemplate(template, 0, 0);
            
            //cerramos el documento y notificamos que el pdf ha sido generado
            document.close();
            JOptionPane.showMessageDialog(null, "Generated pdf succeed");
        } catch (DocumentException | HeadlessException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,ex);
         }
    }
    
}
