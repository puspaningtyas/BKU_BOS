/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bku.helper;

import com.bku.pojos.Sekolah;
import com.bku.util.BKUHibernateUtil;
import java.util.Collections;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author user only
 */
public class SekolahHelper {

    public SekolahHelper() {
    }

    public List<Sekolah> getAllSekolah() {
        Session session = BKUHibernateUtil.getSessionFactory().openSession();
        String query = "from Sekolah";
        List<Sekolah> result = null;
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }

    public Sekolah getSekolah(String npsn) {
        Session session = BKUHibernateUtil.getSessionFactory().openSession();
        long dataNPSN = Long.parseLong(npsn);
        String query = "from Sekolah s where s.npsn=:npsn ";
        List<Sekolah> result = null;
        Query q = session.createQuery(query);
        q.setParameter("npsn", dataNPSN);
        result = q.list();
        session.close();
        if (result != null) {
            return result.get(0);
        } else {
            return null;
        }
    }
}
