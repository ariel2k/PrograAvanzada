package palindromo;

import java.awt.LinearGradientPaint;
import java.io.*;

public class PalinRes {
	
	private static boolean esPalindromo(String linea){
		int posIni = 0,
			posFin = linea.length()-1;
		char inicio = linea.charAt(posIni),
			 fin = linea.charAt(posFin);
				
		while(posIni <= posFin){
			//System.out.println("inicio: "+inicio+"  fin: "+fin);
			if(inicio == fin){
				posIni++;
				posFin--;
				inicio = linea.charAt(posIni);
				fin = linea.charAt(posFin);
			}else
				return false;
		}
		
		return true;
	}
	
	private static boolean esIPalindromo(String linea){
		return esPalindromo(linea.substring(1));
	}
	
	private static boolean esDPalindromo(String linea){
		return esPalindromo(linea.substring(0, linea.length() - 1));
	}
	
	private static int casos(String linea){
		int casos=0;
		if(esPalindromo(linea))	 // caso 1 = 1
			casos++;
		if(linea.length() > 2 && esIPalindromo(linea)) // caso 2 = 2
			casos+=2;
		if(linea.length() > 2 && esDPalindromo(linea)) // caso 3 = 4
			casos+=4;	
		return casos;
		/* caso = 0 -> no es nada
		 * caso = 1 -> es Palindromo
		 * caso = 2 -> es i-palindromo
		 * caso = 3 -> es Palindromo i-palindromo
		 * caso = 4 -> es d-palindromo
		 * caso = 5 -> es Palindromo d-palindromo
		 * caso = 6 -> es i-palindromo d-palindromo
		 * caso = 7 -> son los 3 casos
		 * */
	}

	public static void resolver(String cadena){
		if(cadena.length() < 4)
			System.out.println("No se puede");
		else{
			int[] vecCasos = new int[2];
			int	  hayDistinguidas = 0;
			String 	cad1 = new String(""),
					cad2 = new String("");
			int cota = 2;
			while(cota < cadena.length() -1){
				cad1 = cadena.substring(0, cota);
				cad2 = cadena.substring(cota, cadena.length());
				vecCasos[0] = casos(cad1);
				vecCasos[1] = casos(cad2);
				if( vecCasos[0] != 0 && vecCasos[1] != 0 ){
					hayDistinguidas = 1;
					switch(vecCasos[0]){
					case 0: break;
					case 1: System.out.println(cad1+" Palindromo");
						break;
					case 2: System.out.println(cad1+" i-Palindromo");
						break;
					case 3: System.out.println(cad1+" Palindromo i-palindromo");
						break;
					case 4: System.out.println(cad1+" d-Palindromo");
						break;
					case 5: System.out.println(cad1+" Palindromo d-palindromo");
						break;
					case 6: System.out.println(cad1+" i-Palindromo d-palindromo");
						break;
					case 7: System.out.println(cad1+" Palindromo i-palindromo d-palindromo");
						break;
					}	
					switch(vecCasos[1]){
					case 0: break;
					case 1: System.out.println(cad2+" Palindromo");
						break;
					case 2: System.out.println(cad2+" i-Palindromo");
						break;
					case 3: System.out.println(cad2+" Palindromo i-palindromo");
						break;
					case 4: System.out.println(cad2+" d-Palindromo");
						break;
					case 5: System.out.println(cad2+" Palindromo d-palindromo");
						break;
					case 6: System.out.println(cad2+" i-Palindromo d-palindromo");
						break;
					case 7: System.out.println(cad2+" Palindromo i-palindromo d-palindromo");
						break;
					}		
				}
				
				cota++;
			}
			//Comprobamos si ningun corte logro dos palabras distinguidas
			if(hayDistinguidas == 0)
				System.out.println("No se puede");
		}
	}
	
	
	public static String abrirArchivo(String rutaArch){
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
		  // Apertura del fichero y creacion de BufferedReader para poder
		  // hacer una lectura comoda (disponer del metodo readLine()).
		  archivo = new File (rutaArch);
		  fr = new FileReader (archivo);
		  br = new BufferedReader(fr);			  
		  // Lectura del fichero
		  String linea;
		  if((linea=br.readLine())!=null)
	    	   return linea;
		 }
	  catch(Exception e){
	     e.printStackTrace();
	  }finally{
	     // En el finally cerramos el fichero, para asegurarnos
	     // que se cierra tanto si todo va bien como si salta 
	     // una excepcion.
	     try{                    
	        if( null != fr ){   
	           fr.close();     
	        }                  
	     }catch (Exception e2){ 
	        e2.printStackTrace();
	     }
	  }		
		return null;
	}
	
	public static void main(String[] args) {
		String linea = new String( abrirArchivo("D:\\Ariel\\Instituciones\\Unlam\\1113-Programacion-Avanzada\\workspace\\1erParcial\\04-09-Palindromo\\Documentación\\In\\12-Palabra_corte_doble_tres_distinguidas.in") );
		resolver(linea);
	}

}
