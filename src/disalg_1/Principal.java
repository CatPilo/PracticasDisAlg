package disalg_1;

public class Principal {

	public static void main(String[] args) {
		double[] coeficientes = {-1, 0, 5, 1};
		Polinomio ecuacion = new Polinomio(coeficientes);
		Biseccion biseccion = new Biseccion(ecuacion);
		double[] intervalo = {0, 2};
		double error = 0.000000001;
		intervalo = biseccion.biseccionRecursiva(intervalo, error);
		System.out.println(intervalo[0] + " " + intervalo[1]);
	}

}
