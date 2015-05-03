package orquestaPack;

public class VTrompeta extends Viento implements Afinable{

	public VTrompeta() {
		super("Trompeta");
	}

	public void afinar() {
		System.out.println("Se afino: "+this.nombre);	
	}
	
}