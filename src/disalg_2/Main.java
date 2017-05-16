import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		int[] q = {1, 1};
		Estado estadoInicial = new Estado(q);
		Nim juego = new Nim(estadoInicial);
		juego.forwardSolution();
		
		int[] sticksfinalTurn = juego.getFinalTurn().getSticks();
		for(int i = 0; i < sticksfinalTurn.length; i++) {
			System.out.print(sticksfinalTurn[i]);
		}
	}
}