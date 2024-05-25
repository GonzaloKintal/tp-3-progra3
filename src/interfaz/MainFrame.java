package interfaz;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.plaf.basic.BasicScrollBarUI;

import util.BotonPredeterminado;
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

	private JList<String> infoJList;
	private JScrollPane scrollPane;

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
		
		crearBotonAristaRandom();
		
		crearBotonGenerarVariasCliques();

		agregarBotonesAlPanel();

		crearJList();
		crearScrollPane();
		
		presenter.setComponentes(listaBotones, listaInputs);
		presenter.setearList(infoJList);
	}

	private void agregarBotonesAlPanel() {
		listaBotones.values().stream().forEach(boton -> {
			panelInteractivo.add(boton);
		});
	}

	private void crearFrame() {
		frame = new JFrame();
		frame.setTitle("Clique máxima");
		frame.setBounds(100, 80, 300, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon(getClass().getResource("/icono.png")).getImage());
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
		switchVisualizarGrafo.setBounds(248, 6, 25, 28);
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
					presenter.ver();
				} else {
					presenter.ocultar();
				}
			}
		});
	}

	private void crearImagenOjo() {
		Image imageInfo = new ImageIcon(this.getClass().getResource("/ojo.png")).getImage();
		JLabel infoLabel = new JLabel();
		infoLabel.setIcon(new ImageIcon(imageInfo));
		infoLabel.setBounds(245, 5, 30, 30);
		infoLabel.setToolTipText("Ver información");
		panelInteractivo.add(infoLabel);
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
		JButton boton = new BotonPredeterminado("Agregar vertice");
		boton.setBounds(90, 50, 150, 25);
		listaBotones.put(NombreBotones.AGREGAR_VERTICE, boton);
		panelInteractivo.add(boton);
	}

	private void crearLabelsVertices() {
		JLabel labelVerticeOrigen = new JLabel("Vértice 1");
		labelVerticeOrigen.setBounds(40, 76, 60, 60);
		panelInteractivo.add(labelVerticeOrigen);

		JLabel labelVerticeDestino = new JLabel("Vértice 2");
		labelVerticeDestino.setBounds(150, 76, 60, 60);
		panelInteractivo.add(labelVerticeDestino);
	}

	private void crearInputsVerticesParaAgregarArista() {
		JTextField inputVerticeOrigen = new JTextField();
		inputVerticeOrigen.setBounds(98, 95, 35, 23);
		panelInteractivo.add(inputVerticeOrigen);
		listaInputs.put(NombreInputs.VERTICE1, inputVerticeOrigen);

		JTextField inputVerticeDestino = new JTextField();
		inputVerticeDestino.setBounds(208, 95, 35, 23);
		panelInteractivo.add(inputVerticeDestino);
		listaInputs.put(NombreInputs.VERTICE2, inputVerticeDestino);
	}

	private void crearBotonAgregarArista() {
		JButton boton = new BotonPredeterminado("Agregar arista", 28, 125);
		listaBotones.put(NombreBotones.AGREGAR_ARISTA, boton);
	}

	private void crearBotonGenerarGrafoRandom() {
		JButton boton = new BotonPredeterminado("Generar grafo random", 28, 165);
		listaBotones.put(NombreBotones.GENERAR_GRAFO_RANDOM, boton);
	}

	private void crearBotonDameCliqueMaxima() {
		JButton boton = new BotonPredeterminado("Dame clique máxima", 28, 205);
		listaBotones.put(NombreBotones.DAME_CLIQUE_MAXIMA, boton);
	}

	private void crearBotonReiniciar() {
		JButton boton = new BotonPredeterminado("Reiniciar grafo", 28, 325);
		listaBotones.put(NombreBotones.REINICIAR_GRAFO, boton);
	}
	
	private void crearBotonAristaRandom() {
		JButton boton = new BotonPredeterminado("Crear arista random", 28, 285);
		listaBotones.put(NombreBotones.GENERAR_ARISTA_RANDOM, boton);
	}
	
	private void crearBotonGenerarVariasCliques() {
		JButton boton = new BotonPredeterminado("Generar varias cliques", 28, 245);
		listaBotones.put(NombreBotones.GENERAR_VARIAS_CLIQUES, boton);
	}

	private void crearBotonSalir() {
		JButton boton = new BotonPredeterminado("Salir", 28, 575);
		boton.setBackground(Config.COLOR_BOTON_SALIR);
		listaBotones.put(NombreBotones.SALIR, boton);
		escucharBotonSalir();
	}

	private void escucharBotonSalir() {
		listaBotones.get(NombreBotones.SALIR).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (Window window : Window.getWindows()) {
	                window.dispose();
	            }
			}
		});
	}

	private void crearJList() {
		infoJList = new JList<String>();
		infoJList.setBackground(Color.WHITE);
        infoJList.setForeground(Color.BLACK);
		infoJList.setBounds(0, 0, 200, 200);
		infoJList.setFont(new Font("Roboto", Font.BOLD, 14));
		panelInteractivo.add(infoJList);
	}

	private void crearScrollPane() {
		scrollPane = new JScrollPane(infoJList);
		scrollPane.setBounds(30, 365, 230, 200);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(null);
		scrollPane.getVerticalScrollBar().setBackground(Config.COLOR_BOTON);
	    scrollPane.getVerticalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
	    scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());;
		panelInteractivo.add(scrollPane);
	}
	
	
	// Clase interna para modificar el scroll
	private class CustomScrollBarUI extends BasicScrollBarUI {
	    @Override
	    protected void configureScrollBarColors() {
	        thumbColor = new Color(86, 206, 226);
	        trackColor = Config.COLOR_BOTON;
	        thumbDarkShadowColor = Config.COLOR_BOTON;
	        thumbLightShadowColor = Config.COLOR_BOTON;
	    }
	}
	
}

