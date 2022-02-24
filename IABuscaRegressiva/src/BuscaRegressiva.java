import java.util.*;

public class BuscaRegressiva {
	private Stack<Integer> LE;
	private Stack<Integer> LNE;
	private Stack<Integer> BSS;
	private Integer EC;
	private Stack<Integer> resposta;
	
	
	public BuscaRegressiva(Grafo grafo, int inicial, int objetivo) {
		LE = new Stack<Integer>();
		LNE = new Stack<Integer>();
		BSS = new Stack<Integer>();
		EC = inicial;
		
		resposta = execute(grafo, inicial, objetivo);
		
		System.out.println(traduzir(resposta));
	}
	
	private Stack<Integer> execute(Grafo grafo, int inicial, int objetivo) {
		while(!LNE.isEmpty()) {
			if (EC == objetivo) {
				return LE;
			}
			if (grafo.getAdjacentes(EC).isEmpty()) {
				while((!LE.isEmpty()) && (EC == LE.firstElement())) {
					BSS.add(EC);
					LE.remove(0);
					LNE.remove(0);
					EC = LNE.elementAt(0);
				}
				LE.add(EC);
			}
			else {
				for(int filho : grafo.getAdjacentes(EC)) {
					if ((!BSS.contains(filho)) && (!LE.contains(filho)) && (!LNE.contains(filho))){
						LNE.add(filho);
					}
				}
				EC = LNE.firstElement();
				LE.add(EC);
			}
		}
		return null;
	}
	
	private String traduzir(Stack<Integer> caminho) {
		String result = "Não tem caminho!";
		if (caminho != null) {
			result = "";
			String[] alfabeto = {"A","B","C","D","E","F","G"};
			for (int n : caminho) {
				result = alfabeto[n] + '-';
			}
		}
		return result;
	}
}
