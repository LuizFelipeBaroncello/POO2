package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalavrasParaJogo {

	private Map<List<Character>, List<String>> mapaLetras;
	private List<String> stringsDerivadasDeAnseio;
	private List<Character> conjuntoLetrasAnseio;
	private List<String> stringsDerivadasDeLegado;
	private List<Character> conjuntoLetrasLegado;
	private List<String> stringsDerivadasDeLouvar;
	private List<Character> conjuntoLetrasLouvar;
	private List<String> stringsDerivadasDeAvulso;
	private List<Character> conjuntoLetrasAvulso;
	private List<String> stringsDerivadasDeCeifar;
	private List<Character> conjuntoLetrasCeifar;
	private List<String> stringsDerivadasDeViagem;
	private List<Character> conjuntoLetrasViagem;
	private List<String> stringsDerivadasDeVoltar;
	private List<Character> conjuntoLetrasVoltar;
	private List<String> stringsDerivadasDeCartel;
	private List<Character> conjuntoLetrasCartel;
	private List<String> stringsDerivadasDeCuidar;
	private List<Character> conjuntoLetrasCuidar;
	private List<String> stringsDerivadasDeLigado;
	private List<Character> conjuntoLetrasLigado;
	private List<String> stringsDerivadasDeInfame;
	private List<Character> conjuntoLetrasInfame;
	private List<String> stringsDerivadasDeCoagir;
	private List<Character> conjuntoLetrasCoagir;
	private List<List> conjuntoComConjuntosdeLetras;

	public PalavrasParaJogo() {
		mapaLetras = new HashMap<List<Character>, List<String>>();
		inicializaListas();
		adicionaAoHashMap();
	}

	private void inicializaListas() {
		conjuntoLetrasAnseio = new ArrayList<Character>(Arrays.asList('s', 'n', 'a', 'i', 'e', 'o'));
		stringsDerivadasDeAnseio = new ArrayList<>(Arrays.asList("anseio", "ensaio", "saneio", "sanei", "sino", "seno",
				"seio", "soei", "anos", "asno", "sano", "saio", "soai", "anis", "sina", "sai", "sei", "nao"));

		conjuntoLetrasLegado = new ArrayList<Character>(Arrays.asList('l', 'o', 'a', 'd', 'g', 'e'));
		stringsDerivadasDeLegado = new ArrayList<>(
				Arrays.asList("degola", "gelado", "legado", "alego", "goela", "geado", "gelo", "algo", "galo", "gola",
						"lago", "leoa", "lado", "gado", "dela", "gol", "ego", "doe", "ela"));

		conjuntoLetrasLouvar = new ArrayList<Character>(Arrays.asList('r', 'o', 'l', 'u', 'v', 'a'));
		stringsDerivadasDeLouvar = new ArrayList<>(
				Arrays.asList("lavrou", "louvar", "lavou", "louva", "lavro", "valor", "ralou", "voar", "luva", "luar",
						"alvo", "lavo", "oval", "oral", "ralo", "uva", "rua", "ora", "lua", "lar"));

		conjuntoLetrasAvulso = new ArrayList<Character>(Arrays.asList('v', 'a', 'o', 'l', 's', 'u'));
		stringsDerivadasDeAvulso = new ArrayList<>(Arrays.asList("avulso", "salvou", "luvas", "lavou", "alvos", "lousa",
				"luva", "alvo", "lavo", "sola", "vou", "sou", "uso", "sul", "uva", "sua", "usa", "voa"));

		conjuntoLetrasCeifar = new ArrayList<Character>(Arrays.asList('e', 'c', 'i', 'r', 'a', 'f'));
		stringsDerivadasDeCeifar = new ArrayList<>(
				Arrays.asList("ceifar", "aferi", "farei", "feira", "freia", "cifra", "ficar", "fria", "rifa", "fera",
						"afie", "feia", "cair", "cria", "fica", "cera", "ceia", "rei", "ira", "ria"));

		conjuntoLetrasViagem = new ArrayList<Character>(Arrays.asList('m', 'i', 'a', 'v', 'g', 'e'));
		stringsDerivadasDeViagem = new ArrayList<>(Arrays.asList("viagem", "vaiem", "vagem", "meiga", "viam", "viga",
				"vaie", "veia", "amei", "meia", "agem", "gema", "vem", "vim", "vai", "via", "iam"));

		conjuntoLetrasVoltar = new ArrayList<Character>(Arrays.asList('v', 'l', 'o', 'r', 't', 'a'));
		stringsDerivadasDeVoltar = new ArrayList<>(Arrays.asList("voltar", "travo", "votar", "volta", "valor", "lotar",
				"vota", "voar", "ator", "rato", "rota", "tora", "alvo", "lavo", "voa", "ato", "ora", "tal", "lar"));

		conjuntoLetrasCartel = new ArrayList<Character>(Arrays.asList('e', 'a', 'l', 't', 'r', 'c'));
		stringsDerivadasDeCartel = new ArrayList<>(Arrays.asList("teclar", "cartel", "letra", "certa", "tecla", "lacre",
				"arte", "reta", "tela", "real", "alce", "ter", "ler", "tal", "lar"));

		conjuntoLetrasCuidar = new ArrayList<Character>(Arrays.asList('c', 'r', 'd', 'a', 'i', 'u'));
		stringsDerivadasDeCuidar = new ArrayList<>(Arrays.asList("acudir", "cuidar", "acudi", "cuida", "dura", "crua",
				"cura", "caiu", "cuia", "cair", "cria", "dica", "riu", "rua", "ira", "ria"));

		conjuntoLetrasLigado = new ArrayList<Character>(Arrays.asList('l', 'i', 'a', 'g', 'o', 'd'));
		stringsDerivadasDeLigado = new ArrayList<>(Arrays.asList("ligado", "ligo", "lido", "digo", "alio", "algo",
				"galo", "gola", "lago", "ioga", "liga", "lado", "lida", "gado", "diga", "gol", "ali", "lia"));

		conjuntoLetrasInfame = new ArrayList<Character>(Arrays.asList('n', 'f', 'm', 'a', 'e', 'i'));
		stringsDerivadasDeInfame = new ArrayList<>(Arrays.asList("afinem", "infame", "enfim", "anime", "afine", "afiem",
				"mina", "fina", "afim", "amei", "meia", "feia", "fim", "ame"));

		conjuntoLetrasCoagir = new ArrayList<Character>(Arrays.asList('c', 'r', 'g', 'a', 'i', 'o'));
		stringsDerivadasDeCoagir = new ArrayList<>(Arrays.asList("coagir", "cargo", "coagi", "giro", "rico", "orai",
				"raio", "agir", "gira", "ioga", "arco", "caro", "orca", "cair", "cor", "roa", "ira", "ria"));

		conjuntoComConjuntosdeLetras = new ArrayList<List>(
				Arrays.asList(conjuntoLetrasAnseio, conjuntoLetrasLegado, conjuntoLetrasLouvar, conjuntoLetrasAvulso,
						conjuntoLetrasCeifar, conjuntoLetrasViagem, conjuntoLetrasVoltar, conjuntoLetrasCartel,
						conjuntoLetrasCuidar, conjuntoLetrasLigado, conjuntoLetrasInfame, conjuntoLetrasCoagir));
	}

	private void adicionaAoHashMap() {
		mapaLetras.put(conjuntoLetrasLegado, stringsDerivadasDeLegado);
		mapaLetras.put(conjuntoLetrasAnseio, stringsDerivadasDeAnseio);
		mapaLetras.put(conjuntoLetrasLouvar, stringsDerivadasDeLouvar);
		mapaLetras.put(conjuntoLetrasAvulso, stringsDerivadasDeAvulso);
		mapaLetras.put(conjuntoLetrasCeifar, stringsDerivadasDeCeifar);
		mapaLetras.put(conjuntoLetrasViagem, stringsDerivadasDeViagem);
		mapaLetras.put(conjuntoLetrasVoltar, stringsDerivadasDeVoltar);
		mapaLetras.put(conjuntoLetrasCartel, stringsDerivadasDeCartel);
		mapaLetras.put(conjuntoLetrasCuidar, stringsDerivadasDeCuidar);
		mapaLetras.put(conjuntoLetrasLigado, stringsDerivadasDeLigado);
		mapaLetras.put(conjuntoLetrasInfame, stringsDerivadasDeInfame);
		mapaLetras.put(conjuntoLetrasCoagir, stringsDerivadasDeCoagir);
	}

	public List<List> getConjuntoComConjuntosdeLetras() {
		return conjuntoComConjuntosdeLetras;
	}

	public List<String> getConjuntoPalavrasPeranteChave(List<Character> letrasSelecionadas) {
		return mapaLetras.get(letrasSelecionadas);
	}

}