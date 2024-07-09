package org.example.realestatemanagementsystem.utils;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class RealEstateUtil {

    private RealEstateUtil() {
        //intentionally private
    }

    public static void openPdf(String filePath) {
        if (Desktop.isDesktopSupported()) {
            try {
                File pdfFile = new File(filePath);
                if (pdfFile.exists()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("File not found: " + filePath);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
