
package Math;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MatrizMath implements Cloneable{
	
	private int fila,
				columna;
	private double mat[][];
	
	public MatrizMath(int dim) {
		this.fila = dim;
		this.columna = dim;
		this.mat = new double[dim][dim]; 
	}
	
	public MatrizMath(int fi, int co) {
		this.fila = fi;
		this.columna = co;
		this.mat = new double[fi][co];
	}
	
	public MatrizMath(int fi, int co, double[][] mat) {
		this.fila = fi;
		this.columna = co;
		double[][] auxMat = new double[fi][co];
		for (int i = 0; i < fi; i++) {
			for (int j = 0; j < co; j++) {
				auxMat[i][j] = mat[i][j];
			}
		}
		this.setMat(auxMat);
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
	
	public void setMat(double[][] mat) {
		this.mat = mat;
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

	public VectorMath producto(VectorMath vec) throws DistDimException {
		if(this.columna != vec.getDimension())
			throw new DistDimException(" Numero de columnas distinta a la dimension del vector");	
		VectorMath resultado = new VectorMath (this.fila);
		double a[] = new double[this.fila];
		for(int i = 0; i < this.fila; i++)
			for(int j = 0; j < vec.getDimension(); j++)
					a[i] += this.mat[i][j] * vec.getVec()[j];
		resultado.setVec(a);
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

	public void identidad() {
		for (int i=0, j=0; i<this.fila; i++, j++)
			this.mat[i][j] = 1;
	} 

	public int intercambiarCero(int fila) {
		int i=fila+1;
		while(i<this.fila){
			if(this.mat[i][fila] != 0){
				this.intercambiar(i, fila);
				return i;
			}	
			i++;
		}
		return 0;
	}


	public void intercambiar(int filaOrigen, int filaDestino) {
		double aux;
		for(int i=0; i<this.fila; i++) {
			aux = this.mat[filaDestino][i];
			this.mat[filaDestino][i] = this.mat[filaOrigen][i];
			this.mat[filaOrigen][i] = aux;
		}
	}
	
	public void sumarFilas(double n, int filaDestino) {
		for(int i=0; i<this.fila; i++)
			this.mat[filaDestino][i] += n;
	}
	
	public void sumarFilas(int filaOrigen, int filaDestino, double n) {
		for(int i=0; i<this.fila; i++)
			this.mat[filaDestino][i] += this.mat[filaOrigen][i]*n;	
	}


	public void dividirFilas(double n, int filaDestino) {
		for(int i=0; i<this.fila; i++)
			this.mat[filaDestino][i] /= n;
	}
	
	public boolean filaCero(int fila) {
		for(int i=0; i<this.fila; i++)
			if(this.mat[fila][i] != 0)
				return false;
		
		return true;
	}
	
	public MatrizMath inversa() {
		int dimension = this.fila;
		MatrizMath inversa = new MatrizMath (dimension, dimension);
		MatrizMath copiaThis = new MatrizMath (dimension, dimension, this.getMat());
		inversa.identidad();
		double aux;
		//Triangular Abajo Diagonal
		for(int i = 0; i < dimension; i++) {
			if(copiaThis.mat[i][i] == 0) { //Si es cero lo intercambia por otra fila
				if(copiaThis.filaCero(i))
					return null;
				int auxFila = copiaThis.intercambiarCero(i);
				inversa.intercambiar(i, auxFila);
			}
			aux = copiaThis.mat[i][i]; //obtiene el valor de la diagonal
			copiaThis.dividirFilas(aux, i); //divide toda la fila por ese valor para poner un 1 en la diagonal
			inversa.dividirFilas(aux, i); //idem pero con la matriz inversa
			
			for(int j = i+1; j < dimension; j++) { 
				double numFilaCol = (-1)*copiaThis.mat[j][i];
				copiaThis.sumarFilas(i, j, numFilaCol); //multiplica todas las filas por su negativo restantes para ponerlas en cero
				inversa.sumarFilas(i, j, numFilaCol);
			}			
		}	
		//Triangular Arriba Diagonal
		for(int i = dimension-1; i > 0; i--) {
			for(int j=i-1; j >= 0 ; j--) { 
				double numFilaCol = (-1)*copiaThis.mat[j][i];
				copiaThis.sumarFilas(i, j, numFilaCol); //multiplica todas las filas por su negativo restantes para ponerlas en cero
				inversa.sumarFilas(i, j, numFilaCol);
			}
		}			
		return inversa;
	}
	
	public double normaUno() {
		VectorMath 	sumaColumna = new VectorMath(this.columna); 
		double[] vec = new double[this.columna];
		double cont;
		for(int i = 0; i<this.columna; i++) {
			cont = 0;
			for(int j=0; j<this.fila; j++)
				cont += Math.abs(this.mat[j][i]);	
			vec[i] = cont;
		}
		sumaColumna.setVec(vec);
		return sumaColumna.normaInfinito();		
	}

	
	public double normaDos() {
		double max=0;
		for(int i = 0; i<this.fila; i++) {
			for(int j=0; j<this.columna; j++)
				if(Math.abs(this.mat[i][j]) > max)
					max = Math.abs(this.mat[i][j]);
		}
		return max;
	}
	
	public double normaInfinito() {
		VectorMath 	sumaFila = new VectorMath(this.fila); 
		double[] vec = new double[this.fila];
		double cont;
		for(int i = 0; i<this.fila; i++) {
			cont = 0;
			for(int j=0; j<this.columna; j++)
				cont += Math.abs(this.mat[i][j]);
			vec[i] = cont;
		}
		sumaFila.setVec(vec);
		return sumaFila.normaInfinito();
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
		MatrizMath mat4 = new MatrizMath("mat4.in");
		System.out.println(mat4);
		//System.out.println(mat4.subMatriz(1, 3));
		System.out.println(mat4.determinante());

		//Identidad, suma y resta
		MatrizMath iden = new MatrizMath(4,4);
		iden.identidad();
		System.out.println(iden);
		
		iden.sumarFilas(0,1);
		System.out.println(iden);

		iden.restarFilas(2,1);
		System.out.println(iden);

		//Intercambio
		iden.intercambiar(3,1);
		System.out.println(iden);
		iden.intercambiarCero(1);
		System.out.println(iden);

		MatrizMath mat15 = new MatrizMath("mat15x15.in");
		System.out.println(mat15);
		System.out.println(mat15.determinante());
		//System.out.println(mat15.inversa());
		MatrizMath mat4 = new MatrizMath("mat4.in");
		System.out.println(mat4);
		Calendar tIni = new GregorianCalendar();
		System.out.println(mat4.inversa());
		Calendar tFin = new GregorianCalendar();
		double diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println(diff);
		 */
		
		MatrizMath mat2 = new MatrizMath("mat2.in");
		System.out.println(mat2);
		System.out.println("normaUno: "+mat2.normaUno());
		System.out.println("normaInfinito: "+mat2.normaInfinito());
		System.out.println("normaDos: "+mat2.normaDos());
	}
}
