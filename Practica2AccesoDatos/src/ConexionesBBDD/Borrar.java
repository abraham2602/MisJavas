package ConexionesBBDD;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.CallableStatement;

/**
 * 
 * @author Abraham Ramírez
 * @see Aquí se encuentran todos los métodos relacionados con la eliminación de datos de la base de datos.
 */

public class Borrar {
    
    static Properties props = new Properties();
    
    /**
     *  Método delete() - Sirve para eliminar un sólo registro, introduciendose por JOption
     */
    
    public void delete() {
        
        try {
            FileInputStream in = new FileInputStream("credencialesMysql.properties");
            props.load(in);
            in.close();

            String driver = props.getProperty("jdbc.driver");
            if (driver != null) {
                Class.forName(driver);
            }
        } catch (Exception e) {

        }

        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        try (Connection conn = DriverManager.getConnection(url, username, password);
                Statement stmt = conn.createStatement();) {
            
            int ID_ELIM =  Integer.parseInt(JOptionPane.showInputDialog(null,"Id del alumno a eliminar:" ));
            
            String sql = "DELETE FROM alumnos WHERE id = " + ID_ELIM;
            String resetIncrement = "ALTER TABLE alumnos AUTO_INCREMENT = 1";
            JOptionPane.showMessageDialog(null, "Alumno eliminado");

            stmt.executeUpdate(sql);
            stmt.executeUpdate(resetIncrement);

        } catch (SQLException e) {
            
        }
    }
    
    /*
     * Método borrarTodo() - Sirve para eliminar todos los registros de la base de datos, se borra ejecutando un procedimiento especificado abajo.
     */
    
    public void borrarTodo() {
        
        try {
            FileInputStream in = new FileInputStream("credencialesMysql.properties");
            props.load(in);
            in.close();

            String driver = props.getProperty("jdbc.driver");
            if (driver != null) {
                Class.forName(driver);
            }
        } catch (Exception e) {

        }

        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        try (Connection conn = DriverManager.getConnection(url, username, password);
                Statement stmt = conn.createStatement();) {
            
            /* - PROCEDIMIENTO PARA BORRAR - 
             * 
             * DELIMITER //
             * CREATE PROCEDURE borrarTodo()
             * BEGIN
             * DELETE FROM alumnos;
             * END;
             * //
             * DELIMITER ;
             * 
             */
            
            CallableStatement procedimiento = (CallableStatement) conn.prepareCall("{ call borrarTodo() }");
            procedimiento.execute();
            
            // Se resetea el auto_increment de la id para que vuelva a introducirse desde 1.
            String resetIncrement = "ALTER TABLE alumnos AUTO_INCREMENT = 1";
            
            stmt.executeUpdate(resetIncrement);
            JOptionPane.showMessageDialog(null, "Todos los registros eliminados.");
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }

}
