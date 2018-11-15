/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bku.xls;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author user only
 */
public class BKUConverter {

    public BKUConverter() {
    }

    public ArrayList<Bku> readExcel(File excel) {
        ArrayList<Bku> list = null;
        try {
            // Creating a Workbook from an Excel file (.xls or .xlsx)
            Workbook workbook = WorkbookFactory.create(excel);

            // Retrieving the number of sheets in the Workbook
            System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

        } catch (IOException ex) {
            Logger.getLogger(BKUConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EncryptedDocumentException ex) {
            Logger.getLogger(BKUConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
