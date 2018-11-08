/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bku.helper;

import com.bku.pojos.Sekolah;
import com.bku.pojos.Users;
import com.bku.util.BKUHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author user only
 */
public class UsersHelper {

    public UsersHelper() {
    }
    
    public List<Users> getAllUsers() {
        Session session = BKUHibernateUtil.getSessionFactory().openSession();
        String query = "from Users";
        List<Users> result = null;
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }

    public Users getUsers(String email) {
        Session session = BKUHibernateUtil.getSessionFactory().openSession();
        String query = "from Users u where u.email=:email ";
        List<Users> result = null;
        Query q = session.createQuery(query);
        q.setParameter("email", email);
        result = q.list();
        session.close();
        if (result != null) {
            return result.get(0);
        } else {
            return null;
        }
    }
}
