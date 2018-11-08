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
public class TestSekolah1 {
    public static void main(String[] args) {
        SekolahHelper helper = new SekolahHelper();
        List<Sekolah> daftar = helper.getAllSekolah();
        for (int i = 0; i < daftar.size(); i++) {
            System.out.println("npsn = "+daftar.get(i).getNpsn()
                    +", Nama = "+daftar.get(i).getNamaSekolah());
        }
    }
}
