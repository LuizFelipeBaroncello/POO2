package modelo;

import java.util.HashMap;
import java.util.Map;
import interfaces.EstrategiaSelecionaLetras;

public class FabricaEstrategiaSelecionaLetras {
	
	public enum TiposEstrategia{Aleatoria, ParaTeste}
	
	private Map<TiposEstrategia, EstrategiaSelecionaLetras> mapaTipoEstrategia;
	private static FabricaEstrategiaSelecionaLetras fabrica;
	
	public FabricaEstrategiaSelecionaLetras(){
		this.mapaTipoEstrategia = new HashMap<TiposEstrategia, EstrategiaSelecionaLetras>();
		this.mapaTipoEstrategia.put(TiposEstrategia.Aleatoria, new EstrategiaSelecionaLetrasDeFormaAleatoria());
		this.mapaTipoEstrategia.put(TiposEstrategia.ParaTeste, new EstrategiaSelecionaLetrasParaTeste());
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