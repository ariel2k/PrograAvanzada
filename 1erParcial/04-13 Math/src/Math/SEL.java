package Math;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SEL {
	
	private VectorMath b;
	private MatrizMath a;
	private VectorMath x;
	private MatrizMath aInv;
	private String datosSolucion = new String("");
	private double cotaDeError;
	
	public SEL(String ruta) {
		//abre archivo y lee la primera lina
		Archivo arch = new Archivo(ruta);
		int dimension = Integer.parseInt(arch.leerArchivo());
		
		//Crea el SEL inicializado
		b = new VectorMath(dimension);
		a = new MatrizMath(dimension);
		aInv = new MatrizMath(dimension);
		
		//Llena A
		String linea;
		double auxA[][] = new double[dimension][dimension];
		String[] datos;
		int coordx,
			coordy;
		for (int i = 0; i < dimension*dimension; i++) {
			linea = arch.leerArchivo();
			datos = linea.split(" ");
			coordx = Integer.parseInt(datos[0]);
			coordy = Integer.parseInt(datos[1]);
			auxA[coordx][coordy] = Double.parseDouble(datos[2]);
		}
		a.setMat(auxA);
		
		
		//Llena B
		double auxB[] = new double[dimension];
		for(int i=0; i < dimension; i++) {
			String lineaDeMerca = arch.leerArchivo();
			auxB[i] = Double.parseDouble(lineaDeMerca);
		}		
		b.setVec(auxB);
	}
	
	public boolean resolver() {
		aInv =  a.inversa();
		if (aInv == null){
			this.datosSolucion = "0";
			return false;
		}			
		this.x = aInv.producto(this.b);
		this.datosSolucion += "" + this.x.getVec().length +"\n";
		for(int i = 1; i < this.x.getVec().length + 1; i++)
			this.datosSolucion += "" + this.x.getVec()[i-1] +"\n";
		return true;		
	}
	
	public void guardar(String ruta) {
		if(datosSolucion.equals("0")) {
			this.datosSolucion = "La soluci�n no es finita ni �nica";
		}
		GrabarArchivo guar = new GrabarArchivo(ruta, datosSolucion);
	}
	 
	public void cotaDeError() {
		int dim = a.getColumna();
		MatrizMath identidad = new MatrizMath(dim);
		MatrizMath resultado;
		identidad.identidad();
		resultado = identidad.restar(a.producto(aInv)); //Identidad original - identidad que da entre las matrices a y a^-1
		cotaDeError = resultado	.normaDos();
		if(cotaDeError < 1E-10)
			cotaDeError = 0;
		datosSolucion += "\n"+cotaDeError+"\n";
	}
	
	public String toString() {
		return a+""+x+"=\n"+b+aInv;
	}
	
	public static void main(String[] args) {
		/*
		String[] archivosIn = {"3",
							   "5",
							   "10",
							   "20",
							   "50",
							   "100",
							   "150",
							   "200",
							   "250",
							   "300",
							   "500",
							   "800",
							   "1000",
		};
		
		for (int i = 0; i < archivosIn.length; i++) {	
			SEL sel = new SEL("SEL_"+archivosIn[i]+"_Int.in");
			Calendar tIni = new GregorianCalendar();
			sel.resolver();
			Calendar tFin = new GregorianCalendar();
			double diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
			System.out.println(archivosIn[i]+"_Int: "+diff);     
		}
		
		for (int i = 0; i < archivosIn.length; i++) {			
			SEL sel = new SEL("SEL_"+archivosIn[i]+"_Long.in");
			Calendar tIni = new GregorianCalendar();
			sel.resolver();
			Calendar tFin = new GregorianCalendar();
			double diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
			System.out.println(archivosIn[i]+"_Long: "+diff);     
		}
		*/	
		SEL sel1 = new SEL("Entrada//03_4x4_Normal.in");
		if(sel1.resolver());
			sel1.cotaDeError();
		System.out.println(sel1);
		sel1.guardar("Respuesta.out");
	}
}
