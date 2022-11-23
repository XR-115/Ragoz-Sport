// package com.sena.ragozsport.util;

// import java.util.List;
// import java.util.Map;

// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import org.springframework.stereotype.Component;
// import org.springframework.web.servlet.view.document.AbstractPdfView;

// import com.lowagie.text.Document;
// import com.lowagie.text.pdf.PdfTable;
// import com.lowagie.text.pdf.PdfWriter;
// import com.sena.ragozsport.model.guia.guia;

// @Component("views/guia/guia")
// public class ListarGuiaPdf extends AbstractPdfView{

//     @Override
//     protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
//             HttpServletRequest request, HttpServletResponse response) throws Exception {
//             List<guia> guia = (List<guia>) model.get("guia");

//             PdfTable tablaGuia = new PdfTable(10);
            

//             guia.forEach(guiaa ->{
//                 tablaGuia.addCell(guiaa.get)
//             });
//     }

// }