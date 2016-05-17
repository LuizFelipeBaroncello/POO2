package controle;

public class Main {

	public static void main(String[] args) {
		
		//adicionarBotãoPorTeclaDeAtalho
		//melhorar (e muito) a interface com usuario
		//algumas coisas ali podem ser simplificadas para métodos ou virarem arrays
		//se pa implementar estados na interface para separar os niveis
		//tipo sempre criando uma janela genérica (mais ou menos ja feita)
		//e adicionar funcionalidades dependendo da dificuldade, talvez usar herança
		//botar sistema de pontuações
		//fazer a serializaçao para uma das estrategias funfar
		//botar nivel de dificuldade
		//facil: tem numero ilimitado de "espiadinhas"
		//médio: tres espiadinhas apenas
		//dificil: sem espiadinhas
		//Insano: sem espiadinhas e o jogo acaba em um minuto
		//Impossivel: Insano e uma nova palavra deve ser descoberta a cada 5 segundos senão Leo
		new Controle();
	}

}
