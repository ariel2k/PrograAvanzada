package orquestaPack;

public class CGuitarra extends Cuerda implements Afinable{
	
	public CGuitarra() {
		super("Guitarra");
	}

	public void afinar() {
		System.out.println("Se Afino: "+this.nombre);		
	}
}
