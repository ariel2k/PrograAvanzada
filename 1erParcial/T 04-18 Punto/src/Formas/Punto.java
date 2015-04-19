package Formas;

public class Punto {

	/*
	 * Ocupa un lugar en el plano
	 * Tiene que saber un punto la distancia a otro punto
	 * */
	private double x;
	private double y;
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Punto() {
		new Punto(0,0);
	}
	
	public String toString() {
		return "("+this.x+", "+this.y+")";
	}
	
	public double distancia(Punto p) {
		return (Math.sqrt((this.x - p.x)*(this.x - p.x) + (this.y - p.y)*(this.y - p.y)));
	}
	
	public static void main(String[] args) {
		Punto p1 = new Punto (5, 4);
		Punto p2 = new Punto (3, 9);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("Distancia: "+p1.distancia(p2));
	}

}
