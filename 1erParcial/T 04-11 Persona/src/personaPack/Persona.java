package personaPack;

public class Persona {
	
	private String nombre,
				   apellido;

	public Persona(String nombre, String apellido){
		this.nombre = nombre;
		this.apellido = apellido;
	}
		
	public String nombreCompleto(){
		return nombre+" "+apellido;
	}
	
	public static void main(String[] args) {
		Persona p1 = new Persona("Araceli Paco", "La hermosa");
		System.out.println( p1.nombreCompleto() );
	}
}
