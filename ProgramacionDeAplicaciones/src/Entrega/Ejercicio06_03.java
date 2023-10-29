package Entrega;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Ejercicio06_03 {
	
	private static JFrame ventana, ventana2;
	private static DataSetMunicipios dataset;

	private static VentanaTablaDatos ventanaDatos;
	
	public static void main(String[] args) {
		ventana = new JFrame( "Ejercicio 6.3" );
		ventana.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		ventana.setLocationRelativeTo( null );
		ventana.setSize( 200, 80 );

		JButton bCargaMunicipios = new JButton( "Carga municipios > 200k" );
		ventana.add( bCargaMunicipios );
		
		bCargaMunicipios.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargaMunicipios();
			}
		});
		
		ventana.setVisible( true );
		
		ventana2 = new JFrame("Ventana 2");
		ventana2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventana2.setSize(800, 600);
		ventana2.setLocationRelativeTo(null);
		
		JPanel panelSuperior = new JPanel();
		JLabel labelMensaje = new JLabel("...");
		panelSuperior.add(labelMensaje);
		
		// Árbol
		JTree arbol = new JTree();
		cargarArbol();
		JScrollPane scrollArbol = new JScrollPane(arbol);
		
		// Tabla
		DefaultTableModel model = new DefaultTableModel();
		JTable tabla = new JTable(model);
		JScrollPane scrollTabla = new JScrollPane(tabla);
		
		JPanel panelVisualzacion = new JPanel();
		
		JPanel panelBotones = new JPanel();
		JButton botonInsercion = new JButton("Inserción");
		JButton botonBorrar = new JButton("Borrar");
		
		// Programamos el botón botonInserción para que añada un nuevo municipio al final
		botonInsercion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int provinciaSeleccionada = tabla.getSelectedColumn();
				int comunidadAutononomaSeleccionada = tabla.getSelectedColumn();
				
				Object[] nuevoMunicipio = {0, "", 50000, provinciaSeleccionada, comunidadAutononomaSeleccionada};
				
				model.addColumn(nuevoMunicipio);
			}
		});
		// 
		botonBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JButton botonOrden = new JButton("Órden");
		//
		botonOrden.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//
		TableColumn row = tabla.getColumnModel().getColumn(0);
		
		panelBotones.add(botonInsercion);
		panelBotones.add(botonBorrar);
		panelBotones.add(botonOrden);
		
		ventana2.setLayout(new BorderLayout());
		ventana2.add(panelSuperior, BorderLayout.NORTH);
		ventana2.add(scrollArbol, BorderLayout.WEST);
		ventana2.add(scrollTabla, BorderLayout.CENTER);
		ventana2.add(panelVisualzacion, BorderLayout.EAST);
		ventana2.add(panelBotones, BorderLayout.SOUTH);
		
		ventana2.setVisible(true);
	
		
		
	}
	
	
	
	private static void cargarArbol() {
		// TODO Auto-generated method stub
		cargaMunicipios();
		DefaultMutableTreeNode raizMunicipio = new DefaultMutableTreeNode("Municipios"); // Cargamos el primer nivel del árbol
		for(Municipio m : dataset.getListaMunicipios()) { // Segundo nivel
			DefaultMutableTreeNode nodoAutonomia = new DefaultMutableTreeNode(m.getAutonomia());
			raizMunicipio.add(nodoAutonomia);
		}
		for(Municipio m : dataset.getListaMunicipios()) { // Aquí añadimos el tercer nivel
			DefaultMutableTreeNode nodoProvincia = new DefaultMutableTreeNode(m.getProvincia());
			raizMunicipio.add(nodoProvincia);
		}
		
		DefaultTreeModel modeloArbol = new DefaultTreeModel(raizMunicipio);
		JTree arbol = new JTree(modeloArbol);
		arbol.setEditable(false);
	}



	private static void cargaMunicipios() {
		try {
			dataset = new DataSetMunicipios( "municipios200k.txt" );
			System.out.println( "Cargados municipios:" );
			for (Municipio m : dataset.getListaMunicipios() ) {
				System.out.println( "\t" + m );
			}
			// TODO Resolver el ejercicio 6.3
			ventanaDatos = new VentanaTablaDatos( ventana );
			ventanaDatos.setDatos( dataset );
			ventanaDatos.setVisible( true );
			
			
			
			
		} catch (IOException e) {
			System.err.println( "Error en carga de municipios" );
		}
	}
	
}
