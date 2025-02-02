package br.com.jhegnerlabs.pdf;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PDFReader {

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\tmp\\FILE_.pdf";
        PDDocument document = Loader.loadPDF(new File(filePath));
        readPDFFields(document);
    }

    public static void readPDFFields(PDDocument document) {
        try {
            PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();

            if (acroForm != null) {
                List<PDField> fields = acroForm.getFields();
                for (PDField field : fields) {
                    System.out.println("Field name: " + field.getFullyQualifiedName() + ", Value: " + field.getValueAsString());
                }
            } else {
                System.out.println("No form fields found in the document.");
            }
        } finally {
            try {
                if (document != null) {
                    document.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Error closing PDF document: " + e.getMessage());
            }
        }
    }
}
