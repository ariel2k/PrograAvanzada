package orquestaPack;

public class Cuerda extends Instrumento{
	
	public Cuerda(String nombre){
		this.nombre = new String(nombre);
	}
		
	public void tocar() {
		System.out.println("Tocó Cuerda: "+this.nombre);
	}
}
