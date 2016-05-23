package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import excecoes.ExcecaoPalavraJaEncontrada;
import excecoes.ExcecaoPosicaoInvalida;
import interfaces.EstrategiaSelecionaLetras;

public class GerenciadorJogo {

	private List<Palavra> palavrasSelecionadas;
	private List<String> stringsSelecionadas;
	private List<Character> letrasSelecionadas;
	private EstrategiaSelecionaLetras estrategiaSelecao;
	private PalavrasParaJogo palavrasParaJogo;

	public GerenciadorJogo(EstrategiaSelecionaLetras estrategiaSelecao) {
		this.estrategiaSelecao = estrategiaSelecao;
		palavrasParaJogo = new PalavrasParaJogo();
		selecionaListaPalavras();
	}

	private List<Palavra> geraListaPalavras(List<String> listaStrings) {
		List<Palavra> listaPalavrasGerada = new ArrayList<>();
		for (int i = 0; i < listaStrings.size(); i++) {
			Palavra palavra = new Palavra(listaStrings.get(i));
			listaPalavrasGerada.add(palavra);
		}

		return listaPalavrasGerada;
	}

	public void selecionaListaPalavras() {
		letrasSelecionadas = this.estrategiaSelecao
				.selecionaConjuntoDeLetras(palavrasParaJogo.getConjuntoComConjuntosdeLetras());
		stringsSelecionadas = palavrasParaJogo.getConjuntoPalavrasPeranteChave(letrasSelecionadas);
		organizaEmOrdemAlfabetica(stringsSelecionadas);
		palavrasSelecionadas = geraListaPalavras(stringsSelecionadas);
	}

	private void organizaEmOrdemAlfabetica(List<String> conjuntoPalavras) {
		Collections.sort(conjuntoPalavras);
	}

	public List<Character> getLetrasJogo() {
		return letrasSelecionadas;
	}

	public int retornaNumPalavrasComCertoNumDeLetras(int numeroLetras) {
		int numeroDePalavras = 0;
		for (int i = 0; i < palavrasSelecionadas.size(); i++) {
			int numeroDeLetras = palavrasSelecionadas.get(i).getNome().length();
			if (numeroDeLetras == numeroLetras)
				numeroDePalavras++;
		}
		return numeroDePalavras;
	}

	public boolean verificaSeChuteEhValido(String palavraChute) throws ExcecaoPalavraJaEncontrada {
		for (int i = 0; i < palavrasSelecionadas.size(); i++) {
			Palavra palavra = palavrasSelecionadas.get(i);
			Palavra palavraChutada = new Palavra(palavraChute);
			if (palavra.equals(palavraChutada)) {
				if (palavra.getEncontrada()) {
					throw new ExcecaoPalavraJaEncontrada();
				}
				palavra.setEncontrada(true);
				return true;
			}
		}
		return false;
	}

	public int retornaPosicaoPalavra(String palavraDescoberta) throws ExcecaoPosicaoInvalida {
		int posicaoPalavra = 0;
		for (int i = 2; i < palavraDescoberta.length(); i++) {
			posicaoPalavra += this.retornaNumPalavrasComCertoNumDeLetras(i);
		}
		for (int i = 0; i < palavrasSelecionadas.size(); i++) {
			if (palavraDescoberta.length() == palavrasSelecionadas.get(i).getNome().length()) {
				if (palavraDescoberta.equals(palavrasSelecionadas.get(i).getNome()))
					return posicaoPalavra;
				posicaoPalavra++;
			}
		}
		throw new ExcecaoPosicaoInvalida();
	}

	public List<String> retornaStringsJogo(){
		return this.stringsSelecionadas;
	}
	
}