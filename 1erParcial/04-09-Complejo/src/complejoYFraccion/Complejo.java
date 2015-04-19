package complejoYFraccion;

public class Complejo {

	private double real, img;
	
	public Complejo(){
		real = 0;
		img = 0; 
	}
	
	public Complejo(double real, double img){
		this.real = real;
		this.img = img;
	}
		
	public String toString(){
		return this.real+" + "+this.img+"i";
	}

	public Complejo sumar(Complejo c){
		return new Complejo(this.real + c.real, this.img + c.img);
	}
	
	public Complejo restar(Complejo c){
		return new Complejo(this.real - c.real, this.img - c.img);
	}
	
	public Complejo sumar(long n){
		return new Complejo(this.real + n, this.img);
	}
	
	public Complejo restar(long n){
		return new Complejo(this.real - n, this.img);
	}
	
	public Complejo multiplicar(long num){
		return new Complejo(this.real * num, this.img * num);
	}
	
	public Complejo multiplicar(Complejo c){
		return new Complejo(this.real*c.real - this.img*c.img, this.real*c.img + this.img*c.real);
	}
	
	public Complejo dividir(Complejo c){
		return new Complejo((this.real*c.real + this.img*c.img) /(c.real*c.real + c.img*c.img ) ,
				           (this.img*c.real - this.real*c.img) /(c.real*c.real + c.img*c.img ));
	}
	
	public Complejo dividir(long num){
		return new Complejo(this.real / num, this.img / num);
	}
	
	public double modulo(){
		return Math.sqrt(this.real*this.real + this.img*this.img);
	}
	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complejo other = (Complejo) obj;
		if (img != other.img)
			return false;
		if (real != other.real)
			return false;
		return true;
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Complejo c1 = new Complejo(3, 1);
		//Complejo c2 = new Complejo(1,-2);
		System.out.println(c1.modulo());
	}
}