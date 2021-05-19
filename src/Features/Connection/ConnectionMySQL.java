package Features.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * 
 * @author LosSietePecadosCapitales
 */
public class ConnectionMySQL {
    
    public Connection connection;
    public Statement sentence;
    public ResultSet result;
    private final String url_bd = "jdbc:mysql://186.64.121.26:3306/yugioh";
    private final String userBD ="yugioh";
    private final String passBD ="Y5g34H";
    /**
     * Crea una conexion con la base de datos
     */
    public void ConectarBasedeDatos() {
        try {
            final String controller = "com.mysql.cj.jdbc.Driver";
            Class.forName(controller);            
            connection = DriverManager.getConnection(url_bd, userBD, passBD);
            sentence = connection.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Cierra la conexion con la base de datos
     */
    public void DesconectarBasedeDatos() {
        try {
            if (connection != null) {
                if (sentence != null) {
                    sentence.close();
                }
                connection.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    /**
     * Obtiene la conexion a la base de datos
     * @return 
     */
    public Connection getConnection() {
        return connection;
    }
    /**
     * Obtiene los datos de la base de datos al realizar una consulta
     * @return 
     */
    public ResultSet getResult() {
        return result;
    }
}
