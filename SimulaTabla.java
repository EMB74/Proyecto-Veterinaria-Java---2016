package veterinaria;

import java.util.ArrayList;
import java.util.LinkedList;


/* la idea es que aca se guarden los registros que simulen una tabla
 * la lista contiene en cada posicion un registro  */


public class SimulaTabla  {
	
	private String nombreAnimal;
	private String  matricula;
	private String raza;
	private String especie;
	private String propietario;
	private static LinkedList<SimulaTabla>tablaGenerada=new LinkedList<>();
	
	private LinkedList<Registro> registro = new LinkedList<Registro>();
	

	
	public SimulaTabla(String nombreAnimal, String i, String raza, String especie, String propietario ) {
		
		this.nombreAnimal =nombreAnimal;
		this.matricula= i;
		this.raza=raza;
		this.especie=especie;
		this.propietario=propietario;
		
	}

	public String getNombreAnimal() {
		return nombreAnimal;
	}

	public void setNombreAnimal(String nombreAnimal) {
		this.nombreAnimal = nombreAnimal;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public LinkedList<Registro> getRegistro() {
		return registro;
	}

	public void setRegistro(LinkedList<Registro> registro) {
		this.registro = registro;
	}

	public static void  setTabla(LinkedList<SimulaTabla> auxTabla){
		tablaGenerada=auxTabla;
	}

	
	
	
public static void main(String[] args) {
	
	SimulaTabla reg1 = new SimulaTabla("Paco","1234","Dogo","Canino","Pedro");
	SimulaTabla reg2 = new SimulaTabla("Negro","1234","Ovejero","Canino","Gabriel");
	SimulaTabla reg3 = new SimulaTabla("Berta","1234","Siames","Gatos","Pedro");
	SimulaTabla reg4 = new SimulaTabla("Luna","1234","Terrier","Canino","Ana");
	
	
	LinkedList<SimulaTabla>st=new LinkedList<>();
	
	st.add(reg1);
	st.add(reg2);
	st.add(reg3);
	st.add(reg4);
	
	SimulaTabla.setTabla(st);
	
	System.out.println("Verificando lista generada:  \n");
	for (SimulaTabla datos : st) {
		System.out.println(datos.getNombreAnimal()+"," + datos.getMatricula()+","+datos.getEspecie()+","
		+datos.getPropietario());
	}
	
	
	
}	
	
	

}
