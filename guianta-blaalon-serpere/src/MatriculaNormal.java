/** Clase MatriculaNormal, hereda de Matricula
 *  Representa la inscripcion de un junior o adulto en un curso normal
 * 
 * @author Blanca Alonso Prieto
 * @author Sergio Pérez
 * @author Guillermo Anta
 *
 */
public class MatriculaNormal extends Matricula {
	
	/** Constructor de MatriculaNormal: hereda el alumno y el curso de la clase padre.
	 * 
	 * @param alumno a matricular
	 * @param curso donde matricular
	 */
	public MatriculaNormal(Alumno alumno, Curso curso) {
		super(alumno, curso);
	}
	
	/**comprobarCambio: comprueba que se puede realizar el cambio, es decir que el curso al que te quieres cambiar es del mismo idioma que
	 * el curso en el que estas y se diferencia en uno en el nivel
	 * 
	 * @requires curso sea cursonormal
	 * @requires curso exista
	 * @param curso al que se quiere cambiar
	 * @return true si se puede false si no
	 */
	public boolean comprobarCambio(CursoNormal curso){
		assert(curso!=null);
		assert(curso instanceof CursoNormal);
		CursoNormal este = (CursoNormal) this.getCurso();
		if(this.getCurso().getIdioma()==curso.getIdioma() && Math.abs(este.getNivel()-curso.nivel)==1){
			return true;
		}else{
			return false;
		}	
	}
	/**cambiar_nivel: cambia al alumno de nivel.
	 * 
	 * @requires curso sea cursonormal
	 * @requires curso exista
	 * @param curson al que se quiere cambiar
	 * @ensures el alumno ha cambiado de curso.
	 */
	public void cambiar_nivel(CursoNormal curson){
			assert(curson!=null);
			assert(curson instanceof CursoNormal);
			super.getCurso().rmAlumnos(super.getAlumno());
			super.setCurso(curson);
			curson.setAlumnos(super.getAlumno()); 
			assert(!curson.comprobarRepetido(super.getAlumno()));
		
	}
	
}
