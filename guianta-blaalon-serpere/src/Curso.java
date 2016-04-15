import java.util.ArrayList;
import java.util.GregorianCalendar;
/**Clase Curso: Cada uno de los cursos que organiza la academia. 
 * Tiene un código identificador único
 * Tiene información sobre el idioma, nivel, fechas de inicio y final, así como la hora en que se imparte. 
 * Tiene un número de alumnos máximo, un precio de matrícula y mantiene una lista de los alumnos inscritos.
 * @author Blanca Alonso Prieto
 * @author Sergio Pérez
 * @author Guillermo Anta
*/
public abstract class Curso {
	
	/**
	 * Atributo static para calcular la id en funcion de los cursos
	 */
	private static int nextID;
	private int id;
	private String idioma;
	private double precio;
	private GregorianCalendar fechai;
	private GregorianCalendar fechaf;
	private ArrayList<Alumno> alumnos;
	private int maxAlumnos;

	/**Constructor Curso: Crea e inicializa el Curso y calcula el id del curso sumando uno al id anterior.
	 * Crea el ArrayList Alumno
	 * 
	 * @requires exista el idioma
	 * @requires precio mayor que 0
	 * @requires que la fecha de inicio sea antes que la de fin
	 * @requires maximo de alumnos sea mayor que 0
	 * @param idioma del curso
	 * @param precio del curso
	 * @param fechainicio del curso
	 * @param fechafinal del curso
	 * @param maxAlumnos del curso
	 */
	public Curso(String idioma, double precio, GregorianCalendar fechainicio, GregorianCalendar fechafinal,int maxAlumnos){
		this.id=Curso.nextID;
		assert(idioma != null);
		this.idioma=idioma;
		assert(precio>0);
		this.precio=precio;
		assert(fechainicio.compareTo(fechafinal)<0);
		this.fechai=fechainicio;
		this.fechaf=fechafinal;
		assert(maxAlumnos>0);
		this.maxAlumnos=maxAlumnos;
		this.alumnos = new ArrayList<Alumno>();
		Curso.nextID=Curso.nextID+1;
		
	}
	/**getPrecio: Getter del precio del curso.
	 * 
	 * @return precio del curso
	*/
	public double getPrecio(){
		return precio;
	}
	/**getNalumnos: Getter del numero del alumnos.
	 * 
	 * @return alumnos.size
	*/
	public int getNalumnos(){
		return alumnos.size();
	}
	
	/**getMaxalumnos: Getter del maximo de alumnos de un curso.
	 * 
	 * @return maxAlumnos
	*/
	public int getMaxalumnos() {
		return maxAlumnos;
	}
	/**getIdioma: Getter del idioma de un curso.
	 * 
	 * @return idioma de un curso
	*/
	public String getIdioma() {
		return idioma;
	}
	
	/**getAlumnos: Getter del ArrayList alumnos.
	 * 
	 * @return devuelve una copia del ArrayList alumnos
	*/
	public ArrayList<Alumno> getAlumnos() {
		ArrayList<Alumno> copia = new ArrayList<Alumno>();
		for(int i=0;i<alumnos.size();i++){
				copia.add(alumnos.get(i));
		}
		return copia;
	}	
	
	/**setAlumnos: Setter que annade un alumno al arrayList alumnos.
	 * 
	 * @requires alumno exista
	 * @ensures el arraylist alumno aumente en uno su tamaño
	 * @param alumno de un curso
	*/
	public void setAlumnos(Alumno alumno) {
		int tam=alumnos.size();
		assert(alumno!=null);
		alumnos.add(alumno);
		assert(alumnos.size()==tam+1);
	}
	/**rmAlumnos: Procedimiento que elimina un alumno del arrayList alumnos.
	 * 
	 * @requires alumno exista
	 * @ensures el arraylist alumno disminuya en uno su tamaño
	 * @param alumno de un curso
	*/
	public void rmAlumnos(Alumno alumno){
		int tam=alumnos.size();
		assert(alumno!=null);
		alumnos.remove(alumno);
		assert(alumnos.size()==tam-1);
	}
	/**
	 * getId getter de la id del curso.
	 * @return id del curso.
	 */
	public int getId() {
		return id;
	}
	/**getFechai: Getter de la fecha en la que se inicia un curso.
	 * 
	 * @return fechai de un curso
	*/
	public GregorianCalendar getFechai() {
		return fechai;
	}
	/**getFechaf: Getter de la fecha en la que finaliza un curso.
	 * 
	 * @return fechaf de un curso
	*/
	public GregorianCalendar getFechaf() {
		return fechaf;
	}
	/**comprobarRepetido: Funcion que comprueba si un alumno pertenece al arrayList alumnos (Ya esta matriculado en el curso).
	 * 
	 * @requires alumno exista
	 * @param alumno que se va a comprobar
	 * @return alumnos.contains(alumno) true si pertenece, false si no.
	*/
	public boolean comprobarRepetido(Alumno alumno){
		assert(alumno!=null);
		return !alumnos.contains(alumno);
	}
	/**comprobarMaximo: Funcion que comprueba si el curso esta lleno.
	 * 
	 * @return true si no esta lleno, false si lo esta.
	*/
	public boolean comprobarMaximo(){
		if (alumnos.size()<maxAlumnos){
			return true;
		}else{
			return false;
		}
	}		
}
