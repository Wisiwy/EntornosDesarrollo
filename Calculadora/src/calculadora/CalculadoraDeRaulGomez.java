package calculadora;

public class CalculadoraDeRaulGomez {
	private int num1, num2;
	
	public CalculadoraDeRaulGomez() {
		
	}

	public CalculadoraDeRaulGomez(int a, int b) {
		num1 = a;
		num2 = b;
	}

	public int suma(int num1, int num2) {
		int resul = num1 + num2;
		return resul;
	}

	public int resta(int num1, int num2) {
		int resul = num1 - num2;
		return resul;
	}

	public int multiplica(int num1, int num2) {
		int resul = num1 * num2;
		return resul;
	}

	public int divide(int num1, int num2) {
		int resul = num1 / num2;
	System.out.println("Hola");
		return resul;
	}
	

}
