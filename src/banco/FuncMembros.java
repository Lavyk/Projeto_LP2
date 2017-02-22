/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.*;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class FuncMembros extends ConectarBanco{

    Connection c = null;
    Statement stmt = null;


    public void addMembro(String nome, String cargo) throws SQLException, ClassNotFoundException {

        int matricula = gerarMatricula();

        boolean teste = verificarMatricula(matricula);

        if (teste) {
            gerarMatricula();
        } else {
            try {
                c = getConnection();
                c.setAutoCommit(false);

                stmt = c.createStatement();
                String sql = "INSERT INTO usuarios (matricula, nome, cargo) VALUES (" + matricula + ", '" + nome + "', '" + cargo + "');";
                stmt.executeUpdate(sql);
                stmt.close();
                c.commit();
                c.close();

                String msg = "Membro matriculado com sucesso! \n  Nome: " + nome + " [" + cargo + "] \n  Matricula: " + matricula;
                JOptionPane.showMessageDialog(null, msg);

            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        }
    }

    public void removerMembro(int matricula) throws SQLException {
        try {

            boolean verificaMat = verificarMatricula(matricula);
            if (verificaMat) {
                c = getConnection();
                c.setAutoCommit(false);
                stmt = c.createStatement();
                String sql = "DELETE FROM usuarios WHERE matricula = " + matricula;
                stmt.executeUpdate(sql);
                c.commit();
                JOptionPane.showMessageDialog(null, "Membro removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Não existe nenhum membro com essa matricula! \nMatricula: " + matricula);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }

    public int gerarMatricula() throws SQLException {

        //Gera matricula aleatoria de acordo com o Ano, Mês e o Dia.
        String ano = (Calendar.getInstance().get(Calendar.YEAR) + "").substring(2, 4);
        int intMes = Calendar.getInstance().get(Calendar.MONTH) + 1;
        String mes = null;
        if (intMes <= 9) {
            mes = "0" + intMes;
        } else {
            mes = intMes + "";
        }

        int intDia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        String dia = null;
        if (intDia <= 9) {
            dia = "0" + intDia;
        } else {
            dia = intDia + "";
        }
        String matriculaResto = ThreadLocalRandom.current().nextInt(100, 999 + 1) + "";
        String matricula = (ano + mes + dia + matriculaResto);

        int matFinal = Integer.valueOf(matricula).intValue();
        return matFinal;
    }

    public boolean verificarMatricula(int matricula) throws SQLException {

        boolean result = false;
        c = getConnection();
        c.setAutoCommit(false);
        stmt = c.createStatement();

        String sql = "SELECT * FROM usuarios WHERE matricula = " + matricula + ";";
        //stmt.executeUpdate(sql);
        ResultSet rs = null;

        rs = stmt.executeQuery(sql);
        if (rs.next()) {
            result = true;
        }
        c.close();
        return result;
    }

    public void verMembros(String cargo) throws SQLException {
        c = getConnection();
        c.setAutoCommit(false);
        stmt = c.createStatement();

        String sql = "SELECT * FROM usuarios WHERE cargo = '" + cargo + "';";
        ResultSet rs = stmt.executeQuery(sql);

        Object[] colunas = {"Matricula", "Nome", "Cargo"};

        TableModel tabela = new DefaultTableModel(colunas, 0);
        JTable toDoTable = new JTable(tabela);
        DefaultTableModel modelo = (DefaultTableModel) toDoTable.getModel();

        while (rs.next()) {
            Object[] data = {rs.getString("matricula"), rs.getString("nome"), rs.getString("cargo")};
            modelo.addRow(data);
        }

        JTable ultimaTabela = toDoTable;
        JOptionPane.showMessageDialog(null, new JScrollPane(ultimaTabela));
        
        c.close();
    }

}
