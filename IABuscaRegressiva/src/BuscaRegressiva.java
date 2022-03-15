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
				return LE;
			}
			List <Integer> a = grafo.getAdjacentes(EC);
			a.remove(EC);
			a.remove(antecessor);
			if (a.isEmpty()) {
				while((!LE.isEmpty()) && (EC == LE.peek())) {
					BSS.push(EC);
					LE.pop();
					LNE.pop();
					if (!LNE.isEmpty()) {
						EC = LNE.peek();
					}
					if(!LE.isEmpty()) {
						antecessor = LE.elementAt(LE.size()-1);
					}	
				}
				
				LE.push(EC);
			}
			else {
				List<Integer> filhos = new ArrayList<Integer>();
				for(int filho : a) {
					if ((!BSS.contains(filho)) && (!LE.contains(filho)) && (!LNE.contains(filho))){
						filhos.add(filho);
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
			String[] alfabeto = {"A","B","C","D","E","F","G","H","I","J","K","M"};
			for (int n : caminho) {
				result += alfabeto[n] + '-';
			}
		}
		return result.replaceFirst(".$", "");
	}
}
