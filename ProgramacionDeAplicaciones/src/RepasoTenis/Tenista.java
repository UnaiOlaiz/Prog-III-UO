package RepasoTenis;

public class Tenista {
	
	protected String nombre, nacionalidad;
	protected int numero_Victorias;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public int getNumero_Victorias() {
		return numero_Victorias;
	}
	public void setNumero_Victorias(int numero_Victorias) {
		this.numero_Victorias = numero_Victorias;
	}
	public Tenista(String nombre, String nacionalidad, int numero_Victorias) {
		super();
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.numero_Victorias = numero_Victorias;
	}
	@Override
	public String toString() {
		return "Tenista [nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", numero_Victorias=" + numero_Victorias
				+ "]";
	}
	

}
