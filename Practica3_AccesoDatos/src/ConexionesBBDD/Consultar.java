package ConexionesBBDD;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
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

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Interfaz.app;
import java.awt.Color;

public class Consultar extends JFrame {

	private JTextField textField_PregId;

	static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	static Session session = sessionFactory.openSession();

	int xMouse, yMouse;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void consulta() {

		try {

			JFrame frameTabla = new JFrame("Resultado Consulta");
			frameTabla.setUndecorated(true);

			List<AlumnoITEP> alumnos = (List<AlumnoITEP>) session.createQuery("from Alumno").list();
			String[] rows = { "ID", "Nombre", "Primer Apellido", "Segundo Apellido" };
			DefaultTableModel modeloTabla = new DefaultTableModel(rows, 0);
			
			for (AlumnoITEP e : alumnos) {
				String[] row = { Integer.toString(e.getId()), e.getNombre(), e.getApellido1(), e.getApellido2() };
				modeloTabla.addRow(row);
			}

			JTable tabla = new JTable(modeloTabla);
			tabla.setShowVerticalLines(true);
			tabla.setShowGrid(true);
			tabla.setPreferredScrollableViewportSize(new Dimension(600, 370));

			JScrollPane panelScroll = new JScrollPane(tabla);
			panelScroll.setBounds(41, 110, 602, 358);

			JPanel panelTabla = new JPanel();
			panelTabla.setLayout(null);
			panelTabla.add(panelScroll);

			frameTabla.getContentPane().add(panelTabla);

			JLabel lblPreguntarId = new JLabel("ID");
			lblPreguntarId.setFont(new Font("Roboto", Font.PLAIN, 11));
			lblPreguntarId.setBounds(255, 68, 63, 14);
			panelTabla.add(lblPreguntarId);

			textField_PregId = new JTextField();
			textField_PregId.setBounds(297, 65, 63, 20);
			panelTabla.add(textField_PregId);
			textField_PregId.setColumns(10);

			JLabel lbl_Error = new JLabel("");
			lbl_Error.setFont(new Font("Arial", Font.PLAIN, 12));
			lbl_Error.setBounds(41, 68, 155, 14);
			panelTabla.add(lbl_Error);

			JLabel lbl_Id = new JLabel("");
			lbl_Id.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_Id.setFont(new Font("Arial", Font.PLAIN, 11));
			lbl_Id.setBounds(41, 480, 49, 14);
			panelTabla.add(lbl_Id);

			JLabel lbl_Nombre = new JLabel("");
			lbl_Nombre.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_Nombre.setFont(new Font("Arial", Font.PLAIN, 11));
			lbl_Nombre.setBounds(100, 480, 57, 14);
			panelTabla.add(lbl_Nombre);

			JLabel lbl_Apellido1 = new JLabel("");
			lbl_Apellido1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_Apellido1.setFont(new Font("Arial", Font.PLAIN, 11));
			lbl_Apellido1.setBounds(159, 480, 57, 14);
			panelTabla.add(lbl_Apellido1);

			JLabel lbl_Apellido2 = new JLabel("");
			lbl_Apellido2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_Apellido2.setFont(new Font("Arial", Font.PLAIN, 11));
			lbl_Apellido2.setBounds(217, 480, 57, 14);
			panelTabla.add(lbl_Apellido2);

			JLabel lbl_notaSSII = new JLabel("");
			lbl_notaSSII.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_notaSSII.setFont(new Font("Arial", Font.PLAIN, 11));
			lbl_notaSSII.setBounds(284, 480, 57, 14);
			panelTabla.add(lbl_notaSSII);

			JLabel lbl_notaEEDD = new JLabel("");
			lbl_notaEEDD.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_notaEEDD.setFont(new Font("Arial", Font.PLAIN, 11));
			lbl_notaEEDD.setBounds(343, 480, 57, 14);
			panelTabla.add(lbl_notaEEDD);

			JLabel lbl_notaProg = new JLabel("");
			lbl_notaProg.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_notaProg.setFont(new Font("Arial", Font.PLAIN, 11));
			lbl_notaProg.setBounds(402, 480, 57, 14);
			panelTabla.add(lbl_notaProg);

			JLabel lbl_notaLLMM = new JLabel("");
			lbl_notaLLMM.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_notaLLMM.setFont(new Font("Arial", Font.PLAIN, 11));
			lbl_notaLLMM.setBounds(462, 480, 57, 14);
			panelTabla.add(lbl_notaLLMM);

			JLabel lbl_notaBBDD = new JLabel("");
			lbl_notaBBDD.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_notaBBDD.setFont(new Font("Arial", Font.PLAIN, 11));
			lbl_notaBBDD.setBounds(522, 480, 57, 14);
			panelTabla.add(lbl_notaBBDD);

			JLabel lbl_notaFOL = new JLabel("");
			lbl_notaFOL.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_notaFOL.setFont(new Font("Arial", Font.PLAIN, 11));
			lbl_notaFOL.setBounds(583, 480, 57, 14);
			panelTabla.add(lbl_notaFOL);

			// Cuando cliquemos al botón buscar y el textArea tenga un id válido, se
			// mostrarán los datos de ese id, si no es un id válido,
			// se mostrará por pantalla que ese registro no existe.
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.setBackground(Color.WHITE);
			btnBuscar.setFont(new Font("Arial", Font.PLAIN, 11));
			btnBuscar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					int id = Integer.parseInt(textField_PregId.getText());
					
					List<AlumnoITEP> alumnos = (List<AlumnoITEP>) session.createQuery("from Alumno where id = " + id).list();

					for (AlumnoITEP a : alumnos) {
						
						if (a.getId() == id) {
							
							lbl_Id.setText(Integer.toString(a.getId()));
							lbl_Nombre.setText(a.getNombre());
							lbl_Apellido1.setText(a.getApellido1());
							lbl_Apellido2.setText(a.getApellido2());
							

                        } else if(a.getId() != id){
                        	
                            lbl_Error.setText(
                                    "<html><head><meta charset=\"UTF-8\"></head><body>¡El registro <b><i>no</i></b> existe!</body></html>");
                            lbl_Id.setText("");
                            lbl_Nombre.setText("");
                            
                        }
						
						
					}
					
				}
			});
			btnBuscar.setBounds(554, 64, 89, 23);
			panelTabla.add(btnBuscar);

			JPanel panelArriba = new JPanel();
			panelArriba.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					int x = e.getXOnScreen();
					int y = e.getYOnScreen();
					frameTabla.setLocation(x - xMouse, y - yMouse);
				}
			});
			panelArriba.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					xMouse = e.getX();
					yMouse = e.getY();
				}
			});
			panelArriba.setLayout(null);
			panelArriba.setBackground(Color.LIGHT_GRAY);
			panelArriba.setBounds(0, 0, 700, 30);
			panelTabla.add(panelArriba);

			JPanel panelX = new JPanel();
			panelX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frameTabla.dispose();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					panelX.setBackground(Color.red);
				}

				public void mouseExited(MouseEvent e) {
					panelX.setBackground(new Color(128, 128, 128));
				}
			});
			panelX.setLayout(null);
			panelX.setBackground(Color.GRAY);
			panelX.setBounds(667, 0, 33, 30);
			panelArriba.add(panelX);

			JLabel lblX = new JLabel("X");
			lblX.setBounds(0, 0, 33, 30);
			panelX.add(lblX);
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			lblX.setFont(new Font("Roboto", Font.BOLD, 14));

			frameTabla.setSize(700, 530);
			frameTabla.setLocationRelativeTo(null);
			frameTabla.setResizable(false);
			frameTabla.setVisible(true);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

}
