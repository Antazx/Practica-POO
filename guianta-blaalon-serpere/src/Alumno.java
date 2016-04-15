import java.util.ArrayList;
/**Clase alumno: Cada uno de los alumnos de la academia.
 * 
 * @author Blanca Alonso Prieto
 * @author Sergio Pérez
 * @author Guillermo Anta
 */

public abstract class Alumno {
	
	private ArrayList<Matricula> matriculas;
	private String nombre;
	private String apellidos;
	
	/** Constructor de Alumno: Crea e inicializa al alumno. Crea el ArrayList Matricula.
	 * 
	 * @requires alumno tenga nombre
	 * @requires alumno tenga apellidos
	 * @param nombre del alumno
	 * @param apellidos del alumno
	 */
	public Alumno(String nombre, String apellidos){
		assert(nombre!=null);
		this.nombre=nombre;
		assert(apellidos!=null);
		this.apellidos=apellidos;
		this.matriculas = new ArrayList<Matricula>();
	}
	
	/** getMatriculas: Getter de matricula
	 * 
	 * @return copia de la lista de matriculas
	 */
	public ArrayList<Matricula> getMatriculas() {
		ArrayList<Matricula> copia = new ArrayList<Matricula>();
		for(int i=0;i<matriculas.size();i++){
				copia.add(matriculas.get(i));
		}
		return copia;
	}
	
	
	/** setMatriculas: añade una matricula a la lista de matriculas. Comprueba que esa matricula existe
	 * 
	 * @requires matricula exista
	 * @ensures el tamaño del array de matriculas aumente en uno
	 * @param C: matrícula a añadir
	 */
	public void setMatriculas(Matricula C) {
		int tam=matriculas.size();
		assert(C!=null);
		matriculas.add(C);
		assert(matriculas.size()==tam+1);
	}
	
	/**getNombre: Getter de nombre
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/** getDeuda: Getter de deuda
	 * 
	 * @return deuda 
	 */
	public double getDeuda(){
		double deuda=0;
		for(int i=0; i<getMatriculas().size();i++){
			if (getMatriculas().get(i).isPagada()){
				}else{
					deuda = deuda + getMatriculas().get(i).getCurso().getPrecio();
			}
		}
		return deuda;
	}
	/** getApellidos: Getter de apellidos
	 * 
	 * @return apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
}
