package Repaso_JuegoCoche;

import java.awt.*;

import javax.swing.*;

public class JLabelCoche extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	// Paso 5
	public static void main(String[] args) {
		
		ImageIcon imagenIcon = new ImageIcon("C:\\Users\\unaio\\Downloads\\coche.png");
		
		int Ancho = 100;
		int Alto = 100;
		
		Image imgIcon = imagenIcon.getImage();
		Image imgEscalada = imgIcon.getScaledInstance(Ancho, Alto, Image.SCALE_SMOOTH);
		
		ImageIcon imagenEscalada = new ImageIcon(imgEscalada);
		JLabel labelEscalado = new JLabel(imagenEscalada);
		labelEscalado.setVisible(true);
		
		//	Aquí pruebo como quedaría en una nueva ventana
		//	JFrame frame = new JFrame("Imagen escalada");
		//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//	frame.setSize(400, 400);
		//	frame.getContentPane().add(labelEscalado);
		//	frame.pack();
		//	frame.setVisible(true);
		
		
		
	}
	

}
