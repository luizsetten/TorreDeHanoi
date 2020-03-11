package model;

public class Estado {
	private Estado pai;
	private int ambiente[][];
	
	public Estado getPai() {
		return this.pai;
	}
	
	public int[][] getAmbiente() {
		return ambiente;
	}
	
	public Estado(Estado pai, int discos[][]) {
		this.pai = pai;
		ambiente = new int[discos.length][discos[0].length];
		for(int i = 0; i < discos.length; i++) {
			for(int j = 0; j < discos[0].length; j++) {
				ambiente[i][j] = discos[i][j];
			}
		}
	}
	
    public String geraIdentificador() {
    	String id = null;
    	for(int i = 0; i < ambiente.length; i++ ) {
    		for(int j = 0; j < ambiente[0].length; j++) {
    			id += ambiente[i][j];
    		}
    	}
        return id;
    }
	
    /**
     * @return Retorna uma string "visualmente agradável" do estado
     */
    public String toString() {
    	String caminho = new String("");
    	for(int i = 0; i < ambiente.length; i++) {
    		for(int j = 0; j < ambiente[0].length; j++ ) {
    			caminho += ambiente[i][j] + " ";
    		}
    		caminho += "\n";
    	}
    	return caminho;
    }
    
}
