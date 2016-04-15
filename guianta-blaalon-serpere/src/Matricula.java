/**Clase Matricula: Representa la inscripcion de un alumno en un curso concreto. 
 * Tiene un numero unico de matricula
 * Puede estar pagada o pendiente de pago (estado inicial).
 * @author Blanca Alonso Prieto
 * @author Sergio PÃ©rez
 * @author Guillermo Anta
*/
public abstract class Matricula {
	
	/**
	 * Atributo static para calcular el id en funcion del numero de matriculas
	 */
	private static int nextID;
	private int id;
	private boolean pagada;
	private Alumno alumno;
	private Curso curso;
	
	
	/**
	 * Constructor Matricula: Crea una Matricula que relaciona Curso y Alumno.
	 * Inicializa el valor del id de la matricula sumando uno al anterior.
	 * pagada define el estado de la matricula true=pagada false=pendiente, inicialmente con valor false.
	 * 
	 * @requires alumno exista
	 * @requires curso exista
	 * @requires alumno no este en el curso
	 * @requires curso no tenga el numero maximo de alumnos
	 * @param alumno que se matricula en curso
	 * @param curso en el que se matricula alumno
	 */
	public Matricula(Alumno alumno, Curso curso){
		
		assert (curso!=null);
		assert (curso.comprobarRepetido(alumno));
		assert (curso.comprobarMaximo());
		alumno.setMatriculas(this);
		curso.setAlumnos(alumno);
		this.id=Matricula.nextID;
		assert (alumno!=null);
		this.alumno=alumno;
		this.curso=curso;
		this.pagada=false;
		Matricula.nextID=Matricula.nextID+1;
	}
	/**getNmatricula: Getter del id de un curso.
	 * 
	 * @return id de un curso
	*/
	public int getNmatricula() {
		return id;
	}
	/**setPagada: Setter que cambia pagada a true (se ha pagadao la matricula).
	 * 
	 * @requires matricula no pagada
	 * @ensures matricula pagada
	*/
	public void setPagada() {
		assert(!isPagada());
		this.pagada = true;
		assert(isPagada());
	}
	/**getAlumno: Getter de un alumno.
	 * 
	 * @return alumno
	*/
	public Alumno getAlumno() {
		return alumno;
	}
	/**setCurso: Setter de un curso.
	 * 
	 * @requires curso exista.
	 * @param curso nuevo
	 * 
	*/
	public void setCurso(Curso curso){
		assert(curso!=null);
		this.curso=curso;
	}
	/**getCurso: Getter de un curso.
	 * 
	 * @return curso
	*/
	public Curso getCurso() {
		return curso;
	}
	/**isPagada: Funcion que comprueba si la matricula ha sido pagada.
	 * 
	 * @return pagada que sera true si esta pagada, false en caso contrario
	*/
	public boolean isPagada() {
		return pagada;
	}
}
