package modelo;

import java.util.HashMap;
import java.util.Map;
import interfaces.EstrategiaSelecionaLetras;

public class FabricaEstrategiaSelecionaLetras {
	
	public enum TiposEstrategia{Aleatoria, Ordenada}
	
	private Map<TiposEstrategia, EstrategiaSelecionaLetras> mapaTipoEstrategia;
	private static FabricaEstrategiaSelecionaLetras fabrica;
	
	public FabricaEstrategiaSelecionaLetras(){
		this.mapaTipoEstrategia = new HashMap<TiposEstrategia, EstrategiaSelecionaLetras>();
		this.mapaTipoEstrategia.put(TiposEstrategia.Aleatoria, new EstrategiaSelecionaLetrasDeFormaAleatoria());
		this.mapaTipoEstrategia.put(TiposEstrategia.Ordenada, new EstrategiaSelecionaLetrasDeFormaOrdenada());
	}
	
	public EstrategiaSelecionaLetras retornaEstrategia(TiposEstrategia tipo){
		return this.mapaTipoEstrategia.get(tipo);
	}
	
	public static FabricaEstrategiaSelecionaLetras getFabricaImprimeMosaico(){
		if (fabrica == null)
			fabrica = new FabricaEstrategiaSelecionaLetras();
		return fabrica;
	}

}