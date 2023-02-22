package one.zpq.springbootdemo.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

public interface PdfExportService {
    void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request,
            HttpServletResponse response);
}
