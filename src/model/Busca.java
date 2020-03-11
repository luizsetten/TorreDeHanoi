package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Busca {
	protected final ModeloTransicao m;
	private ArrayList<Estado> borda; 
	private HashMap<String, Estado> rc;
	public Busca () {
		m = new ModeloTransicao();
		borda = new ArrayList<>();
		rc = new HashMap<>();
		int ambiente[][] = {
				{0,1,0},
				{0,1,0},
				{0,1,0},
				{0,1,0}
		};//Determina o estado inicial {0,1,0,},{1,1,0},{1,0,0}
		borda.add(new Estado(null, ambiente)); //Determina a posição inicial do aspirador
	}
	
	public void fazBusca() {
		while(!borda.isEmpty()) {
			Estado e = borda.remove(borda.size()-1);  // <--- Profundidade -> borda.size()-1 | Largura -> 0
			rc.put(e.geraIdentificador(), e); 
			
			//expandeNo(e);

			if(checaObjetivo(e)) {
				//System.out.println("Chegou");
				exibeCaminho(e);
				break;	
			}
		}		
	}
	
	private boolean checaObjetivo(Estado e) {
		int discos[][] = e.getAmbiente();
		
		int[][] ambiente = new int[discos.length][discos[0].length];
		
		for(int j = 0; j < discos[0].length; j++) {
		for(int i = 0; i < discos.length; i++) {
				ambiente[i][j] = discos[i][j];
				System.out.print(ambiente[i][j] + "");
				if(ambiente[i][j] == 0) {
					break;
				}
				if(ambiente[discos.length-1][j] == 1) {
					return true;
				}
			}
			System.out.println();
		}
		
		return false;
	}
	
	private void expandeNo(Estado e) {
		// Fazer verificação se não está na borda ou na região conhecida
		
		int ambiente[][] = e.getAmbiente();
		
		

	}
	
	private boolean checaRCeBorda(Estado e1) {		
        for (Estado e2 : borda) {
            if (e2.geraIdentificador() == (e1.geraIdentificador())) {
                return true;
            }
        }
        return rc.containsKey(e1.geraIdentificador());
	}	
	
    public void exibeCaminho(Estado e) {
        if (e.getPai() != null) {
        	//System.out.println(e.toString());
            exibeCaminho(e.getPai());
        }
       System.out.println("\n" + e.toString());

    }
	
}
