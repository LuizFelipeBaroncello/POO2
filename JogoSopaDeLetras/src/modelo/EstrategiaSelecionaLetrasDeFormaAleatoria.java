package modelo;

import java.util.List;
import java.util.Random;

import interfaces.EstrategiaSelecionaLetras;

public class EstrategiaSelecionaLetrasDeFormaAleatoria implements EstrategiaSelecionaLetras {

	private Random random;
	
	public EstrategiaSelecionaLetrasDeFormaAleatoria() {
		random = new Random();
	}
	
	@Override
	public List<Character> selecionaConjuntoDeLetras(List<List> conjuntoComConjuntosdeLetras) {
		return conjuntoComConjuntosdeLetras.get(random.nextInt(conjuntoComConjuntosdeLetras.size()));
	}

}