package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;

public class Reproductor extends JFrame {

	private JPanel contentPane;

	int xMouse, yMouse;
	Musica mus = new Musica();
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reproductor frame = new Reproductor();
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

	public Reproductor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelniciar = new JPanel();
		panelniciar.setBackground(Color.WHITE);
		panelniciar.setBounds(0, 0, 784, 313);
		contentPane.add(panelniciar);
		panelniciar.setLayout(null);

		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xMouse, y - yMouse);
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		header.setBackground(new Color(0, 0, 128));
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
				exitBtn.setBackground(new Color(0, 0, 128));
			}
		});
		exitBtn.setBackground(new Color(0, 0, 128));
		exitBtn.setBounds(0, 0, 54, 35);
		header.add(exitBtn);

		JLabel lblExit = new JLabel("X");
		lblExit.setForeground(Color.WHITE);
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
		
		JSlider slider = new JSlider();
		slider.setValue(0);
		slider.setBackground(Color.WHITE);
		slider.setForeground(Color.WHITE);
		slider.setBounds(44, 195, 507, 26);
		panelniciar.add(slider);
		
		JLabel lblAlbum = new JLabel("Bruton Music");
		lblAlbum.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblAlbum.setBounds(57, 176, 75, 14);
		panelniciar.add(lblAlbum);
		
		JLabel lblAlbumImagen = new JLabel("");
		lblAlbumImagen.setIcon(new ImageIcon(Reproductor.class.getResource("/img/sweetvictory.jpg")));
		lblAlbumImagen.setBounds(242, 46, 139, 126);
		panelniciar.add(lblAlbumImagen);
		
		JLabel lblArtista = new JLabel("David Glen Eisley");
		lblArtista.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblArtista.setBounds(434, 175, 110, 14);
		panelniciar.add(lblArtista);
		
		JLabel lblNombreCancion = new JLabel("Sweet Victory");
		lblNombreCancion.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblNombreCancion.setBounds(272, 175, 99, 14);
		panelniciar.add(lblNombreCancion);

		JButton btnStop = new JButton("");
		btnStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mus.parar();
			}
		});
		btnStop.setIcon(new ImageIcon(Reproductor.class.getResource("/img/stop.png")));
		btnStop.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnStop.setFocusPainted(false);
		btnStop.setBorder(null);
		btnStop.setBackground(SystemColor.controlHighlight);
		btnStop.setBounds(242, 236, 25, 23);
		panelniciar.add(btnStop);

		JButton btnPlay = new JButton("");
		btnPlay.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				mus.reproducir();
			}
		});
		btnPlay.setIcon(new ImageIcon(Reproductor.class.getResource("/img/play.png")));
		btnPlay.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnPlay.setFocusPainted(false);
		btnPlay.setBorder(null);
		btnPlay.setBackground(SystemColor.controlHighlight);
		btnPlay.setBounds(274, 236, 39, 21);
		panelniciar.add(btnPlay);
		
		JButton btnPause = new JButton("");
		btnPause.setIcon(new ImageIcon(Reproductor.class.getResource("/img/pause.png")));
		btnPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mus.pause();
			}
		});
		
		btnPause.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnPause.setFocusPainted(false);
		btnPause.setBorder(null);
		btnPause.setBackground(SystemColor.controlHighlight);
		btnPause.setBounds(312, 236, 39, 21);
		panelniciar.add(btnPause);
		
		JButton btnAlante = new JButton("");
		btnAlante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mus.paLante();
				if(mus.wav == "2" && mus.estaSonando == false) {
					lblArtista.setText("Freddie Mercury");
					lblNombreCancion.setText("Living on my Own");
					lblAlbum.setText("Mr. Bad Guy");
					lblAlbumImagen.setIcon(new ImageIcon(Reproductor.class.getResource("/img/livingonmyown.jpg")));
				}
			}
		});
		btnAlante.setIcon(new ImageIcon(Reproductor.class.getResource("/img/alante.png")));
		btnAlante.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnAlante.setFocusPainted(false);
		btnAlante.setBorder(null);
		btnAlante.setBackground(SystemColor.controlHighlight);
		btnAlante.setBounds(361, 236, 39, 21);
		panelniciar.add(btnAlante);
		
		JButton btnBack = new JButton("");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mus.paTras();
				if(mus.wav == "1" && mus.estaSonando == false) {
					lblArtista.setText("David Glen Eisley");
					lblNombreCancion.setText("Sweet Victory");
					lblAlbum.setText("Bruton Music");
					lblAlbumImagen.setIcon(new ImageIcon(Reproductor.class.getResource("/img/sweetvictory.jpg")));
				}
			}
		});
		btnBack.setBackground(SystemColor.controlHighlight);
		btnBack.setBorder(null);
		btnBack.setFocusPainted(false);
		btnBack.setIcon(new ImageIcon(Reproductor.class.getResource("/img/back.png")));
		btnBack.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnBack.setBounds(194, 236, 39, 23);
		panelniciar.add(btnBack);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Sweet Victory"},
				{"Living on my Own"},
			},
			new String[] {
				"Canciones"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.setBounds(48, 57, 139, 33);
		panelniciar.add(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(-1, 223, 606, 104);
		panelniciar.add(panel);
		
		
		
		

	}
}
