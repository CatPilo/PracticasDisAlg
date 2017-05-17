import java.util.ArrayList;
import java.util.Arrays;

public class Estado {
	private int[] sticks;
	private boolean winner;
	
	public Estado(int n_filas) {
		this.sticks = new int[n_filas];
		this.winner = false;
	}
	
	public Estado(int[] sticks) {
		this.sticks = sticks;
		this.winner = false;
	}
	
	public boolean isInitial() {
		for(int i=0; i < sticks.length; i++) {
			if(sticks[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public ArrayList<Estado> calcularHijos() {
		ArrayList<Estado> arrayHijos = new ArrayList<Estado>();
		for(int i=0; i < sticks.length; i++) {
			for(int j=1; j <= sticks[i]; j++) {
				int[] sticksHijo = sticks.clone();
				sticksHijo[i] = sticks[i] - j;
				arrayHijos.add(new Estado(sticksHijo));
			}
		}
		return arrayHijos;
	}

	public int[] getSticks() {
		return sticks;
	}
	public void setSticks(int[] sticks) {
		this.sticks = sticks;
	}
	public boolean getWinner() {
		return winner;
	}
	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o == this) return true;
		Estado e = (Estado) o;
		return Arrays.equals(sticks, e.getSticks()) ;
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i < sticks.length; i++) {
			s += Integer.toString(i+1) + " - ";
			for(int j = 0; j < sticks[i]; j++) {
				s += "| ";
			}
			s += "\t(" + sticks[i] + ")\n";
		}
		return s;
	}
}
