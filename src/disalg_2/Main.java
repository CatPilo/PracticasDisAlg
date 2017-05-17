import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//int[] q = {1, 1, 3, 2};
		
		Scanner sc = new Scanner(System.in);
		Estado estado = preguntarEstado(sc); //new Estado(q);
		Nim juego = new Nim(estado);
		
		boolean badInput = true;
		int fOb;
		do {
			System.out.println("Introduce 1 para versión forward, 2 para versión backward (1/2):");
			fOb = sc.nextInt();
			badInput = fOb != 1 && fOb != 2;
		} while(badInput);
		
		System.out.println("Comienza el juego.");
		do {
		System.out.println("Estado actual:");
		System.out.print(estado.toString());
		int fila;
		do {
			System.out.print("¿De qué fila quitamos? ");
			fila = sc.nextInt() - 1;
			badInput = fila < 0 || fila >= estado.getSticks().length || estado.getSticks()[fila] == 0;
			if(badInput) {
				System.out.println("Fila incorrecta");
			}
		} while(badInput);
		int palillosQuitamos;
		do {
			System.out.print("¿Cuántos palillos quitamos? ");
			palillosQuitamos = sc.nextInt();
			badInput = palillosQuitamos <= 0 || palillosQuitamos > estado.getSticks()[fila];
			if(badInput) {
				System.out.println("Número de palillos incorrecto");
			}
		} while(badInput);
		estado.getSticks()[fila] = estado.getSticks()[fila] - palillosQuitamos;
		System.out.println("Tu jugada: ");
		System.out.print(estado.toString());
		System.out.println("Juego yo...");
		juego.setCurrentState(estado);
		if(fOb == 1) {
			juego.forwardSolution();
		} else {
			juego.backwardSolution();	
		}
		estado = juego.getNextTurn();
		} while(!estado.isInitial());
		
		System.out.println("FIN!");
		sc.close();
	}
	
	public static Estado preguntarEstado(Scanner sc) {
		boolean badInput = true;
		int filas;
		do {
		System.out.println("¿De cuántas filas queremos el tablero?");
		filas = sc.nextInt();
		badInput = filas < 1;
		if(badInput) {
			System.out.println("Número de filas incorrecto.");
		}
		} while(badInput);
		Estado e = new Estado(filas);
		int palillos;
		for(int i = 0; i < filas; i++) {
			do {
				System.out.println("¿Cuántos palillos hay en la fila " + (i+1) + " ?");
				palillos = sc.nextInt();
				badInput = palillos <= 0;
				if(badInput) {
					System.out.println("Número de palillos incorrecto.");
				}
			} while(badInput);
			e.getSticks()[i] = palillos;
		}
		return e;
	}
}