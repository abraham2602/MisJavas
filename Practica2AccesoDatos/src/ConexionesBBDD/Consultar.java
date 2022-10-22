package ConexionesBBDD;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Interfaz.app;
import java.awt.Color;

/**
 * 
 * @author Abraham Ramírez
 * @see En esta clase se crea una tabla donde se mostrarán todos los datos de la base de datos. También trae integrado un buscador para buscar los datos de la id que introduzcamos
 * 
 *
 */
public class Consultar {
    
    private JTextField textField_PregId;
    
    /*
     * Método consulta() - Muestra mediante JTable todos los registros de la tabla alumnos y mediante un textArea introduciremos una id válida
     * y se mostrarán sus datos.
     */
    
    public void consulta() {
        
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

            String QUERY = "SELECT * FROM alumnos";
            ResultSet rs = stmt.executeQuery(QUERY);

            
            // Filas y columnas de la JTable
            String columnas[] = { "ID", "Nombre", "Primer Apellido"};
            String datos[][] = new String[21][10];

            // Obtenemos los valores y metemos esos valores a un array bidimensional (Los datos de la tabla.).
            int x = 0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");

                datos[x][0] = id + "";
                datos[x][1] = nombre;
                datos[x][2] = apellido1;

                x++;
            }

            DefaultTableModel modeloTabla = new DefaultTableModel(datos, columnas);

            JTable tabla = new JTable(modeloTabla);
            tabla.setShowVerticalLines(true);
            tabla.setShowGrid(true);
            tabla.setPreferredScrollableViewportSize(new Dimension(600, 370));

            JScrollPane panelScroll = new JScrollPane(tabla);
            panelScroll.setBounds(41, 70, 602, 358);
            JFrame frameTabla = new JFrame("Resultado Consulta");
            JPanel panelTabla = new JPanel();
            panelTabla.setLayout(null);
            panelTabla.add(panelScroll);

            frameTabla.getContentPane().add(panelTabla);

            JLabel lblPreguntarId = new JLabel("ID");
            lblPreguntarId.setFont(new Font("Roboto", Font.PLAIN, 11));
            lblPreguntarId.setBounds(255, 28, 63, 14);
            panelTabla.add(lblPreguntarId);

            textField_PregId = new JTextField();
            textField_PregId.setBounds(297, 25, 63, 20);
            panelTabla.add(textField_PregId);
            textField_PregId.setColumns(10);

            JLabel lbl_Error = new JLabel("");
            lbl_Error.setFont(new Font("Arial", Font.PLAIN, 12));
            lbl_Error.setBounds(41, 28, 155, 14);
            panelTabla.add(lbl_Error);

            JLabel lbl_Id = new JLabel("");
            lbl_Id.setHorizontalAlignment(SwingConstants.CENTER);
            lbl_Id.setFont(new Font("Arial", Font.PLAIN, 11));
            lbl_Id.setBounds(41, 439, 49, 14);
            panelTabla.add(lbl_Id);

            JLabel lbl_Nombre = new JLabel("");
            lbl_Nombre.setHorizontalAlignment(SwingConstants.CENTER);
            lbl_Nombre.setFont(new Font("Arial", Font.PLAIN, 11));
            lbl_Nombre.setBounds(100, 439, 57, 14);
            panelTabla.add(lbl_Nombre);

            JLabel lbl_Apellido1 = new JLabel("");
            lbl_Apellido1.setHorizontalAlignment(SwingConstants.CENTER);
            lbl_Apellido1.setFont(new Font("Arial", Font.PLAIN, 11));
            lbl_Apellido1.setBounds(159, 439, 57, 14);
            panelTabla.add(lbl_Apellido1);

            JLabel lbl_Apellido2 = new JLabel("");
            lbl_Apellido2.setHorizontalAlignment(SwingConstants.CENTER);
            lbl_Apellido2.setFont(new Font("Arial", Font.PLAIN, 11));
            lbl_Apellido2.setBounds(217, 439, 57, 14);
            panelTabla.add(lbl_Apellido2);

