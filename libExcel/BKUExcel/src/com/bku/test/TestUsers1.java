/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bku.test;

import com.bku.helper.UsersHelper;
import com.bku.pojos.Users;
import java.util.List;

/**
 *
 * @author user only
 */
public class TestUsers1 {
    public static void main(String[] args) {
        UsersHelper helper = new UsersHelper();
        List<Users> daftar = helper.getAllUsers();
        for (int i = 0; i < daftar.size(); i++) {
            System.out.println("email = "+daftar.get(i).getEmail()
                    +", Nama = "+daftar.get(i).getName());
        }
    }
}
