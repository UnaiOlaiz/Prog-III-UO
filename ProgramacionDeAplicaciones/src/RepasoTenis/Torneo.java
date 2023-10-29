package RepasoTenis;

public class Torneo {
	
	protected String codigo, nombre, ciudad;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Torneo(String codigo, String nombre, String ciudad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Torneo [codigo=" + codigo + ", nombre=" + nombre + ", ciudad=" + ciudad + "]";
	}
	

}
