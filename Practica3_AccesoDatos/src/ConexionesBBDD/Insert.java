package ConexionesBBDD;

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

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Interfaz.app;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Insert extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Nombre;
	private JTextField textField_Apellido1;
	
	static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	static Session session = sessionFactory.openSession();
	private JTextField textField_Apellido2;
	private JLabel lbl_Id;
	private JTextField textField_Id;
	
	int xMouse, yMouse;

	public Insert() {
		setTitle("Alta");
		setBounds(100, 100, 670, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);

		JLabel lbl_Nombre = new JLabel("Nombre: ");
		lbl_Nombre.setBounds(41, 110, 60, 20);
		lbl_Nombre.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lbl_Nombre);

		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(217, 110, 387, 20);
		contentPane.add(textField_Nombre);
		textField_Nombre.setColumns(10);

		JLabel lbl_Apellido1 = new JLabel("Primer Apellido: ");
		lbl_Apellido1.setBounds(41, 165, 171, 18);
		lbl_Apellido1.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lbl_Apellido1);

		textField_Apellido1 = new JTextField();
		textField_Apellido1.setColumns(10);
		textField_Apellido1.setBounds(217, 165, 387, 20);
		contentPane.add(textField_Apellido1);

		JButton btnEnviar = new JButton("Enviar Datos");
		btnEnviar.setBackground(Color.WHITE);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = textField_Id.getText();
				String nombre = textField_Nombre.getText();
				String apellido1 = textField_Apellido1.getText();
				String apellido2 = textField_Apellido2.getText();

				try {

					AlumnoITEP alumno = new AlumnoITEP(Integer.parseInt(id), nombre, apellido1, apellido2);
					session.beginTransaction();
					session.save(alumno);
					session.getTransaction().commit();
					

					JOptionPane.showMessageDialog(null, "Los datos se han insertado correctamente");

					textField_Id.setText("");
					textField_Nombre.setText("");
					textField_Apellido1.setText("");
					textField_Apellido2.setText("");

				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al insertar. Comprueba los campos");
				}

			}

		});
		btnEnviar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEnviar.setBounds(258, 268, 129, 23);
		contentPane.add(btnEnviar);
		
		JLabel lbl_Apellido2 = new JLabel("Primer Apellido: ");
		lbl_Apellido2.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_Apellido2.setBounds(41, 220, 171, 18);
		contentPane.add(lbl_Apellido2);
		
		textField_Apellido2 = new JTextField();
		textField_Apellido2.setColumns(10);
		textField_Apellido2.setBounds(217, 220, 387, 20);
		contentPane.add(textField_Apellido2);
		
		lbl_Id = new JLabel("Id: ");
		lbl_Id.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_Id.setBounds(41, 58, 60, 20);
		contentPane.add(lbl_Id);
		
		textField_Id = new JTextField();
		textField_Id.setColumns(10);
		textField_Id.setBounds(217, 55, 387, 20);
		contentPane.add(textField_Id);
		
		JPanel panelArriba = new JPanel();
		panelArriba.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xMouse, y - yMouse);
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
		panelArriba.setBounds(0, 0, 670, 30);
		contentPane.add(panelArriba);
		
		JPanel panelX = new JPanel();
		panelX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
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
		panelX.setBounds(637, 0, 33, 30);
		panelArriba.add(panelX);
		
		JLabel lblX = new JLabel("X");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Roboto", Font.BOLD, 14));
		lblX.setBounds(0, 0, 33, 30);
		panelX.add(lblX);

	}

	public void frames() {
		Insert frame = new Insert();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("Formulario de Alta");
	}
}
