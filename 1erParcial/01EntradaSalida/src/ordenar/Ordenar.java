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
	            fichero = new FileWriter("D:\\Ariel\\Instituciones\\Unlam\\1113-Programacion-Avanzada\\workspace\\1erParcial\\TP1-H_Clinicas\\ordenados.out");
	            pw = new PrintWriter(fichero);

	            for (int i = 1; i < 80000; i++) {
	            	pw.println(rnd.nextInt(40000));
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