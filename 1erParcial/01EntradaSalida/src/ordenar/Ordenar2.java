package ordenar;

import java.io.*;
import java.util.Random;

public class Ordenar2 {

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
		String nombre = new String("Pkf");
			try
	        {
	            fichero = new FileWriter("D:\\Ariel\\Instituciones\\Unlam\\1113-Programacion-Avanzada\\workspace\\1erParcial\\TP1-H_Clinicas\\ordenados_1.out");
	            pw = new PrintWriter(fichero);

	            for (int i = 1; i < 2000; i++) {
	            	pw.println(i*2+ " nro"+ i +" H");
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