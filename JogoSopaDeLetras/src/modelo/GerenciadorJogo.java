package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import excecoes.ExcecaoPalavraJaEncontrada;
import excecoes.ExcecaoPosicaoInvalida;
import interfaces.EstrategiaSelecionaLetras;

public class GerenciadorJogo {

	private Map<List<Character>, List<String>> mapaLetras;
	private List<String> stringsDerivadasDeAnseio;
	private List<Character> conjuntoLetrasAnseio;
	private List<Palavra> palavrasSelecionadas;
	private List<String> stringsSelecionadas;
	private List<List> conjuntoComConjuntosdeLetras;
	private List<Character> LetrasSelecionadas;
	private EstrategiaSelecionaLetras estrategiaSelecao;

	public GerenciadorJogo(EstrategiaSelecionaLetras estrategiaSelecao){
		 this.estrategiaSelecao = estrategiaSelecao;
		 mapaLetras = new HashMap<List<Character>, List<String>>();
		 inicializaListas();
		 adicionaAoHashMap();
	}

	private void inicializaListas() {
		conjuntoLetrasAnseio = new ArrayList<Character>(Arrays.asList('s', 'n', 'a', 'i', 'e', 'o'));
		stringsDerivadasDeAnseio = new ArrayList<String>(Arrays.asList("anseio", "ensaio", "saneio", "sanei", "sino",
				 												"seno", "seio", "soei", "anos", "asno", "sano", "saio", "soai", 
				 												"anis", "sina", "sai", "sei", "nao"));
		
		conjuntoComConjuntosdeLetras = new ArrayList<List>(Arrays.asList(conjuntoLetrasAnseio));
	}

	private List<Palavra> geraListaPalavras(List<String> listaStrings){
		List<Palavra> listaPalavrasGerada = new ArrayList<>();
		for (int i = 0; i < listaStrings.size(); i++) {
			Palavra palavra = new Palavra(listaStrings.get(i));
			listaPalavrasGerada.add(palavra);
		}
		
		return listaPalavrasGerada;
	}
	
	private void adicionaAoHashMap() {
		mapaLetras.put(conjuntoLetrasAnseio, stringsDerivadasDeAnseio);
	}

	public void selecionaListaPalavras(){
		LetrasSelecionadas = this.estrategiaSelecao.selecionaConjuntoDeLetras(conjuntoComConjuntosdeLetras);
		stringsSelecionadas = mapaLetras.get(LetrasSelecionadas);
		organizaEmOrdemAlfabetica(stringsSelecionadas);
		palavrasSelecionadas = geraListaPalavras(stringsSelecionadas);
	}

	private void organizaEmOrdemAlfabetica(List<String> conjuntoPalavras) {
		Collections.sort(conjuntoPalavras);
	}

	public List<Character> getLetrasJogo(){
		return LetrasSelecionadas;
	}

	public int retornaNumPalavrasComCertoNumDeLetras(int numeroLetras){
		int numeroDePalavras = 0;
		for (int i = 0; i < palavrasSelecionadas.size(); i++) {
			int numeroDeLetras = palavrasSelecionadas.get(i).getNome().length();
			if(numeroDeLetras == numeroLetras)
				numeroDePalavras++;
		}
		return numeroDePalavras;
	}

	public boolean verificaSeChuteEhValido(String palavraChute) throws ExcecaoPalavraJaEncontrada {
		for (int i = 0; i < palavrasSelecionadas.size(); i++) {
			Palavra palavra = palavrasSelecionadas.get(i);
			Palavra palavraChutada = new Palavra(palavraChute);
			if (palavra.equals(palavraChutada)){
				if(palavra.getEncontrada()){
					throw new ExcecaoPalavraJaEncontrada();
				}
				palavra.setEncontrada(true);
				return true;
			}
		}
		return false;
	}

	public int retornaPosicaoPalavra(String palavraDescoberta) throws ExcecaoPosicaoInvalida{
		int posicaoPalavra = 0;
		for (int i = 2; i < palavraDescoberta.length(); i++) {
				posicaoPalavra += this.retornaNumPalavrasComCertoNumDeLetras(i);
		}
		for (int i = 0; i < palavrasSelecionadas.size(); i++) {
			if(palavraDescoberta.length() == palavrasSelecionadas.get(i).getNome().length()){
				if(palavraDescoberta.equals(palavrasSelecionadas.get(i).getNome()))
					return posicaoPalavra;
				posicaoPalavra++;
			}
		}
		throw new ExcecaoPosicaoInvalida();
	}

}