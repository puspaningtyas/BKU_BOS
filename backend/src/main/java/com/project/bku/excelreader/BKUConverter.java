package com.project.bku.excelreader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.project.bku.exception.BadRequestException;
import com.project.bku.payload.BkuDto;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

/**
 * @author Puspaningtyas
 */

@Service
public class BKUConverter {

    public static final int FIRST_ROW_JANUARY_REPORT = 9;
    public static final int DATE_COLUMN = 0;
    public static final int NO_KODE_COLUMN = 1;
    public static final int NO_BUKTI_COLUMN = 2;
    public static final int URAIAN_COLUMN = 3;
    public static final int CREDIT_COLUMN = 4;
    public static final int DEBIT_COLUMN = 5;
    public static final int LUNAS_DATE_COLUMN = 8;
    public static final int KODE_AKREDITASI_COLUMN = 9;
    public static final int KODE_KEMENTRIAN_COLUMN = 10;
    public static final int KODE_BKD_COLUMN = 11;
    public static final int KODE_BOS_COLUMN = 12;

    public static final int NPSN_COLUMN = 9;
    public static final int NPSN_ROW = 4;
    private long npsn;

    private static final int SALDO_PINDAHAN_ROW = 9;
    private static final int SALDO_COLUMN = 6;

    private int saldo;

    public BKUConverter() {
    }

