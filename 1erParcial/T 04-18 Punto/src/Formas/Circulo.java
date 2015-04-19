package Formas;
public class Circulo {

	private Punto origen;
	private double radio;
	
	public Circulo(Punto origen, double radio) {
		this.origen = origen;
		this.radio = radio;
	}
	
	public String toString() {
		return "Cento: "+this.origen+" Radio: "+radio;
	}
	
	public boolean contiene (Punto p) {
		return this.origen.distancia(p) <= this.radio; 
	}
	
	public boolean interseccion (Circulo c) {
		return this.origen.distancia(c.origen) <= this.radio + c.radio;
	}
	
	public static void main(String[] args) {
		/* Constructor Circulo*/
		Punto p1 = new Punto(0, 0);
		Circulo c1 = new Circulo (p1, 5);
		System.out.println(c1);
		
		/* Punto contenido */
		System.out.println("\n----Punto contenido----");
		Punto p2 = new Punto(3,3);
		System.out.println(c1.contiene(p2));
		Punto p3 = new Punto(5.1,0);
		System.out.println(c1.contiene(p3));
		
		/* Distancia radio */
		System.out.println("\n----Circulos interseccion----");
		Circulo c2 = new Circulo (p2, 5);
		Circulo c3 = new Circulo (p3, 5);
		System.out.println(c1.interseccion(c2));
		System.out.println(c1.interseccion(c3));
		
	}

}
