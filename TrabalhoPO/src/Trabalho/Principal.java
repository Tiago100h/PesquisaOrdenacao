package Trabalho;

import Dados.Multa;

public class Principal {

	public static void main(String[] args) {
		
		String caminhoArquivo = new String("arquivos/multa500alea.txt");
		int tamanhoVetor = 500;
		
		Multa[] multas = new Multa[tamanhoVetor];

		multas = Apoio.lerArquivo(caminhoArquivo, tamanhoVetor);
		
		

	}

}
