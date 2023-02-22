package one.zpq.springbootdemo.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import one.zpq.springbootdemo.service.PdfExportService;

public class PdfView extends AbstractPdfView {

    private PdfExportService service;

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        service.buildPdfDocument(model, document, writer, request, response);
    }

    public PdfView(PdfExportService service) {
        super();
        this.service = service;
    }

}
