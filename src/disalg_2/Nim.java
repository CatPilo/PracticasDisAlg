import java.util.ArrayList;

public class Nim {

	Estado finalturn;
	Estado firststate;
	
	public Nim (Estado estadoInicial) {
		this.firststate = estadoInicial;
		finalturn = null;
	}
	
	/*public boolean backwardSolution(ArrayList<Estado> hijos, Estado actual) {
		if(hijos.contains(actual) && hijos.get(hijos.indexOf(actual)).getWinner() != -1) {
			int winner = hijos.get(hijos.indexOf(actual)).getWinner();
			if(winner == 0) {
				return false;
			} else {
				return true;
			}			
		}
		
		
	}*/
	public boolean backwardSolution(int[] a) {	
		int sum = 0;
		
		for(int i=0; i < a.length; i++) {
			sum += a[i];
		}
		
		if(sum == 0) {
			return false;
		} else {
			ArrayList<int[]> arrayHijos = hijos(a);
			for(int i=0; i < arrayHijos.size(); i++) {
				if(!backwardSolution(arrayHijos.get(i))) {		
					return true;
				}
			}
			return false;
		}
	}
	
	
	public void forwardSolution(ArrayList<Estado> hijos) {
		int count = 0;
	    finalturn = null;
		while (count < hijos.size() && finalturn == null) {
			Estado actual = hijos.get(count);
			for(Estado previous : Main.hijos(actual)) {
				if(hijos.contains(previous)) {
					previous = hijos.get(hijos.indexOf(previous));
				} else {
					hijos.add(previous);
				}
				
				if(actual.getWinner() == 0) {
					previous.setWinner(1);
					if(previous.equals(firststate)) {
						finalturn = actual;
					}
				}
			}
			count++;
		}
	}
	
	public static ArrayList<int[]> hijos(int[] a) {
		ArrayList<int[]> arrayHijos = new ArrayList<int[]>();
		int[] hijo;
		for(int i=0; i < a.length; i++) {
			for(int j=1; j <= a[i]; j++) {
				hijo = a.clone();
				hijo[i] = a[i] - j;
				arrayHijos.add(hijo);
			}
		}
		return arrayHijos;
	}
}
