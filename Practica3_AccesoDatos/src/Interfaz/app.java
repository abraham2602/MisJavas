package Interfaz;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.SwingConstants;

import ConexionesBBDD.Borrar;
import ConexionesBBDD.Consultar;
import ConexionesBBDD.HibernateUtil;
import ConexionesBBDD.Insert;
import ConexionesBBDD.Modificacion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Abraham Ramirez Morales
 * @see Aquí se llama el CRUD mediante la importación de otras clases.
 */

public class app extends JFrame{

	private JFrame frmPractica3;
	JTabbedPane PanelGrande = new JTabbedPane(JTabbedPane.TOP);
	
	int xMouse, yMouse;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app window = new app();
					window.frmPractica3.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public app() {
		initialize();
	}
	
	private void initialize() {
		
		frmPractica3 = new JFrame();
		frmPractica3.setResizable(false);
		frmPractica3.setUndecorated(true);
		frmPractica3.setTitle("Practica 3 - Acceso a Datos");
		frmPractica3.getContentPane().setBackground(Color.WHITE);
		frmPractica3.setBounds(100, 100, 800, 320);
		frmPractica3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPractica3.getContentPane().setLayout(null);
		frmPractica3.setLocationRelativeTo(null);
			
		PanelGrande.setBackground(Color.WHITE);
		PanelGrande.setFont(new Font("Arial", Font.PLAIN, 11));
		
		PanelGrande.setBounds(17, 32, 764, 539);
		frmPractica3.getContentPane().add(PanelGrande);
		
		JPanel panelArriba = new JPanel();
		panelArriba.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				frmPractica3.setLocation(x - xMouse, y - yMouse);
			}
		});
		panelArriba.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		panelArriba.setBackground(new Color(192, 192, 192));
		panelArriba.setBounds(0, 0, 816, 30);
		frmPractica3.getContentPane().add(panelArriba);
		panelArriba.setLayout(null);
		
		JPanel panelX = new JPanel();
		panelX.setBackground(new Color(128, 128, 128));
		panelX.setBounds(767, 0, 33, 30);
		panelX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelX.setBackground(Color.red);
			}

			public void mouseExited(MouseEvent e) {
				panelX.setBackground(new Color(128, 128, 128));
			}
		});
		panelArriba.add(panelX);
		panelX.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Roboto", Font.BOLD, 14));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(0, 0, 33, 30);
		panelX.add(lblX);
		
		
		itemsFUNCIONES();
		
	}
	
	public void itemsFUNCIONES() {
		
		// ====================================== CONSULTA ======================================
		
		JLayeredPane ventanaConsulta = new JLayeredPane();
		PanelGrande.addTab("Consulta", null, ventanaConsulta, null);
		ventanaConsulta.setBackground(Color.WHITE);
		ventanaConsulta.setOpaque(true);
		ventanaConsulta.setBackground(Color.WHITE);
		
		JButton FUNCIONES_btnConsulta = new JButton("Consulta");
		FUNCIONES_btnConsulta.setBackground(Color.WHITE);
		FUNCIONES_btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultar cons = new Consultar();
				cons.consulta();
			}
		});
		FUNCIONES_btnConsulta.setToolTipText("Ver registros");
		FUNCIONES_btnConsulta.setFont(new Font("Arial", Font.PLAIN, 15));
		FUNCIONES_btnConsulta.setBounds(318, 184, 119, 23);
		ventanaConsulta.add(FUNCIONES_btnConsulta);
		
		JLabel lbl_info_Consulta = new JLabel("<html>En la secci\u00F3n <i><b>Consulta</b></i>, como dice su nombre, podrás consultar todos los alumnos que están actualmente dados de alta.<br/><br/>Pulse el bot\u00F3n de abajo para poder acceder a los registros. </html>");
		lbl_info_Consulta.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_info_Consulta.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_info_Consulta.setBounds(74, 26, 632, 125);
		ventanaConsulta.add(lbl_info_Consulta);
		
		// ====================================== CONSULTA ======================================
		
		
		// ====================================== ALTA ======================================
		
		JLayeredPane ventanaInsertar = new JLayeredPane();
		PanelGrande.addTab("Alta", null, ventanaInsertar, null);
		ventanaInsertar.setOpaque(true);
		ventanaInsertar.setBackground(Color.WHITE);
		
		JButton FUNCIONES_btnAlta = new JButton("Alta");
		FUNCIONES_btnAlta.setBackground(Color.WHITE);
		FUNCIONES_btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insert ins = new Insert();
				ins.frames();
			}
		});
		FUNCIONES_btnAlta.setToolTipText("Dar de alta a un nuevo alumno");
		FUNCIONES_btnAlta.setFont(new Font("Arial", Font.PLAIN, 15));
		FUNCIONES_btnAlta.setBounds(318, 187, 119, 23);
		ventanaInsertar.add(FUNCIONES_btnAlta);
		
		JLabel lbl_info_Alta = new JLabel("<html><head><meta charset=\"UTF-8\"></head> En la sección <i><b>Alta</b></i> podrás añadir nuevos alumnos a la base de datos rellenando un pequeño formulario con los datos necesarios.<br><br> Pulse el <b>botón</b> de abajo para dar de alta nuevos registros.</html>");
		lbl_info_Alta.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_info_Alta.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_info_Alta.setBounds(77, 25, 632, 125);
		ventanaInsertar.add(lbl_info_Alta);
		
		// ====================================== ALTA ======================================
		
		
		
		// ====================================== BORRADOS ======================================
		
		JLayeredPane ventanaBorrado = new JLayeredPane();
		PanelGrande.addTab("Baja", null, ventanaBorrado, null);
		ventanaBorrado.setOpaque(true);
		ventanaBorrado.setBackground(Color.WHITE);
		
		JButton FUNCIONES_btnBorrado = new JButton("Eliminar");
		FUNCIONES_btnBorrado.setBackground(Color.WHITE);
		FUNCIONES_btnBorrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Borrar borr = new Borrar();
				borr.delete();
			}
		});
		FUNCIONES_btnBorrado.setToolTipText("Eliminar el registro deseado");
		FUNCIONES_btnBorrado.setFont(new Font("Arial", Font.PLAIN, 15));
		FUNCIONES_btnBorrado.setBounds(203, 188, 119, 23);
		ventanaBorrado.add(FUNCIONES_btnBorrado);
		
		JLabel lbl_info_Borrado = new JLabel("<html><head><meta charset=\"UTF-8\"></head> En la sección <i><b>Borrar</b></i> podrás eliminar / dar de baja a los alumnos  que están actualmente dados de alta.<br/><br/>Pulse el <b>botón</b> de abajo para poder eliminar los registros. </html>");
		lbl_info_Borrado.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_info_Borrado.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_info_Borrado.setBounds(94, 25, 632, 125);
		ventanaBorrado.add(lbl_info_Borrado);
		
		JButton FUNCIONES_btnBorrado_TODO = new JButton("Eliminar Todo");
		FUNCIONES_btnBorrado_TODO.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Borrar bT = new Borrar();
		    	bT.borrarTodo();
		    }
		});
		FUNCIONES_btnBorrado_TODO.setActionCommand("Eliminar Todos los Registros");
		FUNCIONES_btnBorrado_TODO.setBackground(Color.WHITE);
		FUNCIONES_btnBorrado_TODO.setToolTipText("Eliminar el registro deseado");
		FUNCIONES_btnBorrado_TODO.setFont(new Font("Arial", Font.PLAIN, 15));
		FUNCIONES_btnBorrado_TODO.setBounds(399, 188, 148, 23);
		ventanaBorrado.add(FUNCIONES_btnBorrado_TODO);

		// ====================================== BORRADOS ======================================
		
		// ====================================== MODIFICACION ======================================
		
		JLayeredPane ventanaModificacion = new JLayeredPane();
		PanelGrande.addTab("Modificación", null, ventanaModificacion, null);
		ventanaModificacion.setOpaque(true);
		ventanaModificacion.setBackground(Color.WHITE);
		
		JLabel lbl_info_Modificacion = new JLabel("<html><head><meta charset=\"UTF-8\"></head> En la sección de <i><b>Edición</b></i> podrás modificar el valor de cada campo por el nuevo valor que desees. <br><br> Pulse el <b>botón</b> de abajo para poder modificar los registros.</html>");
		lbl_info_Modificacion.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_info_Modificacion.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_info_Modificacion.setBounds(86, 26, 632, 125);
		ventanaModificacion.add(lbl_info_Modificacion);
		
		JButton FUNCIONES_btnModificacion = new JButton("Modificar");
		FUNCIONES_btnModificacion.setBackground(Color.WHITE);
		FUNCIONES_btnModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modificacion mod = new Modificacion();
				mod.frames();
			}
		});
		FUNCIONES_btnModificacion.setToolTipText("Eliminar el registro deseado");
		FUNCIONES_btnModificacion.setFont(new Font("Arial", Font.PLAIN, 15));
		FUNCIONES_btnModificacion.setBounds(318, 184, 119, 23);
		ventanaModificacion.add(FUNCIONES_btnModificacion);
     // ================================== FUNCIÓN ==================================
	}
}
