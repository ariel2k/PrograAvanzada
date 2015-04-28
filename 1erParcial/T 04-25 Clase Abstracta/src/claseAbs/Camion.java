package claseAbs;

public class Camion extends Transporte {

	private int pesoLimite,
				kmLimite,
				peso,
				km;
	
	public Camion(int pesoLimite, int kmLimite) {
		this.pesoLimite = pesoLimite;
		this.kmLimite = kmLimite;
		this.km = 0;
		this.peso = 0;
	}
	
	public void agregarCarga (int peso) {
			this.peso += peso;
	}
	
	public void recorrerKm (int km) {	
		this.km += km;
	}

	public boolean puedoAgregar(int peso) {
		return this.peso + peso <= this.pesoLimite;
	}

	public boolean hayQueReparar() {
		return this.km >= this.kmLimite;
	}
	

	public static void main(String[] args) {
		Camion c1 = new Camion (10000, 10000);
		if(c1.puedoAgregar(40)){
			c1.agregarCarga(40);
			System.out.println("El camion1 agrego correctamente");
		}
		
	}

}
