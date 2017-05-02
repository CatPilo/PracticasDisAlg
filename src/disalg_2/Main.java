import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		int[] q = {1, 2};
		Estado estadoInicial = new Estado(q);
		Nim juego = new Nim(estadoInicial);
		ArrayList<Estado> estados = new ArrayList<Estado>();
		juego.forwardSolution(estados);
		
		System.out.println(juego.finalturn);
		System.out.println(juego.backwardSolution(q));

	}
	public static ArrayList<Estado> hijos(Estado e) {
		ArrayList<Estado> arrayHijos = new ArrayList<Estado>();
		int[] a = e.getSticks();
		Estado hijo;
		for(int i=0; i < a.length; i++) {
			for(int j=1; j <= a[i]; j++) {
				hijo = new Estado(a);
				hijo.getSticks()[i] = hijo.getSticks()[i] - j;
				arrayHijos.add(hijo);
			}
		}
		return arrayHijos;
	}
	
	
}
