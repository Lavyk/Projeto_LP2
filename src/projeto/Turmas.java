/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import banco.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Turmas extends javax.swing.JFrame {

    FuncTurmas db = new FuncTurmas();

    public Turmas() {
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
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 20;
        jPanel2.add(jLabel2, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        jLabel1.setText("Turmas");
        jPanel1.add(jLabel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jPanel1, gridBagConstraints);

        btnVincular.setText("Criar turma");
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

        btnDesvincular.setText("Remover turma");
        btnDesvincular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesvincular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDesvincularMouseClicked(evt);
            }
        });
        btnDesvincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesvincularActionPerformed(evt);
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
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 20);
        jPanel2.add(jButton1, gridBagConstraints);

        jButton2.setText("Ver turmas");
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

        jButton3.setText("Encerrar turma");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 10);
        jPanel2.add(jButton3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("empty-statement")
    private void btnVincularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVincularMouseClicked
        String disciplina = null;
        String professor = null;

        try {

            disciplina = db.selecionarDisciplinas();

            if (disciplina == null) {
                JOptionPane.showMessageDialog(null, "Selecione uma disciplina!");
            } else {

                professor = db.selecionarProfessor();
                if (professor == null) {
                    JOptionPane.showMessageDialog(null, "Selecione um professor!");
                } else {
                    boolean verificar = db.verificarTurma(disciplina, professor);
                    boolean professorDisponivel = db.professorDisponivel(professor);
                    if (professorDisponivel) {
                        if (verificar == false) {
                            TurmaAlunos alunos = new TurmaAlunos(professor, disciplina);
                            alunos.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "O professor " + professor + " já tem uma turma de " + disciplina);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "O professor " + professor + " atingiu o numero máximo de turmas. [Máx: 2]");
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Turmas.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnVincularMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        try {
            db.verTurmas();
        } catch (SQLException ex) {
            Logger.getLogger(Turmas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2MouseClicked

    private void btnDesvincularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDesvincularMouseClicked
        try {
            db.removerTurma();

        } catch (SQLException ex) {
            Logger.getLogger(Turmas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnDesvincularMouseClicked

    private void btnDesvincularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesvincularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesvincularActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        try {
            db.encerrarTurma();
        } catch (SQLException ex) {
            Logger.getLogger(Turmas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3MouseClicked

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
            java.util.logging.Logger.getLogger(Turmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Turmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Turmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Turmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Turmas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDesvincular;
    private javax.swing.JButton btnVincular;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
