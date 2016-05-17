package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GerenciadorDados {

	public Pontuacoes carregaDados() {
		Pontuacoes pontuacoes;
		try {
			FileInputStream in = new FileInputStream("src" + File.separator + "resources" + File.separator + "Dados");
			ObjectInputStream objIn = new ObjectInputStream(in);

			pontuacoes = (Pontuacoes) objIn.readObject();

			in.close();
			objIn.close();

			return pontuacoes;
		} catch (Exception e) {
			return pontuacoes = new Pontuacoes();
		}

	}

	public void salvaArquivo(Pontuacoes pontuacoes) {
		try {
			FileOutputStream out = new FileOutputStream("src" + File.separator + "resources" + File.separator + "Dados");
			ObjectOutputStream objOut = new ObjectOutputStream(out);

			objOut.writeObject(pontuacoes);
			out.close();
			objOut.close();
		} catch (Exception e) {
			
		}

	}

}