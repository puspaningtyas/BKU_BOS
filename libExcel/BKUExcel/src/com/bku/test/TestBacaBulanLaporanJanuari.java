/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bku.test;

import com.bku.xls.BKUConverter;
import javax.swing.JFileChooser;

/**
 *
 * @author user only
 */
public class TestBacaBulanLaporanJanuari {

    public static void main(String[] args) {
        JFileChooser jf = new JFileChooser();
        int returnVal = jf.showOpenDialog(null);
        BKUConverter bku = new BKUConverter();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            boolean isLaporanJanuari = bku.isJanuaryReport(jf.getSelectedFile());
            System.out.println("isJanuaryReport = " + isLaporanJanuari);
        }
    }
}
