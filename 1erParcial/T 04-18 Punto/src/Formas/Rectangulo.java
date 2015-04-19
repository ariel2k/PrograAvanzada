package Formas;

public class Rectangulo {
	private Punto p1,
				  p2; 
	private double largo;
	private double alto;
	
	public Rectangulo(Punto p1, Punto p2) {
		this.p1 = p1;
		this.p2 = p2;
		this.largo = Math.abs(this.p1.getX() - this.p2.getX());
		this.alto = Math.abs(this.p1.getY() - this.p2.getY());
	}
	
	public String toString() {
		return "Largo: "+this.largo+" Alto: "+this.alto+"\n"+this.p1+" "+this.p2;
	}
	
	private int puntoTriangulo() {
		/*	Sup Izq 
			this.p1.getX() < this.p2.getX()
			this.p1.getY() > this.p2.getY()
		*/
		if( this.p1.getX() < this.p2.getX() &&
			this.p1.getY() > this.p2.getY())
				return 1;
			
		/*	Sup Der 
			this.p1.getX() > this.p2.getX()
			this.p1.getY() > this.p2.getY()
		*/		
		if( this.p1.getX() > this.p2.getX() &&
			this.p1.getY() > this.p2.getY())
				return 2;

		/*	Inf Izq 
			this.p1.getX() < this.p2.getX()
			this.p1.getY() < this.p2.getY()
		*/		
		if( this.p1.getX() < this.p2.getX() &&
			this.p1.getY() < this.p2.getY())
				return 3;

		/*	Inf Der 
			this.p1.getX() > this.p2.getX()
			this.p1.getY() < this.p2.getY()
		*/		
		if( this.p1.getX() > this.p2.getX() &&
			this.p1.getY() < this.p2.getY())
				return 4;
		
		return 0;
	}


	public boolean puntoEnRectanulo(Punto p) {
		
	}
	
	public static void main(String[] args) {
		Punto p1 = new Punto(1,1);
		Punto p2 = new Punto(2,2);
		Rectangulo r1 = new Rectangulo(p1, p2);
		System.out.println(r1);
	}
}
