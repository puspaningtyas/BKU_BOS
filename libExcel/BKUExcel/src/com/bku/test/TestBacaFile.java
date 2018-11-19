/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bku.test;

import com.bku.xls.BKUConverter;
import com.bku.xls.Bku;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author user only
 */
public class TestBacaFile {

    public static void main(String[] args) {
        JFileChooser jf = new JFileChooser();
        int returnVal = jf.showOpenDialog(null);
        BKUConverter bku = new BKUConverter();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            ArrayList<Bku> list = bku.readExcel(jf.getSelectedFile());
            System.out.println("Panjang List = "+list.size());
            for (int i = 0; i < list.size(); i++) {
                Bku tmp = list.get(i);
                System.out.println("Npsn = "+tmp.getNpsn()
                        +",tgl = "+tmp.getTanggal()
                        +",uraian = "+tmp.getUraian()
                        +",kredit = "+tmp.getPenerimaan()
                        +",debit = "+tmp.getPengeluaran()
                        +",akreditasi = "+tmp.getKodeAkreditasi()
                        +",bkd = "+tmp.getKodeBkd());
                
            }
        }
    }
}
