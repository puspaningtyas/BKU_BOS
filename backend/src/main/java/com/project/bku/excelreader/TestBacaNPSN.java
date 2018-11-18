package com.project.bku.excelreader;

import javax.swing.*;

public class TestBacaNPSN {
    public static void main(String[] args) {
        JFileChooser jf = new JFileChooser();
        int returnVal = jf.showOpenDialog(null);
        BKUConverter bku = new BKUConverter();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            long npsn = bku.readNpsn(jf.getSelectedFile());
            System.out.println("NPSN = " + npsn);
        }
    }
}
