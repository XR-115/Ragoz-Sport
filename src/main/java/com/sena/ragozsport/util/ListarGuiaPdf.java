package com.sena.ragozsport.util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sena.ragozsport.model.guia.guia;

@Component("views/guia/guia")
public class ListarGuiaPdf extends AbstractPdfView{

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
    HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Integer dato = Integer.parseInt(request.getParameter("id"));

        @SuppressWarnings("unchecked")
        List<guia> guias = (List<guia>) model.get("guias");
        List<guia> guia = new ArrayList<guia>();
        Iterator<guia> i = guias.iterator();


        while (i.hasNext()) {
            guia iterar = i.next();
            if (dato == 0) {
                // if (iterar.getIdGuia() == dato ) {
                    guia.add(iterar);
                // }
            }
            else if(dato !=0){
                if (iterar.getIdGuia() == dato){
                    guia.add(iterar);
                }
            }
        } 

        //LETRAS COLUMNAS
        Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, Color.black);
        //LATRAS TITULO 
        Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, Color.black);
        
        //PARA LA ROTACIÓN DE LA HOJA (EN ESTE CASO HORIZONTAL)
        document.setPageSize(PageSize.LETTER.rotate());
        document.setPageSize(PageSize.ARCH_A.rotate());

        //PARA MARGEN DE LA HOJA
        document.setMargins(2, 2, 40, 10);
        document.open();
        //PARA TOMAR CELDA
        PdfPCell celda = null;

        // TITULO TABLA
        PdfPTable TablaTitulo = new PdfPTable(1);

        celda = new PdfPCell(new Phrase("GUÍA DEL ENVÍO", fuenteTitulo));
        TablaTitulo.setSpacingBefore(30);
        celda.setBackgroundColor(new Color(56, 198, 215));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(30);
        TablaTitulo.addCell(celda);
        TablaTitulo.setSpacingAfter(20);

        //PARA TOMAR LA IMAGEN DESDE UNA DIRECIIÓN WEB O DE ARCHIVOS
        Image image  = Image.getInstance("src//main//resources//static/img/logo-envioz.png");
        
        //TAMAÑO DE LA IMAGEN
        image.scaleToFit(200,100);
        //ALINEACIÓN 
        image.setAlignment(image.ALIGN_LEFT);

        //CANTIDAD COLUMNAS
        PdfPTable TablaGuia = new PdfPTable (10);

        //TAMAÑO COLUMNAS
        TablaGuia.setWidths (new float[]{ 1,5,6,5,3,5,5,5,4,4});

        //ESTILOS DE COLUMNA
        celda = new PdfPCell(new Phrase("ID", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(56, 198, 215));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPaddingTop(10);
        celda.setPaddingBottom(10);
        TablaGuia.addCell(celda);

        celda = new PdfPCell(new Phrase("TELÉFONO", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(56, 198, 215));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPaddingTop(10);
        celda.setPaddingBottom(10);
        TablaGuia.addCell(celda);

        celda = new PdfPCell(new Phrase("DIRECCIÓN", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(56, 198, 215));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPaddingTop(10);
        celda.setPaddingBottom(10);
        TablaGuia.addCell(celda);

        celda = new PdfPCell(new Phrase("FECHA", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(56, 198, 215));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPaddingTop(10);
        celda.setPaddingBottom(10);
        TablaGuia.addCell(celda);

        celda = new PdfPCell(new Phrase("CAJAS", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(56, 198, 215));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPaddingTop(10);
        celda.setPaddingBottom(10);
        TablaGuia.addCell(celda);

        celda = new PdfPCell(new Phrase("V.MERCANCÍA", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(56, 198, 215));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPaddingTop(10);
        celda.setPaddingBottom(10);
        TablaGuia.addCell(celda);

        celda = new PdfPCell(new Phrase("REMITENTE", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(56, 198, 215));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPaddingTop(10);
        celda.setPaddingBottom(10);
        TablaGuia.addCell(celda);

        celda = new PdfPCell(new Phrase("DESTINATARIO", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(56, 198, 215));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPaddingTop(10);
        celda.setPaddingBottom(10);
        TablaGuia.addCell(celda);

        celda = new PdfPCell(new Phrase("C.ORIGEN", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(56, 198, 215));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPaddingTop(10);
        celda.setPaddingBottom(10);
        TablaGuia.addCell(celda);

        celda = new PdfPCell(new Phrase("C.DESTINO", fuenteTituloColumnas));
        celda.setBackgroundColor(new Color(56, 198, 215));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPaddingTop(10);
        celda.setPaddingBottom(10);
        TablaGuia.addCell(celda);

        //LLAMDO DE DATOS
        guia.forEach(guiaa ->{
            TablaGuia.addCell(guiaa.getIdGuia().toString());
            TablaGuia.addCell(guiaa.getTelGuia().toString());
            TablaGuia.addCell(guiaa.getDirecGuia());
            TablaGuia.addCell(guiaa.getFechaGuia().toString());
            TablaGuia.addCell(guiaa.getNumCajasGuia().toString());
            TablaGuia.addCell(guiaa.getValorMercancia().toString());
            TablaGuia.addCell(guiaa.getRemitente().toString());
            TablaGuia.addCell(guiaa.getDestinatario().toString());
            TablaGuia.addCell(guiaa.getCiudadOrigen().toString());
            TablaGuia.addCell(guiaa.getDestinatario().toString());
        });

        document.add(image);
        document.add(TablaTitulo);
        document.add(TablaGuia);
    }
}