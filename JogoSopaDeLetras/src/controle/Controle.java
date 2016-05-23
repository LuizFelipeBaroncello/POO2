package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;

import excecoes.ExcecaoPalavraJaEncontrada;
import excecoes.ExcecaoPosicaoInvalida;
import interfaces.EstrategiaSelecionaLetras;
import modelo.FabricaEstrategiaSelecionaLetras;
import modelo.GerenciadorJogo;
import modelo.FabricaEstrategiaSelecionaLetras.TiposEstrategia;
import visao.JanelaPrincipal;
import visao.JanelaSelecionaNivel;
import visao.Mensagem;

public class Controle {

	private GerenciadorJogo gerenciadorJogo;
	private JanelaPrincipal janelaJogo;
	private JanelaSelecionaNivel janelaNivel;
	private Mensagem mensagem;
	private int vezesQueDicaFoiClicado;

	public Controle() {
		EstrategiaSelecionaLetras estrategia = new FabricaEstrategiaSelecionaLetras()
				.retornaEstrategia(TiposEstrategia.Aleatoria);
		gerenciadorJogo = new GerenciadorJogo(estrategia);
		mensagem = new Mensagem();

		janelaNivel = new JanelaSelecionaNivel();
		adicionaActionListenerModoFacil();
		adicionaActionListenerModoMedio();
		adicionaActionListenerModoDificil();
	}

	private void adicionaActionListenerModoDificil() {
		janelaNivel.setAcaoBotaoDificil(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				executaJanelaJogo();
				janelaJogo.setAcaoMostraDica(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						mensagem.exibeMensagem("Nao se pode ver as palavras no modo dificil.");
					}
				});
				janelaNivel.fechaJanelaNiveis();
			}
		});
	}

	private void adicionaActionListenerModoMedio() {
		janelaNivel.setAcaoBotaoMedio(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				executaJanelaJogo();
				janelaJogo.setAcaoMostraDica(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (vezesQueDicaFoiClicado != 3) {
							janelaJogo.exibePalavrasJogo(gerenciadorJogo.retornaStringsJogo());
							vezesQueDicaFoiClicado++;
						} else
							mensagem.exibeMensagem("Voce não pode mais ver as palavras");
					}
				});
				janelaNivel.fechaJanelaNiveis();
			}
		});
	}

	private void adicionaActionListenerModoFacil() {
		janelaNivel.setAcaoBotaoFacil(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				executaJanelaJogo();
				janelaJogo.setAcaoMostraDica(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						janelaJogo.exibePalavrasJogo(gerenciadorJogo.retornaStringsJogo());
					}
				});
				janelaNivel.fechaJanelaNiveis();
			}
		});
	}

	private void adicionaActionListenerBotaoChute() {
		janelaJogo.adicionaAcaoAoBotaoChute(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int posicao;
				try {
					if (verificaSeChuteEhValido(janelaJogo.getPalavraChuteDigitada())) {
						try {
							posicao = retornaPosicaoPalavra(janelaJogo.getPalavraChuteDigitada());
							janelaJogo.setPosicaoChutePalavra(posicao);
						} catch (ExcecaoPosicaoInvalida e1) {
							mensagem.exibeMensagem("Tente novamente.");
						}
					} else {
						mensagem.exibeMensagem("Parece que essa palavra nao esta entre os anagramas.");
					}
				} catch (ExcecaoPalavraJaEncontrada e1) {
					mensagem.exibeMensagem("Voce ja acertou essa palavra, nao faz sentido chuta-la novamente.");
				}
				janelaJogo.setPalavraChuteDigitada("");
			}
		});
	}

	private void executaJanelaJogo() {
		janelaJogo = new JanelaPrincipal(retornaLetrasEmJogo(), palavrasComTresLetras(), palavrasComQuatroLetras(),
				palavrasComCincoLetras(), palavrasComSeisLetras());
		adicionaActionListenerBotaoChute();

		janelaJogo.criaBotaoMostraDica();

	}

	public boolean verificaSeChuteEhValido(String palavraUsuario) throws ExcecaoPalavraJaEncontrada {
		if (gerenciadorJogo.verificaSeChuteEhValido(palavraUsuario)) {
			return true;
		} else {
			return false;
		}
	}

	public int retornaPosicaoPalavra(String palavra) throws ExcecaoPosicaoInvalida {
		return gerenciadorJogo.retornaPosicaoPalavra(palavra);
	}

	public List<Character> retornaLetrasEmJogo() {
		return gerenciadorJogo.getLetrasJogo();
	}

	public int palavrasComQuatroLetras() {
		return gerenciadorJogo.retornaNumPalavrasComCertoNumDeLetras(4);
	}

	public int palavrasComCincoLetras() {
		return gerenciadorJogo.retornaNumPalavrasComCertoNumDeLetras(5);
	}

	public int palavrasComSeisLetras() {
		return gerenciadorJogo.retornaNumPalavrasComCertoNumDeLetras(6);
	}

	public int palavrasComTresLetras() {
		return gerenciadorJogo.retornaNumPalavrasComCertoNumDeLetras(3);
	}

}