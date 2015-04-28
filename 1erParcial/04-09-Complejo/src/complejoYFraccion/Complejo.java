package complejoYFraccion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Complejo implements Comparable<Complejo>{

	private double  real,
					img;
	
	public Complejo(){
		real = 0;
		img = 0; 
	}
	
	public Complejo(double real, double img){
		this.real = real;
		this.img = img;
	}
	
	public int compareTo(Complejo c) { 
		return (int) (this.modulo() - c.modulo());
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
		/*
		Random rnd = new Random();
		double c1,
			   c2;
		Complejo aux;
		int cant=10;
		Complejo[] c = new Complejo[cant];
		for(int i=0; i<cant; i++) {
			aux = new Complejo(10-i,10-i);
			c[i] = aux;
		}
		
		for(int i=0; i<cant; i++)
			System.out.println(c[i]);
		
		System.out.println("-------------------------");
				
		Arrays.sort(c);
		
		for(int i=0; i<cant; i++)
			System.out.println(c[i]);
		 */

		ArrayList<Complejo> lc = new ArrayList<Complejo>();
		Complejo aux;
		int cant=10;
		for(int i=0; i<cant; i++) {
			aux = new Complejo(10-i,10-i);
			lc.add(aux);
		}
		
		for(Complejo o : lc)
			System.out.println(o);
		
		System.out.println("-------------------------");
				
		Collections.sort(lc);
		
		for(Complejo o : lc)
			System.out.println(o);
	}
}
