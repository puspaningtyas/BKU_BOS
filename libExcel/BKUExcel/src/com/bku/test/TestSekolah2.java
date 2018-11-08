/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bku.test;

import com.bku.helper.SekolahHelper;
import com.bku.pojos.Sekolah;
import java.util.List;

/**
 *
 * @author user only
 */
public class TestSekolah2 {
    public static void main(String[] args) {
        SekolahHelper helper = new SekolahHelper();
        Sekolah daftar = helper.getSekolah("7985410241129");
            System.out.println("npsn = "+daftar.getNpsn()
                    +", Nama = "+daftar.getNamaSekolah());
        
    }
}
