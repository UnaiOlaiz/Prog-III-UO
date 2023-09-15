package es.deusto.prog3.cap00.ejercicios;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

/** Ejercicio de hilos con ventanas. Programa esta clase para que se cree una ventana
 * que pida un dato de texto al usuario y un botón de confirmar para que se confirme.
 * Haz que al pulsar el botón de confirmación se llame al procesoConfirmar()
 * que simula un proceso de almacenamiento externo que tarda unos segundos.
 * Observa que hasta que ocurre esta confirmación la ventana no responde.
 * 1. Arréglalo para que la ventana no se quede "frita" hasta que se acabe de confirmar.
 * 2. Haz que el botón de "confirmar" no se pueda pulsar dos veces mientras el proceso
 * de confirmación se esté realizando
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class VentanaConfirmacionLenta {

		private static Random r = new Random();
	// Este método simula un proceso que tarda un tiempo en hacerse (entre 5 y 10 segundos)
	private static void procesoConfirmar() {
		try {
			Thread.sleep( 5000 + 1000*r.nextInt(6) );
		} catch (InterruptedException e) {}
	}
	
	public static void main(String[] args) {
		// TODO Desarrollar la clase de acuerdo a los comentarios de la cabecera
		JFrame ventana = new JFrame();
		ventana.setSize(200, 100);
		ventana.setLocation(2000, 0);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel pCentral = new JPanel();
		JTextField textFieldUsuario = new JTextField( "Usuario" );
		ventana.add(textFieldUsuario);
		pCentral.add(textFieldUsuario);
		ventana.add(pCentral, BorderLayout.CENTER);
		
		JButton bAceptar = new JButton("Aceptar");
		ventana.add(bAceptar, BorderLayout.SOUTH);
		
		bAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Presionando botón");
				procesoConfirmar();
			}
		});
		
		ventana.setVisible(true);
		System.out.println( "Fin" );
		verHilos();
		
	}

	private static void verHilos() {
		for (Thread hilo : Thread.getAllStackTraces().keySet()) {
			System.out.println( " " + hilo.getName() + " " + hilo.isDaemon());
		}
	}  

}
