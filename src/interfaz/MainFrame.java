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
		
		crearBotonReiniciar();

		crearBotonSalir();

		//Agregar botones al panel
		listaBotones.values().stream().forEach(boton -> {
			panelInteractivo.add(boton);
		});

		presenter.setComponentes(listaBotones, listaInputs);
	}

	private void crearFrame() {
		frame = new JFrame();
		frame.setTitle("Clique máxima");
		frame.setBounds(100, 80, 300, 600);
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
//				if (switchVisualizarGrafo.isSelected()) {
//					presenter.visualizar();
//				} else {
//					presenter.ocultar();
//				}
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
		JButton boton =  new BotonPredeterminado("Agregar Vertice");
		boton.setBounds(90, 50, 150, 25);
		listaBotones.put(NombreBotones.AGREGAR_VERTICE, boton);
		panelInteractivo.add(boton);
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
		JButton boton = new BotonPredeterminado("Agregar Arista", 28, 130);
		listaBotones.put(NombreBotones.AGREGAR_ARISTA, boton);
	}

	private void crearBotonGenerarGrafoRandom() {
		JButton boton = new BotonPredeterminado("Generar Grafo Random", 28, 170);
		listaBotones.put(NombreBotones.GENERAR_GRAFO_RANDOM, boton);
	}

	private void crearBotonDameCliqueMaxima() {
		JButton boton = new BotonPredeterminado("Dame clique máxima", 28, 210);
		listaBotones.put(NombreBotones.DAME_CLIQUE_MAXIMA, boton);
	}
	
	private void crearBotonReiniciar() {
		JButton boton = new BotonPredeterminado("Reiniciar Grafo", 28, 250);
		listaBotones.put(NombreBotones.REINICIAR_GRAFO, boton);
	}

	private void crearBotonSalir() {
		JButton boton = new BotonPredeterminado("Salir", 28, 520);
		boton.setBackground(Config.COLOR_BOTON_SALIR);
		listaBotones.put(NombreBotones.SALIR, boton);
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
