package Math;

public class MatrizMath {
	
	private int fila,
				columna;
	private double mat[][];

	public MatrizMath(int fi, int co) {
		this.fila = fi;
		this.columna = co;
		this.mat = new double[fi][co];
	}
	
	public MatrizMath(String ruta) {
		Archivo arch = new Archivo(ruta);
		String linea = arch.leerArchivo();
		String[] splited = linea.split(" ");
		String[] datos;
		int fi = Integer.parseInt(splited[0]),
			co = Integer.parseInt(splited[1]),
			coordx,
			coordy;		
		this.fila = fi;
		this.columna = co;
		this.mat = new double[fi][co];
		
		for (int i = 1; i <= fi * co; i++) {
			linea = arch.leerArchivo();
			datos = linea.split(" ");
			coordx = Integer.parseInt(datos[0]);
			coordy = Integer.parseInt(datos[1]);
			this.mat[coordx][coordy] = Double.parseDouble(datos[2]);
		}		
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public double[][] getMat() {
		return mat;
	}

	public MatrizMath sumar(MatrizMath matrizSum) throws DistDimException{
		if (this.fila != matrizSum.fila && this.columna != matrizSum.columna)
			throw new DistDimException(" Distinta Dimension ");
		MatrizMath resultado = new MatrizMath(this.fila, this.columna);
		for(int i = 0; i < this.fila; i++) {
			for(int j = 0; j < this.columna; j++) {
				resultado.mat[i][j] = this.mat[i][j] + matrizSum.mat[i][j];
			}
		}
		return resultado;
	}
	
	public MatrizMath restar(MatrizMath matrizRest) throws DistDimException {
		if (this.fila != matrizRest.fila && this.columna != matrizRest.columna)
			throw new DistDimException(" Distinta Dimension ");
		MatrizMath resultado = new MatrizMath(this.fila, this.columna);
		for(int i = 0; i < this.fila; i++) {
			for(int j = 0; j < this.columna; j++) {
				resultado.mat[i][j] = this.mat[i][j] - matrizRest.mat[i][j];
			}
		}
		return resultado;
	}
	
	public MatrizMath producto(MatrizMath matriz) throws DistDimException {
		if(this.columna != matriz.fila)
			throw new DistDimException(" Numero de columnas de la primera matriz, no coincide con el de columnas de la segunda  ");
		MatrizMath resultado = new MatrizMath(this.fila, matriz.columna);
		for(int i = 0; i < this.fila; i++)
			for(int j = 0; j < matriz.columna; j++)
				for(int ciclo = 0; ciclo < this.columna; ciclo++)
					resultado.mat[i][j] += this.mat[i][ciclo] * matriz.mat[ciclo][j];
		return resultado;
	}
	
	public MatrizMath producto(float n) {
		MatrizMath resultado = new MatrizMath(this.fila, this.columna);
		for (int i = 0; i < this.fila; i++)
			for (int j = 0; j < this.columna; j++)
				resultado.mat[i][j] = n * this.mat[i][j];
		return resultado;
	}

	public MatrizMath producto(VectorMath vec) throws DistDimException {
		if(this.columna != vec.getDimension())
			throw new DistDimException(" Numero de columnas distinta a la dimension del vector");
		
		MatrizMath resultado = new MatrizMath (this.fila, 1);
		for(int i = 0; i < this.fila; i++)
			for(int j = 0; j < vec.getDimension(); j++)
					resultado.mat[i][0] += this.mat[i][j] * vec.getVec()[j];
		return resultado;
	}
	
	public String toString() {
		String cad = new String("");
		for (int i = 0; i < this.fila; i++) {
			cad += "[";
			for (int j = 0; j < this.columna; j++) {
				if (this.mat[i][j] >= 0)
					cad += " ";
				cad += this.mat[i][j] + " ";
			}
			cad += "]\n";
		}
		return cad;
	}
	
	public MatrizMath subMatriz(int filaASacar, int columnaASacar) {
		int dim = this.fila-1;
		MatrizMath m = new MatrizMath (dim, dim); 
		int	fila=0,
			colum=0,
			bandera;
		for(int i=0; i<this.fila; i++) {
			bandera =0;
			for(int j=0; j<this.fila; j++)
				if(i != filaASacar && j!= columnaASacar) {
					m.mat[fila][colum] = this.mat[i][j];
					colum++;
					bandera=1;
				}
			if(bandera == 1)
				fila++;
			colum=0;		
		}
		return m;
	}
	
	public double determinante() throws DistDimException {
		  if (this.columna != this.fila)
		   throw new DistDimException(" No es una matriz cuadrada ");
		  int dim = this.columna;
		  if(dim == 2)
		   return(this.mat[0][0] * this.mat[1][1] - this.mat[0][1] * this.mat[1][0]);
		  else {
		   // Si no es de 2 * 2
		   double det = 0;
		   MatrizMath subMat = new MatrizMath(dim - 1, dim - 1);
		   for(int k = 0; k < dim; k++) 
		    for(int i = 1; i < dim; i++) 
		     for(int j = 0, z = 0; j < dim; j++) { 
		      if(j != k) {
		       subMat.mat[i-1][z] = this.mat[i][j];
		       z++;
		      }		    
		   int m;
		   if(k % 2 == 0)
		    m = 1;
		   else
		    m = -1;
		    det += this.mat[0][k] * subMat.determinante() * m;
		   }
		   return det;
		  }  
	}
	
	
	public static void main(String[] args) {
		/*
		 * 
		MatrizMath mat1 = new MatrizMath("mat1.in");
		MatrizMath mat2 = new MatrizMath("mat2.in");
		MatrizMath mat3 = new MatrizMath("mat3.in");
		System.out.println("La matriz 1:\n" + mat1);
		System.out.println("La matriz 2:\n" + mat2);
		System.out.println("La matriz 3:\n" + mat3);
		System.out.println("La matriz 4:\n" + mat4);
		// Suma entre matrices
		System.out.println("Mat1 + Mat1:\n" + mat1.sumar(mat1));
		System.out.println("Mat1 + Mat2:\n" + mat1.sumar(mat2));
		// Resta entre matrices
		System.out.println("Mat1 - Mat1:\n" + mat1.restar(mat1));
		System.out.println("Mat1 - Mat2:\n" + mat1.restar(mat2));
		// Producto entre matrices
		System.out.println("Mat3 * Mat4:\n" + mat3.producto(mat4));
		
		// Producto con float
		System.out.println("La matriz 1:\n" + mat1);
		System.out.println("Mat1 * 2.53:\n" + mat1.producto(2.53f));
		
		VectorMath vec2 = new VectorMath("vec2.in");
		System.out.println(mat4);
		System.out.println(vec2);
		// Producto matriz vector
		System.out.println("Producto matriz vector: \n"+mat4.producto(vec2));
		 */
		MatrizMath mat4 = new MatrizMath("mat4.in");
		System.out.println(mat4);
		//System.out.println(mat4.subMatriz(1, 3));
		System.out.println(mat4.determinante());
	}
}
