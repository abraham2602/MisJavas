package ConexionesBBDD;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Interfaz.app;

/**
 * 
 * @author Abraham Ramirez
 * @see En esta clase se puede modificar los valores de cada registro. Se introduce con JOption el registro a modificar y se mostrarán los campos a modificar.
 *
 */

public class Modificacion extends JFrame {
	public Modificacion() {
	}
	
	static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	static Session session = sessionFactory.openSession();
    
    JFrame frame;
    int xMouse, yMouse;
    
    public void frames() {

        
        frame = new JFrame();
        frame.setBounds(100, 100, 583, 395);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setUndecorated(true);
        
        frame.setTitle("ITEPasen");
        frame.getContentPane().setLayout(null);

        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setFont(new Font("Arial", Font.PLAIN, 11));

        Modify();
    }
    

    public void Modify() {

        int getID = Integer.parseInt(JOptionPane.showInputDialog(null, "ID del registro que quieres modificar:"));
        AlumnoITEP alumno = (AlumnoITEP) session.get(AlumnoITEP.class, getID);
        
        frame.repaint();
        

        JLabel lbl_Info = new JLabel("<html><body>Seleccione el campo a editar: </body></html>");
        lbl_Info.setFont(new Font("Arial", Font.PLAIN, 12));
        lbl_Info.setBounds(197, 66, 260, 14);
        frame.getContentPane().add(lbl_Info);
        
       

        JLabel lbl_InfoID = new JLabel("<html><body>ID: " + getID + "</body></html>");
        lbl_InfoID.setFont(new Font("Arial", Font.PLAIN, 12));
        lbl_InfoID.setBounds(265, 96, 260, 14);
        frame.getContentPane().add(lbl_InfoID);

        JButton btnNombre = new JButton("Nombre");
        btnNombre.setFont(new Font("Arial", Font.PLAIN, 12));
        btnNombre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nuevoNombre = JOptionPane.showInputDialog(null, "Nuevo nombre: ");

                
                try {

            		alumno.setNombre(nuevoNombre);

            		session.beginTransaction();
            		session.update(alumno);
            		session.getTransaction().commit();
                	
                    JOptionPane.showMessageDialog(null, "Los datos se han cambiado correctamente");

                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al modificar.");
                }

            }
        });
        btnNombre.setBounds(120, 130, 89, 23);
        frame.getContentPane().add(btnNombre);

        JButton btnApellido1 = new JButton("Apellido 1");
        btnApellido1.setFont(new Font("Arial", Font.PLAIN, 12));
        btnApellido1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nuevoApellido1 = JOptionPane.showInputDialog(null, "Nuevo apellido: ");

                try {
                    
                	alumno.setApellido1(nuevoApellido1);

            		session.beginTransaction();
            		session.update(alumno);
            		session.getTransaction().commit();
                	
                    JOptionPane.showMessageDialog(null, "Los datos se han cambiado correctamente");

                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al modificar.");
                }

            }
        });
        btnApellido1.setBounds(240, 130, 89, 23);
        frame.getContentPane().add(btnApellido1);
        
        
        JButton btnApellido2 = new JButton("Apellido 2");
        btnApellido2.setFont(new Font("Arial", Font.PLAIN, 12));
        btnApellido2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nuevoApellido2 = JOptionPane.showInputDialog(null, "Nuevo apellido: ");

                try {
                    
                	alumno.setApellido2(nuevoApellido2);

            		session.beginTransaction();
            		session.update(alumno);
            		session.getTransaction().commit();
                	
                    JOptionPane.showMessageDialog(null, "Los datos se han cambiado correctamente");

                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al modificar.");
                }

            }
        });
        btnApellido2.setBounds(360, 130, 89, 23);
        frame.getContentPane().add(btnApellido2);
        
        repaint();

    }

}
