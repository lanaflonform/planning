/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning;

import java.awt.Color;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

public class ConnexionBD {
    
    public static Connection open(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/planning_bd","root","");
            if (connection!=null)
                System.out.println("Connexion Reussite");
            else
                System.out.println("Erreur de Connexion");
        return connection;
        
                
        }catch(Exception e){
            System.out.println("--> SQLException : "+ e);
            return null;
        }
        
    }
     public static void main(String args[]){
         Connection conn = null;
         ResultSet rs = null;
         PreparedStatement ps = null;
         ConnexionBD.open();
         try{
            String requete = "select * from Enseignant ";
            ps = conn.prepareStatement(requete);
            rs = ps.executeQuery();
            if(rs.next()){
                  System.out.println("DONE !");
                  
                  
                  
                  
            }
            
            
        }catch(Exception e){
            System.out.println("--> Exception : "+ e);
          
    }                   
         
     }
    
}
