package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.plaf.basic.BasicScrollBarUI;

import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

import util.BotonPredeterminado;
import util.Config;
import util.NombreBotones;
import util.NombreInputs;

public class MainFrame {

	private JFrame _frame;
	private JSplitPane _splitPane; 
	private JPanel _panelInteractivo;
	private JPanel _panelGrafo;

	private HashMap<NombreBotones, JButton> _botones;
	private HashMap<NombreInputs, JTextField> _inputs;

	private JToggleButton _switchVisualizarGrafo;
	private VisualizadorGrafo _visualizadorGrafo;

	private Presenter _presenter;

	private PanelEstadisticas _estadisticas;
	private JScrollPane _scrollPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window._frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		_botones = new HashMap<>();
		_inputs = new HashMap<>();
		_presenter = new Presenter();
		_visualizadorGrafo = new VisualizadorGrafo();
		initialize();
	}

	private void initialize() {

		crearFrame();

		crearPanelInteractivo();
		crearGrafo();

		dividirPantalla();
		
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
		agregarInputsAlPanel();

		crearPanelEstadisticas();
		crearScrollPane();

		_presenter.inyectarListeners(_botones, _inputs);
		_presenter.registrarObservador(_estadisticas);
		_presenter.registrarObservador(_visualizadorGrafo);
	}


	private void crearFrame() {
		_frame = new JFrame();
		_frame.setTitle("Clique máxima");
		_frame.setBounds(100, 80, 800, 650);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setIconImage(new ImageIcon(getClass().getResource("/icono.png")).getImage());
	}
	
	private void dividirPantalla() {
		_splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, _panelInteractivo, _panelGrafo);
	    _panelInteractivo.setLayout(null);
	    _splitPane.setResizeWeight(0);
	    _splitPane.setDividerSize(0);
	    _splitPane.setDividerLocation(300);
	    _frame.add(_splitPane);
	  }
	
	private void crearGrafo() {
		Viewer viewer = new Viewer(_visualizadorGrafo.getGrafo(),
                Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
		viewer.enableAutoLayout();
		View view = viewer.addDefaultView(false);
		
		_panelGrafo = new JPanel();
		_panelGrafo.setBounds(0, 0, 400, 500);
		_panelGrafo.setLayout(new BorderLayout());
		_panelGrafo.add((Component) view, BorderLayout.CENTER);
	}

	private void crearPanelInteractivo() {
		_panelInteractivo = new JPanel();
		_panelInteractivo.setBounds(0, 0, 300, 500);
		_panelInteractivo.setBackground(Config.COLOR_PANEL);
		_panelInteractivo.setLayout(null);
	}

	private void crearSwitchVisualizarGrafo() {
		_switchVisualizarGrafo = new JToggleButton();
		_switchVisualizarGrafo.setBounds(248, 6, 25, 28);
		_switchVisualizarGrafo.setContentAreaFilled(false);
		_switchVisualizarGrafo.setOpaque(false);
		_switchVisualizarGrafo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		_switchVisualizarGrafo.setBorder(null);

		_panelInteractivo.add(_switchVisualizarGrafo);
	}

	private void escucharSwitchVisualizarGrafo() {
		_switchVisualizarGrafo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (_switchVisualizarGrafo.isSelected()) {
					_panelGrafo.setVisible(false);
					_frame.setBounds(100, 80, Config.WIDTH_PANEL_INTERACTIVO, Config.HEIGHT_FRAME);
				} else {
					_frame.setBounds(100, 80, Config.WIDTH_FRAME, Config.HEIGHT_FRAME);
					_panelGrafo.setVisible(true);
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
		_panelInteractivo.add(infoLabel);
	}

	private void crearLabelPeso() {
		JLabel label = new JLabel("Peso");
		label.setBounds(45, 30, 40, 25);
		_panelInteractivo.add(label);
	}

	private void crearInputPesoVertice() {
		JTextField input = new JTextField();
		input.setBounds(40, 51, 40, 25);
		_inputs.put(NombreInputs.PESO_VERTICE, input);
	}

	private void crearBotonAgregarVertice() {
		JButton boton = new BotonPredeterminado("Agregar vertice");
		boton.setBounds(90, 50, 150, 25);
		_botones.put(NombreBotones.AGREGAR_VERTICE, boton);
	}

	private void crearLabelsVertices() {
		JLabel labelVerticeOrigen = new JLabel("Vértice 1");
		labelVerticeOrigen.setBounds(40, 76, 60, 60);
		_panelInteractivo.add(labelVerticeOrigen);

		JLabel labelVerticeDestino = new JLabel("Vértice 2");
		labelVerticeDestino.setBounds(150, 76, 60, 60);
		_panelInteractivo.add(labelVerticeDestino);
	}

	private void crearInputsVerticesParaAgregarArista() {
		JTextField inputVerticeOrigen = new JTextField();
		inputVerticeOrigen.setBounds(98, 95, 35, 23);
		_inputs.put(NombreInputs.VERTICE1, inputVerticeOrigen);

		JTextField inputVerticeDestino = new JTextField();
		inputVerticeDestino.setBounds(208, 95, 35, 23);
		_inputs.put(NombreInputs.VERTICE2, inputVerticeDestino);
	}

	private void crearBotonAgregarArista() {
		JButton boton = new BotonPredeterminado("Agregar arista", 28, 125);
		_botones.put(NombreBotones.AGREGAR_ARISTA, boton);
	}

	private void crearBotonGenerarGrafoRandom() {
		JButton boton = new BotonPredeterminado("Generar grafo random", 28, 165);
		_botones.put(NombreBotones.GENERAR_GRAFO_RANDOM, boton);
	}

	private void crearBotonDameCliqueMaxima() {
		JButton boton = new BotonPredeterminado("Dame clique máxima", 28, 205);
		_botones.put(NombreBotones.DAME_CLIQUE_MAXIMA, boton);
	}

	private void crearBotonReiniciar() {
		JButton boton = new BotonPredeterminado("Reiniciar grafo", 28, 325);
		_botones.put(NombreBotones.REINICIAR_GRAFO, boton);
	}

	private void crearBotonAristaRandom() {
		JButton boton = new BotonPredeterminado("Crear arista random", 28, 285);
		_botones.put(NombreBotones.GENERAR_ARISTA_RANDOM, boton);
	}

	private void crearBotonGenerarVariasCliques() {
		JButton boton = new BotonPredeterminado("Generar varias cliques", 28, 245);
		_botones.put(NombreBotones.GENERAR_VARIAS_CLIQUES, boton);
	}

	private void crearBotonSalir() {
		JButton boton = new BotonPredeterminado("Salir", 28, 575);
		boton.setBackground(Config.COLOR_BOTON_SALIR);
		_botones.put(NombreBotones.SALIR, boton);
	}
	

	private void agregarBotonesAlPanel() {
		_botones.values().stream().forEach(boton -> {
			_panelInteractivo.add(boton);
		});
	}

	private void agregarInputsAlPanel() {
		_inputs.values().stream().forEach(input -> {
			_panelInteractivo.add(input);
		});
	}

	private void crearPanelEstadisticas() {
		_estadisticas = new PanelEstadisticas();
		_panelInteractivo.add(_estadisticas);
	}

	private void crearScrollPane() {
		_scrollPane = new JScrollPane(_estadisticas);
		_scrollPane.setBounds(30, 365, 230, 200);
		_scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		_scrollPane.setBorder(null);
		_scrollPane.getVerticalScrollBar().setBackground(Config.COLOR_BOTON);
		_scrollPane.getVerticalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
		_scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
		_panelInteractivo.add(_scrollPane);
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
