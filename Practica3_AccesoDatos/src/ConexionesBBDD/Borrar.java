package ConexionesBBDD;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.mysql.cj.jdbc.CallableStatement;


public class Borrar {
    
	static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	static Session session = sessionFactory.openSession();
	
    public void delete() {
        
        try  {
            
            int ID_ELIM =  Integer.parseInt(JOptionPane.showInputDialog(null,"Id del alumno a eliminar:" ));
            
            AlumnoITEP al = new AlumnoITEP(ID_ELIM);
            session.beginTransaction();
            session.delete(al);
            session.getTransaction().commit();
            session.close();
            
            JOptionPane.showMessageDialog(null, "Alumno eliminado");


        } catch (Exception e) {
            
        }
    }
    

    
    public void borrarTodo() {

        try {
        	session.beginTransaction();
        	session.createQuery("delete from Alumno").executeUpdate();
        	session.getTransaction().commit();
        	session.close();
        	 
            JOptionPane.showMessageDialog(null, "Todos los registros eliminados.");
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }

}
