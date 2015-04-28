package claseAbs;

public class Persona extends Transporte {
	
	private int kmLimite = 10,
				viajeLimite = 5,
				paqueteLimite = 3,
				pesoLimite = 10,
				peso,
				paquete,
				km,
				viaje;
	
	public Persona() {
		this.paquete = this.peso = this.km = this.viaje = 0;
	}
	
	public void agregarCarga(int peso) {
		this.peso += peso;
		this.paquete++;
	}

	public void recorrerKm(int km) {
		this.km += km;
		this.viaje++;
	}

	public boolean puedoAgregar(int peso) {
		return this.peso + peso <= this.pesoLimite
				&& this.paquete < this.paqueteLimite;
	}

	public boolean hayQueReparar() {
		return this.viaje >= this.viajeLimite ||
				this.km >= this.kmLimite;
	}
	
	public static void main(String[] args) {
		
	}

}
