package visao;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JanelaSelecionaNivel extends JFrame {

	private JButton botaoFacil;
	private JButton botaoMedio;
	private JButton botaoDificil;	
	
	public JanelaSelecionaNivel(){
		
		criaBotoes();
		criaJanela();
		
		
	}

	private void criaJanela() {
		this.setTitle("Sopa de Letras");
		setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(176, 150);
		setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void criaBotoes() {
		botaoFacil = new JButton("Facil");
		botaoFacil.setSize(128, 24);
		botaoFacil.setLocation(16, 16);
		getContentPane().add(botaoFacil);
		
		botaoMedio = new JButton("Medio");
		botaoMedio.setSize(128, 24);
		botaoMedio.setLocation(16, 48);
		getContentPane().add(botaoMedio);
		
		botaoDificil = new JButton("Dificil");
		botaoDificil.setSize(128, 24);
		botaoDificil.setLocation(16, 80);
		getContentPane().add(botaoDificil);
	}
	
	public void setAcaoBotaoFacil(ActionListener actionListener){
		this.botaoFacil.addActionListener(actionListener);
	}
	
	public void setAcaoBotaoMedio(ActionListener actionListener){
		this.botaoMedio.addActionListener(actionListener);
	}
	
	public void setAcaoBotaoDificil(ActionListener actionListener){
		this.botaoDificil.addActionListener(actionListener);
	}
	
	public void fechaJanelaNiveis(){
		dispose();
	}

}