package disAlgoritmos_Pract1;

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
	
	public double biseccionPilas (double [] variables, double error){
		Stack<Double> izquierda=new Stack<Double>();
		Stack<Double> derecha=new Stack<Double>();
		izquierda.push(variables[0]);
		derecha.push(variables[1]);
		double valormedio=(variables[0]+variables[1])/2;
		
		while(Math.abs(ecuacion.evaluar(valormedio))>error){
			if(ecuacion.evaluar(valormedio)*ecuacion.evaluar(izquierda.peek())>0){
				izquierda.push(valormedio);
				derecha.push(derecha.peek());
			}else{
				derecha.push(valormedio);
				izquierda.push(izquierda.peek());
			}
			valormedio= (izquierda.peek()+derecha.peek())/2.0;
		}
		return valormedio;
	}
	
	
}//Class

