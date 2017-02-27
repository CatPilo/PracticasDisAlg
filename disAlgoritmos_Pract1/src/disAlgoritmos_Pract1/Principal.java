package disAlgoritmos_Pract1;

public class Principal {

	public static void main(String[] args) {
		double[] coeficientes = {-1, 1, 0, 1};
		Polinomio ecuacion = new Polinomio(coeficientes);
		Biseccion biseccion = new Biseccion(ecuacion);
		double[] intervalo = {0, 1};
		double error = 0.000000001;
		double resultado = biseccion.biseccionPilas(intervalo,error);
		intervalo = biseccion.biseccionRecursiva(intervalo, error);
		System.out.println(intervalo[0] + " " + intervalo[1]);
		System.out.println("X=0 para el valor = "+resultado);
	}

}
