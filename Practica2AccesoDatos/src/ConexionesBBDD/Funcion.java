package ConexionesBBDD;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * 
 * @author Abraham Ramirez
 * @see En esta clase se ejecuta una funci�n
 *
 */

public class Funcion {

    
    static Properties props = new Properties();
    
    /*
     * M�todo funcion() - Ejecuta una funci�n almacenada que devuelve Largo o Corto seg�n la longitud del nombre del registro.
     */
    
    public void funcion() {
       
        
//        CREATE DEFINER=`root`@`%` FUNCTION `tama�oNombres`(  
//                nombre varchar(20)  
//            ) RETURNS varchar(20) CHARSET latin1
//    BEGIN  
//                DECLARE largo VARCHAR(20);  
//                IF length(nombre) > 5 THEN  
//                    SET largo = 'Largo';  
//                ELSEIF length(nombre) < 5 THEN
//                    SET largo = 'Corto';
//                END IF;  
//                RETURN (largo);  
//            END


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
            
            PreparedStatement sql = conn.prepareStatement("SELECT nombre, tama�oNombres(nombre) FROM alumnos");
            ResultSet rs = sql.executeQuery();
            
            while(rs.next()) {
                System.out.println(rs.getString("nombre") + " -> " + rs.getString("tama�oNombres(nombre)"));
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        
    }

}
