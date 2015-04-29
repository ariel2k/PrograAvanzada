package Math;

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
	
	public void resolver() {
		aInv = a.inversa();
		if (aInv == null)
			this.datosSolucion = "0";
		else {
			System.out.println(aInv);
			this.x = aInv.producto(this.b);
			this.datosSolucion += "" + this.x.getVec().length +"\n";
			for(int i = 1; i < this.x.getVec().length + 1; i++)
				this.datosSolucion += "" + this.x.getVec()[i-1] +"\n";
		}
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
		cotaDeError = resultado.normaDos();
		datosSolucion += "\n"+cotaDeError+"\n";
	}
	
	public static void main(String[] args) {
		SEL sel1 = new SEL("SEL1.in");
		sel1.resolver();
		sel1.cotaDeError();
		sel1.guardar("Respuesta.out");
	}
}
