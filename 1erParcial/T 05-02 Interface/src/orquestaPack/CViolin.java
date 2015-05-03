package orquestaPack;

public class CViolin extends Cuerda implements Afinable{

	public CViolin() {
		super("Violin");
	}

	public void afinar() {
		System.out.println("Se afino: "+this.nombre);
	}

}
