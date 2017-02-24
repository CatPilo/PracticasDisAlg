package disalg_1;

import java.util.Stack;

public class Biseccion {
	private Polinomio ecuacion;
	
	public Biseccion(Polinomio ecuacion) {
		this.ecuacion = ecuacion;
	}
	
	public double[] biseccionRecursiva(double[] intervalo, double error) {
		if(Math.abs(intervalo[1] - intervalo[0]) <= error) {
			return intervalo;
		} 			
		double mitad = (intervalo[0] + intervalo[1]) / 2.0;
		intervalo[0] = ecuacion.evaluar(intervalo[0])*ecuacion.evaluar(mitad) < 0 ? 
				intervalo[0] : mitad;
		intervalo[1] = ecuacion.evaluar(intervalo[1])*ecuacion.evaluar(mitad) < 0 ?
				intervalo[1] : mitad;
		
		return biseccionRecursiva(intervalo, error);
	}
	
	public double[] biseccionPilas(double[] intervalo, double error) {
		Stack<Double[]> pN = new Stack<Double[]>(); // Argumentos
		Stack<Double[]> pS = new Stack<Double[]>(); // Resultados
		
		double[] argumentos = {intervalo[0], intervalo[1], error};
		
		while(Math.abs(pN.peek()[1] - pN.peek()[0]) > error) {
			double mitad = (argumentos[0] + argumentos[1]) / 2.0;
			argumentos[0] = ecuacion.evaluar(argumentos[0])*ecuacion.evaluar(mitad) < 0 ? 
					argumentos[0] : mitad;
			argumentos[1] = ecuacion.evaluar(argumentos[1])*ecuacion.evaluar(mitad) < 0 ?
					argumentos[1] : mitad;
		}
	}
}
