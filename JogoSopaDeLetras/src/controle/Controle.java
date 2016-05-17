package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import excecoes.ExcecaoPalavraJaEncontrada;
import excecoes.ExcecaoPosicaoInvalida;
import modelo.Fachada;
import visao.JanelaPrincipal;

public class Controle {

	private Fachada fachadaJogo;
	JanelaPrincipal janelaJogo;
			
	public Controle(){
		fachadaJogo = new Fachada();
		janelaJogo = new JanelaPrincipal(retornaLetrasEmJogo(), retornaNumeroPalavrasComTresLetras(), 
						retornaNumeroPalavrasComQuatroLetras(), retornaNumeroPalavrasComCincoLetras(), 
						retornaNumeroPalavrasComSeisLetras());	
		adicionaActionListener();
	}

	private void adicionaActionListener() {
		janelaJogo.adicionaAcaoAoBotaoChute(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int posicao;
				try {
					if(verificaSeChuteEhValido(janelaJogo.getPalavraChuteDigitada())){
						try {
							posicao = retornaPosicaoPalavra(janelaJogo.getPalavraChuteDigitada());
							janelaJogo.setPosicaoChutePalavra(posicao);
						} catch (ExcecaoPosicaoInvalida e1) {
							janelaJogo.exibeMensagem("Tente novamente.");
						}
					}else{
						janelaJogo.exibeMensagem("Parece que essa palavra nao esta entre os anagramas.");					
					}
				} catch (ExcecaoPalavraJaEncontrada e1) {
					janelaJogo.exibeMensagem("Voce ja acertou essa palavra, nao tem faz sentido chuta-la novamente.");
				}
            	janelaJogo.setPalavraChuteDigitada("");
            }
        });
	}
			
	public boolean verificaSeChuteEhValido(String palavraUsuario) throws ExcecaoPalavraJaEncontrada {
			if(fachadaJogo.verificaSeChuteEhValido(palavraUsuario)){
				return true;
			}else{
				return false;
			}
	}
	
	public int retornaPosicaoPalavra(String palavra) throws ExcecaoPosicaoInvalida{
		return fachadaJogo.retornaPosicaoPalavra(palavra);
	}
	
	public List<Character> retornaLetrasEmJogo(){
		return fachadaJogo.retornaLetrasParaJogo();
	}
	//fazer dentro de um for
	public int retornaNumeroPalavrasComQuatroLetras(){
		return fachadaJogo.retornaNumPalavrasComCertoNumDeLetras(4);
	}

	public int retornaNumeroPalavrasComCincoLetras(){
		return fachadaJogo.retornaNumPalavrasComCertoNumDeLetras(5);
	}
	
	public int retornaNumeroPalavrasComSeisLetras(){
		return fachadaJogo.retornaNumPalavrasComCertoNumDeLetras(6);
	}
	
	public int retornaNumeroPalavrasComTresLetras(){
		return fachadaJogo.retornaNumPalavrasComCertoNumDeLetras(3);
	}
	
}