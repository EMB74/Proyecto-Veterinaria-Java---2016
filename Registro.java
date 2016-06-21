package veterinaria;


	import java.util.Date;


	public class Registro {
		protected int fecha;
		double peso;
		double medida;
		
		public Registro(){
			this.fecha = 0;
			this.peso = 0;
			this.medida = 0;
		}
		
		public Registro( int i, double peso, double medida) {
			this.fecha = i;
			this.peso = peso;
			this.medida = medida;
		}
		
		public int getFecha() {
			return fecha;
		}
		
		public double getMedida() {
			return medida;
		}
		
		public double getPeso() {
			return peso;
		}
		
		@Override
		public String toString() {
			return fecha+" - "+peso+" - "+medida;
		}
		
		
		
		
		
		
	}

