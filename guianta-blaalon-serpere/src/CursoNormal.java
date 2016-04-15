import java.util.GregorianCalendar;
/** Clase CursoNormal, que hereda de curso
 *  Tiene informacion sobre el nivel de dicho curso 
 * 
 *@author Blanca Alonso Prieto
 * @author Sergio Pérez
 * @author Guillermo Anta
 *
 */
public class CursoNormal extends Curso{
		
	int nivel;
	
	/** Constuctor de CursoNormal: hereda el idioma, el precio, las fechas de inicio y final del curso y la cantidad maxima de alumnos de curso
	 * de la clase Curso. Tambien posee el nivel del curso.
	 * 
	 * @requires nivel mayor que 0
	 * @param idioma del curso
	 * @param precio del curso
	 * @param fechainicio del curso
	 * @param fechafinal del curso
	 * @param maxAlumnos del curso
	 * @param nivel del curso
	 */		
	public CursoNormal(String idioma, double precio, GregorianCalendar fechainicio, GregorianCalendar fechafinal,int maxAlumnos
			, int nivel){
			super(idioma,precio,fechainicio,fechafinal,maxAlumnos);
			assert(nivel>0);
			this.nivel=nivel;		
	}
	/**getId: Getter del nivel de un curso normal.
	 * 
	 * @return nivel de un curso normal
	 */
	public int getNivel(){
		return nivel;
	}
}