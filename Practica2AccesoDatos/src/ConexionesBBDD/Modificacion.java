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

import Interfaz.app;

/**
 * 
 * @author Abraham Ramirez
 * @see En esta clase se puede modificar los valores de cada registro. Se introduce con JOption el registro a modificar y se mostrarán los campos a modificar.
 *
 */

public class Modificacion extends JFrame {

    
    private JFrame frame;
    
    public void frames() {

        
        frame = new JFrame();
        frame.setBounds(100, 100, 583, 395);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("Formulario de Alta");

        frame.setResizable(false);
        frame.setTitle("ITEPasen");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.getContentPane().setLayout(null);

        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setFont(new Font("Arial", Font.PLAIN, 11));

        Modify();
    }
    
    /*
     * Método modify() - Muestra por pantalla dos botones, uno para modificar nombre, y el otro para modificar el apellido. Antes se deberá indicar la id del registro
     * 
     */

    public void Modify() {

        int getID = Integer.parseInt(JOptionPane.showInputDialog(null, "ID del registro que quieres modificar:"));
        frame.repaint();
        
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

        JLabel lbl_Info = new JLabel("<html><body>Seleccione el campo a editar: </body></html>");
        lbl_Info.setFont(new Font("Arial", Font.PLAIN, 12));
        lbl_Info.setBounds(197, 46, 260, 14);
        frame.getContentPane().add(lbl_Info);

        JLabel lbl_InfoID = new JLabel("<html><body>ID: " + getID + "</body></html>");
        lbl_InfoID.setFont(new Font("Arial", Font.PLAIN, 12));
        lbl_InfoID.setBounds(265, 66, 260, 14);
        frame.getContentPane().add(lbl_InfoID);

        JButton btnNombre = new JButton("Nombre");
        btnNombre.setFont(new Font("Arial", Font.PLAIN, 12));
        btnNombre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nuevoNombre = JOptionPane.showInputDialog(null, "Nuevo nombre: ");

                try (Connection conn = DriverManager.getConnection(url, username, password);
                        Statement stmt = conn.createStatement();) {
                    if ((nuevoNombre.length() < 1)) {
                        conn.close();
                        stmt.close();
                    }
                    String sql = "UPDATE alumnos SET nombre ='" + nuevoNombre + "' WHERE id =" + getID;
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Los datos se han cambiado correctamente");

                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al modificar.");
                }

            }
        });
        btnNombre.setBounds(180, 100, 89, 23);
        frame.getContentPane().add(btnNombre);

        JButton btnApellido1 = new JButton("Apellido 1");
        btnApellido1.setFont(new Font("Arial", Font.PLAIN, 12));
        btnApellido1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nuevoApellido1 = JOptionPane.showInputDialog(null, "Nuevo apellido: ");

                try (Connection conn = DriverManager.getConnection(url, username, password);
                        Statement stmt = conn.createStatement();) {
                    if ((nuevoApellido1.length() < 1)) {
                        conn.close();
                        stmt.close();
                    }
                    String sql = "UPDATE alumnos SET apellido1 ='" + nuevoApellido1 + "' WHERE id =" + getID;
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Los datos se han cambiado correctamente");

                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al modificar.");
                }

            }
        });
        btnApellido1.setBounds(300, 100, 89, 23);
        frame.getContentPane().add(btnApellido1);

    }

}
