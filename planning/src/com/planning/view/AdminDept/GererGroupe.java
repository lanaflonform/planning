/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.view.AdminDept;

import com.planning.dao.implement.GroupeDAO;
import com.planning.model.ConnexionBD;
import com.planning.model.Groupe;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Azough Mehdi
 */
public class GererGroupe extends javax.swing.JInternalFrame {
    DefaultTableModel model = new DefaultTableModel();
    Groupe grp;
    GroupeDAO groupeD;
    ResultSet res = null;
    Connection conn = ConnexionBD.init();
    Groupe obj;
    int selectedRowIndex;
    int selectedColumnIndex;
    
    public GererGroupe() {
        
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)getUI()).setNorthPane(null);
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.getContentPane().setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        affichage(); 
    }
        
        
        
        
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Modifier = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeGroupe = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setTitle("Gérer groupes");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Gestion des groupes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Modifier.setText("Modifier");
        Modifier.setEnabled(false);
        Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierActionPerformed(evt);
            }
        });
        getContentPane().add(Modifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 120, 30));

        supprimer.setText("Supprimer");
        supprimer.setEnabled(false);
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });
        getContentPane().add(supprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 120, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 150, 40));

        listeGroupe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NomGroupe", "NomFiliere", "Niveau"
            }
        ));
        jScrollPane1.setViewportView(listeGroupe);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 490, 160));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        Modifier.setEnabled(false);
        supprimer.setEnabled(false);
        listeGroupe.clearSelection();
        
    }//GEN-LAST:event_formMouseClicked

    private void ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierActionPerformed
         Modifier modifier = new Modifier();
         modifier.setTitle("Modifier");
         int row = listeGroupe.getSelectedRow();
         String groupe =listeGroupe.getModel().getValueAt(row,0).toString();
         modifier.nomgroupefield.setText(groupe);
         modifier.setVisible(true);
         
    }//GEN-LAST:event_ModifierActionPerformed
      
     public void affichage(){
         groupeD = new GroupeDAO(conn);    
         res = groupeD.findALL();
         
         model = (DefaultTableModel) listeGroupe.getModel();
         model.setRowCount(0);
         try {
             while(res.next()) {
                model.addRow(new Object[] {res.getString(1), res.getString(2), res.getString(3)});
            }
         } catch (Exception e) {
             System.out.println("Exception in resulat: " + e);
         }
         
         listeGroupe.setModel(model);
      
         
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Ajouter ajouter = new Ajouter(); 
        ajouter.getgerergroupe(this);
        
        ajouter.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
   
    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        int p = JOptionPane.showConfirmDialog(null,"êtes-vous sur de vouloir sauvegarder","Confirmation",JOptionPane.YES_NO_OPTION);
        
    }//GEN-LAST:event_supprimerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Modifier;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listeGroupe;
    private javax.swing.JButton supprimer;
    // End of variables declaration//GEN-END:variables
}
