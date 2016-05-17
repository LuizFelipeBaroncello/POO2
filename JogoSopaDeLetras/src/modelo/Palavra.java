package modelo;

public class Palavra {

	private String nome;
	private boolean encontrada;
	
	public Palavra(String nome){
		this.nome = nome;
		encontrada = false;
	}

	public boolean getEncontrada() {
		return encontrada;
	}

	public void setEncontrada(boolean encontrada) {
		this.encontrada = encontrada;
	}

	public String getNome() {
		return nome;
	}
	
	public boolean equals(Palavra palavraRecebida) {
		
	    if(this.nome.equals(palavraRecebida.getNome())) {
	        return true;
	    }
	    else return false;
	}
	
}