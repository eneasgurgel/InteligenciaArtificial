import java.util.*;

public class Main {

	public static void main(String[] args) {

		Grafo grafo = new Grafo(12);

		// [0,1,2,3,4,5,6,7,8,9]
		// [A,B,C,D,E,F,G,H,I,J]

		grafo.addAresta(0, 1);
		grafo.addAresta(0, 2);
		grafo.addAresta(0, 3);

		grafo.addAresta(1, 4);
		grafo.addAresta(1, 5);

		grafo.addAresta(2, 5);

		grafo.addAresta(2, 6);
		grafo.addAresta(4, 7);
		grafo.addAresta(4, 8);

		grafo.addAresta(5, 11);

		int origem = 0;
		int destino = 6;

		System.out.println("Caminho de A até G:");
		BuscaRegressiva busca1 = new BuscaRegressiva(grafo, origem, destino);
		
		origem = 0;
		destino = 10;
		
		System.out.println("Caminho de A até M:");
		BuscaRegressiva busca2 = new BuscaRegressiva(grafo, origem, destino);

	}

}
