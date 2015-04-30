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
			String[] Dimension = {"3",
					   "5",
					   "10",
					   "20",
					   "50",
					   "100",
					   "150",
					   "200",
					   "250",
					   "300",
					   "500",
					   "800",
					   "1000",};
			
			//Archivos Long
			for (int Dim = 0; Dim < Dimension.length; Dim++) {				
				int DimSEL = Integer.parseInt(Dimension[Dim]);
				fichero = new FileWriter("SEL_"+DimSEL+"_Int.in");
				pw = new PrintWriter(fichero);
				
				pw.println(DimSEL);
				for (int i = 0; i < DimSEL; i++) 
					for(int j=0; j< DimSEL; j++) 
						pw.println(i+" "+j+" "+rnd.nextInt(3));  
				for (int i = 0; i < DimSEL; i++)
					pw.println(rnd.nextInt(3)); 
				try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
			}
			
			//Archivos int
			for (int Dim = 0; Dim < Dimension.length; Dim++) {				
				int DimSEL = Integer.parseInt(Dimension[Dim]);
				fichero = new FileWriter("SEL_"+DimSEL+"_Long.in");
				pw = new PrintWriter(fichero);
				
				pw.println(DimSEL);
				for (int i = 0; i < DimSEL; i++) 
					for(int j=0; j< DimSEL; j++) 
						pw.println(i+" "+j+" "+rnd.nextLong());  
				for (int i = 0; i < DimSEL; i++)
					pw.println(rnd.nextLong()); 
				try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
			}
			
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