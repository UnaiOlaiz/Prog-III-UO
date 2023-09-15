package Repaso_JuegoCoche;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaJuego extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Thread miHilo;

	// Pasos 1 y 2
	public static void main(String[] args) {
		
		Coche coche = new Coche();
		
		JFrame ventana = new JFrame();
		ventana.setLayout(new BorderLayout());
		ventana.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ventana.setVisible(true);
		ventana.setSize(600, 400);
		ventana.setTitle("Juego de Coche");
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.white);
		panelPrincipal.setLayout(null);
		ventana.add(panelPrincipal, BorderLayout.CENTER);
		
		JPanel panelBotonera = new JPanel();
		panelBotonera.setLayout(new FlowLayout());
		
		JButton botonAcelera = new JButton("Acelera");
		panelBotonera.add(botonAcelera);
		botonAcelera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(5);
				System.out.println(coche.getMiVelocidad());
			}
		});
		
		JButton botonFrena = new JButton("Frena");
		panelBotonera.add(botonFrena);
		botonFrena.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(-5);
			}
		});
		JButton botonGiraIzq = new JButton("Gira Izq.");
		panelBotonera.add(botonGiraIzq);
		botonGiraIzq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.gira(-10);
				System.out.println(coche.getMiDireccionActual());
			}
		});
		
		JButton botonGiraDer = new JButton("Gira Der.");
		panelBotonera.add(botonGiraDer);
		botonGiraDer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.gira(10);
				System.out.println(coche.getMiDireccionActual());
			}
		});
		
		ventana.add(panelBotonera, BorderLayout.SOUTH);
		
		// Probamos el primer coche; Paso 3
		Coche coche1 = new Coche(200, 189, 150, 100, "El Puto Amo");
		System.out.println(coche1.toString());
		
		setMiHilo(new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				while(ventana.isActive()) {
					coche.mueve(40);
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}));
		
	}

	public static Thread getMiHilo() {
		return miHilo;
	}

	public static void setMiHilo(Thread miHilo) {
		VentanaJuego.miHilo = miHilo;
	}
	
}
