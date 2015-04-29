package Math;

import java.io.*;
import java.util.Random;

public class GeneradorSEL {

	public static void main(String[] args) {
		FileWriter fichero = null;
	    PrintWriter pw = null;
	    Random rnd = new Random();
		try
        {
			int DimSEL = 3;
            fichero = new FileWriter("SEL_"+DimSEL+".in");
            pw = new PrintWriter(fichero);
            
            pw.println(DimSEL);
            for (int i = 0; i < DimSEL; i++) 
            	for(int j=0; j< DimSEL; j++) 
            		pw.println(i+" "+j+" "+rnd.nextLong());  
            for (int i = 0; i < DimSEL; i++)
            	pw.println(rnd.nextLong()); 
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