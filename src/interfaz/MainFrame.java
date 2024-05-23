package interfaz;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import util.Config;
import util.NombreBotones;

public class MainFrame {

	private JFrame frame;
	private JPanel panel;

	private JToggleButton switchVisualizarGrafo;
	private JTextField inputPesoVertice;

	private HashMap<NombreBotones, JButton> listaBotones;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		listaBotones = new HashMap<>();
		initialize();
	}

	private void initialize() {

		crearFrame();

		crearPanel();

		crearSwitchVisualizarGrafo();

		escucharSwitchVisualizarGrafo();

//		crearImagenOjo();

		crearLabelPeso();

		crearInputPesoVertice();

		crearBotonAgregarVertice();

		JLabel labelVertice1 = new JLabel("Vértice 1");
		labelVertice1.setBounds(40, 81, 60, 60);
		panel.add(labelVertice1);

		JLabel labelVertice2 = new JLabel("Vértice 2");
		labelVertice2.setBounds(150, 81, 60, 60);
		panel.add(labelVertice2);

		new Presenter(listaBotones);

		JTextField inputVertice1 = new JTextField();
		inputVertice1.setBounds(98, 100, 35, 23);
		panel.add(inputVertice1);

		JTextField inputVertice2 = new JTextField();
		inputVertice2.setBounds(208, 100, 35, 23);
		panel.add(inputVertice2);

		JButton botonAgregarArista = new JButton("Agregar arista");
		botonAgregarArista.setBounds(28, 130, 230, 25);
		botonAgregarArista.setFont(new Font("Arial", Font.BOLD, 14));
		botonAgregarArista.setBorder(null);
		botonAgregarArista.setBackground(Config.COLOR_BOTON);
		botonAgregarArista.setForeground(Color.WHITE);
		botonAgregarArista.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonAgregarArista.setFocusPainted(false);
		listaBotones.put(NombreBotones.AGREGAR_ARISTA, botonAgregarArista);
		panel.add(botonAgregarArista);
	}

	private void crearFrame() {
		frame = new JFrame();
		frame.setBounds(400, 80, 300, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void crearPanel() {
		panel = new JPanel();
		panel.setBounds(0, 20, 300, 500);
		panel.setBackground(Config.COLOR_PANEL);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
	}

	private void crearSwitchVisualizarGrafo() {
		switchVisualizarGrafo = new JToggleButton();
		switchVisualizarGrafo.setBounds(3, 5, 30, 20);
		switchVisualizarGrafo.setContentAreaFilled(false);
		switchVisualizarGrafo.setOpaque(false);
		switchVisualizarGrafo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		switchVisualizarGrafo.setBorder(null);
		panel.add(switchVisualizarGrafo);
	}

	private void escucharSwitchVisualizarGrafo() {
		switchVisualizarGrafo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (switchVisualizarGrafo.isSelected()) {
					frame.setSize(700, 600);
				} else {
					frame.setSize(300, 600);
				}
			}
		});
	}

	private void crearImagenOjo() {
		Image imageOjo = new ImageIcon(this.getClass().getResource("/ojo2.png")).getImage();
		JLabel ojoLabel = new JLabel();
		ojoLabel.setIcon(new ImageIcon(imageOjo));
		ojoLabel.setBounds(3, 0, 30, 30);
		ojoLabel.setToolTipText("Ir al repositorio de GitHub");
		panel.add(ojoLabel);
	}

	private void crearLabelPeso() {
		JLabel labelPeso = new JLabel("Peso");
		labelPeso.setBounds(45, 30, 40, 25);
		panel.add(labelPeso);
	}

	private void crearInputPesoVertice() {
		inputPesoVertice = new JTextField();
		inputPesoVertice.setBounds(40, 51, 40, 25);
		panel.add(inputPesoVertice);
	}

	private void crearBotonAgregarVertice() {
		JButton botonAgregarVertice = new JButton("Agregar vértice");
		botonAgregarVertice.setBounds(90, 50, 150, 25);
		botonAgregarVertice.setFont(new Font("Arial", Font.BOLD, 14));
		botonAgregarVertice.setBorder(null);
		botonAgregarVertice.setBackground(Config.COLOR_BOTON);
		botonAgregarVertice.setForeground(Color.WHITE);
		botonAgregarVertice.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonAgregarVertice.setFocusPainted(false);
		listaBotones.put(NombreBotones.AGREGAR_VERTICE, botonAgregarVertice);
		panel.add(botonAgregarVertice);
	}

}
