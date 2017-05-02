import java.util.Random;

public class Probabilistas {
	
	public float Montecarlo(int n_puntos) {
		int caeDentro = 0;
		for(int i = 0; i < n_puntos; i++) {
			float x = new Random().nextFloat();
			float y = new Random().nextFloat();
			float z = 2 * (new Random().nextFloat());
			
			if((Math.pow(x, 2) + Math.pow(y,2)) <= z) {
				caeDentro++;
			} 
		}
		return (2 * caeDentro) / (float) n_puntos;
	}
}
