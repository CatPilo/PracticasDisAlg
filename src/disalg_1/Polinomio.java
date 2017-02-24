package disalg_1;

public class Polinomio {
	private double[] coeficientes;
	
	public Polinomio(double[] coeficientes) {
		this.coeficientes = coeficientes;
	}
	
	public double evaluar(double x) {
		double sum = 0;
		for(int i = 0; i < coeficientes.length; i++) {
			sum += coeficientes[i] * Math.pow(x, i);
		}
		return sum;
	}
}
