package RepasoTenis;

import java.util.ArrayList;
import java.util.TreeSet;

public abstract class DatoTabular implements Comparable<Object> {
	
	protected ArrayList<String> cabeceras, tipos;
	protected TreeSet<Integer> valores;

	public ArrayList<String> getCabeceras() {
		return cabeceras;
	}

	public void setCabeceras(ArrayList<String> cabeceras) {
		this.cabeceras = cabeceras;
	}

	public ArrayList<String> getTipos() {
		return tipos;
	}

	public void setTipos(ArrayList<String> tipos) {
		this.tipos = tipos;
	}

	public TreeSet<Integer> getValores() {
		return valores;
	}

	public void setValores(TreeSet<Integer> valores) {
		this.valores = valores;
	}

	public DatoTabular(ArrayList<String> cabeceras, ArrayList<String> tipos, TreeSet<Integer> valores) {
		super();
		this.cabeceras = cabeceras;
		this.tipos = tipos;
		this.valores = valores;
	}
	
	
	// Otros métodos
	

}
