package Math;

import java.io.FileWriter;
import java.io.PrintWriter;

public class GrabarAchivo {

    //Escribir
    private FileWriter fichero;
    private PrintWriter pw;

	public GrabarAchivo(String path, String[] linea) {
    	try
        {
    		int i = 0;
            this.fichero = new FileWriter(path);
            this.pw = new PrintWriter(fichero);
            while(linea != null) {
            	this.pw.println(linea[i]);
            	System.out.println(linea[i]);
            	i++;
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