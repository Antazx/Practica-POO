import java.util.Calendar;
import java.util.GregorianCalendar;
/** Clase MatriculaJunior, que hereda de Matricula
 * Representa la inscripcion de un junior en un curso junior.
 * Tiene informacion sobre el numero de telefono
 * 
 * @author Blanca Alonso Prieto
 * @author Sergio Pérez
 * @author Guillermo Anta
 *
 */
public class MatriculaJunior extends Matricula {
	
	private int telefono;
	
	
	/** Constructor de MatriculaJunior: hereda el alumno y el curso de la clase padre.
	 * 
	 * @requires curso sea cursojunior
	 * @requires alumno sea junior
	 * @requires alumno exista
	 * @requires curso exista
	 * @requires edad de junior entre la minima y maxima
	 * @requires telefono mayor que 0
	 * @param alumno a matricular
	 * @param curso donde se va a matricular
	 * @param telefono de contacto
	 */
	public MatriculaJunior(Junior alumno, CursoJunior curso, int telefono){
		super(alumno, curso);
		assert(curso instanceof CursoJunior);
		assert(alumno instanceof Junior);
		assert(curso!=null);
		assert(alumno!=null);
		assert(comprobarEdad(curso,alumno));
		assert(telefono>0);
		this.telefono=telefono;
	}
	
	/** getTelefono: getter de telefono
	 * 
	 * @return telefono
	 */
	public int getTelefono(){
		return telefono;
	}
	
	/**comprobarEdad: comprueba que el alumno junior puede cursar un determinado curso ya que su edad se comprende entre la minima y maxima
	 * 
	 * @requires junior exista
	 * @requires cursojunior exista
	 * @param cursoj a comprobar
	 * @param alumnoj a comprobar
	 * @return true/false
	 */
	public boolean comprobarEdad(CursoJunior cursoj, Junior alumnoj) {
		
		assert(cursoj!=null);
		assert(alumnoj!=null);
		int annio,mes,dia;
		Calendar hoy = new GregorianCalendar();
		
		annio=hoy.get(Calendar.YEAR)-alumnoj.getFnacimiento().get(Calendar.YEAR);
		mes=hoy.get(Calendar.MONTH)-alumnoj.getFnacimiento().get(Calendar.MONTH);
		dia=hoy.get(Calendar.DATE)-alumnoj.getFnacimiento().get(Calendar.DATE);
		if(mes<0 ||(mes == 0 && dia<0)){
		annio--;
		}
		if(annio>=cursoj.getE_minima() || annio<cursoj.getE_maxima()){
			return true;
		}else{
			return false;
		}
	
	}
	
}
