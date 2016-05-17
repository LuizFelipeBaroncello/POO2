package modelo;

import java.util.List;

import excecoes.ExcecaoPalavraJaEncontrada;
import excecoes.ExcecaoPosicaoInvalida;
import interfaces.EstrategiaSelecionaLetras;
import modelo.FabricaEstrategiaSelecionaLetras.TiposEstrategia;

public class Fachada {

	private GerenciadorJogo gerenciadorJogo;

	public Fachada() {
		EstrategiaSelecionaLetras estrategia = new FabricaEstrategiaSelecionaLetras().retornaEstrategia(TiposEstrategia.Aleatoria);
		gerenciadorJogo = new GerenciadorJogo(estrategia);
		gerenciadorJogo.selecionaListaPalavras();
	}

	public List<Character> retornaLetrasParaJogo(){
		return gerenciadorJogo.getLetrasJogo();
	}
	
	public int retornaNumPalavrasComCertoNumDeLetras(int numeroLetras) {
		return gerenciadorJogo.retornaNumPalavrasComCertoNumDeLetras(numeroLetras);
	}

	public boolean verificaSeChuteEhValido(String palavraChute) throws ExcecaoPalavraJaEncontrada {
		return gerenciadorJogo.verificaSeChuteEhValido(palavraChute);
	}	

	public int retornaPosicaoPalavra(String palavra) throws ExcecaoPosicaoInvalida{
		return gerenciadorJogo.retornaPosicaoPalavra(palavra);
	}
	
}