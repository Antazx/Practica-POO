import java.util.GregorianCalendar;

/** Clase CursoJunior, que hereda de curso
 *  Tiene informacion sobre la edad minima y maxima para poder cursar dicho curso 
 * 
 *@author Blanca Alonso Prieto
 * @author Sergio Pérez
 * @author Guillermo Anta
 *
 */
public class CursoJunior extends Curso {
	
	private int e_maxima;
	private int e_minima;
	
	/** Constuctor de CursoJunior: hereda el idioma, el precio, las fechas de inicio y final del curso y la cantidad maxima de alumnosde la clase Curso.
	 * 
	 * @requires edad minima mayor a 0
	 * @requires edad maxima menor o igual a 17
	 * @requires edad maxima mayor que edad minima
	 * @param idioma del curso
	 * @param precio del curso
	 * @param fechainicio del curso
	 * @param fechafinal del curso
	 * @param maxAlumnos del curso
	 * @param edad_maxima del curso
	 * @param edad_minima del curso
	 */
	public CursoJunior(String idioma, double precio, GregorianCalendar fechainicio, GregorianCalendar fechafinal, int maxAlumnos, int edad_maxima, int edad_minima){
		super(idioma,precio,fechainicio,fechafinal,maxAlumnos);
		assert(edad_minima>0);
		assert(17>=edad_maxima);
		assert(edad_maxima>edad_minima);
		this.e_maxima=edad_maxima;
		this.e_minima=edad_minima;
	}
	/** getE_maxima: Getter de e_maxima
	 * 
	 * @return e_maxima
	 */
	public int getE_maxima() {
		return e_maxima;
	}
	/** getE_minima: Getter de e_minima
	 * 
	 * @return e_minima
	 */
	public int getE_minima() {
		return e_minima;
	}
}
