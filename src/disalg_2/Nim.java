import java.util.ArrayList;

public class Nim {

	private Estado finalturn;
	private Estado firststate;
	
	public Nim (Estado firstate) {
		this.firststate = firstate;
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
			ArrayList<int[]> arrayHijos = calcularHijos(a);
			for(int i=0; i < arrayHijos.size(); i++) {
				if(!backwardSolution(arrayHijos.get(i))) {		
					return true;
				}
			}
			return false;
		}
	}
	
	
	public void forwardSolution() {
		ArrayList<Estado> hijos = firststate.calcularHijos();
		int count = 0;
	    finalturn = null;
		while (count < hijos.size() && finalturn == null) {
			Estado actual = hijos.get(count);
			ArrayList<Estado> hijosActual = actual.calcularHijos();
			for(Estado previous : hijosActual) {
				if(hijos.contains(previous)) {
					previous = hijos.get(hijos.indexOf(previous));
				} else {
					if(actual.getWinner() == 0) {
						previous.setWinner(1);
						if(previous.equals(firststate)) {
							finalturn = actual;
						}
					}
					hijos.add(previous);
				}		
			}
			count++;
		}
	}
	
	public Estado getFinalTurn() {
		return finalturn;
	}
}
