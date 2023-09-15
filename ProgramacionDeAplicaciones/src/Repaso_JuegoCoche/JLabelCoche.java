package Repaso_JuegoCoche;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JLabelCoche extends Coche {
	
	// Paso 5
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("JLabel con Imagen PNG");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(100, 100);
		
		ImageIcon imagenIcon = new ImageIcon("coche.png");
		
		JLabel imagenLabel = new JLabel(imagenIcon);
		
		frame.add(imagenLabel);
		
		frame.setVisible(true);
	}
	

}
