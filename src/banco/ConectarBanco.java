//Precisa importar a biblioteca "sqlite-jdbc" para o projeto
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Super i3
 */
abstract class ConectarBanco {

    public Connection getConnection() {
        try {
                
            return DriverManager.getConnection("jdbc:sqlite:src/banco/bancoUser.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
            
        }
    }

    public void fecharConexao(Statement stmt, Connection c) throws SQLException {
        stmt.close();
        c.commit();
        c.close();
    }
}
