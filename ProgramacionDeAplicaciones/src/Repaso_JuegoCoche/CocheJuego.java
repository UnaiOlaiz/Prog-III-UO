package Repaso_JuegoCoche;

// Paso 6

public class CocheJuego extends Coche {
	
	Coche coche = new Coche();
	JLabelCoche labelCoche;
	
	@Override
	public void setPosX(double posX) {
		super.setPosX(coche.getPosX());
	}
	@Override
	public void setPosY(double posY) {
		super.setPosY(coche.getPosY());
	}
	
	
	
}
