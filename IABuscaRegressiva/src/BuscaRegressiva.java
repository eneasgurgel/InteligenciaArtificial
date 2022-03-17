import java.util.*;

public class BuscaRegressiva {
	private String[] alfabeto = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private Stack<Integer> LE;
	private Stack<Integer> LNE;
	private Stack<Integer> BSS;
	private Integer EC;
	private Integer antecessor;
	private Stack<Integer> resposta;
	
	
	public BuscaRegressiva(Grafo grafo, int inicial, String objetivo) {
		
		this.LE = new Stack<Integer>();
		this.LNE = new Stack<Integer>();
		this.BSS = new Stack<Integer>();
		this.EC = inicial;
		this.LE.push(inicial);
		this.LNE.push(inicial);
		
		int IndexObjetivo = Arrays.asList(alfabeto).indexOf(objetivo);
		
		if(IndexObjetivo >= grafo.qtdVertices) {
			System.err.println("Destino tem que estar dentro do Grafo!");
		}else {
		
			resposta = execute(grafo, inicial, IndexObjetivo);
		
			System.out.println(traduzir(resposta,inicial, IndexObjetivo));
		
		}
	}
	
	private Stack<Integer> execute(Grafo grafo, int inicial, int objetivo) {
		while(!LNE.isEmpty()) {
			imprimeEstruturas();
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
	
	private String traduzir(Stack<Integer> caminho, int inicial,int destino) {
		String result = "Não tem caminho! ";
		if (caminho != null) {
			result = "";
			
			for (int n : caminho) {
				result += alfabeto[n] + '-';
			}
		}
		return "Caminho de " + alfabeto[inicial] + " para " + alfabeto[destino]+": "+result.replaceFirst(".$", "");
	}
	private void imprimeEstruturas() {
		String resultBSS = "BSS: ";
		for (int n : this.BSS) {
			resultBSS += alfabeto[n] + '-';
			
		}
		System.out.println(resultBSS.replaceFirst(".$", ""));
		
		String resultLNE = "LNE:";
		for (int n : this.LNE) {
			resultLNE += alfabeto[n] + '-';
		}
		System.out.println(resultLNE.replaceFirst(".$", ""));
		
		String resultLE = "LE:";
		for (int n : this.LE) {
			resultLE += alfabeto[n] + '-';
		}
		System.out.println(resultLE.replaceFirst(".$", ""));
		
		System.out.println("EC: "+alfabeto[this.EC]);
		System.out.println("-----------------------------");


	}
}