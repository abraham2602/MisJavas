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
import ConexionesBBDD.Funcion;
import ConexionesBBDD.Insert;
import ConexionesBBDD.Modificacion;
import ConexionesBBDD.Transacciones;

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

public class app {

	private JFrame frmItepasen;
	JTabbedPane PanelGrande = new JTabbedPane(JTabbedPane.TOP);
	
	Consultar consulta = new Consultar();
	int xMouse, yMouse;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app window = new app();
					window.frmItepasen.setVisible(true);
					
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
		
		frmItepasen = new JFrame();
		frmItepasen.setResizable(false);
		frmItepasen.setTitle("Practica 2 - Acceso a Datos");
		frmItepasen.getContentPane().setBackground(Color.WHITE);
		frmItepasen.setBounds(100, 100, 800, 320);
		frmItepasen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmItepasen.getContentPane().setLayout(null);
		frmItepasen.setLocationRelativeTo(null);
			
		PanelGrande.setBackground(Color.WHITE);
		PanelGrande.setFont(new Font("Arial", Font.PLAIN, 11));
		
		PanelGrande.setBounds(10, 11, 764, 539);
		frmItepasen.getContentPane().add(PanelGrande);
		
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
				Insert a = new Insert();
				a.frames();
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
				Borrar borrando = new Borrar();
				borrando.delete();
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
		        Borrar borrado = new Borrar();
		        borrado.borrarTodo();
		    }
		});
		FUNCIONES_btnBorrado_TODO.setActionCommand("Eliminar Todos los Registros");
		FUNCIONES_btnBorrado_TODO.setBackground(Color.WHITE);
		FUNCIONES_btnBorrado_TODO.setToolTipText("Eliminar el registro deseado");
		FUNCIONES_btnBorrado_TODO.setFont(new Font("Arial", Font.PLAIN, 15));
		FUNCIONES_btnBorrado_TODO.setBounds(399, 188, 148, 23);
		ventanaBorrado.add(FUNCIONES_btnBorrado_TODO);
		
		JLabel lbl_info_Borrado_procedimiento = new JLabel("<html> (Mediante procedimiento) </html>");
		lbl_info_Borrado_procedimiento.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_info_Borrado_procedimiento.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_info_Borrado_procedimiento.setBounds(391, 161, 632, 125);
		ventanaBorrado.add(lbl_info_Borrado_procedimiento);

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
		
		// ================================== TRANSACCIONES ==================================
		JLayeredPane ventanaTransaccion = new JLayeredPane();
		PanelGrande.addTab("Transacción", null, ventanaTransaccion, null);
		ventanaTransaccion.setOpaque(true);
        ventanaTransaccion.setBackground(Color.WHITE);
        
        JLabel lbl_info_Transaccion = new JLabel("<html>En la secci\u00F3n <i><b>Transaccion</b></i>, podr\u00E1s realizar una transacción, en este caso, añadir 10 alumnos genéricos automáticamente. </html>");
        lbl_info_Transaccion.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_info_Transaccion.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_info_Transaccion.setBounds(78, 30, 632, 125);
        ventanaTransaccion.add(lbl_info_Transaccion);
        
        JButton FUNCIONES_btnTransaccion = new JButton("Transacci\u00F3n");
        FUNCIONES_btnTransaccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Transacciones trans = new Transacciones();
                trans.Transaccion();
            }
        });
        FUNCIONES_btnTransaccion.setToolTipText("Realiza una transacci\u00F3n");
        FUNCIONES_btnTransaccion.setFont(new Font("Arial", Font.PLAIN, 15));
        FUNCIONES_btnTransaccion.setBackground(Color.WHITE);
        FUNCIONES_btnTransaccion.setBounds(308, 178, 119, 23);
        ventanaTransaccion.add(FUNCIONES_btnTransaccion);

     // ================================== TRANSACCIONES ==================================
        
        
     // ================================== FUNCIÓN ==================================
        JLayeredPane ventanaFuncion = new JLayeredPane();
        PanelGrande.addTab("Función", null, ventanaFuncion, null);
        ventanaFuncion.setOpaque(true);
        ventanaFuncion.setBackground(Color.WHITE);
        
        JLabel lbl_info_Funcion = new JLabel("<html>En la secci\u00F3n <i><b>Función</b></i>, podr\u00E1s ejecutar una función que devolverá por consola el nombre de cada alumno y si el nombre es largo o corto.<br/><br/>Pulse el bot\u00F3n de abajo para ejecutar la función. </html>");
        lbl_info_Funcion.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_info_Funcion.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_info_Funcion.setBounds(83, 42, 632, 125);
        ventanaFuncion.add(lbl_info_Funcion);
        
        JButton FUNCIONES_btnFuncion = new JButton("Funci\u00F3n");
        FUNCIONES_btnFuncion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Funcion fun = new Funcion();
                fun.funcion();
            }
        });
        FUNCIONES_btnFuncion.setToolTipText("Realiza una transacci\u00F3n");
        FUNCIONES_btnFuncion.setFont(new Font("Arial", Font.PLAIN, 15));
        FUNCIONES_btnFuncion.setBackground(Color.WHITE);
        FUNCIONES_btnFuncion.setBounds(309, 181, 119, 23);
        ventanaFuncion.add(FUNCIONES_btnFuncion);
     // ================================== FUNCIÓN ==================================
	}
}
