package model;

public class ModeloTransicao {
	/**
	 * 
	 * @param torre de origem vai de 0 à ambiente 
	 * @param torre de destino
	 * @param ambiente
	 * @return Retorna um novo estado, se possivel, se não retorna NULL
	 */
	public Estado mover(Estado pai, int origem, int destino, int ambiente[][]) {
		for(int i = 0; i < ambiente[0].length; i++) {
			if(ambiente[origem][i] == 1) {
				for(int j = 0; j < i; j++) {
					if(ambiente[destino][j] == 1) {
						break;
					}
					if(j == i) {
						ambiente[origem][j] = 0;
						ambiente[destino][j] = 1;
						break;
					}
				}
				break;
			}
		}
		
		return new Estado(pai, ambiente);
	}
	/**
	 * Pode fazer com hastes (com pilhas) um vetor de pilhas 
	 * 
	 * 
	 * Pode fazer com tabela (linha a haste e coluna o prato)
	 * 
	 * 
	 * 
	 */
}


