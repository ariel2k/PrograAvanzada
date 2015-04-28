package calculadora;
public class Calculadora {

	private double numAnt=0;
	
	public int sumar(int num1, int num2) {
		if(num1 < 0 || num2 < 0)
			throw new RuntimeException();
		numAnt = num1 + num2;
		return (int)numAnt;
	}
	
	public double sumar(double num1, double num2) {
		numAnt = num1 + num2;
		return numAnt;
	}
	
	public double dividir(double num1, double num2) {
		if(num2 == 0)
			throw new RuntimeException();
		return num1/num2;
	}
	
	public int sumarConMemoria(int n) {
		numAnt += n;
		return (int)numAnt;
	}
}
