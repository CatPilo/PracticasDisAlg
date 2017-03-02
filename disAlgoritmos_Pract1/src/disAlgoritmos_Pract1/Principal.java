package disAlgoritmos_Pract1;

public class Principal {

	public static void main(String[] args) {
		double[] coeficientes = {-1, 0, 5, 1};
		Polinomio ecuacion = new Polinomio(coeficientes);
		Biseccion biseccion = new Biseccion(ecuacion);
		double[] intervalo = {0, 2};
		long[] tiemposRecur = {};
		long[] tiemposPilas = {};
		double error = 2;
		for(int i=0; i <= 20 ; i++) {
		    long startTimeRecur = System.currentTimeMillis();
		    biseccion.biseccionRecursiva(intervalo, error);
		    tiemposRecur[i] = System.currentTimeMillis() - startTimeRecur;
		    long startTimePilas = System.currentTimeMillis();
		    biseccion.biseccionPilas(intervalo, error);
		    tiemposPilas[i] = System.currentTimeMillis() - startTimePilas;

		    error *= 0.1;
		    System.out.println("Recursivo: " + tiemposRecur[i] + " Pilas: " + tiemposPilas[i]);
		}	        
	}

}
