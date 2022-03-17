//import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Grafo grafo = new Grafo(12);

		// [0,1,2,3,4,5,6,7,8,9,10,11]
		// ["A","B","C","D","E","F","G","H","I","J","K"]

		grafo.addAresta(0, 1);
		grafo.addAresta(0, 2);
		grafo.addAresta(0, 3);

		grafo.addAresta(1, 4);
		grafo.addAresta(1, 5);

		grafo.addAresta(2, 5);

		grafo.addAresta(2, 6);
		grafo.addAresta(4, 7);
		grafo.addAresta(4, 8);

		grafo.addAresta(5, 9);

		int origem = 0;
		String destino;
		String escolha = "s";
		Scanner scanDestino = new Scanner(System.in);
		Scanner scanEscolha = new Scanner(System.in);
		
		
		while(escolha.toLowerCase().equals("s")) {
			System.out.println("Digite o destino:");
			destino = scanDestino.next();
			BuscaRegressiva busca1 = new BuscaRegressiva(grafo, origem, destino.toUpperCase());
			System.out.println("Deseja repetir?(S):");
			escolha = scanEscolha.next();
			for (int i = 0; i < 50; ++i) System.out.println();	
		}
		
		scanDestino.close();
		scanEscolha.close();
		
		System.out.println("Fim!");
	}

}