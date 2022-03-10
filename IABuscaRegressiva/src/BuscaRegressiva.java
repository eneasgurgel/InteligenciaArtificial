import java.util.*;

public class BuscaRegressiva {
	private Stack<Integer> LE;
	private Stack<Integer> LNE;
	private Stack<Integer> BSS;
	private Integer EC;
	private Integer antecessor;
	private Stack<Integer> resposta;
	
	
	public BuscaRegressiva(Grafo grafo, int inicial, int objetivo) {
		this.LE = new Stack<Integer>();
		this.LNE = new Stack<Integer>();
		this.BSS = new Stack<Integer>();
		this.EC = inicial;
		this.LE.push(inicial);
		this.LNE.push(inicial);
		
		resposta = execute(grafo, inicial, objetivo);
		
		System.out.println(traduzir(resposta));
	}
	
	private Stack<Integer> execute(Grafo grafo, int inicial, int objetivo) {
		while(!LNE.isEmpty()) {
			if (EC == objetivo) {
				System.out.println("Primeiro");
				System.out.println(LE);
				System.out.println("--");
				System.out.println(LNE);
				System.out.println("--");
				System.out.println(BSS);
				System.out.println("--");
				System.out.println(EC);
				return LE;
			}
			System.out.println("a");
			System.out.println(grafo.getAdjacentes(EC));
			List <Integer> a = grafo.getAdjacentes(EC);
			a.remove(EC);
			a.remove(antecessor);
			System.out.println("depois do EC: "+grafo.getAdjacentes(EC));
			if (a.isEmpty()) {
				System.out.println("s");
				System.out.println(BSS);
				while((!LE.isEmpty()) && (EC == LE.peek())) {
					BSS.push(EC);
					LE.pop();
					LNE.pop();
					EC = LNE.peek();
					
				}
				
				LE.push(EC);
			}
			else {
				List<Integer> filhos = new ArrayList<Integer>();
				for(int filho : grafo.getAdjacentes(EC)) {
					if ((!BSS.contains(filho)) && (!LE.contains(filho)) && (!LNE.contains(filho))){
						
						filhos.add(filho);
						System.out.println("b");
						System.out.println(LNE);
					}
				}
				for(int i = filhos.size() -1 ; i >= 0 ; i--) {
					LNE.push(filhos.get(i));
				}
				antecessor=EC;
				EC = LNE.peek();
				LE.push(EC);
			}
		}
		return null;
	}
	
	private String traduzir(Stack<Integer> caminho) {
		String result = "Não tem caminho!";
		if (caminho != null) {
			result = "";
			String[] alfabeto = {"A","B","C","D","E","F","G","H","I","J"};
			for (int n : caminho) {
				result += alfabeto[n] + '-';
			}
		}
		return result;
	}
}
