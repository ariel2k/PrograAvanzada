package fracc;

public class Fraccion {

	private int numerador,
				 denominador;
	
	public Fraccion(int numerador, int denominador){
		this.numerador = numerador;
		this.denominador = denominador;
		this.simplificar(this);
	}
	
	private int mcd(int a, int b){
		if(b==0)
           return a;
       else
           return mcd(b, a % b);
	}
	
	private Fraccion simplificar(Fraccion f){
		int mcd = this.mcd(this.numerador, this.denominador);
		numerador/=mcd;
		denominador/=mcd;
		return this;
	}
	
	public String toString(){
		return numerador+"/"+denominador;
	}
	
	public Fraccion sumar(Fraccion f){
		return new Fraccion(this.numerador*f.denominador + f.numerador*this.denominador, this.denominador*f.denominador); //a.num*b.den+b.num*a.den, a.den*b.den);
	}	
	
	public Fraccion restar(Fraccion f){
		return new Fraccion(this.numerador*f.denominador - f.numerador*this.denominador, this.denominador*f.denominador); //a.num*b.den+b.num*a.den, a.den*b.den);
	}	

	public Fraccion multiplicar(Fraccion f){
		return new Fraccion(this.numerador * f.numerador, this.denominador*f.denominador);
	}
	
	public Fraccion dividir(Fraccion f){
		return new Fraccion(this.numerador * f.denominador, this.denominador*f.numerador);
	}
	
	public Fraccion inversa(){
		return new Fraccion(this.denominador, this.numerador);
	}
	
	public static void main(String[] args){
		Fraccion f1 = new Fraccion(1,5);
		Fraccion f2 = new Fraccion(5,10);
		System.out.println(f2);
		System.out.println(f1.multiplicar(f2));
	}

}
