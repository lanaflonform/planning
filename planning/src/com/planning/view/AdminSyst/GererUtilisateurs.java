/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.view.AdminSyst;

import com.planning.dao.implement.EnseignantDAO;
import com.planning.dao.implement.UsersDAO;
import com.planning.model.ConnexionBD;
import com.planning.model.Enseignant;
import com.planning.model.Users;
import java.awt.Color;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Azough Mehdi
 */
public class GererUtilisateurs extends javax.swing.JInternalFrame {
    private ArrayList listens = null;
    private ArrayList listusers = null;
    private DefaultTableModel model;
    Connection conn = ConnexionBD.init();
    /**
     * Creates new form SeanceRattrapage
     */
    public GererUtilisateurs() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listeutilisateur = new javax.swing.JTable();
        modifier = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setTitle("Gestion des Utilisateurs");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listeutilisateur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Prenom", "Mail", "Tel", "ID", "Fonction", "Filiere"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listeutilisateur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeutilisateurMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listeutilisateur);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 740, 380));

        modifier.setText("Modifier");
        modifier.setEnabled(false);
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });
        getContentPane().add(modifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 130, 30));

        supprimer.setText("Supprimer");
        supprimer.setEnabled(false);
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Suprimer(evt);
            }
        });
        getContentPane().add(supprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 130, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 130, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void init() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI)getUI()).setNorthPane(null);
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.getContentPane().setBackground(Color.white);
        updateTable();
    }
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        listeutilisateur.clearSelection();
        modifier.setEnabled(false);
        supprimer.setEnabled(false);
    }//GEN-LAST:event_formMouseClicked

    private void listeutilisateurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeutilisateurMouseClicked
        modifier.setEnabled(true);
        supprimer.setEnabled(true);
    }//GEN-LAST:event_listeutilisateurMouseClicked

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        Enseignant ens;
        int row = listeutilisateur.getSelectedRow();
        String nom = listeutilisateur.getModel().getValueAt(row,0).toString();
        String prenom = listeutilisateur.getModel().getValueAt(row,1).toString();
        String mail = listeutilisateur.getModel().getValueAt(row,2).toString();
        String tel = listeutilisateur.getModel().getValueAt(row,3).toString();
        String id = listeutilisateur.getModel().getValueAt(row,4).toString();
        
        Modifier_Util1 modifier = new Modifier_Util1();
        modifier.setTitle("Modification de l'utilisateur");
        for(int i = 0; i < listens.size(); i++) {
            ens = (Enseignant) listens.get(i);
            if(id.equals(ens.getIDUser())) {
                modifier.setOldUser(ens);
            }
        }
        modifier.getFields(this, nom, prenom, mail, tel, id);
        modifier.setVisible(true);
        
    }//GEN-LAST:event_modifierActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Ajouter_Modifier_Util ajouter = new Ajouter_Modifier_Util();
        ajouter.setTitle("Ajout d'un utilisateur");
        ajouter.getGererUtili(this);
        ajouter.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Suprimer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Suprimer
        // TODO add your handling code here:
        String text = "Etes-vous sur de vouloir sauvegarder?\nLa suppression d'un enseignant entraînera la destruction de toutes les seances dispensées par ce dernier.";
        
        int p = JOptionPane.showConfirmDialog(null, text,"Confirmation",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        
        if(p == JOptionPane.NO_OPTION){
            return;
        }
        UsersDAO usersDAO = new UsersDAO(ConnexionBD.init());
        
        int row = listeutilisateur.getSelectedRow();
        String id = listeutilisateur.getModel().getValueAt(row,4).toString();
        
        Users user = new Users(id);
        usersDAO.delete(user);
        updateTable();

    }//GEN-LAST:event_Suprimer
    
    public void updateTable(){
        UsersDAO udao = new UsersDAO(conn);
        EnseignantDAO edao = new EnseignantDAO(conn);
        listens = edao.findAll();
        listusers = udao.findALL();
        Users user;
        Enseignant ens;
        model = (DefaultTableModel) listeutilisateur.getModel();
        model.setRowCount(0);
        if(listusers == null) return;
        for(int i = 0; i < listusers.size(); i++) {
           user = (Users) listusers.get(i);
           ens = user.getEnseignant();
           if(ens != null) model.addRow(new Object[]{ens.getNomEns(), ens.getPrenomEns(), ens.getMail(), ens.getTel(), ens.getIDUser(), user.getFonction(), user.getNomFiliere()});
           else model.addRow(new Object[]{"", "", "", 0, user.getIDUser(), user.getFonction(), user.getNomFiliere()});
       } 
       listeutilisateur.setModel(model); 
    }
    
    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
       
        
    }                                         


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable listeutilisateur;
    private javax.swing.JButton modifier;
    private javax.swing.JButton supprimer;
    // End of variables declaration//GEN-END:variables
}
