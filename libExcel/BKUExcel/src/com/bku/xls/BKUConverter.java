/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bku.xls;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author user only
 */
public class BKUConverter {

    private long npsn;

    public BKUConverter() {
    }

    public ArrayList<Bku> readExcel(File excel) {
        ArrayList<Bku> list = null;
        try {
            // Creating a Workbook from an Excel file (.xls or .xlsx)
            Workbook workbook = WorkbookFactory.create(excel);

            // Retrieving the number of sheets in the Workbook
            System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
            // get first sheet
            Sheet sheet = workbook.getSheetAt(0);
            // get npsn
            //    set to npsn active cell
            Iterator<Row> iterator = sheet.iterator();

        } catch (IOException ex) {
            Logger.getLogger(BKUConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EncryptedDocumentException ex) {
            Logger.getLogger(BKUConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * Fungsi mengambil data npsn
     *
     * @param excel
     * @return
     */
    public long readNpsn(File excel) {
        long npsn = -1;
        try {
            // Creating a Workbook from an Excel file (.xls or .xlsx)
            Workbook workbook = WorkbookFactory.create(excel);
            
            // Retrieving the number of sheets in the Workbook
            System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
            // get first sheet
            Sheet sheet = workbook.getSheetAt(0);
            // get npsn
            //    set to npsn active cell
            Iterator<Row> iterator = sheet.iterator();
        } catch (IOException ex) {
            Logger.getLogger(BKUConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EncryptedDocumentException ex) {
            Logger.getLogger(BKUConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return npsn;
    }

    /**
     * @return the npsn
     */
    public long getNpsn() {
        return npsn;
    }

    /**
     * @param npsn the npsn to set
     */
    public void setNpsn(long npsn) {
        this.npsn = npsn;
    }
}
