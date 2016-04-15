import java.util.Calendar;
import java.util.GregorianCalendar;
/** Clase Junior, que hereda de Alumno.
 * Tiene informacion sobre la fecha de nacimiento y el adulto responsable.
 * 
 * @author Blanca Alonso Prieto
 * @author Sergio Pérez
 * @author Guillermo Anta
 */
public class Junior extends Alumno {
	

	private GregorianCalendar f_nacimiento;
	private Adulto responsable;
	
	
	/**Constructor Junior: hereda el nombre y los apellidos de la clase padre y comprueba que hay una fecha de nacimiento, que la edad es la correcta y que existe un responsable
	 * 
	 * @requires responsable exista
	 * @requires tenga 17 o menos años
	 * @requires fecha de nacimiento exista
	 * @param nombre del alumno
	 * @param apellidos del alumno
	 * @param f_nacimiento del alumno
	 * @param responsable del alumno
	 */
	public Junior (String nombre,String apellidos, GregorianCalendar f_nacimiento, Adulto responsable){
		super(nombre,apellidos);
		assert(f_nacimiento!=null);
		assert (comprobarEdad(f_nacimiento));
		assert(responsable!=null);
		responsable.setJuniors(this);
		this.responsable=responsable;
		this.f_nacimiento=f_nacimiento;
		
	}
	

	@Override
	/**getDeuda: Getter de deuda
	 * 
	 * @return 0
	 */
	public double getDeuda(){	
		return 0;
	}
	/**getFnacimiento: Getter de f_nacimiento
	 * 
	 * @return f_nacimiento
	 */
	public Calendar getFnacimiento() {
		return f_nacimiento;
	}
	/** getResponsable: Getter de responsable
	 * 
	 * @return responsable
	 */
	public Adulto getResponsable() {
		return responsable;
	}
	/** comprobarEdad: Comprueba que el alumno tiene 17 o menos años
	 * 
	 * @param fnacimiento del Junior
	 * @return true/false 
	 */
	public boolean comprobarEdad(GregorianCalendar fnacimiento) {
		Calendar hoy = new GregorianCalendar();
		hoy.set(Calendar.YEAR, hoy.get(Calendar.YEAR)-17);
		int x = hoy.compareTo(fnacimiento);
		if (x<0){
			return true;
		}else{
			return false;
		}
	}
}
