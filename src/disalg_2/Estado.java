import java.util.ArrayList;

public class Estado {
	private int[] sticks;
	private int winner;
	
	public Estado(int[] sticks) {
		this.sticks = sticks;
		
		int sum = 0;
		for(int i = 0; i < sticks.length; i++) {
			sum += sticks[i];
		}
		if(sum == 0) {
			this.winner = 0;
		} else {
			this.winner = -1;
		}
		
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
	public int getWinner() {
		return winner;
	}
	public void setWinner(int winner) {
		this.winner = winner;
	}
	
	
}
