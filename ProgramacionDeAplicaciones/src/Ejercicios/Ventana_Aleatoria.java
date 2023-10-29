package Ejercicios;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Ventana_Aleatoria {
	
	public static void main(String[] args) {
		JFrame ventana = new MarcoTabla();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}

}

class MarcoTabla extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MarcoTabla() {
		setTitle("Ventana aleatoria");
		setBounds(300, 300, 400, 200);
		
		// Tabla
		DefaultTableModel modeloTabla = new DefaultTableModel(2, 2);
		JTable tabla = new JTable(modeloTabla);
		
		JScrollPane scrollPane = new JScrollPane(tabla);
		add(scrollPane, BorderLayout.CENTER);
		add(tabla, BorderLayout.CENTER);
		
		// Randoma geroko berkodiu
		Random random = new Random();
		
		// Otros componentes
		JPanel panel_componentes = new JPanel();
		panel_componentes.setLayout(new FlowLayout());
		
		String[] opciones = {"2x2", "3x3", "4x4", "5x5"};
		JComboBox<String> comboBox = new JComboBox<>(opciones);
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actualizarTabla();
			}

			private void actualizarTabla() {
				// TODO Auto-generated method stub
				String aukera = (String) comboBox.getSelectedItem();
				int filak = Integer.parseInt(aukera.substring(0, 1));
				int zutabiak = Integer.parseInt(aukera.substring(2,3));
				
				modeloTabla.setRowCount(filak);
				modeloTabla.setColumnCount(zutabiak);
			}
		});
		panel_componentes.add(comboBox);
		
		JButton boton_aleatorio = new JButton("¡Aleatorio!");
		boton_aleatorio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hasiItek();
			}

			private void hasiItek() {
				// TODO Auto-generated method stub
				boton_aleatorio.setEnabled(false);
				Timer timer = new Timer(100, new ActionListener() {
					int segunduak = 0;
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(segunduak < 30) {
							for(int i = 0; i<tabla.getRowCount(); i++) {
								for(int j = 0; j<tabla.getColumnCount(); j++) {
									int zenbakiya = random.nextInt(1000) + 1;
									modeloTabla.setValueAt(zenbakiya, i, j);
								}
							}
							segunduak++;
						}else {
							boton_aleatorio.setEnabled(true);
						}
					}
				});
				timer.start();
			}
		});
		panel_componentes.add(boton_aleatorio);
		
		JButton boton_segunda_tabla = new JButton("Segunda Tabla");
		boton_segunda_tabla.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame ventana2 = new JFrame();
				ventana2.setBounds(200, 200, 300, 200);
				ventana2.setVisible(true);
				ventana2.setDefaultCloseOperation(EXIT_ON_CLOSE);
				
				String [] nombre_de_columnas = {"Nombre socio", "Año alta", "Rango"};
				Object [][] datos_de_filas = {
						 {"Agote", 235, 23}
				};
				
				JTable tabla_Socio = new JTable(datos_de_filas, nombre_de_columnas );
				
				// tabla_Socio.getColumnModel().getColumn(3).setCellRenderer(new BarraDeProgreso());
				ventana2.add(new JScrollPane(tabla_Socio), BorderLayout.CENTER);
				
			}
		});
		
		panel_componentes.add(boton_segunda_tabla);
		
		add(panel_componentes, BorderLayout.SOUTH);
		
	}
	
}

class BarraDeProgreso extends DefaultTableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		if(value instanceof Integer) {
			JProgressBar barra_de_progreso = new JProgressBar(0, 100);
			barra_de_progreso.setValue((int) value);
			barra_de_progreso.setStringPainted(true);
			return barra_de_progreso;
		}
		
		return null;
		
	}
}

