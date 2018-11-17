/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bku.xls;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author user only
 */
public class BKUConverter {

    public static final int FIRST_ROW_JANUARY_REPORT = 9;
    public static final int DATE_COLUMN = 0;
    public static final int NO_KODE_COLUMN = 1;
    public static final int NO_BUKTI_COLUMN = 2;
    public static final int URAIAN_COLUMN = 3;
    public static final int DEBIT_COLUMN = 4;
    public static final int CREDIT_COLUMN = 5;

    public static final int NPSN_COLUMN = 9;
    public static final int NPSN_ROW = 4;
    private long npsn;

    public BKUConverter() {
    }

    public ArrayList<Bku> readExcel(File excel) {
        // read npsn
        readNpsn(excel);
        // npsn not found
        if (npsn == -1) {
            return null;
        } else {
            // create bku list
            ArrayList<Bku> list = null;
            try {
                // Creating a Workbook from an Excel file (.xls or .xlsx)
                Workbook workbook = WorkbookFactory.create(excel);
                // get first sheet
                Sheet sheet = workbook.getSheetAt(0);
                int rowIndex = 0;
                boolean endOfReport = false;
                // chek month of report
                if (isJanuaryReport(excel)) {
                    // january report
                    // first row
                    rowIndex = FIRST_ROW_JANUARY_REPORT;
                } else {
                    // non january report
                    // first row
                    rowIndex = FIRST_ROW_JANUARY_REPORT + 1;
                }
                // read line of report
                while (!endOfReport) {
                    // set row object
                    Row row = sheet.getRow(rowIndex);
                    // baris sesuai standar apa tidak
                    if (isRowStandard(row)) {
                        //baca baris
                        Bku bku = readRow(row);
                        // tambahkan ke list
                        list.add(bku);
                    }
                    //increase row index
                    rowIndex++;
                    // cek end of report
                    row = sheet.getRow(rowIndex);
                    endOfReport = isEndOfReport(row);
                };
            } catch (IOException ex) {
                Logger.getLogger(BKUConverter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (EncryptedDocumentException ex) {
                Logger.getLogger(BKUConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
        }
    }

    public boolean isEndOfReport(Row row) {
        //set uraian
        String uraian;
        Cell uraianCell;
        uraianCell = row.getCell(URAIAN_COLUMN);
        uraian = uraianCell.getStringCellValue();
        uraian = uraian.toLowerCase();
        if (uraian.contains("jumlah")) {
            return true;
        } else{
            return false;
        }
    }

    public boolean isRowStandard(Row row) {
        //read debit or credit column
        Cell debitCell = row.getCell(DEBIT_COLUMN);
        double debit = debitCell.getNumericCellValue();
        Cell creditCell = row.getCell(CREDIT_COLUMN);
        double credit = creditCell.getNumericCellValue();
        //baca tanggal
        Cell dateCell = row.getCell(DATE_COLUMN);
        Date date = dateCell.getDateCellValue();
        // cek debit !=0 atau kredit !=0 dan tanggal tidak kosong
        if ((debit != 0 || credit != 0) && date != null) {
            return true;
        } else {
            return false;
        }
    }

    public Bku readRow(Row row) {
        //read debit or credit column
        Cell debitCell = row.getCell(DEBIT_COLUMN);
        double debit = debitCell.getNumericCellValue();
        int debitint = (int) debit;
        Cell creditCell = row.getCell(CREDIT_COLUMN);
        double credit = creditCell.getNumericCellValue();
        int creditint = (int) credit;
        //baca tanggal
        Cell dateCell = row.getCell(DATE_COLUMN);
        Date date = dateCell.getDateCellValue();
        // baca no kode
        Cell kodeCell = row.getCell(NO_KODE_COLUMN);
        String kode = kodeCell.getStringCellValue();
        // baca no bukti
        Cell buktiCell = row.getCell(NO_BUKTI_COLUMN);
        String bukti = buktiCell.getStringCellValue();
        //baca uraian
        String uraian;
        Cell uraianCell;
        uraianCell = row.getCell(URAIAN_COLUMN);
        uraian = uraianCell.getStringCellValue();
        uraian = uraian.toLowerCase();

        
        // set Bku object
        Bku bku = new Bku();
        bku.setNpsn(npsn);
        bku.setTanggal(date);
        bku.setNoKode(kode);
        bku.setNoBukti(bukti);
        bku.setUraian(uraian);
        bku.setPengeluaran(debitint);
        bku.setPenerimaan(creditint);
        
        // return bku
        return bku;
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
            // get first sheet
            Sheet sheet = workbook.getSheetAt(0);
            // get npsn
            //    set to npsn active cell
            Row row = sheet.getRow(NPSN_ROW);
            Cell cell = row.getCell(NPSN_ROW);
            if (cell.getCellType() == CellType.NUMERIC) {
                double hasil = cell.getNumericCellValue();
                npsn = (long) hasil;
            } else if (cell.getCellType() == CellType.STRING) {
                String hasil = cell.getStringCellValue();
                npsn = Long.parseLong(hasil);
            }
        } catch (IOException ex) {
            Logger.getLogger(BKUConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EncryptedDocumentException ex) {
            Logger.getLogger(BKUConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return npsn;
    }

    public boolean isJanuaryReport(File excel) {
        boolean result = false;
        try {

            // Creating a Workbook from an Excel file (.xls or .xlsx)
            Workbook workbook = WorkbookFactory.create(excel);
            // get first sheet
            Sheet sheet = workbook.getSheetAt(0);
            // get npsn
            //    set to npsn active cell
            Row row = sheet.getRow(FIRST_ROW_JANUARY_REPORT);
            Cell cell = row.getCell(URAIAN_COLUMN);
            String hasil = cell.getStringCellValue();
            hasil = hasil.toLowerCase();
            if (hasil.contains("desember")) {
                result = true;
            }
        } catch (IOException ex) {
            Logger.getLogger(BKUConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EncryptedDocumentException ex) {
            Logger.getLogger(BKUConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
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
