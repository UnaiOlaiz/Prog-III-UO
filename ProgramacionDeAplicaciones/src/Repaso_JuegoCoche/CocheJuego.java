package Repaso_JuegoCoche;

// Paso 6

public class CocheJuego extends Coche {
	
	private JLabelCoche labelCoche;

	public CocheJuego(double miVelocidad, double miDireccionActual, double posX, double posY, String piloto,
			JLabelCoche labelCoche) {
		super(miVelocidad, miDireccionActual, posX, posY, piloto);
		this.labelCoche = labelCoche;
	}

	@Override
	public void setPosX(double posX) {
		super.setPosX(posX);
	}

	@Override
	public void setPosY(double posY) {
		super.setPosY(posY);
	}
	
	
	
}
