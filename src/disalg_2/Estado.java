
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
