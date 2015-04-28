package claseAbs;

public abstract class Transporte {

	public abstract boolean hayQueReparar();
	public abstract void agregarCarga(int peso);
	public abstract void recorrerKm(int km);
	public abstract boolean puedoAgregar(int peso);

}
