package ConexionesBBDD;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;

/**
 * 
 * @author Abraham Ramirez
 * @see En esta clase se realiza una transacción. Introduce 10 alumnos genéricos a la base de datos.
 */
public class Transacciones {

    /**
     * Método Transacion() - Introduce mediante una transacción a 10 alumnos genéricos, si hay algún error no se introducirá nada gracias al autoCommit false
     */
    public void Transaccion() {
        
        Properties props = new Properties();

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
            
            conn.setAutoCommit(false);
            
            for(int i = 0; i<10; i++) {
                
                String sql = "INSERT INTO alumnos(nombre,apellido1) VALUES('Alumno"+i+"','Apellido"+i+"')";
                stmt.executeUpdate(sql);
                
            }
            
            JOptionPane.showMessageDialog(null, "Los datos se han insertado correctamente");
           
          
            conn.commit();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
