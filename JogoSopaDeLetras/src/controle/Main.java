package controle;

public class Main {

	public static void main(String[] args) {
		
		//adicionarBot�oPorTeclaDeAtalho
		//melhorar (e muito) a interface com usuario
		//algumas coisas ali podem ser simplificadas para m�todos ou virarem arrays
		//se pa implementar estados na interface para separar os niveis
		//tipo sempre criando uma janela gen�rica (mais ou menos ja feita)
		//e adicionar funcionalidades dependendo da dificuldade, talvez usar heran�a
		//botar sistema de pontua��es
		//fazer a serializa�ao para uma das estrategias funfar
		//botar nivel de dificuldade
		//facil: tem numero ilimitado de "espiadinhas"
		//m�dio: tres espiadinhas apenas
		//dificil: sem espiadinhas
		//Insano: sem espiadinhas e o jogo acaba em um minuto
		//Impossivel: Insano e uma nova palavra deve ser descoberta a cada 5 segundos sen�o Leo
		new Controle();
	}

}
