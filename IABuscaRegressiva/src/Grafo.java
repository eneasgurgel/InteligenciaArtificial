import java.util.*;

public class Grafo {
	protected int[][] adjacents;
	protected int qtdVertices;
	
	public Grafo(int qtdVertices) {
		
		this.qtdVertices = qtdVertices;
		this.adjacents = new int[qtdVertices][qtdVertices];
		
		for (int i = 0; i < adjacents.length; i++) {
			for (int j = 0; j < adjacents.length; j++) {
				if (i == j) {
					adjacents[i][j] = 0; 
				} else {
					adjacents[i][j] = 0; 
					adjacents[j][i] = 0; 
				}
			}
		}
		
	}
	
	public void addAresta(int v, int w) {
		
		adjacents[v][w]=1;
		adjacents[w][v]=1;
				
	}

	public List<Integer> getAdjacentes(int v) {
	
		List<Integer> result = new ArrayList<Integer>();
		
		for (int i = 0; i < adjacents.length; i++) {
			if (adjacents[v][i] != 0) {
				result.add(i);
			}
		}
	
		return result;
		
	}
	
}