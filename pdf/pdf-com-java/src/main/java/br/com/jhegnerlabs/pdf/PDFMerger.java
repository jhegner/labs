package br.com.jhegnerlabs.pdf;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;

public class PDFMerger {

    public static void main(String[] args) {
        String[] pdfFiles = {
                "C:\\Users\\tmp\\0.pdf",
        };
        String outputFileName = "DOC.pdf";
        String outputFolder = "C:\\Users\\tmp\\";

        mergePDFs(pdfFiles, outputFolder + outputFileName);
    }

    public static void mergePDFs(String[] pdfFiles, String outputFilePath) {
        PDFMergerUtility pdfMerger = new PDFMergerUtility();

        try {
            for (String filePath : pdfFiles) {
                pdfMerger.addSource(new File(filePath));
            }

            pdfMerger.setDestinationFileName(outputFilePath);
            pdfMerger.mergeDocuments(null);
            System.out.println("PDFs merged successfully!");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error merging PDFs: " + e.getMessage());
        }
    }
}
