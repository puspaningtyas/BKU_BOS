package com.bku.pojos;
// Generated Nov 1, 2018 9:41:32 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Roles generated by hbm2java
 */
public class Roles  implements java.io.Serializable {


     private long id;
     private String name;
     private Set<Users> userses = new HashSet<Users>(0);

    public Roles() {
    }

	
    public Roles(long id) {
        this.id = id;
    }
    public Roles(long id, String name, Set<Users> userses) {
       this.id = id;
       this.name = name;
       this.userses = userses;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set<Users> getUserses() {
        return this.userses;
    }
    
    public void setUserses(Set<Users> userses) {
        this.userses = userses;
    }




}

