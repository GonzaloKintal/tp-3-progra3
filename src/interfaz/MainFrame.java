package interfaz;

import java.awt.Cursor;
import java.awt.EventQueue;
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
import util.NombreInputs;

public class MainFrame {

	private JFrame frame;
	private JPanel panel;

	private JToggleButton switchVisualizarGrafo;

	private HashMap<NombreBotones, JButton> listaBotones;
	private HashMap<NombreInputs, JTextField> listaInputs;
	private Presenter presenter;

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
		presenter = new Presenter();
		listaBotones = new HashMap<>();
		listaInputs = new HashMap<>();
		initialize();
	}

	private void initialize() {

		crearFrame();

		crearPanel();

		crearSwitchVisualizarGrafo();

		escucharSwitchVisualizarGrafo();

		crearImagenOjo();

		crearLabelPeso();

		crearInputPesoVertice();

		crearBotonAgregarVertice();

		crearLabelsVertices();

		crearInputsVerticesParaAgregarArista();

		crearBotonAgregarArista();

		crearBotonGenerarGrafoRandom();
		
		presenter.setComponentes(listaBotones, listaInputs);
	}

	private void crearFrame() {
		frame = new JFrame();
		frame.setBounds(400, 80, 300, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void dibujarGrafo() {
		// TODO
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
		JTextField inputPesoVertice = new JTextField();
		inputPesoVertice.setBounds(40, 51, 40, 25);
		panel.add(inputPesoVertice);
		listaInputs.put(NombreInputs.PESO_VERTICE, inputPesoVertice);
	}

	private void crearBotonAgregarVertice() {
		JButton botonAgregarVertice = BotonPredeteminado.crear("Agregar Vertice");
		botonAgregarVertice.setBounds(90, 50, 150, 25);
		listaBotones.put(NombreBotones.AGREGAR_VERTICE, botonAgregarVertice);
		panel.add(botonAgregarVertice);
	}

	private void crearLabelsVertices() {
		JLabel labelVerticeOrigen = new JLabel("Vértice 1");
		labelVerticeOrigen.setBounds(40, 81, 60, 60);
		panel.add(labelVerticeOrigen);

		JLabel labelVerticeDestino = new JLabel("Vértice 2");
		labelVerticeDestino.setBounds(150, 81, 60, 60);
		panel.add(labelVerticeDestino);
	}

	private void crearInputsVerticesParaAgregarArista() {
		JTextField inputVerticeOrigen = new JTextField();
		inputVerticeOrigen.setBounds(98, 100, 35, 23);
		panel.add(inputVerticeOrigen);
		listaInputs.put(NombreInputs.VERTICE1, inputVerticeOrigen);

		JTextField inputVerticeDestino = new JTextField();
		inputVerticeDestino.setBounds(208, 100, 35, 23);
		panel.add(inputVerticeDestino);
		listaInputs.put(NombreInputs.VERTICE2, inputVerticeDestino);
	}

	private void crearBotonAgregarArista() {
		JButton botonAgregarArista = BotonPredeteminado.crear("Agregar Arista");
		botonAgregarArista.setBounds(28, 130, 230, 25);
		listaBotones.put(NombreBotones.AGREGAR_ARISTA, botonAgregarArista);
		panel.add(botonAgregarArista);
	}

	private void crearBotonGenerarGrafoRandom() {
		JButton boton = BotonPredeteminado.crear("Generar Grafo Random");
		boton.setBounds(28, 170, 230, 25);
		listaBotones.put(NombreBotones.GENERAR_GRAFO_RANDOM, boton);
		panel.add(boton);
	}

}
