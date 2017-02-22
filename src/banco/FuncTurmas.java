package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import projeto.TurmaAlunos;

public class FuncTurmas extends ConectarBanco {

    Connection c = null;
    Statement stmt = null;

    public boolean criarTurma(String professor, String disciplina) throws SQLException, ClassNotFoundException {
        boolean concluido = false;
        try {

            boolean verificar = verificarTurma(disciplina, professor);

            if (verificarMatriculados()) {

                if (verificar == false) {
                    c = getConnection();
                    c.setAutoCommit(false);
                    stmt = c.createStatement();

                    String sql = "INSERT INTO turmas (disciplina, professor) VALUES ('" + disciplina + "', '" + professor + "');";
                    stmt.executeUpdate(sql);
                    fecharConexao(stmt, c);

                    String msg = "Turma criada com sucesso! \n \nNome: " + disciplina + " [" + professor + "]";
                    JOptionPane.showMessageDialog(null, msg);
                    concluido = true;

                } else {
                    String msg = "O professor " + professor + " já tem uma turma de " + disciplina + "]";
                    JOptionPane.showMessageDialog(null, msg);

                }
            } else {
                String msg = "Cadastre pelo menos 1 aluno!";
                JOptionPane.showMessageDialog(null, msg);
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return concluido;
    }

    public boolean verificarMatriculados() throws SQLException {
        boolean resultado = false;

        try {
            int turmaID = ultimoID() + 1;

            c = getConnection();
            c.setAutoCommit(false);
            stmt = c.createStatement();

            String sql = "SELECT * FROM turmasCadastro WHERE turmaID = " + turmaID + ";";

            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                resultado = true;
            } else {
                resultado = false;
            }

            fecharConexao(stmt, c);

        } catch (Exception e) {
            System.out.println(e);
        }

        return resultado;
    }

    public boolean verificarTurma(String disciplina, String professor) throws SQLException {
        boolean result = false;
        c = getConnection();
        c.setAutoCommit(false);
        stmt = c.createStatement();

        String sql = "SELECT * FROM turmas WHERE disciplina = '" + disciplina + "' and professor = '" + professor + "';";
        stmt.executeUpdate(sql);
        ResultSet rs = null;

        rs = stmt.executeQuery(sql);
        if (rs.next()) {
            result = true;
        }

        stmt.close();
        c.commit();
        c.close();
        return result;
    }

    public boolean professorDisponivel(String professor) throws SQLException {
        boolean result = true;

        c = getConnection();
        c.setAutoCommit(false);
        stmt = c.createStatement();

        String sql = "SELECT * FROM turmas WHERE professor = '" + professor + "';";
        //stmt.executeUpdate(sql);
        ResultSet rs = null;

        rs = stmt.executeQuery(sql);

        int cont = 0;
        while (rs.next()) {
            cont++;
        }

        fecharConexao(stmt, c);

        if (cont >= 2) {
            return result = false;
        } else {
            return result = true;
        }

    }

    public void removerTurma() throws SQLException {
        JTable tabelaTurmas = todasTurmas();

        JOptionPane.showMessageDialog(null, new JScrollPane(tabelaTurmas));
        int selectAluno = tabelaTurmas.getSelectedRow();

        try {
            String strID = tabelaTurmas.getValueAt(selectAluno, 0).toString();
            c = getConnection();
            c.setAutoCommit(false);
            stmt = c.createStatement();

            String sql = "DELETE FROM turmas WHERE id = " + strID;
            stmt.executeUpdate(sql);

            fecharConexao(stmt, c);
            removerAlunoTurma();

            JOptionPane.showMessageDialog(null, "A turma foi excluida!");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {

        } finally {

        }

    }

    public void removerAlunoTurma() throws SQLException {
        int ultimoID = ultimoID() + 1;

        c = getConnection();
        c.setAutoCommit(false);
        stmt = c.createStatement();

        String sql = "SELECT * FROM turmasCadastro WHERE turmaID = " + (ultimoID);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {

            sql = "DELETE FROM turmasCadastro WHERE turmaID = " + ultimoID;
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();

        }
        fecharConexao(stmt, c);
    }

    public JTable todasTurmas() throws SQLException {
        c = getConnection();
        c.setAutoCommit(false);
        stmt = c.createStatement();

        String sql = "SELECT * FROM turmas;";
        ResultSet rs = stmt.executeQuery(sql);

        Object[] colunas = {"id", "Disciplina", "Professor"};

        TableModel tabela = new DefaultTableModel(colunas, 0) {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        JTable toDoTable = new JTable(tabela);
        DefaultTableModel modelo = (DefaultTableModel) toDoTable.getModel();

        while (rs.next()) {
            Object[] data = {rs.getString("id"), rs.getString("disciplina"), rs.getString("professor")};
            modelo.addRow(data);
        }

        JTable ultimaTabela = toDoTable;
        fecharConexao(stmt, c);

        return ultimaTabela;
    }

    public void verTurmas() throws SQLException {
        JTable ultimaTabela = todasTurmas();
        JOptionPane.showMessageDialog(null, new JScrollPane(ultimaTabela));
    }

    public String selecionarDisciplinas() throws SQLException {

        c = getConnection();
        c.setAutoCommit(false);
        stmt = c.createStatement();

        String sql = "SELECT * FROM disciplinas;";
        ResultSet rs = stmt.executeQuery(sql);
        String[] arrayDisciplinas = new String[99];
        int i = 0;

        while (rs.next()) {
            arrayDisciplinas[i] = rs.getString("nome");
            i++;
        }

        fecharConexao(stmt, c);

        String disciplina = (String) JOptionPane.showInputDialog(null, "Disciplina: ", "Criar turma", JOptionPane.QUESTION_MESSAGE, null, arrayDisciplinas, arrayDisciplinas[0]);
        //System.out.println(arrayDisciplinas.toString());

        if (disciplina == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma disciplina!");
            return null;
        } else {
            return disciplina;
        }

    }

    public String selecionarProfessor() throws SQLException {

        c = getConnection();
        c.setAutoCommit(false);
        stmt = c.createStatement();

        String sql = "SELECT * FROM usuarios WHERE cargo = 'Professor';";
        ResultSet rs = stmt.executeQuery(sql);
        String[] arrayProfessor = new String[99];
        int i = 0;

        while (rs.next()) {
            arrayProfessor[i] = rs.getString("nome");
            i++;
        }

        fecharConexao(stmt, c);

        String professor = (String) JOptionPane.showInputDialog(null, "Professor: ", "Criar turma", JOptionPane.QUESTION_MESSAGE, null, arrayProfessor, arrayProfessor[0]);

        if (professor == null) {
            JOptionPane.showMessageDialog(null, "Selecione um professor!");
            return null;
        } else {
            return professor;
        }

    }

    public void verMembros(JTable tabela) throws SQLException {
        c = getConnection();
        c.setAutoCommit(false);
        stmt = c.createStatement();

        PreparedStatement stmt = c.prepareStatement("SELECT * FROM usuarios WHERE cargo = 'Aluno';");
        ResultSet rs = stmt.executeQuery();

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

        while (rs.next()) {
            Object[] data = {rs.getString("matricula"), rs.getString("nome")};
            modelo.addRow(data);
        }

        fecharConexao(stmt, c);
    }

    public void vincularAluno(int matricula, String disciplina) throws SQLException {

        if (verificarAluno(matricula)) {
            if (verificarAlunoDisciplinas(matricula, disciplina)) {
                int ultimoID = ultimoID() + 1;

                c = getConnection();
                c.setAutoCommit(false);
                stmt = c.createStatement();

                String sql = "INSERT INTO turmasCadastro (matricula, disciplina, turmaID) VALUES ( '" + matricula + "', '" + disciplina + "', " + ultimoID + ");";

                stmt.executeUpdate(sql);

                fecharConexao(stmt, c);

                JOptionPane.showMessageDialog(null, "Aluno matriculado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "O aluno já está matriculado nessa turma.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "O aluno já está matriculado em 3 turmas.");
        }

    }

    public boolean verificarAluno(int matricula) throws SQLException {
        boolean apto = true;

        c = getConnection();
        c.setAutoCommit(false);
        stmt = c.createStatement();

        String sql = "SELECT * FROM turmasCadastro WHERE matricula = '" + matricula + "';";
        ResultSet rs = stmt.executeQuery(sql);

        int cont = 0;
        while (rs.next()) {
            cont++;
        }

        fecharConexao(stmt, c);

        if (cont >= 3) {
            return apto = false;
        } else {
            return apto = true;
        }
    }

    public boolean verificarAlunoDisciplinas(int matricula, String disciplina) throws SQLException {
        boolean apto = true;

        c = getConnection();
        c.setAutoCommit(false);
        stmt = c.createStatement();

        String sql = "SELECT * FROM turmasCadastro WHERE matricula = '" + matricula + "';";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            if (rs.getString("disciplina").equals(disciplina)) {
                apto = false;
            }

        }

        fecharConexao(stmt, c);

        return apto;
    }

    public int ultimoID() throws SQLException {

        c = getConnection();
        c.setAutoCommit(false);
        stmt = c.createStatement();

        String sql = "SELECT * FROM turmas";
        ResultSet rs = stmt.executeQuery(sql);
        int i = 0;
        while (rs.next()) {

            i = rs.getInt("id");
        }

        stmt.close();
        c.commit();
        c.close();

        return i;
    }

    public boolean encerrarTurma() throws SQLException {
        boolean terminou = false;

        c = getConnection();
        c.setAutoCommit(false);
        stmt = c.createStatement();

        String sql = "SELECT * FROM turmas";
        ResultSet rs = stmt.executeQuery(sql);
        String[] arrayTurmas = new String[99];
        int i = 0;

        String professor = rs.getString("professor");
        String disciplina = rs.getString("disciplina");

        while (rs.next()) {
            arrayTurmas[i] = "[ID: " + rs.getString("id") + "] " + disciplina + " [" + professor + "]";
            i++;
        }

        fecharConexao(stmt, c);

        String turmaID = (String) JOptionPane.showInputDialog(null, "Turma: ", "Encerrar turma", JOptionPane.QUESTION_MESSAGE, null, arrayTurmas, arrayTurmas[0]);
        int a, b;
        a = turmaID.indexOf(": ");
        b = turmaID.lastIndexOf("] ");
        turmaID = turmaID.substring(a + 1, b);

        if (turmaID == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma turma!");
            return false;
        } else {

            c = getConnection();
            c.setAutoCommit(false);
            stmt = c.createStatement();

            sql = "SELECT * FROM turmasCadastro WHERE turmaID = " + turmaID;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int matricula = rs.getInt("matricula");
                String nome = pegarNome(matricula);

            }

            fecharConexao(stmt, c);
            return true;
        }

    }

    public void inserirNoHistorico(int matricula, String media, String disciplina, String professor) throws SQLException {
        c = getConnection();
        c.setAutoCommit(false);
        stmt = c.createStatement();

        JOptionPane.showInputDialog(null, c.isClosed());
        String sql = "INSERT INTO historico (matricula, disciplina) VALUES (" + matricula + " , '" + disciplina + "');";
        stmt.executeUpdate(sql);
        fecharConexao(stmt, c);

    }

    public String pegarNome(int matricula) throws SQLException {

        c = getConnection();
        c.setAutoCommit(false);
        stmt = c.createStatement();

        String sql = "SELECT * FROM usuarios WHERE matricula = " + matricula;
        ResultSet rs = stmt.executeQuery(sql);
        String nome = rs.getString("nome");

        fecharConexao(stmt, c);

        return nome;
    }

    public void verAlunosMatriculados() throws SQLException {
        c = getConnection();
        c.setAutoCommit(false);
        stmt = c.createStatement();

        String sql = "SELECT * FROM turmasCadastro WHERE turmaID = 1";
        ResultSet rs = stmt.executeQuery(sql);

        Object[] colunas = {"Matricula", "Nome", "Disciplina", "Média"};

        TableModel tabela = new DefaultTableModel(colunas, 0) {
            boolean[] canEdit = new boolean[]{
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        };

        JTable toDoTable = new JTable(tabela);
        DefaultTableModel modelo = (DefaultTableModel) toDoTable.getModel();

        while (rs.next()) {

            int matricula = rs.getInt("matricula");
            String nome = pegarNome(matricula);
            String disciplina = rs.getString("disciplina");

            Object[] data = {matricula, nome, disciplina, ""};
            modelo.addRow(data);
        }

        JTable ultimaTabela = toDoTable;

        JOptionPane.showMessageDialog(null, new JScrollPane(ultimaTabela));

        int cont = 0;
        while (cont < ultimaTabela.getRowCount()) {
            String matricula = ultimaTabela.getValueAt(cont, 0) + "";
            String nome = (String) ultimaTabela.getValueAt(cont, 1) + "";
            String disciplina = (String) ultimaTabela.getValueAt(cont, 2) + "";
            String media = (String) ultimaTabela.getValueAt(cont, 3) + "";

            String opa = "[" + matricula + "] " + nome + "\nMédia: " + media;

            JOptionPane.showMessageDialog(null, opa);
            
            sql = "INSERT INTO historico (matricula, disciplina, nota) VALUES (" + matricula + ", '" + disciplina + "', '" + media + "');";
            stmt.executeUpdate(sql);

            cont++;
        }

    }

    public static void main(String[] args) throws SQLException {
        FuncTurmas main = new FuncTurmas();
        main.verAlunosMatriculados();
    }
}
