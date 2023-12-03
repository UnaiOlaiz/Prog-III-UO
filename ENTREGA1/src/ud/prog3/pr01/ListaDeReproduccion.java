package ud.prog3.pr01;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;


/** Clase para crear instancias como listas de reproducción,
 * que permite almacenar listas de ficheros con posición de índice
 * (al estilo de un array / arraylist)
 * con marcas de error en los ficheros y con métodos para cambiar la posición
 * de los elementos en la lista, borrar elementos y añadir nuevos.
 */
public class ListaDeReproduccion implements ListModel<String> {
	ArrayList<File> ficherosLista;     // ficheros de la lista de reproducción
	int ficheroEnCurso = -1;           // Fichero seleccionado (-1 si no hay ninguno seleccionado)

	private static Logger logger = Logger.getLogger( ListaDeReproduccion.class.getName() ); // Paso 4
	private static final boolean ANYADIR_A_FIC_LOG = false; 
	static {
		try {
			logger.addHandler( new FileHandler(
					ListaDeReproduccion.class.getName()+".log.xml", ANYADIR_A_FIC_LOG ));
		} catch ( SecurityException | IOException e) {
			logger.log( Level.SEVERE, "Error en creación fichero log" );
		}
	}
	
	/** Constructor de lista de reproducción, crea una lista vacía
	 */
	public ListaDeReproduccion() {
		ficherosLista = new ArrayList<>();
	}
	
	/** Devuelve uno de los ficheros de la lista
	 * @param posi	Posición del fichero en la lista (de 0 a size()-1)
	 * @return	Devuelve el fichero en esa posición
	 * @throws IndexOutOfBoundsException	Si el índice no es válido
	 */
	public File getFic( int posi ) throws IndexOutOfBoundsException {
		return ficherosLista.get( posi );
	}	

	/** Añade a la lista de reproducción todos los ficheros que haya en la 
	 * carpeta indicada, que cumplan el filtro indicado.
	 * Si hay cualquier error, la lista de reproducción queda solo con los ficheros
	 * que hayan podido ser cargados de forma correcta.
	 * @param carpetaFicheros	Path de la carpeta donde buscar los ficheros
	 * @param filtroFicheros	Filtro del formato que tienen que tener los nombres de
	 * 							los ficheros para ser cargados.
	 * 							String con cualquier letra o dígito. Si tiene un asterisco
	 * 							hace referencia a cualquier conjunto de letras o dígitos.
	 * 							Por ejemplo p*.* hace referencia a cualquier fichero de nombre
	 * 							que empiece por p y tenga cualquier extensión.
	 * @return	Número de ficheros que han sido añadidos a la lista
	 */
	public int add(String carpetaFicheros, String filtroFicheros) {
		// TODO: Codificar este método de acuerdo a la práctica (pasos 3 y sucesivos)
		filtroFicheros = filtroFicheros.replaceAll( "\\.", "\\\\." );  // Pone el símbolo de la expresión regular \. donde figure un .
		logger.toString();
		filtroFicheros = filtroFicheros.replaceAll("\\*", "\\.*"); // Cambiamos los "*" por los ".*"
		logger.toString();
		// Paso 3b
		File fInic = new File( carpetaFicheros );
		if( fInic.isDirectory() ) {
			for( File f : fInic.listFiles() ) {
				logger.log( Level.FINE, "Procesando fichero " + f.getName() );
				if( f.getName() != null ) {
					ficherosLista.add(fInic);
				}
			}
		}
		return 0;
	}
	
	
	//
	// Métodos de selección
	
	// Funcion para intercambiar posiciones
	public void intercambia( int posi1, int posi2 ) {
		if( ficherosLista.get(posi1) == null || ficherosLista.get(posi2) == null) {
			return;
		} else {
			File fichero1 = ficherosLista.get(posi1);
			File fichero2 = ficherosLista.get(posi2);
			ficherosLista.set(posi2, fichero1);
			ficherosLista.set(posi1, fichero2);
		}
	}
	
