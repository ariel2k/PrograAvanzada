package ordenar;

import java.io.*;
import java.util.Random;

public class Ordenar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int suma=0;
		File f = null;
		FileReader fr = null;
		BufferedReader br =null;
		
		//Escribir
		FileWriter fichero = null;
	    PrintWriter pw = null;
		Random rnd = new Random();
			try
	        {
				int matriz = 15;
	            fichero = new FileWriter("mat15x15.in");
	            pw = new PrintWriter(fichero);
	            
	            pw.println(matriz+" "+matriz);
	            for (int i = 0; i <matriz; i++) {
	            	for(int j=0; j<matriz; j++)
	            	pw.println(i+" "+j+" ");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
				
		
	}

}