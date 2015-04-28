package claseAbs;

public class Bicicleta extends Transporte {
	
	private int paquetes,
				paquetesLimite = 4,
				viajesLimite = 50,
				pesoLimite,
				viajes,
				peso,
				km;

	public Bicicleta(int pesoLimite) {
		this.paquetes = 0;
		this.viajes = 0;
		this.peso = 0;
		this.km = 0;
		this.pesoLimite = pesoLimite;
	}

	public void agregarCarga(int peso) {
		this.peso += peso;
		this.paquetes++;
	}

	public void recorrerKm(int km) {
		this.km += km;
		this.viajes++;
	}

	public boolean puedoAgregar(int peso) {
		return this.peso + peso <= this.pesoLimite &&
			   this.paquetes < this.paquetesLimite;
	}

	public boolean hayQueReparar() {
		return this.viajes >= this.viajesLimite;
	}

	public static void main(String[] args) {
		Bicicleta b1 = new Bicicleta(100);
		if (b1.puedoAgregar(100)) {
			b1.agregarCarga(40);
			b1.agregarCarga(60);
			System.out.println("La bici1 agrego correctamente ");
		}

	}
}
