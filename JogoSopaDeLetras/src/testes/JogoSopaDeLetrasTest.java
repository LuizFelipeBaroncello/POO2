package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import modelo.Fachada;


public class JogoSopaDeLetrasTest {

	private Fachada fachada;
	
	@Before
	public void setup() throws Exception{
		fachada = new Fachada();
	}

	@Test 
	public void testaSeNumeroDePalavrasComTresLetrasEstaCerto() {
		assertEquals(3, fachada.retornaNumPalavrasComCertoNumDeLetras(3));	
	}

	@Test 
	public void testaSeNumeroDePalavrasComQuatroLetrasEstaCerto() {
		assertEquals(11, fachada.retornaNumPalavrasComCertoNumDeLetras(4));	
	}
	
	@Test 
	public void testaSeNumeroDePalavrasComCincoLetrasEstaCerto() {
		assertEquals(1, fachada.retornaNumPalavrasComCertoNumDeLetras(5));	
	}
	
	@Test 
	public void testaSeNumeroDePalavrasComSeisLetrasEstaCerto() {
		assertEquals(3, fachada.retornaNumPalavrasComCertoNumDeLetras(6));	
	}
	
	@Test 
	public void testaSeRetornaPalavraChute() throws Exception {
		assertEquals(true , fachada.verificaSeChuteEhValido("saneio"));	
	}
	
}
