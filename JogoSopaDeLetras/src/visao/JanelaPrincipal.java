package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private List<JTextField> listaComPalavrasEmJogo;
	private List<JLabel> listaComPalavrasDica;
	private JTextField palavraParaChute;
	private List<JButton> botoesParaChute;
	private List<AcaoTeclado> acoesBotoes;
	private Action acaoEnter;
	private Action acaoLimpar;
	private JButton botaoChute;
	private JButton botaoLimpar;
	private JButton mostraDicaJogo;
	private List<Character> letrasJogo;
	private List<String> botoes;
	private ActionMap actionMap;
	private InputMap imap;

	public JanelaPrincipal(List<Character> letrasJogo, int numPalavrasComTresLetras, int numPalavrasComQuatroLetras,
			int numPalavrasComCincoLetras, int numPalavrasComSeisLetras) {

		this.letrasJogo = letrasJogo;
		adicionaAcoesAosBotoes();
		recebeAcoesDoTeclado();
		criaListasComPalavras();
		criaLabelLetrasChute();
		criaBotoesComLetrasParaChute();
		criaTextFieldsParaExibicaoDasParalavrasQueIramSerChutadas(numPalavrasComTresLetras, numPalavrasComQuatroLetras,
				numPalavrasComCincoLetras, numPalavrasComSeisLetras);
		criaLabelPalavraParaChute();
		inicializaTextFieldPalavraParaChute();
		criaBotaoChute();
		criaBotaoLimpar();
		criaJanela();
	}

	private void adicionaAcoesAosBotoes() {
		acoesBotoes = new ArrayList<>();

		for (int i = 0; i < letrasJogo.size(); i++) {
			AcaoTeclado acaoBotao = new AcaoTeclado(i);
			acoesBotoes.add(acaoBotao);
		}

		acaoTecladoDelete();
		acaoTecladoEnter();

	}

	private void acaoTecladoDelete() {
		acaoLimpar = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				botaoLimpar.doClick();
			}
		};
	}

	private void acaoTecladoEnter() {
		acaoEnter = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				botaoChute.doClick();
			}
		};
	}

	private void retiraAcaoDoTeclado(int i) {
		actionMap.remove(botoes.get(i));
	}

	private void recebeAcoesDoTeclado() {
		String stringChute = "CHUTE";
		String stringDelete = "DELETE";

		botoes = new ArrayList<>(Arrays.asList("botao0", "botao1", "botao2", "botao3", "botao4", "botao5"));
		actionMap = ((JComponent) getContentPane()).getActionMap();

		for (int i = 0; i < acoesBotoes.size(); i++) {
			actionMap.put(botoes.get(i), acoesBotoes.get(i));
		}
		actionMap.put(stringDelete, acaoLimpar);
		actionMap.put(stringChute, acaoEnter);

		((JComponent) getContentPane()).setActionMap(actionMap);

		imap = ((JComponent) getContentPane()).getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);

		for (int i = 0; i < letrasJogo.size(); i++) {
			imap.put(KeyStroke.getKeyStroke(letrasJogo.get(i)), botoes.get(i));
		}

		imap.put(KeyStroke.getKeyStroke((KeyEvent.VK_ENTER), 0), stringChute);
		imap.put(KeyStroke.getKeyStroke((KeyEvent.VK_DELETE), 0), stringDelete);

	}

	private void criaBotaoChute() {
		botaoChute = new JButton("Chute");
		botaoChute.setSize(68, 24);
		botaoChute.setLocation(248, 68);
		botaoChute.setToolTipText("Tambem fuinciona com o botao (ENTER) ");
		getContentPane().add(botaoChute);
		botaoChute.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < botoesParaChute.size(); i++) {
					botoesParaChute.get(i).setEnabled(true);
				}
				for (int i = 0; i < listaComPalavrasDica.size(); i++) {
					listaComPalavrasDica.get(i).setText("");			
				}		
				recebeAcoesDoTeclado();
			}
		});

	}

	private void criaBotaoLimpar() {
		botaoLimpar = new JButton("Limpar");
		botaoLimpar.setSize(80, 24);
		botaoLimpar.setLocation(324, 68);
		botaoLimpar.setToolTipText("Tambem funciona com o botao (DELETE) ");
		getContentPane().add(botaoLimpar);
		botaoLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < botoesParaChute.size(); i++) {
					botoesParaChute.get(i).setEnabled(true);
				}
				recebeAcoesDoTeclado();
				palavraParaChute.setText("");
			}
		});

	}

	private class AcaoTeclado extends AbstractAction {
		private int posicao;
		private static final long serialVersionUID = 1L;

		public AcaoTeclado(int posicao) {
			this.posicao = posicao;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			botoesParaChute.get(posicao).doClick();
		}
	}

	public void adicionaAcaoAoBotaoChute(ActionListener actionListener) {
		botaoChute.addActionListener(actionListener);
	}

	private void inicializaTextFieldPalavraParaChute() {
		palavraParaChute = new JTextField();
		palavraParaChute.setSize(68, 24);
		palavraParaChute.setLocation(176, 68);
		palavraParaChute.setEditable(false);
		getContentPane().add(palavraParaChute);
	}

	private void criaListasComPalavras() {
		listaComPalavrasEmJogo = new ArrayList<JTextField>();
		listaComPalavrasDica = new ArrayList<JLabel>();
	}

	private void criaTextFieldsParaExibicaoDasParalavrasQueIramSerChutadas(int numPalavrasComTresLetras,
			int numPalavrasComQuatroLetras, int numPalavrasComCincoLetras, int numPalavrasComSeisLetras) {

		int posicaoYTextField = 128;
		int posicaoXTextField = 152;
		int numeroPalavras = numPalavrasComTresLetras + numPalavrasComQuatroLetras + numPalavrasComCincoLetras
				+ numPalavrasComSeisLetras;
		for (int i = 0; i < numeroPalavras; i++) {
			JTextField palavra = new JTextField();
			palavra.setText(getStringExibidaAntesDeAcertarPalavra(i, numPalavrasComTresLetras,
					numPalavrasComQuatroLetras, numPalavrasComCincoLetras, numPalavrasComSeisLetras));
			palavra.setSize(66, 24);
			palavra.setLocation(posicaoXTextField, posicaoYTextField);
			posicaoYTextField += 28;
			palavra.setEditable(false);
			getContentPane().add(palavra);
			listaComPalavrasEmJogo.add(palavra);
			if (posicaoYTextField >= 400) {
				posicaoYTextField = 128;
				posicaoXTextField = 280;
			}
		}
		int posicaoYLabel = 128;
		int posicaoXLabel = 78;
		for (int i = 0; i < numeroPalavras; i++) {
			JLabel palavra = new JLabel();
			palavra.setSize(66, 24);
			palavra.setLocation(posicaoXLabel, posicaoYLabel);
			posicaoYLabel += 28;
			getContentPane().add(palavra);
			listaComPalavrasDica.add(palavra);
			if (posicaoYLabel >= 400) {
				posicaoYLabel = 128;
				posicaoXLabel = 8;
			}
		}
		

	}

	private String getStringExibidaAntesDeAcertarPalavra(int i, int numPalavrasComTresLetras,
			int numPalavrasComQuatroLetras, int numPalavrasComCincoLetras, int numPalavrasComSeisLetras) {
		if (i < numPalavrasComTresLetras)
			return "      _ _ _ ";
		else {
			if (i < numPalavrasComTresLetras + numPalavrasComQuatroLetras)
				return "    _ _ _ _ ";
			else {
				if (i < numPalavrasComTresLetras + numPalavrasComQuatroLetras + numPalavrasComCincoLetras)
					return "  _ _ _ _ _ ";
				else
					return " _ _ _ _ _ _ ";
			}
		}
	}

	private void criaLabelLetrasChute() {
		JLabel labelLetrasChute = new JLabel("Letras para chute: ");
		labelLetrasChute.setSize(108, 24);
		labelLetrasChute.setLocation(4, 4);
		getContentPane().add(labelLetrasChute);
	}

	private void criaLabelPalavraParaChute() {
		JLabel labelLetrasChute = new JLabel("Palavra para chute: ");
		labelLetrasChute.setSize(124, 24);
		labelLetrasChute.setLocation(48, 68);
		getContentPane().add(labelLetrasChute);
	}

	private void geraBotaoComLetraParaChute(List<Character> letrasJogo, int posicao, int posicaoXBotao) {
		botoesParaChute.add(new JButton(letrasJogo.get(posicao) + ""));
		botoesParaChute.get(posicao).setSize(48, 24);
		botoesParaChute.get(posicao).setLocation(posicaoXBotao, 4);
		botoesParaChute.get(posicao)
				.setToolTipText("Adiciona a letra (" + letrasJogo.get(posicao) + ") para a palavra a ser chutada");
		getContentPane().add(botoesParaChute.get(posicao));
		botoesParaChute.get(posicao).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				botoesParaChute.get(posicao).setEnabled(false);
				retiraAcaoDoTeclado(posicao);
				palavraParaChute.setText(palavraParaChute.getText() + letrasJogo.get(posicao));
			}
		});
	}

	private void criaBotoesComLetrasParaChute() {
		botoesParaChute = new ArrayList<>();
		int posicaoXBotao = 124;

		for (int i = 0; i < 6; i++) {
			geraBotaoComLetraParaChute(letrasJogo, i, posicaoXBotao);
			posicaoXBotao += 52;
		}
	}

	private void criaJanela() {
		this.setTitle("Sopa de Letras");
		setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void criaBotaoMostraDica(){
		mostraDicaJogo = new JButton("Mostrar Palavras");
		mostraDicaJogo.setSize(156, 24);
		mostraDicaJogo.setLocation(280, 410);	
		getContentPane().add(mostraDicaJogo);
	}
	
	public void exibePalavrasJogo(List<String> palavrasJogo){
		for (int i = 0; i < palavrasJogo.size(); i++) {
			this.listaComPalavrasDica.get(i).setText(palavrasJogo.get(i));			
		}		
	}
	
	public void setAcaoMostraDica(ActionListener actionListener){
		this.mostraDicaJogo.addActionListener(actionListener);
	}

	public String getPalavraChuteDigitada() {
		return palavraParaChute.getText();
	}

	public void setPosicaoChutePalavra(int posicao) {
		listaComPalavrasEmJogo.get(posicao).setText(getPalavraChuteDigitada());
	}

	public void setPalavraChuteDigitada(String palavraParaTextField) {
		palavraParaChute.setText(palavraParaTextField);
	}

}