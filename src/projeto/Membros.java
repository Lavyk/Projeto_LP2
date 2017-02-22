/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import banco.FuncMembros;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Super i3
 */
public class Membros extends javax.swing.JFrame {

    /**
     * Creates new form Membros
     */
    FuncMembros db = new FuncMembros();

    public Membros() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnVincular = new javax.swing.JButton();
        btnDesvincular = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 20;
        jPanel2.add(jLabel2, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        jLabel1.setText("Membros");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jPanel1, gridBagConstraints);

        btnVincular.setText("Matricular membro");
        btnVincular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVincular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVincularMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 10);
        jPanel2.add(btnVincular, gridBagConstraints);

        btnDesvincular.setText("Desmatricular membro");
        btnDesvincular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesvincular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDesvincularMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 10);
        jPanel2.add(btnDesvincular, gridBagConstraints);

        jButton1.setText("Fechar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 20);
        jPanel2.add(jButton1, gridBagConstraints);

        jButton2.setText("Ver membros");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 10);
        jPanel2.add(jButton2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVincularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVincularMouseClicked
        Object[] message2 = {"Nome: "};
        String strNome = JOptionPane.showInputDialog(null, message2, "Vincular membro", JOptionPane.QUESTION_MESSAGE);
        if (strNome != null) {
            if (strNome.equals("")) {
                JOptionPane.showMessageDialog(null, "O nome não pode ficar em branco!");
            } else {

                String[] choices = {"Aluno", "Professor"};
                String strCargo = (String) JOptionPane.showInputDialog(null, "Cargo: ", "Vincular membro", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
                try {
                    if (!strCargo.equals(null)) {
                        db.addMembro(strNome, strCargo);
                    }
                } catch (Exception e) {
                    //Qnd cancelar a operação
                }

            }
        }

    }//GEN-LAST:event_btnVincularMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        String[] choices = {"Aluno", "Professor"};
        String cargo = (String) JOptionPane.showInputDialog(null, "Cargo: ", "Ver membros", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

        try {
            if (cargo.equals("Aluno")) {
                //Ver todos os alunos da instituição.
                db.verMembros(cargo);
            } else {
                //Ver todos os professores da instituição.
                db.verMembros(cargo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Membros.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton2MouseClicked

    private void btnDesvincularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDesvincularMouseClicked
        Object[] message = {"Matricula: "};
        String strMatricula = JOptionPane.showInputDialog(null, message, "Desmatricular membro", JOptionPane.QUESTION_MESSAGE);
        try {
            if (strMatricula.equals("")) {
                JOptionPane.showMessageDialog(null, "A matricula não pode ficar em branco!");
            } else {
                if(strMatricula.length() == 9){
                    try {
                        int matricula = Integer.valueOf(strMatricula);
                        db.removerMembro(matricula);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "A matricula não pode receber letras!");
                    } 
                } else {
                    JOptionPane.showMessageDialog(null, "Matricula invalida!");
                }
                
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnDesvincularMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Membros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Membros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Membros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Membros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Membros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDesvincular;
    private javax.swing.JButton btnVincular;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}