/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.dao.implement;

import com.planning.dao.DAO;
import com.planning.model.Filiere;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author genereux
 */
public class FiliereDAO extends DAO<Filiere> {
    
    public FiliereDAO (Connection conn) {
        super(conn);
    }
    
    public boolean create(Filiere obj) {
        return false;
    }
    
    public boolean delete(Filiere obj){
        return false;
    }
    
    public boolean update(Filiere obj){
        return false;
   
    }
    
    public Filiere find(int id){
        
        Filiere filiere = new Filiere();
        
        try {
            
            Statement state = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            
            String query = new String("SELECT * FROM Filiere WHERE NumFiliere = " + id);
            
            ResultSet res = state.executeQuery(query);
            
            if(res.first()) {
            
                    filiere = new Filiere(res.getInt(0), res.getString(1));
             } 
        }catch (SQLException e) {
            
        e.printStackTrace();
                
        }
        
        return filiere;
    
    }
    
    
}