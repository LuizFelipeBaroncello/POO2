package modelo;

import java.util.List;

import interfaces.EstrategiaSelecionaLetras;

public class EstrategiaSelecionaLetrasParaTeste implements EstrategiaSelecionaLetras {

	@Override
	public List<Character> selecionaConjuntoDeLetras(List<List> conjuntoComConjuntosdeLetras) {
		return conjuntoComConjuntosdeLetras.get(0);
	}

}