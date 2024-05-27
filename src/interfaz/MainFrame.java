package interfaz;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class MainFrame implements Observador {

	private JFrame _frame;
	private JPanel _panelInteractivo;

	private JToggleButton _switchVisualizarGrafo;
	
	private Presenter _presenter;

	private JList<String> _infoJList;
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
		_presenter = new Presenter();
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
		
		_presenter.escucharComponentes();
		_presenter.registrarObservador(this);
	}

	private void agregarBotonesAlPanel() {
		_presenter.getBotones().values().stream().forEach(boton -> {
			_panelInteractivo.add(boton);
		});
	}

	private void crearFrame() {
		_frame = new JFrame();
		_frame.setTitle("Clique máxima");
		_frame.setBounds(100, 80, 300, 650);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setIconImage(new ImageIcon(getClass().getResource("/icono.png")).getImage());
	}

	private void crearPanelInteractivo() {
		_panelInteractivo = new JPanel();
		_panelInteractivo.setBounds(0, 20, 300, 500);
		_panelInteractivo.setBackground(Config.COLOR_PANEL);
		_panelInteractivo.setLayout(null);
		_frame.getContentPane().add(_panelInteractivo);
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
					_presenter.ver();
				} else {
					_presenter.ocultar();
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
		JLabel labelPeso = new JLabel("Peso");
		labelPeso.setBounds(45, 30, 40, 25);
		_panelInteractivo.add(labelPeso);
	}

	private void crearInputPesoVertice() {
		JTextField inputPesoVertice = new JTextField();
		inputPesoVertice.setBounds(40, 51, 40, 25);
		_panelInteractivo.add(inputPesoVertice);
		_presenter.agregarInput(NombreInputs.PESO_VERTICE, inputPesoVertice);
	}

	private void crearBotonAgregarVertice() {
		JButton boton = new BotonPredeterminado("Agregar vertice");
		boton.setBounds(90, 50, 150, 25);
		_presenter.agregarBoton(NombreBotones.AGREGAR_VERTICE, boton);
		_panelInteractivo.add(boton);
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
		_panelInteractivo.add(inputVerticeOrigen);
		_presenter.agregarInput(NombreInputs.VERTICE1, inputVerticeOrigen);

		JTextField inputVerticeDestino = new JTextField();
		inputVerticeDestino.setBounds(208, 95, 35, 23);
		_panelInteractivo.add(inputVerticeDestino);
		_presenter.agregarInput(NombreInputs.VERTICE2, inputVerticeDestino);
	}

	private void crearBotonAgregarArista() {
		JButton boton = new BotonPredeterminado("Agregar arista", 28, 125);
		_presenter.agregarBoton(NombreBotones.AGREGAR_ARISTA, boton);
	}

	private void crearBotonGenerarGrafoRandom() {
		JButton boton = new BotonPredeterminado("Generar grafo random", 28, 165);
		_presenter.agregarBoton(NombreBotones.GENERAR_GRAFO_RANDOM, boton);
	}

	private void crearBotonDameCliqueMaxima() {
		JButton boton = new BotonPredeterminado("Dame clique máxima", 28, 205);
		_presenter.agregarBoton(NombreBotones.DAME_CLIQUE_MAXIMA, boton);
	}

	private void crearBotonReiniciar() {
		JButton boton = new BotonPredeterminado("Reiniciar grafo", 28, 325);
		_presenter.agregarBoton(NombreBotones.REINICIAR_GRAFO, boton);
	}
	
	private void crearBotonAristaRandom() {
		JButton boton = new BotonPredeterminado("Crear arista random", 28, 285);
		_presenter.agregarBoton(NombreBotones.GENERAR_ARISTA_RANDOM, boton);
	}
	
	private void crearBotonGenerarVariasCliques() {
		JButton boton = new BotonPredeterminado("Generar varias cliques", 28, 245);
		_presenter.agregarBoton(NombreBotones.GENERAR_VARIAS_CLIQUES, boton);
	}

	private void crearBotonSalir() {
		JButton boton = new BotonPredeterminado("Salir", 28, 575);
		boton.setBackground(Config.COLOR_BOTON_SALIR);
		_presenter.agregarBoton(NombreBotones.SALIR, boton);
	}

	

	private void crearJList() {
		_infoJList = new JList<String>();
		_infoJList.setBackground(Color.WHITE);
        _infoJList.setForeground(Color.BLACK);
		_infoJList.setBounds(0, 0, 200, 200);
		_infoJList.setFont(new Font("Roboto", Font.BOLD, 14));
		_panelInteractivo.add(_infoJList);
	}

	private void crearScrollPane() {
		_scrollPane = new JScrollPane(_infoJList);
		_scrollPane.setBounds(30, 365, 230, 200);
		_scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		_scrollPane.setBorder(null);
		_scrollPane.getVerticalScrollBar().setBackground(Config.COLOR_BOTON);
	    _scrollPane.getVerticalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
	    _scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());;
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


	@Override
	public void actualizar(Object dato) {
		String[] infoString = ((String) dato).split("\n");
		_infoJList.setListData(infoString);
		
	}
	
}

