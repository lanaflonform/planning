/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.view.AdminSyst;

import com.planning.view.Enseignant.*;

/**
 *
 * @author Azough Mehdi
 */
public class GererUtilisateurs extends javax.swing.JInternalFrame {

    /**
     * Creates new form SeanceRattrapage
     */
    public GererUtilisateurs() {
        initComponents();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        listeutilisateur = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        modifier = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        nomfield = new javax.swing.JTextField();
        prenomfield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mailfield = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        telfield = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        idfield = new javax.swing.JTextField();
        Confirmer = new javax.swing.JButton();

        setTitle("Gérer utilisateurs");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Gestion Utilisateurs");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        listeutilisateur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nom", "Prenom", "Mail", "Tel", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 540, 150));

        jLabel2.setText("Liste utilisateurs:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        modifier.setText("Modifier");
        getContentPane().add(modifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 130, 30));

        supprimer.setText("Supprimer");
        getContentPane().add(supprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 130, 30));

        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Ajouter utilisateur");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        nomfield.setEnabled(false);
        getContentPane().add(nomfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 160, 20));

        prenomfield.setEnabled(false);
        prenomfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenomfieldActionPerformed(evt);
            }
        });
        getContentPane().add(prenomfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 160, 20));

        jLabel4.setText("Nom");
        jLabel4.setEnabled(false);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        jLabel5.setText("Prenom");
        jLabel5.setEnabled(false);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, -1));

        mailfield.setEnabled(false);
        getContentPane().add(mailfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 160, 20));

        jLabel6.setText("mail");
        jLabel6.setEnabled(false);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));

        jLabel7.setText("Tel");
        jLabel7.setEnabled(false);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, -1, -1));

        telfield.setEnabled(false);
        getContentPane().add(telfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 160, 20));

        jLabel8.setText("Saisir l'identifiant de l'utilisateur");
        jLabel8.setEnabled(false);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, -1, -1));

        idfield.setEnabled(false);
        idfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idfieldActionPerformed(evt);
            }
        });
        getContentPane().add(idfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 210, 30));

        Confirmer.setText("Confirmer");
        Confirmer.setEnabled(false);
        getContentPane().add(Confirmer, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, 140, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prenomfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenomfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prenomfieldActionPerformed

    private void idfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idfieldActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if(jRadioButton1.isSelected()){
            jLabel4.setEnabled(true);
            jLabel5.setEnabled(true);
            jLabel6.setEnabled(true);
            jLabel7.setEnabled(true);
            jLabel8.setEnabled(true);
            nomfield.setEnabled(true);
            prenomfield.setEnabled(true);
            mailfield.setEnabled(true);
            idfield.setEnabled(true);
            telfield.setEnabled(true);
            Confirmer.setEnabled(true);
        }
        else{
            
            jLabel4.setEnabled(false);
            jLabel5.setEnabled(false);
            jLabel6.setEnabled(false);
            jLabel7.setEnabled(false);
            jLabel8.setEnabled(false);
            nomfield.setEnabled(false);
            prenomfield.setEnabled(false);
            mailfield.setEnabled(false);
            idfield.setEnabled(false);
            Confirmer.setEnabled(false);
            telfield.setEnabled(false);
            
            
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        listeutilisateur.clearSelection();
        modifier.setEnabled(false);
        supprimer.setEnabled(false);
    }//GEN-LAST:event_formMouseClicked

    private void listeutilisateurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeutilisateurMouseClicked
        modifier.setEnabled(true);
        supprimer.setEnabled(true);
    }//GEN-LAST:event_listeutilisateurMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Confirmer;
    private javax.swing.JTextField idfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listeutilisateur;
    private javax.swing.JTextField mailfield;
    private javax.swing.JButton modifier;
    private javax.swing.JTextField nomfield;
    private javax.swing.JTextField prenomfield;
    private javax.swing.JButton supprimer;
    private javax.swing.JTextField telfield;
    // End of variables declaration//GEN-END:variables
}
