import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**Clase Academia: Comprueba el buen funcionamiento del resto de las clases. 
 * Esta clase crea y mantiene la lista de cursos, alumnos y matrículas. 
 * Comprueba si se dan las condiciones previas para las matrículas y si es posible crearlas.
 * Contiene el main y los métodos que imprimen las listas de cursos, alumnos, matrículas,
 * los cursos de un alumno, los alumnos de un curso y las matrículas sin pagar
 * @author Blanca Alonso Prieto
 * @author Sergio Pérez
 * @author Guillermo Anta
*/
public class Academia {

		private ArrayList<Alumno> alumnos;
		private ArrayList<Curso> cursos;
		private ArrayList<Matricula> matriculas;
	
		/**Constructor Academia: Crea e inicializa Academia creando sus respectivas listas.
		 * 
		 */
	public Academia(){
		
		this.alumnos = new ArrayList<Alumno>();
		this.cursos = new ArrayList<Curso>();
		this.matriculas = new ArrayList<Matricula>();
		
	}
	/**
	 * adultos: crea una lista con los adultos de la lista de alumnos.
	 * @return lista de adultos.
	 */
	private ArrayList<Adulto> adultos(){
		ArrayList<Adulto> adulto = new ArrayList<Adulto>();
		for (int i=0;i<alumnos.size();i++){
			if(alumnos.get(i) instanceof Adulto){
				adulto.add((Adulto) alumnos.get(i));
			}
		}
		return adulto;
	}
	/**
	 * juniors: crea una lista con los juniores de la lista de alumnos.
	 * @return lista de juniors.
	 */
	private ArrayList<Junior> juniors(){
		ArrayList<Junior> junior = new ArrayList<Junior>();
		for(int i=0;i<alumnos.size();i++){
			if(alumnos.get(i) instanceof Junior){
				junior.add((Junior) alumnos.get(i));
			}
		}
		return junior;
	}
	/**
	 * matriculasJunior crea una lista de las matriculas junior de la lista de matriculas.
	 * @return lista de matriculas junior.
	 */
	private ArrayList<MatriculaJunior> matriculasJunior (){
		ArrayList<MatriculaJunior> matriculasJunior = new ArrayList<MatriculaJunior>();
		for (int i = 0;i<matriculas.size();i++)
			if (matriculas.get(i) instanceof MatriculaJunior)
				matriculasJunior.add((MatriculaJunior) matriculas.get(i));
		return matriculasJunior;
	}
	/**
	 * matriculasNormales crea una lista de las matriculas normales de la lista de matriculas.
	 * @return lista de matriculas normales.
	 */
	private ArrayList<MatriculaNormal> matriculasNormales (){
		ArrayList<MatriculaNormal> matriculasNormales = new ArrayList<MatriculaNormal>();
		for (int i = 0;i<matriculas.size();i++)
			if (matriculas.get(i) instanceof MatriculaNormal)
				matriculasNormales.add((MatriculaNormal) matriculas.get(i));
		return matriculasNormales;
	}
	/**
	 * cursosNormales crea una lista de los cursos normales de la lista de cursos.
	 * @return lista de cursos normales.
	 */
	private ArrayList<CursoNormal> cursosNormales(){
		ArrayList<CursoNormal> normales = new ArrayList<CursoNormal>();
		for(int i=0;i<cursos.size();i++){
			if(cursos.get(i) instanceof CursoNormal){
				normales.add((CursoNormal) cursos.get(i));
			}
		}
		return normales;
	}
	/**
	 * cursosJunior crea una lista de cursos junior de la lista de cursos.
	 * @return
	 */
	private ArrayList<CursoJunior> cursosJunior(){
		ArrayList<CursoJunior> juniors = new ArrayList<CursoJunior>();
		for(int i=0;i<cursos.size();i++){
			if(cursos.get(i) instanceof CursoJunior){
				juniors.add((CursoJunior) cursos.get(i));
			}
		}
		return juniors;
	}
	/**
	 * imatricula imprime la lista de todas las matriculas de la academia.
	 */
	private void imatricula(){
		System.out.println("\n-----Numero total de matriculas: " +matriculas.size() +"\n");
		System.out.println ("-Numero total de matriculas junior: "+matriculasJunior().size()+"\n");
		for(int i=0;i<matriculasJunior().size();i++){
			String estado;
			if(matriculas.get(i).isPagada()){
				estado = "Pagada";
			}else{
				estado = "Pendiente de pago";
			}
			System.out.println("   La matricula " 
					+matriculasJunior().get(i).getNmatricula() 	
					+" pertenece al alumno "  
					+matriculasJunior().get(i).getAlumno().getNombre() +" " 
					+matriculasJunior().get(i).getAlumno().getApellidos() +", cuyo responsable es "
					+((Junior) matriculasJunior().get(i).getAlumno()).getResponsable().getNombre()+" "
					+((Junior) matriculasJunior().get(i).getAlumno()).getResponsable().getApellidos()
					+" (" +estado +")" +"\n"
					+" del curso "
					+matriculasJunior().get(i).getCurso().getIdioma()
					+"\n");
		}
		System.out.println("---Numero total de matriculas normales: "+matriculasNormales().size()+"\n");
		for(int i=0;i<matriculasNormales().size();i++){
			String estado;
			if(matriculas.get(i).isPagada()){
				estado = "Pagada";
			}else{
				estado = "Pendiente de pago";
			}
			
			if(matriculasNormales().get(i).getAlumno() instanceof Adulto){
				System.out.println("   La matricula " 
						+matriculasNormales().get(i).getNmatricula() 	
						+" es de  "  
						+matriculasNormales().get(i).getAlumno().getNombre() +" " 
						+matriculasNormales().get(i).getAlumno().getApellidos() +", con DNI:"
						+((Adulto)matriculasNormales().get(i).getAlumno()).getDni()
						+" (" +estado +")" +"\n"
						+" del curso "
						+matriculasNormales().get(i).getCurso().getIdioma()
						+" con nivel "
						+((CursoNormal)matriculasNormales().get(i).getCurso()).getNivel()
						+"\n");
			}else{
				System.out.println("La matricula " 
						+matriculasNormales().get(i).getNmatricula() 	
						+" pertenece al alumno "  
						+matriculasNormales().get(i).getAlumno().getNombre() +" " 
						+matriculasNormales().get(i).getAlumno().getApellidos() +" ("
						+((Junior)matriculasNormales().get(i).getAlumno()).getFnacimiento().get(Calendar.YEAR)
						+"/"
						+((Junior)matriculasNormales().get(i).getAlumno()).getFnacimiento().get(Calendar.MONTH)
						+"/"
						+((Junior)matriculasNormales().get(i).getAlumno()).getFnacimiento().get(Calendar.YEAR)
						+") "
						+" (" +estado +")" +"\n"
						+" del curso "
						+matriculasNormales().get(i).getCurso().getIdioma()
						+" con nivel "
						+((CursoNormal)matriculasNormales().get(i).getCurso()).getNivel()
						+"\n");
			}
		}
	}
	/**
	 * ialumnos imprime la lista de todos los alumnos de la academia.
	 */
	private void ialumnos(){
		int i,x;
		System.out.println("\n--El número total de adultos de la academia es: "+adultos().size()+"--\n");
		for(i=0;i<adultos().size();i++){
			System.out.println("    El alumno: "
					+adultos().get(i).getNombre()+" "
					+adultos().get(i).getApellidos()
					+" con DNI "
					+adultos().get(i).getDni()
					+" ("
					+adultos().get(i).getDeuda()
					+"€)\n ");
			if(adultos().get(i).getJuniors().size()!=0){
				System.out.println("    --Es el responsable de: \n");
				for(x=0;x<adultos().get(i).getJuniors().size();x++){
					System.out.println("       "
							+adultos().get(i).getJuniors().get(x).getNombre()
							+" "
							+adultos().get(i).getJuniors().get(x).getApellidos()
							+"\n");
				}
			}
		}
		System.out.println("--El número total de juniors de la academia "+juniors().size()+"--\n");
		for(i=0;i<juniors().size();i++){
			System.out.println("    El alumno: "
					+juniors().get(i).getNombre()
					+" "
					+juniors().get(i).getApellidos()
					+" ("
					+juniors().get(i).getFnacimiento().get(Calendar.DATE)
					+"/"
					+juniors().get(i).getFnacimiento().get(Calendar.MONTH)
					+"/"
					+juniors().get(i).getFnacimiento().get(Calendar.YEAR)
					+") ("
					+juniors().get(i).getResponsable().getNombre()
					+" "
					+juniors().get(i).getResponsable().getApellidos()
					+")\n");
		}
		
	}
	/**
	 * icursos imprime la lista de todos los cursos de la academia.
	 */
	private void icurso(){
		int i;
		System.out.println("\n--Numero total de cursos normales: " +cursosNormales().size() +"--\n");
		for(i=0;i<cursosNormales().size();i++){
			System.out.println("    -El curso "+cursosNormales().get(i).getIdioma()
					+" con nivel "
					+cursosNormales().get(i).getNivel()
					+" con precio "
					+cursosNormales().get(i).getPrecio()
					+"€ ("
					+cursosNormales().get(i).getNalumnos()
					+"/"
					+cursosNormales().get(i).getMaxalumnos()
					+")\n");
		}
		System.out.println("\n--Número total de cursos junior: "+cursosJunior().size()+"--\n");
		for(i=0;i<cursosJunior().size();i++){
			System.out.println("    -El curso "+cursosJunior().get(i).getIdioma()
					+" de los "
					+cursosJunior().get(i).getE_minima()
					+" a los "
					+cursosJunior().get(i).getE_maxima()
					+" con precio "
					+cursosJunior().get(i).getPrecio()
					+"€ ("
					+cursosJunior().get(i).getNalumnos()
					+"/"
					+cursosJunior().get(i).getMaxalumnos()
					+")\n");
		}
	}
	/**
	 * ialumnoscurso imprime una lista de los alumnos matriculados en un curso.
	 * @param curso a comprobar.
	 */
	private void ialumnoscurso(Curso curso){
		if(curso instanceof CursoNormal){
			System.out.println("---Los alumnos del curso "+curso.getIdioma()
				+" con nivel "
				+((CursoNormal)curso).getNivel()
				+" son: \n");
			for(int i=0;i<curso.getAlumnos().size();i++){
				System.out.println("  "
						+curso.getAlumnos().get(i).getNombre()
						+" "
						+curso.getAlumnos().get(i).getApellidos());
				if(curso.getAlumnos().get(i) instanceof Adulto){
					System.out.println(" (Adulto)\n");
				}else{
					System.out.println(" (Junior)\n");
				}
			}		
		}else{
			System.out.println("---Los alumnos del curso "+curso.getIdioma()
				+" ("
				+((CursoJunior)curso).getE_minima()
				+"-"
				+((CursoJunior)curso).getE_maxima()
				+")"
				+" son: \n");
			for(int i=0;i<curso.getAlumnos().size();i++){
				System.out.println("  "
					+curso.getAlumnos().get(i).getNombre()
					+" "
					+curso.getAlumnos().get(i).getApellidos()
					+" (Junior)\n");
				
			}
		}
	}
	/**
	 * icursosalumno imprime una lista de los cursos de un alumno.
	 * @param alumno a comprobar.
	 */
	private void icursosalumno(Alumno alumno){
		CursoNormal normal;
		CursoJunior junior;
		if(alumno instanceof Adulto){
			System.out.println("\nLos cursos del alumno "
					+alumno.getNombre()
					+" "
					+alumno.getApellidos()
					+" son:\n");
			for(int i=0;i<alumno.getMatriculas().size();i++){
					if(alumno.getMatriculas().get(i).getCurso() instanceof CursoNormal){
						normal =(CursoNormal)alumno.getMatriculas().get(i).getCurso();
						System.out.println(normal.getIdioma()
						+" con nivel "
						+normal.getNivel());
					}
			}
		}else{
			System.out.println("\nLos cursos del alumno "
					+alumno.getNombre()
					+" "
					+alumno.getApellidos()
					+" son:\n");
			for(int i=0;i<alumno.getMatriculas().size();i++){
					if(alumno.getMatriculas().get(i).getCurso() instanceof CursoJunior){
						junior = (CursoJunior) alumno.getMatriculas().get(i).getCurso();
						System.out.println(junior.getIdioma()
								+" ("
								+junior.getE_minima()
								+"-"
								+junior.getE_maxima()
								+")");
					}else{
						normal = (CursoNormal) alumno.getMatriculas().get(i).getCurso();
						System.out.println(normal.getIdioma()
								+" con nivel "
								+normal.getNivel());
					}
			}
		}
	}
	/**
	 * comprobarEdad comprueba si la edad es mayor o menor a 17 años
	 * @param fnacimiento del junior a comprobar
	 * @return true si tiene menos de 17, false si no
	 */
	public boolean comprobarEdad (GregorianCalendar fnacimiento){
			Calendar hoy = new GregorianCalendar();
			hoy.set(Calendar.YEAR, hoy.get(Calendar.YEAR)-17);
			int x = hoy.compareTo(fnacimiento);
			if (x<0){
				return true;
			}else{
				return false;
			}
		}
	/**
	 * inopagadas imprime la lista de matriculas no pagadas de un curso.
	 * @param curso a comprobar.
	 */
	private void inopagadas(Curso curso) {
		
		if(curso instanceof CursoNormal){
			System.out.println("\nLas matriculas no pagadas del curso " 
						+curso.getIdioma()
						+" con nivel "
						+((CursoNormal)curso).getNivel()
						+" son:\n");
			for(int i=0;i<curso.getAlumnos().size();i++){
				for (int j = 0; j < curso.getAlumnos().get(i).getMatriculas().size(); j++) {
					if (curso.getAlumnos().get(i).getMatriculas().get(j).getCurso() == curso) {
						if (curso.getAlumnos().get(i).getMatriculas().get(j).isPagada() == false) {
							System.out.println("--La matricula del alumno: " 
									+ curso.getAlumnos().get(i).getNombre() 
									+ " "
									+ curso.getAlumnos().get(i).getApellidos());
						}
					}
				}
			}
		}else{
			System.out.println("\nLas matriculas no pagadas del curso " 
					+curso.getIdioma()
					+" ("
					+((CursoJunior)curso).getE_minima()
					+"-"
					+((CursoJunior)curso).getE_maxima()
					+") son:\n");
		for(int i=0;i<curso.getAlumnos().size();i++){
			for (int j = 0; j < curso.getAlumnos().get(i).getMatriculas().size(); j++) {
				if (curso.getAlumnos().get(i).getMatriculas().get(j).getCurso() == curso) {
					if (curso.getAlumnos().get(i).getMatriculas().get(j).isPagada() == false) {
						System.out.println("--La matricula del alumno: " 
								+ curso.getAlumnos().get(i).getNombre() 
								+ " "
								+ curso.getAlumnos().get(i).getApellidos());
					}
				}
			}
		}
		}
	}
	/**
	 * erroresAlumno prueba el correcto funcionamiento de las clases Alumno Adulto y Junior.
	 */
	private  void erroresAlumno(){
	
		Adulto prueba1 = new Adulto("Prueba", "Errores","12424242E");
		Junior prueba2 = new Junior("Pueba", "Errores",new GregorianCalendar(1999,0,1),prueba1);
		
		try{
			prueba1.setJuniors(null);
			}
        catch (AssertionError e) {System.out.println("*** Error en el assert (junior!=null) del metodo setJuniors() (Adulto).");}
		
		try{
			prueba1 = new Adulto(null,"Errores","12233454H");
			}
		catch (AssertionError e) {System.out.println("*** Error en el assert (nombre!=null) del constructor (Alumno).");}
		
		try{
			prueba2 = new Junior("Prueba",null,new GregorianCalendar(1999,0,1),prueba1);
			}
		catch (AssertionError e) {System.out.println("*** Error en el assert (apellidos!=null) del constructor (Alumno).");}
		
		try{
			prueba1.setMatriculas(null);
			}
		catch (AssertionError e) {System.out.println("*** Error en el assert (matricula!=null) del metodo setMatriculas() (Alumno).");}
		
		try{
			prueba1= new Adulto("Prueba", "Error",null);
			}
		catch (AssertionError e) {System.out.println("*** Error en el assert (dni!=null) del constructor (Adulto).");}
		
		
		try{
			prueba2 = new Junior("Pueba", "Errores",null,prueba1);	
			}
		catch (AssertionError e) {System.out.println("*** Error en el assert (f_nacimiento!=null) del constructor (Junior).");}
		
		try{
			prueba2 = new Junior("Pueba", "Errores",new GregorianCalendar(1994,6,21),prueba1);
			}
		catch (AssertionError e) {System.out.println("*** Error en el assert (edad>17) del constructor (Junior).");}
		
		if(prueba2.getDeuda()!=0)
			System.out.println("*** Error en el metoto getDeuda() (Junior)");
	}
	/**
	 * erroresCurso prueba el correcto funcionamiento de las clases Curso CursoNormal y CursoJunior.
	 */
	private void erroresCurso() {
		CursoNormal prueba = new CursoNormal("Prueba",50,new GregorianCalendar(2016,0,8,9,00),new GregorianCalendar(2016,6,23,10,00),20, 1);
		CursoJunior prueba2 = new CursoJunior("Prueba", 15.50,new GregorianCalendar(2016,0,8,9,00),new GregorianCalendar(2016,6,23,10,00),10,15,13);
		
		try{
			prueba= new CursoNormal(null,50,new GregorianCalendar(2016,0,8,9,00),new GregorianCalendar(2016,6,23,10,00),20, 1);
		}
		catch (AssertionError e){System.out.println("***Error en el assert (idioma!=null) del constructor (Curso).");}
		
		try{
			prueba2 = new CursoJunior("Prueba", 0,new GregorianCalendar(2016,0,8,9,00),new GregorianCalendar(2016,6,23,10,00),10,15,13);
		}
		catch (AssertionError e){System.out.println("***Error en el assert (precio>0) del constructor (Curso).");}
		
		try{
			prueba2 = new CursoJunior("Prueba", 0,new GregorianCalendar(2016,6,23,10,002),new GregorianCalendar(016,0,8,9,00),10,15,13);
		}
		catch (AssertionError e){System.out.println("***Error en el assert (fechainicio<fechafinal) del constructor (Curso).");}
		
		try{
			prueba= new CursoNormal("Prueba",50,new GregorianCalendar(2016,0,8,9,00),new GregorianCalendar(2016,6,23,10,00),0, 1);
		}
		catch (AssertionError e){System.out.println("***Error en el assert (idioma!=null) del constructor (Curso).");}
		
		try{
			prueba.setAlumnos(null);
		}
		catch (AssertionError e){System.out.println("***Error en el assert (alumno!=null) del metodo setAlumnos() (Curso).");}
		
		try{
			prueba2.rmAlumnos(null);
		}
		catch (AssertionError e){System.out.println("***Error en el assert (alumno!=null) del metodo rmAlumnos() (Curso).");}
		
		try{
			prueba.comprobarRepetido(null);
		}
		catch (AssertionError e){System.out.println("***Error en el assert (alumno!=null) del metodo comprobarRepetido() (Curso).");}
		
		try{
			prueba2 = new CursoJunior("Prueba", 0,new GregorianCalendar(2016,6,23,10,002),new GregorianCalendar(016,0,8,9,00),10,0,13);
		}
		catch (AssertionError e){System.out.println("***Error en el assert (edadMinima>0) del constructor (CursoJunior).");}
		
		try{
			prueba2 = new CursoJunior("Prueba", 0,new GregorianCalendar(2016,6,23,10,002),new GregorianCalendar(016,0,8,9,00),10,15,20);
		}
		catch (AssertionError e){System.out.println("***Error en el assert (edadMaxima<17) del constructor (CursoJunior).");}
		
		try{
			prueba2 = new CursoJunior("Prueba", 0,new GregorianCalendar(2016,6,23,10,002),new GregorianCalendar(016,0,8,9,00),10,15,10);
		}
		catch (AssertionError e){System.out.println("***Error en el assert (edadMaxima>edadMinima) del constructor (CursoJunior).");}
		

		try{
			prueba= new CursoNormal("Prueba",50,new GregorianCalendar(2016,0,8,9,00),new GregorianCalendar(2016,6,23,10,00),15, -8);
		}
		catch (AssertionError e){System.out.println("***Error en el assert (nivel>=0) del constructor (CursoNormal).");}
	}
	/**
	 * erroresMatricula prueba el correcto funcionamiento de las clases Matricula MatriculaNormal y MatriculaJunior
	 */
	private void erroresMatricula(){
		CursoNormal normalprueba = new CursoNormal("Ingles",19.50,new GregorianCalendar(2016,0,8,9,00),new GregorianCalendar(2016,6,23,10,00),1, 1);
		CursoJunior juniorprueba = new CursoJunior("Ingles", 15.50,new GregorianCalendar(2016,0,8,9,00),new GregorianCalendar(2016,6,23,10,00),10,13,6);
		Adulto adultoprueba = new Adulto("Prueba","Error","1111111A");
		Junior ninioprueba = new Junior("Prueba", "Error",new GregorianCalendar(2000,0,8), adultoprueba);
		MatriculaNormal prueba = new MatriculaNormal(adultoprueba,normalprueba);
		MatriculaJunior prueba2 = new MatriculaJunior(ninioprueba, juniorprueba,111111111);
		
		try{
			prueba = new MatriculaNormal(adultoprueba,null);
		}
		catch(AssertionError e){System.out.println("*** Error en el assert (curso!=null) del constructor (Matricula).");}
		
		try{
			prueba = new MatriculaNormal(null,normalprueba);
		}
		catch(AssertionError e){System.out.println("*** Error en el assert (alumno!=null) del constructor (Matricula).");}
		
		try{
			prueba = new MatriculaNormal(ninioprueba,normalprueba);
		}
		catch(AssertionError e){System.out.println("*** Error en el assert (comprobarMaximo()) del constructor (Matricula).");}
		
		try{
			prueba = new MatriculaNormal(adultoprueba,normalprueba);
		}
		catch(AssertionError e){System.out.println("*** Error en el assert (comprobarRepetido(alumno)) del constructor (Matricula).");}
		
		
		try{
			prueba2.setCurso(null);
		}
		catch(AssertionError e){System.out.println("*** Error en el assert(curso!=null) del metodo setCurso (Matricula).");}
		
		try{
			prueba2.comprobarEdad(null, ninioprueba);
		}
		catch(AssertionError e){System.out.println("*** Error en el assert(curso!=null) del metodo comprobarEdad (MatriculaJunior).");}
		
		try{
			prueba2.comprobarEdad(juniorprueba, null);
		}
		catch(AssertionError e){System.out.println("*** Error en el assert(alumno!=null) del metodo comprobarEdad (MatriculaJunior).");}
		
		try{
			prueba2 = new MatriculaJunior(ninioprueba, juniorprueba,0);
		}
		catch(AssertionError e){System.out.println("*** Error en el assert(telefono>0) del constructor (MatriculaJunior).");}
		
		try{
			Junior ninioprueba2 = new Junior("Prueba", "Error",new GregorianCalendar(1996,0,8), adultoprueba);
			prueba2 = new MatriculaJunior(ninioprueba2, juniorprueba,0);
		}
		catch(AssertionError e){System.out.println("*** Error en el assert(comprobarEdad()) del constructor (MatriculaJunior).");}
		
		try{
			prueba.cambiar_nivel(null);
		}
		catch(AssertionError e){System.out.println("*** Error en el assert(curso!=null) del metodo cambiar_nivel (MatriculaNormal).");}
		
	}
	
	
	public static void main(String[] args) {
		Academia primera = new Academia();
		
		//Fecha de comienzo y fin de los cursos
		GregorianCalendar comienzoCursos = new GregorianCalendar(2016,0,8,9,00);
		GregorianCalendar finCursos = new GregorianCalendar(2016,6,23,10,00);
		
		
		//Creamos los cursos normales comprobando que las fechas son correctas
		CursoNormal NIn1 = null;
		if(comienzoCursos.compareTo(finCursos)<0)
		NIn1 = new CursoNormal("Ingles",19.50,comienzoCursos,finCursos,20, 1);
		primera.cursos.add(NIn1);
		
		CursoNormal NIn2 = null;
		if(comienzoCursos.compareTo(finCursos)<0)
		NIn2 = new CursoNormal("Ingles",29.50,comienzoCursos,finCursos,15,2);
		primera.cursos.add(NIn2);
		
		CursoNormal NIn3 = null;
		if(comienzoCursos.compareTo(finCursos)<0)
		NIn3 = new CursoNormal("Ingles",39.50,comienzoCursos,finCursos,10,3);
		primera.cursos.add(NIn3);
		
		CursoNormal NAl1 = null;
		if(comienzoCursos.compareTo(finCursos)<0)
		NAl1 = new CursoNormal("Aleman",39.50,comienzoCursos,finCursos,20,1);
		primera.cursos.add(NAl1);
		
		CursoNormal NFr1 = null;
		if(comienzoCursos.compareTo(finCursos)<0)
		NFr1 = new CursoNormal("Frances",39.50,comienzoCursos,finCursos,10,1);
		primera.cursos.add(NFr1);
		
		CursoNormal NCn1 = null;
		if(comienzoCursos.compareTo(finCursos)<0)
		NCn1 = new CursoNormal("Cantones",39.50,comienzoCursos,finCursos,5,1);
		primera.cursos.add(NCn1);
		
		//Creamos los cursos Junior comprobando que las fechas son correctas.
		
		CursoJunior JIn1 = null;
		if(comienzoCursos.compareTo(finCursos)<0)
		JIn1 = new CursoJunior("Ingles", 15.50,comienzoCursos,finCursos,10,13,6);
		primera.cursos.add(JIn1);
		
		CursoJunior JAl1 = null;
		if(comienzoCursos.compareTo(finCursos)<0)
		JAl1 = new CursoJunior("Aleman", 15.50,comienzoCursos,finCursos,10,15,13);
		primera.cursos.add(JAl1);

		CursoJunior JFr1 = null;
		if(comienzoCursos.compareTo(finCursos)<0)
		JFr1 = new CursoJunior("Frances", 15.50,comienzoCursos,finCursos,10,17,15);
		primera.cursos.add(JFr1);
		
		CursoJunior JCn1 = null;
		if(comienzoCursos.compareTo(finCursos)<0)
		JCn1 = new CursoJunior("Cantones", 15.50,comienzoCursos,finCursos,10,17,5);
		primera.cursos.add(JCn1);
		
		//Creamos los alumnos adultos 
		Adulto gAA_A = new Adulto ("Guillermo","Anta","12424235A");
		primera.alumnos.add (gAA_A);
		Adulto bAP_A = new Adulto("Blanca","Alonso","12345678B");
		primera.alumnos.add (bAP_A);
		Adulto sPH_A = new Adulto("Sergio","Perez","98765432C");
		primera.alumnos.add(sPH_A);
		Adulto vPR_A = new Adulto("Valle", "Pérez","71173110R");
		primera.alumnos.add (vPR_A);
		Adulto aCR_A = new Adulto("Adrian", "Calvo", "71112233T");
		primera.alumnos.add (aCR_A);
		
		//Creamos los alumnos Junior comprobando que tienen <17 años
		Junior mr = null;
		GregorianCalendar cmr = new GregorianCalendar(1999,10,20);
		if(primera.comprobarEdad(cmr)){
			mr = new Junior("Mateo", "Ruiz", cmr, vPR_A);
			primera.alumnos.add(mr);
		}
		
		Junior ag = null;
		GregorianCalendar cag = new GregorianCalendar(2000,1,2);
		if(primera.comprobarEdad(cag)){
			ag = new Junior("Ana", "Gonzalez", cag, gAA_A);
			primera.alumnos.add(ag);
		}
		
		Junior ap = null;
		GregorianCalendar cap = new GregorianCalendar(2003,5,6);
		if(primera.comprobarEdad(cap)){
			ap = new Junior("Alejandro","Perez", cap, sPH_A);
			primera.alumnos.add(ap);
		}
		
		Junior cv = null;
		GregorianCalendar ccv = new GregorianCalendar(2005,8,21);
		if(primera.comprobarEdad(ccv)){
			cv = new Junior("Carlos","Vega", ccv, gAA_A);
			primera.alumnos.add(cv);
		}
		
		Junior ma = null;
		GregorianCalendar cma = new GregorianCalendar(1999,9,9);
		if(primera.comprobarEdad(cma)){
			ma = new Junior("Magdalena","Alvarez", cma, bAP_A);
			primera.alumnos.add(ma);
		}
			
		//Creamos las matriculas Junior comprobando que el curso es tipo junior y que se puede matricular al alumno en el
		Matricula mri1 = null;
		if(JIn1 instanceof CursoJunior){
			if (JIn1.comprobarMaximo() && JIn1.comprobarRepetido(mr)){
				if(mr instanceof Junior){
				mri1 = new MatriculaJunior(mr,JIn1,698974123);
				primera.matriculas.add(mri1);
				}
			}
		}else{
			if (NIn1.comprobarMaximo() && NIn1.comprobarRepetido(mr)){
				mri1 = new MatriculaNormal(mr,NIn1);
				primera.matriculas.add(mri1);
			}
		}
		
		Matricula agfr1 = null;
		if(JFr1 instanceof CursoJunior){
			if (JFr1.comprobarMaximo() && JFr1.comprobarRepetido(ag)){
				if(ag instanceof Junior){
				agfr1 = new MatriculaJunior(ag,JFr1,678594032);
				primera.matriculas.add(agfr1);
				}
			}
		}else{
			if (NFr1.comprobarMaximo() && NFr1.comprobarRepetido(ag)){
				agfr1 = new MatriculaNormal(ag,NFr1);
				primera.matriculas.add(agfr1);
			}
		}
		
			
		Matricula apal1 = null;
		if(JAl1 instanceof CursoJunior){
			if (JAl1.comprobarMaximo() && JAl1.comprobarRepetido(ap)){
				if(ap instanceof Junior){
				apal1 = new MatriculaJunior(ap,JAl1,63256321);
				primera.matriculas.add(apal1);
				}
			}
		}else{
			if (NAl1.comprobarMaximo() && NAl1.comprobarRepetido(ap)){
				apal1 = new MatriculaNormal(ap,NAl1);
				primera.matriculas.add(apal1);
			}
		}
		
		Matricula cvcn1 = null;
		if(JCn1 instanceof CursoJunior){
			if (JCn1.comprobarMaximo() && JCn1.comprobarRepetido(cv)){
				if(cv instanceof Junior){
				cvcn1 = new MatriculaJunior(cv,JCn1,67859444);
				primera.matriculas.add(cvcn1);
				}
			}
		}else{
			if (NFr1.comprobarMaximo() && NFr1.comprobarRepetido(ag)){
				cvcn1 = new MatriculaNormal(ag,NFr1);
				primera.matriculas.add(cvcn1);
			}
		}
		
		Matricula main1 = null;
		if(JIn1 instanceof CursoJunior){
			if (JIn1.comprobarMaximo() && JIn1.comprobarRepetido(ma)){
				if(ma instanceof Junior){
				main1 = new MatriculaJunior(ma,JIn1,67339444);
				primera.matriculas.add(main1);
				}
			}
		}else{
			if (NIn1.comprobarMaximo() && NIn1.comprobarRepetido(ma)){
				main1 = new MatriculaNormal(ma,NIn1);
				primera.matriculas.add(main1);
			}
		}
		
		
		//Creamos las matriculas normales comprobando que podemos matricular a el alumno en el curso.
		MatriculaNormal manin1 =null;
		if(NIn1.comprobarMaximo()&&NIn1.comprobarRepetido(ma)){
			manin1 = new MatriculaNormal(ma,NIn1);
			primera.matriculas.add(manin1);
		}
		MatriculaNormal gAAI1 = null;
		if(NIn1.comprobarMaximo()&& NIn1.comprobarRepetido(gAA_A)){
			gAAI1 = new MatriculaNormal(gAA_A, NIn1); 	
			primera.matriculas.add(gAAI1);}
		
		MatriculaNormal gAAA1 = null;
		if(NAl1.comprobarMaximo()&& NAl1.comprobarRepetido(gAA_A)){
			gAAA1 = new MatriculaNormal(gAA_A, NAl1); 	
			primera.matriculas.add(gAAA1);}
		
		MatriculaNormal bAPI3 = null;
		if(NIn3.comprobarMaximo()&& NIn3.comprobarRepetido(bAP_A)){
			bAPI3 = new MatriculaNormal(bAP_A, NIn3); 	
			primera.matriculas.add(bAPI3);}
		
		MatriculaNormal bAPA1 = null;
		if(NAl1.comprobarMaximo()&& NAl1.comprobarRepetido(bAP_A)){
			bAPA1 = new MatriculaNormal(bAP_A, NAl1); 	
			primera.matriculas.add(bAPA1);}
		
		MatriculaNormal sPHI2 = null;
		if(NIn2.comprobarMaximo()&& NIn2.comprobarRepetido(sPH_A)){
			sPHI2 = new MatriculaNormal(sPH_A, NIn2); 	
			primera.matriculas.add(sPHI2);}
		
		MatriculaNormal sPHA1 = null;
		if(NAl1.comprobarMaximo()&& NAl1.comprobarRepetido(sPH_A)){
			sPHA1 = new MatriculaNormal(sPH_A, NAl1); 	
			primera.matriculas.add(sPHA1);}
		
		MatriculaNormal vPA1 = null;
		if(NAl1.comprobarMaximo()&& NAl1.comprobarRepetido(vPR_A)){
			vPA1 = new MatriculaNormal(vPR_A, NAl1); 	
			primera.matriculas.add(vPA1);}
		
		MatriculaNormal aCRI1 = null;
		if(NIn1.comprobarMaximo()&& NIn1.comprobarRepetido(aCR_A)){
			aCRI1 = new MatriculaNormal(aCR_A, NIn1); 	
			primera.matriculas.add(aCRI1);}
		
		

		System.out.println("\n\n\n------------------------LISTA DE ALUMNOS---------------------------");
		primera.ialumnos();
		System.out.println("\n\n\n------------------------LISTA DE CURSOS----------------------------");
		primera.icurso();
		System.out.println("\n\n\n------------------------LISTA DE MATRICULAS------------------------");
		primera.imatricula();
		
		System.out.println("\n\n\n------------------------ALUMNOS DE UN CURSO------------------------");
		primera.ialumnoscurso(NIn1);
		primera.ialumnoscurso(NIn2);
		primera.ialumnoscurso(NIn3);
		primera.ialumnoscurso(NAl1);
		primera.ialumnoscurso(JIn1);
		primera.ialumnoscurso(JFr1);
		primera.ialumnoscurso(JAl1);
		primera.ialumnoscurso(JCn1);
		
		System.out.println("\n\n\n------------------------CURSOS DE UN ALUMNO------------------------");
		primera.icursosalumno(gAA_A);
		primera.icursosalumno(bAP_A);
		primera.icursosalumno(sPH_A);
		primera.icursosalumno(vPR_A);
		primera.icursosalumno(aCR_A);
		primera.icursosalumno(ma);
		primera.icursosalumno(ap);
		
		System.out.println("\n\n\n------------------------MATRICUALAS NO PAGADAS DE UN CURSO------------------------");
		primera.inopagadas(NAl1);
		primera.inopagadas(NIn1);
		primera.inopagadas(NIn2);
		primera.inopagadas(NIn3);
		primera.inopagadas(JIn1);
		primera.inopagadas(JAl1);
		primera.inopagadas(JCn1);
		
		System.out.println("\n------------------------SE CAMBIAN DE CURSO ALGUNOS ALUMNOS------------------------\n");
		
		if(bAPI3.comprobarCambio(NIn2)&&NIn2.comprobarMaximo()&&NIn2.comprobarRepetido(bAP_A)){
			bAPI3.cambiar_nivel(NIn2);}
		
		if(gAAI1.comprobarCambio(NIn2)&&NIn2.comprobarMaximo()&&NIn2.comprobarRepetido(gAA_A)){
			gAAI1.cambiar_nivel(NIn2);}
		
		if(manin1.comprobarCambio(NIn2)&&NIn2.comprobarMaximo()&&NIn2.comprobarRepetido(ma)){
			manin1.cambiar_nivel(NIn2);
		}
		
		System.out.println("\n------------------------SE REALIZAN ALGUNOS PAGOS------------------------\n");
		
		aCR_A.pagar(); //Adrian calvo paga deuda
		sPH_A.pagar(); //Sergio Perez paga deuda
		gAA_A.pagar(); //Guillermo Anta paga deuda
		bAP_A.pagar(); //Blanca Alonso paga deuda
		
		
		
		
		System.out.println("\n\n\n------------------------LISTA DE ALUMNOS---------------------------");
		primera.ialumnos();
		System.out.println("\n\n\n------------------------LISTA DE CURSOS----------------------------");
		primera.icurso();
		System.out.println("\n\n\n------------------------LISTA DE MATRICULAS------------------------");
		primera.imatricula();
		
		System.out.println("\nErrores de la clase Alumno, Adulto y Junior: \n");
		primera.erroresAlumno();
		System.out.println("\nErrores de la clase Curso, CursoNormal y CursoJunior:\n");
		primera.erroresCurso();
		System.out.println("\nErrrore de la clase Matricula, MatriculaNormal y MatriculaJunior:\n");
		primera.erroresMatricula();
	}

	
}
