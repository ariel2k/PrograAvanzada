package Math;

public class SEL {
	
	private VectorMath b;
	private MatrizMath a;
	private VectorMath x;
	private String[] datosSolucion;
	
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
		MatrizMath aInv;
		aInv = a.inversa();
		datosSolucion = new String[this.b.getVec().length + 1];
		if (aInv == null)
			this.datosSolucion[0] = "0";
		else {
			System.out.println(aInv);
			this.x = aInv.producto(this.b);
			this.datosSolucion[0] = "" + this.x.getVec().length;
			for(int i = 1; i < this.x.getVec().length + 1; i++)
				this.datosSolucion[i] = "" + this.x.getVec()[i-1];
		}
	}
	
	public void guardar(String ruta) {
		if(Integer.parseInt(datosSolucion[0]) == 0) {
			this.datosSolucion = new String[1];
			this.datosSolucion[0] = "La soluci�n no es finita ni �nica";
		}
		GrabarArchivo guar = new GrabarArchivo(ruta, datosSolucion);
	}
	 
	
	public static void main(String[] args) {
		SEL sel1 = new SEL("SEL1.in");
		sel1.resolver();
		sel1.guardar("Respuesta.out");
	}
}
