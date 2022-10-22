package ConexionesBBDD;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Interfaz.app;
import java.awt.Color;

/**
 * 
 * @author Abraham Ramirez
 *
 */
public class Insert extends JFrame{
    
    private JPanel contentPane;
    private JTextField textField_Nombre;
    private JTextField textField_Apellido1;

    /**
     * @see En esta clase se encuentra el formulario de inserción de datos. Parseo de textFields para introducirlo en la BBDD
     *      
     */
    
    public Insert() {
        setBounds(100, 100, 670, 470);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lbl_Nombre = new JLabel("Nombre: ");
        lbl_Nombre.setBounds(41, 62, 60, 20);
        lbl_Nombre.setFont(new Font("Arial", Font.PLAIN, 15));
        contentPane.add(lbl_Nombre);
        
        textField_Nombre = new JTextField();
        textField_Nombre.setBounds(217, 62, 387, 20);
        contentPane.add(textField_Nombre);
        textField_Nombre.setColumns(10);
        
        JLabel lbl_Apellido1 = new JLabel("Primer Apellido: ");
        lbl_Apellido1.setBounds(41, 117, 171, 18);
        lbl_Apellido1.setFont(new Font("Arial", Font.PLAIN, 15));
        contentPane.add(lbl_Apellido1);
        
        textField_Apellido1 = new JTextField();
        textField_Apellido1.setColumns(10);
        textField_Apellido1.setBounds(217, 117, 387, 20);
        contentPane.add(textField_Apellido1);
        
        
        // Al clicar en enviar datos, se cargan los datos de los TextFields a variables que luego se introducirán por sentencia sql.
        JButton btnEnviar = new JButton("Enviar Datos");
        btnEnviar.setBackground(Color.WHITE);
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String nombre = textField_Nombre.getText();
                String apellido1 = textField_Apellido1.getText();

                
                Properties props = new Properties();
                
                try {
                    FileInputStream in = new FileInputStream("credencialesMysql.properties");
                    props.load(in);
                    in.close();

                    String driver = props.getProperty("jdbc.driver");
                    if (driver != null) {
                        Class.forName(driver);
                    }
                    
                } catch (Exception e1) {

                }

                String url = props.getProperty("jdbc.url");
                String username = props.getProperty("jdbc.username");
                String password = props.getProperty("jdbc.password");
                
                try(Connection conn = DriverManager.getConnection(url,username,password); Statement stmt = conn.createStatement();) {
                    if ((nombre.length() < 1)) {
                        conn.close();
                        stmt.close();
                    }
                    String sql = "INSERT INTO alumnos(nombre,apellido1) VALUES('"+nombre+"','"+apellido1+"')";
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Los datos se han insertado correctamente");
                    
                    textField_Nombre.setText("");
                    textField_Apellido1.setText("");
                    
                    
                }catch(SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al insertar. Comprueba los campos");
                }
                
        }
            
        });
        btnEnviar.setFont(new Font("Arial", Font.PLAIN, 15));
        btnEnviar.setBounds(258, 285, 129, 23);
        contentPane.add(btnEnviar);
        
        
        
            
        }
    
    public void frames() {
        Insert frame = new Insert();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("Formulario de Alta");
    }
}
