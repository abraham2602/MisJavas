package Interfaz;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * @author Abraham Ramírez
 * @see Clase inicio de sesión.
 *
 */

public class InicioSesion extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	app aplic = new app();

	int xMouse, yMouse;
	
	/**
	 * 
	 * usuario: admin - contraseña: 1234
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
					frame.setLocationByPlatform(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setUndecorated(true);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public InicioSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JPanel panelniciar = new JPanel();
		panelniciar.setBackground(Color.WHITE);
		panelniciar.setBounds(0, 0, 784, 570);
		contentPane.add(panelniciar);
		panelniciar.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(new Color(0,156,223));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(new Color(0,0,255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(textFieldUsuario.getText().equals("admin") && String.valueOf(passwordField.getPassword()).equals("1234")) {
				    aplic.main(null);
					dispose();
				}else {
					JOptionPane.showMessageDialog(panel, "El usuario y/o contraseña es incorrecta.");
				}
			}
		});
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(41, 439, 102, 35);
		panelniciar.add(panel);
		panel.setLayout(null);
		
		JLabel imgVertical = new JLabel("");
		imgVertical.setIcon(new ImageIcon(InicioSesion.class.getResource("/resources/img/fondoVertical.png")));
		imgVertical.setBounds(443, 0, 358, 570);
		panelniciar.add(imgVertical);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblUsuario.setBounds(41, 200, 102, 28);
		panelniciar.add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		lblContraseña.setBounds(41, 324, 102, 28);
		panelniciar.add(lblContraseña);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER && textFieldUsuario.getText().equals("admin") && String.valueOf(passwordField.getPassword()).equals("1234")) {
					aplic.main(null);
				    dispose();
				}else if (e.getKeyCode()==KeyEvent.VK_ENTER && textFieldUsuario.getText().equals("admin") != String.valueOf(passwordField.getPassword()).equals("1234")){
					JOptionPane.showMessageDialog(panel, "Usuario y/o contraseña incorrectas");
				}
			}
		});
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(String.valueOf(passwordField.getPassword()).equals("********")) {
					passwordField.setText("");
					passwordField.setForeground(Color.black);
				}
				
				if(textFieldUsuario.getText().isEmpty()) {
					textFieldUsuario.setText("Introduzca su usuario");
					textFieldUsuario.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		passwordField.setToolTipText("");
		passwordField.setForeground(Color.LIGHT_GRAY);
		passwordField.setText("********");
		passwordField.setEchoChar('*');
		passwordField.setBorder(null);
		passwordField.setBounds(41, 363, 358, 28);
		panelniciar.add(passwordField);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
					
					if(textFieldUsuario.getText().equals("Introduzca su usuario")) {
						textFieldUsuario.setText("");
						textFieldUsuario.setForeground(Color.black);
					}
					
					if(String.valueOf(passwordField.getPassword()).isEmpty()) {
						passwordField.setText("********");
						passwordField.setForeground(Color.LIGHT_GRAY);
					}
				
			}
		});
		textFieldUsuario.setForeground(Color.LIGHT_GRAY);
		textFieldUsuario.setFont(new Font("Roboto", Font.PLAIN, 11));
		textFieldUsuario.setBorder(null);
		textFieldUsuario.setText("Introduzca su usuario");
		textFieldUsuario.setBounds(41, 251, 358, 28);
		
		panelniciar.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblTitulo = new JLabel("INICIAR SESI\u00D3N");
		lblTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 30));
		lblTitulo.setBounds(41, 131, 285, 35);
		panelniciar.add(lblTitulo);
		
		JSeparator separador1 = new JSeparator();
		separador1.setBounds(41, 279, 358, 8);
		panelniciar.add(separador1);
		
		JSeparator separador2 = new JSeparator();
		separador2.setBounds(41, 391, 358, 8);
		panelniciar.add(separador2);
		
		
		
		JLabel lblIniciar = new JLabel("INICIAR");
		lblIniciar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(textFieldUsuario.getText().equals("admin") && String.valueOf(passwordField.getPassword()).equals("1234")) {
				    aplic.main(null);
					dispose();
				}else {
					JOptionPane.showMessageDialog(panel, "El usuario y/o contraseña es incorrecta.");
				}
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(new Color(0,156,223));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(new Color(0,0,255));
			}
		});
		lblIniciar.setBounds(27, 11, 50, 14);
		lblIniciar.setHorizontalTextPosition(JLabel.CENTER);
		lblIniciar.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		lblIniciar.setForeground(Color.WHITE);
		panel.add(lblIniciar);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-xMouse,y-yMouse);
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 735, 35);
		panelniciar.add(header);
		header.setLayout(null);
		
		JPanel exitBtn = new JPanel();
		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				exitBtn.setBackground(Color.red);
			}
			
			public void mouseExited(MouseEvent e) {
				exitBtn.setBackground(Color.white);
			}
		});
		exitBtn.setBackground(Color.WHITE);
		exitBtn.setBounds(0, 0, 54, 35);
		header.add(exitBtn);
		
		JLabel lblExit = new JLabel("X");
		lblExit.setBackground(Color.WHITE);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit.setBackground(Color.red);
				exitBtn.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setBackground(Color.white);
				exitBtn.setBackground(Color.white);
			}
		});
		lblExit.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblExit.setVerticalAlignment(SwingConstants.BOTTOM);
		exitBtn.add(lblExit);
		
		
		
		
	}
}