    public ArrayList<BkuDto> readExcel(File excel) {
        // read npsn
        npsn = readNpsn(excel);
        // npsn not found
        if (npsn == -1) {
            return null;
        } else {
            // create bku list
            ArrayList<BkuDto> list = new ArrayList<BkuDto>();
            try {
                // Creating a Workbook from an Excel file (.xls or .xlsx)
                Workbook workbook = WorkbookFactory.create(excel);
                // get first sheet
                Sheet sheet = workbook.getSheetAt(0);
                int rowIndex = SALDO_PINDAHAN_ROW;
                boolean endOfReport = false;
                // read saldo pindahan
                Row row = sheet.getRow(rowIndex);
                BkuDto saldoPindahan = readRowSaldoPindahan(row);
                // read or set saldo
                saldo = saldoPindahan.getSaldo();
                // add to list
                list.add(saldoPindahan);
                // set row for next read
                rowIndex++;
                // chek month of report
//                if (isJanuaryReport(excel)) {
//                    // january report
//                    // first row
//                    rowIndex = FIRST_ROW_JANUARY_REPORT;
//                } else {
//                    // non january report
//                    // first row
//                    rowIndex = FIRST_ROW_JANUARY_REPORT + 1;
//                }

                // read line of report
                while (!endOfReport) {
                    // set row object
                    row = sheet.getRow(rowIndex);
                    // baris sesuai standar apa tidak
                    if (isRowStandard(row)) {
                        //baca baris
                        BkuDto bku = readRow(row);
                        // tambahkan ke list
                        // cek saldo is right
                        if (isSaldoRight(bku)) {
                            list.add(bku);
                            saldo = bku.getSaldo();
                        } else{
                            throw new BadRequestException("Saldo is wrong");
                        }
                    }
                    //increase row index
                    rowIndex++;
                    // cek end of report
                    row = sheet.getRow(rowIndex);
                    endOfReport = isEndOfReport(row);
                }
                ;
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
        if (uraian.equals("jumlah")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSaldoRight(BkuDto bku) {
        int realSaldo = 0;
        if (bku.getPenerimaan() > 0) {
            realSaldo = saldo + bku.getPenerimaan();
            if (realSaldo == bku.getSaldo()) {
                return true;
            } else {
                return false;
            }
        } else if (bku.getPengeluaran() > 0) {
            realSaldo = saldo - bku.getPengeluaran();
            if (realSaldo == bku.getSaldo()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public BkuDto readRowSaldoPindahan(Row row) {
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

        //baca uraian
        String uraian;
        Cell uraianCell;
        uraianCell = row.getCell(URAIAN_COLUMN);
        uraian = uraianCell.getStringCellValue();
        uraian = uraian.toLowerCase();

        //baca saldo
        Cell saldoCell = row.getCell(SALDO_COLUMN);
        double saldo = saldoCell.getNumericCellValue();
        int saldoint = (int) saldo;

        // set Bku object
        BkuDto bku = new BkuDto();
        bku.setNpsn(npsn);
        bku.setTanggal(date);
        bku.setNoKode("-");
        bku.setNoBukti("-");
        bku.setUraian(uraian);
        bku.setPengeluaran(debitint);
        bku.setPenerimaan(creditint);
        bku.setSaldo(saldoint);
        bku.setTanggalPelunasan(date);
        // return bku
        return bku;
    }

    public boolean isRowStandard(Row row) {
        //read debit or credit column
        Cell debitCell = row.getCell(DEBIT_COLUMN);
        double debit = debitCell.getNumericCellValue();
        Cell creditCell = row.getCell(CREDIT_COLUMN);
        double credit = creditCell.getNumericCellValue();
        //baca tanggal
        Cell dateCell;

        dateCell = row.getCell(DATE_COLUMN);
        Date date;
        try {
            date = dateCell.getDateCellValue();
        } catch (IllegalStateException e) {
            throw new BadRequestException("Salah ketik pada kolom jumlah akhir.");
        }
        // cek debit !=0 atau kredit !=0 dan tanggal tidak kosong
        if ((debit != 0 || credit != 0) && date != null) {
            return true;
        } else {
            return false;
        }
    }

    public BkuDto readRow(Row row) {
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
        String kode;
        if (kodeCell.getCellType() == CellType.STRING) {
            kode = kodeCell.getStringCellValue();
        } else {
            double kodeDouble = kodeCell.getNumericCellValue();
            kode = String.valueOf(kodeDouble);
        }

        // baca no bukti
        Cell buktiCell = row.getCell(NO_BUKTI_COLUMN);
        String bukti;
        if (buktiCell.getCellType() == CellType.STRING) {
            bukti = buktiCell.getStringCellValue();
        } else {
            double buktiDouble = buktiCell.getNumericCellValue();
            bukti = String.valueOf(buktiDouble);
        }

        //baca uraian
        String uraian;
        Cell uraianCell;
        uraianCell = row.getCell(URAIAN_COLUMN);
        uraian = uraianCell.getStringCellValue();
        uraian = uraian.toLowerCase();

        //baca saldo
        Cell saldoCell = row.getCell(SALDO_COLUMN);
        double saldo = saldoCell.getNumericCellValue();
        int saldoint = (int) saldo;

        // baca tanggal lunas
        Cell tglLunasCell = row.getCell(LUNAS_DATE_COLUMN);
        Date tglLunas = tglLunasCell.getDateCellValue();

        //Temp
        String akreditasi = "";
        String kementrian = "";
        String bkd11 = "";
        String bos = "";

        // baca kode akreditasi
        Cell akreditasiCell = row.getCell(KODE_AKREDITASI_COLUMN);
        if (akreditasiCell != null) {
            if (akreditasiCell.getCellType() == CellType.STRING) {
                akreditasi = akreditasiCell.getStringCellValue();
            } else {
                double akreditasiDouble = akreditasiCell.getNumericCellValue();
                akreditasi = String.valueOf(akreditasiDouble);
            }
        }

        // baca kode kementrian
        Cell kementrianCell = row.getCell(KODE_KEMENTRIAN_COLUMN);
        if (kementrianCell != null) {
            if (kementrianCell.getCellType() == CellType.STRING) {
                kementrian = kementrianCell.getStringCellValue();
            } else {
                double kementrianDouble = kementrianCell.getNumericCellValue();
                kementrian = String.valueOf(kementrianDouble);
            }
        }

        // baca kode bkd
        Cell bkdCell = row.getCell(KODE_BKD_COLUMN);
        if (bkdCell != null) {
            if (bkdCell.getCellType() == CellType.STRING) {
                bkd11 = bkdCell.getStringCellValue();
            } else {
                double bkdDouble = bkdCell.getNumericCellValue();
                bkd11 = String.valueOf(bkdDouble);
            }
        }

        // baca kode BOS
        Cell bosCell = row.getCell(KODE_BOS_COLUMN);
        if (bosCell != null) {
            if (bosCell.getCellType() == CellType.STRING) {
                bos = bosCell.getStringCellValue();
            } else {
                double bosDouble = bosCell.getNumericCellValue();
                bos = String.valueOf(bosDouble);
            }
        }

        // set Bku object
        BkuDto bku = new BkuDto();
        bku.setNpsn(npsn);
        bku.setTanggal(date);
        bku.setNoKode(kode);
        bku.setNoBukti(bukti);
        bku.setUraian(uraian);
        bku.setPengeluaran(debitint);
        bku.setPenerimaan(creditint);
        bku.setSaldo(saldoint);
        bku.setTanggalPelunasan(tglLunas);
        bku.setKodeAkreditasi(akreditasi);
        bku.setKodeKementrian(kementrian);
        bku.setKodeBkd(bkd11);
        bku.setKodeLaporanBos(bos);
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
            Cell cell = row.getCell(NPSN_COLUMN);
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