	// Devuelve el tamaño de la lista
	public int size() {
		return ficherosLista.size();
	}
	
	// Añadir un fichero al final de la lista
	public void add( File f, String filtroFicheros ) {
		logger.log( Level.INFO, "Añadiendo ficheros con filtro " + filtroFicheros );
		ficherosLista.add(f);
	}
	
	// Eliminar un fichero de la lista, dada su posición
	public void removeFic( int posi ) {
		ficherosLista.remove(posi);
	}
	
	// Borrar la lista
	public void clear() {
		ficherosLista.clear();
	}
	//
	
	/** Selecciona un fichero aleatorio de la lista de reproducción.
	* @return true si la selección es correcta, false si hay error y no se puede seleccionar
	*/
	public boolean irARandom() {
		if( ficherosLista == null || ficherosLista.isEmpty() ) {
			return false;
		} else {
			Random random = new Random();
			int ficheroRandom = random.nextInt(ficherosLista.size());
			File ficheroAleatorioSeleccionado = ficherosLista.get(ficheroRandom);
			System.out.println( "Fichero aleatorio seleccionado: " + ficheroAleatorioSeleccionado );
			return true;
		}
	}
	
	/** Seleciona el primer fichero de la lista de reproducción
	 * @return	true si la selección es correcta, false si hay error y no se puede seleccionar
	 */
	public boolean irAPrimero() {
		ficheroEnCurso = 0;  // Inicia
		if (ficheroEnCurso>=ficherosLista.size()) {
			ficheroEnCurso = -1;  // Si no se encuentra, no hay selección
			return false;  // Y devuelve error
		}
		return true;
	}
	
	/** Seleciona el último fichero de la lista de reproducción
	 * @return	true si la selección es correcta, false si hay error y no se puede seleccionar
	 */
	public boolean irAUltimo() {
		ficheroEnCurso = ficherosLista.size()-1;  // Inicia al final
		if (ficheroEnCurso==-1) {  // Si no se encuentra, no hay selección
			return false;  // Y devuelve error
		}
		return true;
	}

	/** Seleciona el anterior fichero de la lista de reproducción
	 * @return	true si la selección es correcta, false si hay error y no se puede seleccionar
	 */
	public boolean irAAnterior() {
		if (ficheroEnCurso>=0) ficheroEnCurso--;
		if (ficheroEnCurso==-1) {  // Si no se encuentra, no hay selección
			return false;  // Y devuelve error
		}
		return true;
	}

	/** Seleciona el siguiente fichero de la lista de reproducción
	 * @return	true si la selección es correcta, false si hay error y no se puede seleccionar
	 */
	public boolean irASiguiente() {
		ficheroEnCurso++;
		if (ficheroEnCurso>=ficherosLista.size()) {
			ficheroEnCurso = -1;  // Si no se encuentra, no hay selección
			return false;  // Y devuelve error
		}
		return true;
	}

	/** Devuelve el fichero seleccionado de la lista
	 * @return	Posición del fichero seleccionado en la lista de reproducción (0 a n-1), -1 si no lo hay
	 */
	public int getFicSeleccionado() {
		return ficheroEnCurso;
	}

	//
	// Métodos de DefaultListModel
	//
	
	@Override
	public int getSize() {
		return ficherosLista.size();
	}

	@Override
	public String getElementAt(int index) {
		return ficherosLista.get(index).getName();
	}

		// Escuchadores de datos de la lista
		ArrayList<ListDataListener> misEscuchadores = new ArrayList<>();
	@Override
	public void addListDataListener(ListDataListener l) {
		misEscuchadores.add( l );
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		misEscuchadores.remove( l );
	}
	
	// Llamar a este método cuando se añada un elemento a la lista
	// (Utilizado para avisar a los escuchadores de cambio de datos de la lista)
	private void avisarAnyadido( int posi ) {
		for (ListDataListener ldl : misEscuchadores) {
			ldl.intervalAdded( new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, posi, posi ));
		}
	}
}
