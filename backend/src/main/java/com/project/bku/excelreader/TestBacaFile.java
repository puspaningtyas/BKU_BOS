package com.project.bku.excelreader;

import com.project.bku.payload.BkuDto;

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
            ArrayList<BkuDto> list = bku.readExcel(jf.getSelectedFile());
            System.out.println("Panjang List = "+list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.println("getNpsn : "+list.get(i).getNpsn());
                System.out.println("getKodeAkreditasi : "+list.get(i).getKodeAkreditasi());
                System.out.println("getKodeLaporanBos : "+list.get(i).getKodeLaporanBos());
                System.out.println("getKodeKementrian : "+list.get(i).getKodeKementrian());
                System.out.println("getKodeBkd : "+list.get(i).getKodeBkd());
                System.out.println("getUraian : "+list.get(i).getUraian());
                System.out.println("getNoBukti : "+list.get(i).getNoBukti());
                System.out.println("getPenerimaan : "+list.get(i).getPenerimaan());
                System.out.println("getPengeluaran : "+list.get(i).getPengeluaran());
                System.out.println("getNoKode : "+list.get(i).getNoKode());
                System.out.println("getTanggal : "+list.get(i).getTanggal());
                System.out.println("getTanggalPelunasan : "+list.get(i).getTanggalPelunasan());
                System.out.println("getStatusPemeriksa : "+list.get(i).getStatusPemeriksa());
            }
        }
    }
}
