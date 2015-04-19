package luch;

public class Luchadores {
	private int peso;
	private int altura;
	
	public Luchadores(int p, int a) {
		this.peso = p;
		this.altura = a;
	}
	private boolean domina(Luchadores l2){
		if(this.peso >= l2.peso && this.altura >= l2.altura)
			return true;
		return false;
	}
	public static void resolver(String ruta) {
		Archivo arch = new Archivo(ruta);
		int cant =	Integer.parseInt(arch.leerArchivo());
		Luchadores[] luch = new Luchadores[cant];
		String[] split;
		int domina;
		String aux = new String("");
		for(int l = 0; l < cant; l++){
			aux = arch.leerArchivo();
			split = aux.split(" ");
			luch[l] = new Luchadores(Integer.parseInt(split[0]), Integer.parseInt(split[1]));	
		}
		for(int i = 0; i < cant; i++){
			domina = -1;
			for(int j = 0; j < cant; j++){
				if(luch[i].domina(luch[j]))
					domina++;
			}
			System.out.println(domina);
		}
		
	}
	
	public static void main(String[] args){
		resolver("luchadores.in");
	}
}
