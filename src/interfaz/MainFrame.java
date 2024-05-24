package interfaz;

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
import util.NombreInputs;

public class MainFrame {

	private JFrame frame;
	private JPanel panelInteractivo;

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

		crearPanelInteractivo();
		
		crearSwitchVisualizarGrafo();
		crearImagenOjo();
		escucharSwitchVisualizarGrafo();

		crearLabelPeso();
		crearInputPesoVertice();
		crearBotonAgregarVertice();

		crearLabelsVertices();
		crearInputsVerticesParaAgregarArista();
		crearBotonAgregarArista();

		crearBotonGenerarGrafoRandom();

		crearBotonDameCliqueMaxima();

		crearBotonSalir();

		presenter.setComponentes(listaBotones, listaInputs);
	}

	private void crearFrame() {
		frame = new JFrame();
		frame.setTitle("Clique máxima");
		frame.setBounds(400, 80, 300, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon(getClass().getResource("/prueba.png")).getImage());
	}

	private void crearPanelInteractivo() {
		panelInteractivo = new JPanel();
		panelInteractivo.setBounds(0, 20, 300, 500);
		panelInteractivo.setBackground(Config.COLOR_PANEL);
		panelInteractivo.setLayout(null);
		frame.getContentPane().add(panelInteractivo);
	}

	private void crearSwitchVisualizarGrafo() {
		switchVisualizarGrafo = new JToggleButton();
		switchVisualizarGrafo.setBounds(5, 5, 30, 20);
		switchVisualizarGrafo.setContentAreaFilled(false);
		switchVisualizarGrafo.setOpaque(false);
		switchVisualizarGrafo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		switchVisualizarGrafo.setBorder(null);
		
		panelInteractivo.add(switchVisualizarGrafo);
	}

	private void escucharSwitchVisualizarGrafo() {
		switchVisualizarGrafo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (switchVisualizarGrafo.isSelected()) {
					presenter.visualizar();
				} else {
					presenter.ocultar();
				}
			}
		});
	}

	private void crearImagenOjo() {
		Image imageOjo = new ImageIcon(this.getClass().getResource("/ojo.png")).getImage();
		JLabel ojoLabel = new JLabel();
		ojoLabel.setIcon(new ImageIcon(imageOjo));
		ojoLabel.setBounds(5, 0, 30, 30);
		ojoLabel.setToolTipText("Ir al repositorio de GitHub");
		panelInteractivo.add(ojoLabel);
	}

	private void crearLabelPeso() {
		JLabel labelPeso = new JLabel("Peso");
		labelPeso.setBounds(45, 30, 40, 25);
		panelInteractivo.add(labelPeso);
	}

	private void crearInputPesoVertice() {
		JTextField inputPesoVertice = new JTextField();
		inputPesoVertice.setBounds(40, 51, 40, 25);
		panelInteractivo.add(inputPesoVertice);
		listaInputs.put(NombreInputs.PESO_VERTICE, inputPesoVertice);
	}

	private void crearBotonAgregarVertice() {
		JButton botonAgregarVertice = BotonPredeteminado.crear("Agregar Vertice");
		botonAgregarVertice.setBounds(90, 50, 150, 25);
		listaBotones.put(NombreBotones.AGREGAR_VERTICE, botonAgregarVertice);
		panelInteractivo.add(botonAgregarVertice);
	}

	private void crearLabelsVertices() {
		JLabel labelVerticeOrigen = new JLabel("Vértice 1");
		labelVerticeOrigen.setBounds(40, 81, 60, 60);
		panelInteractivo.add(labelVerticeOrigen);

		JLabel labelVerticeDestino = new JLabel("Vértice 2");
		labelVerticeDestino.setBounds(150, 81, 60, 60);
		panelInteractivo.add(labelVerticeDestino);
	}

	private void crearInputsVerticesParaAgregarArista() {
		JTextField inputVerticeOrigen = new JTextField();
		inputVerticeOrigen.setBounds(98, 100, 35, 23);
		panelInteractivo.add(inputVerticeOrigen);
		listaInputs.put(NombreInputs.VERTICE1, inputVerticeOrigen);

		JTextField inputVerticeDestino = new JTextField();
		inputVerticeDestino.setBounds(208, 100, 35, 23);
		panelInteractivo.add(inputVerticeDestino);
		listaInputs.put(NombreInputs.VERTICE2, inputVerticeDestino);
	}

	private void crearBotonAgregarArista() {
		JButton botonAgregarArista = BotonPredeteminado.crear("Agregar Arista");
		botonAgregarArista.setBounds(28, 130, 230, 25);
		listaBotones.put(NombreBotones.AGREGAR_ARISTA, botonAgregarArista);
		panelInteractivo.add(botonAgregarArista);
	}

	private void crearBotonGenerarGrafoRandom() {
		JButton botonGenerarGrafoRandom = BotonPredeteminado.crear("Generar Grafo Random");
		botonGenerarGrafoRandom.setBounds(28, 170, 230, 25);
		listaBotones.put(NombreBotones.GENERAR_GRAFO_RANDOM, botonGenerarGrafoRandom);
		panelInteractivo.add(botonGenerarGrafoRandom);
	}

	private void crearBotonDameCliqueMaxima() {
		JButton botonDameCliqueMaxima = BotonPredeteminado.crear("Dame clique máxima");
		botonDameCliqueMaxima.setBounds(28, 210, 230, 25);
		listaBotones.put(NombreBotones.DAME_CLIQUE_MAXIMA, botonDameCliqueMaxima);
		panelInteractivo.add(botonDameCliqueMaxima);
	}

	private void crearBotonSalir() {
		JButton botonSalir = BotonPredeteminado.crear("Salir");
		botonSalir.setFont(new Font("Arial", Font.BOLD, 16));
		botonSalir.setBounds(28, 520, 230, 30);
		botonSalir.setBackground(Config.COLOR_BOTON_SALIR);
		listaBotones.put(NombreBotones.SALIR, botonSalir);
		panelInteractivo.add(botonSalir);
		escucharBotonSalir();
	}

	private void escucharBotonSalir() {
		listaBotones.get(NombreBotones.SALIR).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}

		});
	}

}
