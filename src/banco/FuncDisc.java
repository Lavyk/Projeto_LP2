/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Super i3
 */
public class FuncDisc extends ConectarBanco {

    Connection c = null;
    Statement stmt = null;

    public void criarDisciplina(String discNome) throws SQLException, ClassNotFoundException {
        try {
            c = getConnection();
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "INSERT INTO disciplinas (nome) VALUES ( '" + discNome + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();

            String msg = "Disciplina criada com sucesso! \n  Disciplina: " + discNome;
            JOptionPane.showMessageDialog(null, msg);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }

    public JTable todasDisciplinas() throws SQLException {
        c = getConnection();
        c.setAutoCommit(false);
        stmt = c.createStatement();

        String sql = "SELECT * FROM disciplinas;";
        ResultSet rs = stmt.executeQuery(sql);

        Object[] colunas = {"Nome"};

        TableModel tabela = new DefaultTableModel(colunas, 0) {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        JTable toDoTable = new JTable(tabela);
        DefaultTableModel modelo = (DefaultTableModel) toDoTable.getModel();

        while (rs.next()) {
            Object[] data = {rs.getString("nome")};
            modelo.addRow(data);
        }

        JTable ultimaTabela = toDoTable;
        stmt.close();
        c.commit();
        c.close();

        return ultimaTabela;
    }

    public void verDisciplinas() throws SQLException {
        JTable ultimaTabela = todasDisciplinas();
        JOptionPane.showMessageDialog(null, new JScrollPane(ultimaTabela));
    }

    public void removerDisciplinas() throws SQLException {
        JTable ultimaTabela = todasDisciplinas();
        int confirmar = JOptionPane.showConfirmDialog(null, new JScrollPane(ultimaTabela));

        String disciplinaNome;
        int valor = ultimaTabela.getSelectedRow();

        try {
            disciplinaNome = ultimaTabela.getValueAt(valor, 0).toString();

        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            disciplinaNome = null;
        }

        c = getConnection();
        c.setAutoCommit(false);
        stmt = c.createStatement();

        if (confirmar == 0) {
            if (disciplinaNome != null) {
                String sql = "DELETE FROM disciplinas WHERE nome = '" + disciplinaNome + "';";
                stmt.executeUpdate(sql);
                stmt.close();
                c.commit();
                c.close();
                JOptionPane.showMessageDialog(null, disciplinaNome + " foi removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Escolha uma disciplina!");
            }

        }

    }
}
