import java.util.ArrayList;
/** Clase Adulto, que hereda de Alumno.
 *  Tiene información sobre el DNI del alumno
 * 
 * @author Blanca Alonso Prieto
 * @author Sergio Pérez
 * @author Guillermo Anta
 *
 */
public class Adulto extends Alumno {
	

	private String dni;
	private ArrayList<Junior> juniors;
	
	/** Constructor de Adulto: Recibe el nombre y apellidos de la clase padre.
	 * Crea el ArrayList Junior
	 * 
	 * @requires exista el dni
	 * @param nombre del alumno
	 * @param apellidos del alumno
	 * @param dni del alumno
	 */
	public Adulto(String nombre, String apellidos, String dni){
		super(nombre, apellidos);
		assert(dni!=null);
		this.dni=dni;
		this.juniors=new ArrayList<Junior>();
	}
	/** getJuniors: Getter de juniors
	 * 
	 * @return copia de la lista de juniors
	 */
	public ArrayList<Junior> getJuniors() {
		ArrayList<Junior> copia = new ArrayList<Junior>();
		for(int i=0;i<juniors.size();i++){
				copia.add(juniors.get(i));
		}
		return copia;
	}
	/** setJuniors: añade un junior a la lista de junior.
	 * 
	 * @requires existe el junior a introducir
	 * @ensures lista de juniors aumenta en 1 su tamaño
	 * @param junior a añadir
	 */
	public void setJuniors(Junior junior){
		int tam=juniors.size();
		assert(junior!=null);
		juniors.add(junior);
		assert(juniors.size()==tam+1);
	}

	@Override
	/** getDeuda: Getter de deuda
	 * 
	 * @return deuda del adulto y del junior que esta bajo su responsabilidad
	 */
	public double getDeuda(){
		double deuda=0;
		for(int i=0;i<super.getMatriculas().size();i++){
			if(!super.getMatriculas().get(i).isPagada()){
				deuda=deuda+super.getMatriculas().get(i).getCurso().getPrecio();
			}
		}
		for(int x=0;x<juniors.size();x++){
			for(int j=0;j<juniors.get(x).getMatriculas().size();j++){
				if(!juniors.get(x).getMatriculas().get(j).isPagada()){
					deuda=deuda+juniors.get(x).getMatriculas().get(j).getCurso().getPrecio();
				}
			}
		}
		
		return deuda;
	}
	/** pagar: Paga la matricula de un alumno en un curso
	 * 
	 * @requires exista el curso
	 * @ensures la matricula quede pagada
	 */
	public void pagar(){
		int i;
		for (i=0;i<super.getMatriculas().size();i++){
			if(!super.getMatriculas().get(i).isPagada()){
				super.getMatriculas().get(i).setPagada();
				assert(super.getMatriculas().get(i).isPagada());
			}
		}
		for(i=0;i<juniors.size();i++){
			for(int j=0;j<juniors.get(i).getMatriculas().size();j++){
				if(!juniors.get(i).getMatriculas().get(j).isPagada()){
					juniors.get(i).getMatriculas().get(j).setPagada();
					assert(juniors.get(i).getMatriculas().get(j).isPagada());
				}
			}
			
		}
	}
	
	/** getDni: Getter de dni
	 * 
	 * @return dni
	 */
	public String getDni(){
		return dni;
	}
}