            JLabel lbl_notaSSII = new JLabel("");
            lbl_notaSSII.setHorizontalAlignment(SwingConstants.CENTER);
            lbl_notaSSII.setFont(new Font("Arial", Font.PLAIN, 11));
            lbl_notaSSII.setBounds(284, 439, 57, 14);
            panelTabla.add(lbl_notaSSII);

            JLabel lbl_notaEEDD = new JLabel("");
            lbl_notaEEDD.setHorizontalAlignment(SwingConstants.CENTER);
            lbl_notaEEDD.setFont(new Font("Arial", Font.PLAIN, 11));
            lbl_notaEEDD.setBounds(343, 439, 57, 14);
            panelTabla.add(lbl_notaEEDD);

            JLabel lbl_notaProg = new JLabel("");
            lbl_notaProg.setHorizontalAlignment(SwingConstants.CENTER);
            lbl_notaProg.setFont(new Font("Arial", Font.PLAIN, 11));
            lbl_notaProg.setBounds(402, 439, 57, 14);
            panelTabla.add(lbl_notaProg);

            JLabel lbl_notaLLMM = new JLabel("");
            lbl_notaLLMM.setHorizontalAlignment(SwingConstants.CENTER);
            lbl_notaLLMM.setFont(new Font("Arial", Font.PLAIN, 11));
            lbl_notaLLMM.setBounds(462, 439, 57, 14);
            panelTabla.add(lbl_notaLLMM);

            JLabel lbl_notaBBDD = new JLabel("");
            lbl_notaBBDD.setHorizontalAlignment(SwingConstants.CENTER);
            lbl_notaBBDD.setFont(new Font("Arial", Font.PLAIN, 11));
            lbl_notaBBDD.setBounds(522, 439, 57, 14);
            panelTabla.add(lbl_notaBBDD);

            JLabel lbl_notaFOL = new JLabel("");
            lbl_notaFOL.setHorizontalAlignment(SwingConstants.CENTER);
            lbl_notaFOL.setFont(new Font("Arial", Font.PLAIN, 11));
            lbl_notaFOL.setBounds(583, 439, 57, 14);
            panelTabla.add(lbl_notaFOL);

            
            // Cuando cliquemos al botón buscar y el textArea tenga un id válido, se mostrarán los datos de ese id, si no es un id válido,
            // se mostrará por pantalla que ese registro no existe.
            JButton btnBuscar = new JButton("Buscar");
            btnBuscar.setBackground(Color.WHITE);
            btnBuscar.setFont(new Font("Arial", Font.PLAIN, 11));
            btnBuscar.addActionListener(new ActionListener() {
                
                public void actionPerformed(ActionEvent e) {
                    
                    int id = Integer.parseInt(textField_PregId.getText());

                    try {

                        Connection conexion = DriverManager.getConnection(url,username,password);
                        Statement comando = conexion.createStatement();
                        ResultSet registro = comando.executeQuery("SELECT id,nombre,apellido1 FROM alumnos WHERE id=" + id);

                        if (registro.next() == true) {
                            lbl_Error.setText("");
                            lbl_Id.setText(registro.getString("id"));
                            lbl_Nombre.setText(registro.getString("nombre"));
                            lbl_Apellido1.setText(registro.getString("apellido1"));

                        } else {
                            lbl_Error.setText(
                                    "<html><head><meta charset=\"UTF-8\"></head><body>¡El registro <b><i>no</i></b> existe!</body></html>");
                            lbl_Id.setText("");
                            lbl_Nombre.setText("");
                        }

                        conexion.close();

                    } catch (Exception ex) {

                    }

                }
            });
            btnBuscar.setBounds(554, 24, 89, 23);
            panelTabla.add(btnBuscar);

            frameTabla.setSize(700, 530);
            frameTabla.setLocationRelativeTo(null);
            frameTabla.setResizable(false);
            frameTabla.setVisible(true);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
