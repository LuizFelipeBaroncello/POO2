package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JanelaPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	private List<JTextField> listaComPalavrasEmJogo;
	private JTextField palavraParaChute;
	private List<JButton> botoesParaChute;
	private JButton botaoChute;
	private JButton botaoLimpar;
	
	public JanelaPrincipal(List<Character> letrasJogo,	int numPalavrasComTresLetras, int numPalavrasComQuatroLetras,
						int numPalavrasComCincoLetras, int numPalavrasComSeisLetras){
		
		criaListaComPalavrasEmJogo();
		criaLabelLetrasChute();
		criaBotoesComLetrasParaChute(letrasJogo);
		criaTextFieldsParaExibicaoDasParalavrasQueIramSerChutadas(numPalavrasComTresLetras, numPalavrasComQuatroLetras,
																  numPalavrasComCincoLetras, numPalavrasComSeisLetras);
		criaLabelPalavraParaChute();
		inicializaTextFieldPalavraParaChute();
		criaBotaoChute();
		criaBotaoLimpar();
		criaJanela();
	}

	private void criaBotaoChute() {
		botaoChute = new JButton("Chute");
		botaoChute.setSize(68, 24);
		botaoChute.setLocation(248 , 68);
		botaoChute.setToolTipText("Efetua tentativa de chute para a palavra " + palavraParaChute.getText()); 
 		getContentPane().add(botaoChute);
 		botaoChute.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				for (int i = 0; i < botoesParaChute.size(); i++) {
					botoesParaChute.get(i).setEnabled(true);					
				}
			}
		});

	}
	
	private void criaBotaoLimpar() {
		botaoLimpar = new JButton("Limpar");
		botaoLimpar.setSize(80, 24);
		botaoLimpar.setLocation(324 , 68);
		botaoLimpar.setToolTipText("Limpa a caixa de texto com as letras da palavra a ser chutada"); 
 		getContentPane().add(botaoLimpar);
 		botaoLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				for (int i = 0; i < botoesParaChute.size(); i++) {
					botoesParaChute.get(i).setEnabled(true);					
				}
				palavraParaChute.setText("");
			}
		});
		
	}
	
	public void adicionaAcaoAoBotaoChute(ActionListener actionListener){
		botaoChute.addActionListener(actionListener);
	}

	private void inicializaTextFieldPalavraParaChute() {
		palavraParaChute = new JTextField();
		palavraParaChute.setSize(68, 24);
		palavraParaChute.setLocation(176, 68);
		palavraParaChute.setEditable(false);
		getContentPane().add(palavraParaChute);
	}

	private void criaListaComPalavrasEmJogo() {
		listaComPalavrasEmJogo = new ArrayList<JTextField>();
	}

	private void criaTextFieldsParaExibicaoDasParalavrasQueIramSerChutadas(int numPalavrasComTresLetras,
							int numPalavrasComQuatroLetras, int numPalavrasComCincoLetras, int numPalavrasComSeisLetras) {

		int posicaoY = 128;
		int posicaoX = 152;
		int numeroPalavras = numPalavrasComTresLetras + numPalavrasComQuatroLetras + numPalavrasComCincoLetras + numPalavrasComSeisLetras;
		for (int i = 0; i < numeroPalavras; i++) {
			JTextField palavra = new JTextField();
				palavra.setText(" _ _ _ ");//mudar para aparecer certo
			palavra.setSize(68, 24);
			palavra.setLocation(posicaoX, posicaoY);
			posicaoY += 28;
			palavra.setEditable(false);
			getContentPane().add(palavra);
			listaComPalavrasEmJogo.add(palavra);
			if(posicaoY >= 400){
				posicaoY = 128;
				posicaoX = 280;
			}
		}
		
//		for (int i = 0; i < numPalavrasComTresLetras; i++) {
//			JTextField palavraComTresLetras = new JTextField(" _ _ _ ");
//			palavraComTresLetras.setSize(36, 24);
//			palavraComTresLetras.setLocation(posicaoX, posicaoY);
//			posicaoY += 28;
//			palavraComTresLetras.setEditable(false);
//			getContentPane().add(palavraComTresLetras);
//			listaComPalavrasEmJogo.add(palavraComTresLetras);
//		}
//		for (int i = 0; i < numPalavrasComQuatroLetras; i++) {
//			JTextField palavraComQuatroLetras = new JTextField(" _ _ _ _ ");
//			palavraComQuatroLetras.setSize(46, 24);
//			palavraComQuatroLetras.setLocation(posicaoX, posicaoY);
//			posicaoY += 28;
//			palavraComQuatroLetras.setEditable(false);
//			getContentPane().add(palavraComQuatroLetras);
//			listaComPalavrasEmJogo.add(palavraComQuatroLetras);
//			if(posicaoY >= 400){
//				posicaoY = 128;
//				posicaoX = 280;
//			}
//		}
//		for (int i = 0; i < numPalavrasComCincoLetras; i++) {
//			JTextField palavraComCincoLetras = new JTextField(" _ _ _ _ _ ");
//			palavraComCincoLetras.setSize(56, 24);
//			palavraComCincoLetras.setLocation(posicaoX, posicaoY);
//			posicaoY += 28;
//			palavraComCincoLetras.setEditable(false);
//			getContentPane().add(palavraComCincoLetras);
//			listaComPalavrasEmJogo.add(palavraComCincoLetras);
//			if(posicaoY >= 400){
//				posicaoY = 128;
//				posicaoX = 280;
//			}
//		}
//		for (int i = 0; i < numPalavrasComSeisLetras; i++) {
//			JTextField palavraComSeisLetras = new JTextField(" _ _ _ _ _ _ ");
//			palavraComSeisLetras.setSize(68, 24);
//			palavraComSeisLetras.setLocation(posicaoX, posicaoY);
//			posicaoY += 28;
//			palavraComSeisLetras.setEditable(false);
//			getContentPane().add(palavraComSeisLetras);
//			listaComPalavrasEmJogo.add(palavraComSeisLetras);
//		}
		
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

	private void geraBotaoComLetraParaChute(List<Character> letrasJogo, int posicao, int posicaoXBotao){
		botoesParaChute.add(new JButton(letrasJogo.get(posicao) + ""));
		botoesParaChute.get(posicao).setSize(48, 24);
		botoesParaChute.get(posicao).setLocation(posicaoXBotao , 4);
 		botoesParaChute.get(posicao).setToolTipText("Adiciona a letra (" + letrasJogo.get(posicao) + ") para a palavra a ser chutada"); 
 		getContentPane().add(botoesParaChute.get(posicao));
		botoesParaChute.get(posicao).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					botoesParaChute.get(posicao).setEnabled(false);
					String letrasJaChutadas = palavraParaChute.getText();
					letrasJaChutadas += letrasJogo.get(posicao)+ "";
					palavraParaChute.setText(letrasJaChutadas);
			}
		});		
	}
	
	private void criaBotoesComLetrasParaChute(List<Character> letrasJogo) {	
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
	
	public String getPalavraChuteDigitada(){
		return palavraParaChute.getText();
	}
	
	public void setPosicaoChutePalavra(int posicao){
		listaComPalavrasEmJogo.get(posicao).setText(getPalavraChuteDigitada());
	}

	public void setPalavraChuteDigitada(String palavraParaTextField){
		palavraParaChute.setText(palavraParaTextField);
	}
	
	public void exibeMensagem(String mensagem){
		JOptionPane.showMessageDialog(null, mensagem);
	}

}