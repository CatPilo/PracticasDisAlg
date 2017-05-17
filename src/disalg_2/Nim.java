import java.util.ArrayList;
import java.util.Arrays;

public class Nim {

	private Estado nextturn;
	private Estado currentstate;
	private ArrayList<Estado> listaEstados;
	
	public Nim (Estado firstate) {
		this.currentstate = firstate;
		nextturn = null;
		listaEstados = new ArrayList<Estado>();
		listaEstados.add(new Estado(currentstate.getSticks().length));
	}
	
	public void backwardSolution() {
		nextturn = null;
		backwardSolution(currentstate);
	}
	
	public void backwardSolution(Estado e) {	
		ArrayList<Estado> arrayHijos = e.calcularHijos();
		for(int i = 0; i < arrayHijos.size(); i++) {
			Estado hijo = arrayHijos.get(i);
			
			if(listaEstados.contains(hijo)) {
				hijo = listaEstados.get(listaEstados.indexOf(hijo));
			} else {
				backwardSolution(hijo);
				listaEstados.add(hijo);
			}
			
			if(!hijo.getWinner()) {
				e.setWinner(true);
				if(e.equals(this.currentstate)) {
					nextturn = hijo;
				}
			}
		}
	}
	
	public void forwardSolution() {
		nextturn = null;
		int count = 0;
		while (count < listaEstados.size() && nextturn == null) {
			Estado actual = listaEstados.get(count);
			// Generamos padres
			ArrayList<Estado> padresActual = new ArrayList<Estado>();
			for(int i = 0; i < currentstate.getSticks().length; i++) {
				for(int j = 1; j <= (currentstate.getSticks()[i] - actual.getSticks()[i]); j++) {
					int[] sticksHijo = actual.getSticks().clone();
					sticksHijo[i] += j;
					padresActual.add(new Estado(sticksHijo));
				}
			}
			
			for(Estado previous : padresActual) {
				if(listaEstados.contains(previous)) {
					previous = listaEstados.get(listaEstados.indexOf(previous));
				} else {
					listaEstados.add(previous);
				}
				
				if(!actual.getWinner()) {
					previous.setWinner(true);
					if(currentstate.equals(previous)) {
						nextturn = actual;
					}
				}				
			}		
			count++;
		}
	}
	
	public Estado getNextTurn() {
		if(nextturn != null) {
			return nextturn;
		} else {// En caso de fracaso, devolver un estado cualquiera
			System.out.println("FRACASO!");
			ArrayList<Estado> arrayHijos = currentstate.calcularHijos();
			return arrayHijos.get(0);
		}
	}
	
	public void setCurrentState(Estado e) {
		currentstate = e;
	}
}
