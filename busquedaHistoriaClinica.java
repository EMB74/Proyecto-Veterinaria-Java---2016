package veterinaria;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class busquedaHistoriaClinica extends JFrame  implements ActionListener, TableModel  {

	private static final long serialVersionUID = 1L;
	
	
	static Object [][]tablaPrevia;
	static LinkedList<SimulaTabla> listaSimulada =new LinkedList<>();

	static LinkedList<SimulaTabla> listaBusqueda = new LinkedList<>();

	static Object []encabezado={"Matricula","Animal","Dueño","Raza","Especie"};
	static JScrollPane tablaFinal;
	static int columna, fila;
	static 	JTextField textoBuscado = new JTextField();
	
	
	public busquedaHistoriaClinica() {
       
		setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		/*seteo de pantalla principal de historia clinica*/
        JLabel titulo = new JLabel("BUSQUEDA DE HISTORIA CLINICA");
        titulo.setHorizontalAlignment(2);
		titulo.setBounds(50, 10, 300,30);
		add(titulo);
		
		
		
		/*Se agrega campo de texto a buscar*/
	
		textoBuscado.setBounds(100, 40, 300,30);
		add(textoBuscado);
		
		/*se agrega boton de busqueda*/
		JButton botonBusqueda = new JButton("BUSCAR");
		botonBusqueda.setBounds(50, 70, 100, 30);
		add(botonBusqueda);
		botonBusqueda.addActionListener(this);	
		botonBusqueda.setVisible(true);
		
		/*se agrega boton de mostrar tabla completa*/
		JButton botonTablaCompleta = new JButton("BASE DE DATOS COMPLETA");
		botonTablaCompleta.setBounds(250, 70, 200, 30);
		add(botonTablaCompleta);
		//botonBusqueda.addActionListener(this);
		

		this.setTitle("Buscador de Historia Clinica- Veterinaria ");
		this.setSize(500,300);
		this.setVisible(true);
		
	}

		public void actionPerformed(ActionEvent e) {
			//evento que hace que aparezca busqueda (por ahora hace aparecer tabla completa)
			
			//String temporal = textoBuscado.getText();
			//textoMostrado.setText(temporal);
			//textoMostrado.setVisible(true);
			/*Se arma tabla a mostar*/
			cargaTabla(buscaDato(listaSimulada,textoBuscado.getText()));
			DefaultTableModel dtm= new DefaultTableModel(tablaPrevia,encabezado);
			JTable tabla = new JTable(dtm);
			tablaFinal = new JScrollPane(tabla);
			tablaFinal.setBounds(100, 150, 400, 200);
			add(tablaFinal);
			tablaFinal.setVisible(true);
			
		}
	
	/*metodo que carga un objeto matriz para posteriormente armar la tabla*/
	public static void cargaTabla(LinkedList<SimulaTabla> list){
		 fila=list.size();
		 columna=5;
		 tablaPrevia=new Object[fila][columna];
		 System.out.println("Verificando de nuevo lista generada:  \n");
		 int i=0;
		 for (SimulaTabla datos : list) {
				tablaPrevia[i][0]=datos.getMatricula();
				tablaPrevia[i][1]=datos.getNombreAnimal();
				tablaPrevia[i][2]=datos.getPropietario();
				tablaPrevia[i][3]=datos.getRaza();
				tablaPrevia[i][4]=datos.getEspecie();
				i++;
			}
	}
	
	/*metodo de busqueda. Devuelve un LinkedList unicamente con las
	 * filas que contienen el dato*/
	public static LinkedList<SimulaTabla> buscaDato(LinkedList<SimulaTabla> lista2,String valorBusqueda){
		System.out.println("entro a buscar...");
		int i=0;
			//Iterator<SimulaTabla>datos=lista2.iterator();
			//while (datos.hasNext()) {
				for (SimulaTabla linea : lista2) {
					if(linea.getEspecie().equals(valorBusqueda)||linea.getMatricula().equals(valorBusqueda)||
						linea.getNombreAnimal().equals(valorBusqueda)||linea.getPropietario().equals(valorBusqueda)||
						linea.getRaza().equals(valorBusqueda)){
						listaBusqueda.add(linea);
						System.out.println("agrego la linea " + i);
						
					}i++;
				}
				
			//}
			if(listaBusqueda.isEmpty()){
				return null;
			}else{
				return listaBusqueda;
			}
	
	}
	
		

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}


	
	
/*metodo MAIN*/		
	
	
	
public static void main(String[] args) {
/*generamos una tabla falsa*/
	
	
	
	
	//LinkedList<SimulaTabla>st=new LinkedList<>();
	
	listaSimulada.add(new SimulaTabla("Paco","1234","Dogo","Canino","Pedro"));
	listaSimulada.add(new SimulaTabla("Negro","1234","Ovejero","Canino","Gabriel"));
	listaSimulada.add(new SimulaTabla("Berta","1234","Siames","Felino","Pedro"));
	listaSimulada.add(new SimulaTabla("Luna","1234","Terrier","Canino","Ana"));
	

	
	System.out.println("Verificando lista generada:  \n");
	for (SimulaTabla datos : listaSimulada) {
		System.out.println(  datos.getNombreAnimal()+"," + datos.getMatricula()+","+datos.getEspecie()+","
		+datos.getPropietario());
	}
	
	//busquedaHistoriaClinica.cargaTabla(listaSimulada);

	new busquedaHistoriaClinica();

}



	
	
}
	
	

