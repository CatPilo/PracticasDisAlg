import java.util.*;
import java.io.*;

public class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main (String [] args) throws IOException{
		
		System.out.println("Introduzca el patrón que desea buscar");
		String patron = scan.next();
		System.out.println("Introduzca el porcentaje de texto que desea explorar");
		int porcentaje = scan.nextInt();
		int lineasTotales = cuentalineas("quijoteCap1.txt");
		int seSaltanEstasLineas=100/porcentaje;
		System.out.println("El texto que va a analizarse es: ");
		String analizable =leerFichero("quijoteCap1.txt",seSaltanEstasLineas,lineasTotales);
		System.out.println(analizable);
		System.out.println("MÉTODO NAIVE: ");
		System.out.println("LLega"+imprimeResultados(KnuthMorrisPrat(patron,analizable)));
		
	}//Main
	public static String leerFichero(String fichero,int saltos, int lTotales){
		File file = new File(fichero);
		String textoAnalizable="";
		int i;
	    try {
	        Scanner sc = new Scanner(file);

	        for(i=0;sc.hasNextLine() && i<lTotales;i+=saltos) {
	            textoAnalizable+=sc.nextLine()+"\n";
	        }
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    return textoAnalizable;
	}
	public static int cuentalineas(String file) throws IOException{
		int nLineas=0;
		String cadena;
		FileReader f = new FileReader(file);
		BufferedReader b = new BufferedReader(f);
		while((cadena = b.readLine())!=null) {
			nLineas++;
		}

		b.close();
		return nLineas;
	}
	
	public static ArrayList<Integer> Naive(String patron,String texto){
		ArrayList<Integer> ocurrencias=new ArrayList<Integer>();//posicionde las coincidencias
		if(patron.length()>0 && texto.length()>=patron.length()){
			int t=0;//desplazamiento en el texto
			int p=0;//desplazamiento en el patron
			while(texto.length()-t>=patron.length()){
				if(texto.charAt(t)==patron.charAt(p)){//busqueda
					int T=t+1;int P=1;
					while(P<patron.length() && texto.charAt(T)==patron.charAt(P)){
						T++;
						P++;
					}
					if(P==patron.length()) ocurrencias.add(t);
				}
				t++;
			}
		}
		return ocurrencias;
	}
	
	public static String imprimeResultados(ArrayList <Integer>lista){
		int i;
		for(i=0;i<lista.size();i++){
			System.out.print(lista.get(i));
		}
		return "llega";	
	}
	
	static LinkedList luis(String archivo,int lineas,int valor,int repeticiones){
		int aleatorio=0;
		LinkedList<Integer> list=new LinkedList();
		int segmento=(int)lineas/valor;
		for(int i=0;i<valor;i++){
			int inicio=i*segmento;
			int fin=i*segmento+segmento;
			for(int j=0;j<repeticiones;j++){
				do {
					aleatorio=generaNumeroAleatorio(inicio,fin);
				}while(buscarlinea(list,aleatorio));
				list.add(aleatorio);
			}
		}

		return list;
	}
	
	public static int generaNumeroAleatorio(int minimo,int maximo) {
		return ((int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo)));
	}
	
	public static boolean buscarlinea(LinkedList<Integer> lista,int linea) {
		boolean encontrado=false;
		for (int i=0;i<lista.size() && !encontrado;i++)  {
			if (lista.get(i)==linea)
				encontrado=true;
		}
		return encontrado;
	}
	//*************************************************************************************************
	public static ArrayList<Integer> KnuthMorrisPrat(String patron,String texto,int[] fallo){
		ArrayList<Integer> pos=new ArrayList<Integer>();
		int t=0;
		int p=0;
		while(texto.length()-t>=patron.length()){
			if(p==patron.length()){
				pos.add(t);
				p=0;
				t++;
			}
			else{
				if(texto.charAt(t+p)==patron.charAt(p)) p++;
				else{
					t=t+p-fallo[p];
					if(p>0) p=fallo[p];
				}
			}
		}
		return pos;
	}
	public static ArrayList<Integer> KnuthMorrisPrat(String patron,String texto){
		ArrayList<Integer> ocurrencias=new ArrayList<Integer>();
		if(patron.length()>0 && texto.length()>=patron.length()){
			int[] fallo=new int[patron.length()];
			fallo=preproceso(patron);//matriz de fallos
			ocurrencias=KnuthMorrisPrat(patron,texto,fallo);
		}
		return ocurrencias;
	}
	public static int[] preproceso(String patron){
		int[] fallo=new int[patron.length()];
		int i=2;
		int j=0;
		fallo[0] = -1;
		if(patron.length()>1){
			fallo[1]=0;
			while(i < patron.length()) {
				if(patron.charAt(i-1)==patron.charAt(j)){
					j++;
					fallo[i]=j;
					i++;
				}
				else{
					if(j>0) j=fallo[j];
					else{
						fallo[i]=0;
						i++;
					}
				}
			}
		}
		return fallo;
	}
}
