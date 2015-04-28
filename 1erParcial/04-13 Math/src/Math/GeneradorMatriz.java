package Math;

import java.io.*;
import java.util.Random;

public class GeneradorMatriz {

	public static void main(String[] args) {
		FileWriter fichero = null;
	    PrintWriter pw = null;
	    Random rnd = new Random();
		try
        {
			int matriz = 15;
            fichero = new FileWriter("C:\\ARIEL Datos\\Ariel\\Instituciones\\Unlam\\1113-Programacion-Avanzada\\workspace\\1erParcial\\04-13 Math\\mat"+matriz+"x"+matriz+".in");
            pw = new PrintWriter(fichero);
            
            pw.println(matriz+" "+matriz);
            for (int i = 0; i < matriz; i++) 
            	for(int j=0; j< matriz; j++) 
            		pw.println(i+" "+j+" "+rnd.nextDouble());  
            System.out.println("Archivo finalizado");
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