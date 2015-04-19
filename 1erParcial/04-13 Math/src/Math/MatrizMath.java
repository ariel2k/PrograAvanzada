package Math;

public class MatrizMath {
	
	private int fila,
				columna;
	private double[][] mat;

	public MatrizMath(int fila, int colum) {
		this.fila = fila;
		this.columna = colum;
		this.mat = new double[fila][colum];
	}
	
	public MatrizMath(String ruta){
		Archivo arch = new Archivo(ruta);
		String linea = arch.leerArchivo();
		String[] split = linea.split(" ");
		String[] contenido;
		this.fila = Integer.parseInt(split[0]);
		this.columna = Integer.parseInt(split[1]);
		int f,
			c;
		double num;
		this.mat = new double[this.fila][this.columna];
		for(int i = 0; i<this.fila * this.columna; i++){
			linea = arch.leerArchivo();
			contenido = linea.split(" ");
			f = Integer.parseInt(contenido[0]);
			c = Integer.parseInt(contenido[1]);
			num = Double.parseDouble(contenido[2]);
			this.mat[f][c] = num;
		}
	}
	
	public String toString() {
		String cad = new String("");
		for(int i = 0; i<this.fila; i++) {
			cad += "[";
			for(int j = 0; j<this.columna; j++) {
				if(this.mat[i][j] > 0)
					cad += " ";
				cad += this.mat[i][j] + " ";
			}
			cad += "]\n";
		}
		return cad;
	}
	
	public MatrizMath sumar(MatrizMath mat) {
		MatrizMath aux = new MatrizMath(this.fila, this.columna);
	}
	
	public static void main(String[] args) {
		MatrizMath mat1 = new MatrizMath("mat1.in");
		MatrizMath mat2 = new MatrizMath("mat2.in");
		System.out.println("mat1: \n" + mat1);
		System.out.println("mat2: \n" + mat2);
		/*
		System.out.println("Suma: \n" + mat1.sumar(mat2));
		System.out.println("Resta: \n" + mat1.restar(mat2));
		
		System.out.println("Producto: \n" + mat1.producto(mat2));
		System.out.println("Producto por 3: \n" + mat1.producto(3));
		
		System.out.println("Norma Uno: " + mat1.normaUno());
		System.out.println("Norma Dos: " + mat1.normaDos());
		System.out.println("Norma Infinito: " + mat1.normaInfinito());
		
		MatrizMath mat3 = mat1.clone();
		System.out.println("\nClonado de matriz 1: \n" + mat3);
		
		if(mat1.equals(mat3))
			System.out.println("Matrices iguales");
		else
			System.out.println("Matrices distintos");
		
		if(mat1.equals(mat2))
			System.out.println("Matrices iguales");
		else
			System.out.println("Matrices distintos");
		*/
	}

}
