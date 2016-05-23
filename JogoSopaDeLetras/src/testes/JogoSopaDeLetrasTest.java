package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import excecoes.ExcecaoPosicaoInvalida;
import interfaces.EstrategiaSelecionaLetras;
import modelo.FabricaEstrategiaSelecionaLetras;
import modelo.GerenciadorJogo;
import modelo.FabricaEstrategiaSelecionaLetras.TiposEstrategia;


public class JogoSopaDeLetrasTest {

	private GerenciadorJogo gerenciadorJogo;
	
	@Before
	public void setup() throws Exception{
		EstrategiaSelecionaLetras estrategia = new FabricaEstrategiaSelecionaLetras()
				.retornaEstrategia(TiposEstrategia.ParaTeste);
		gerenciadorJogo = new GerenciadorJogo(estrategia);
	}

	@Test 
	public void testaSeNumeroDePalavrasComTresLetrasEstaCerto() {
		assertEquals(3, gerenciadorJogo.retornaNumPalavrasComCertoNumDeLetras(3));	
	}

	@Test 
	public void testaSeNumeroDePalavrasComQuatroLetrasEstaCerto() {
		assertEquals(11, gerenciadorJogo.retornaNumPalavrasComCertoNumDeLetras(4));	
	}
	
	@Test 
	public void testaSeNumeroDePalavrasComCincoLetrasEstaCerto() {
		assertEquals(1, gerenciadorJogo.retornaNumPalavrasComCertoNumDeLetras(5));	
	}
	
	@Test 
	public void testaSeNumeroDePalavrasComSeisLetrasEstaCerto() {
		assertEquals(3, gerenciadorJogo.retornaNumPalavrasComCertoNumDeLetras(6));	
	}
	
	@Test 
	public void testaSeRetornaPalavraChute() throws Exception {
		assertEquals(true , gerenciadorJogo.verificaSeChuteEhValido("saneio"));	
	}
	
	@Test 
	public void testaSeRetornaPosicaoCorreta() throws ExcecaoPosicaoInvalida {
		assertEquals(6, gerenciadorJogo.retornaPosicaoPalavra("saio"));
	}
	
	
}