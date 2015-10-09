package Trabalho;

import java.util.Date;

import Dados.Multa;

public class Principal {

	public static void main(String[] args) {
		//1) Começar a contar o tempo
		Date tempo = new Date();
		long mediaTempo = tempo.getTime();

		//5) Processar 5 vezes do 2) ao 4)
		for (int i = 0; i < 4; i++) {

			//2) Carregar arquivo
			String caminhoArquivo = new String("arquivos/multa500alea.txt");
			int tamanhoVetor = 500;		
			Multa[] multas = new Multa[tamanhoVetor];
			multas = Apoio.lerArquivo(caminhoArquivo, tamanhoVetor);	

			//3) Ordenar pela placa
			Metodos.ShellSort(multas);

			//4) Pesquisar placas e escrever no arquivo

		}
		
		//6) Terminar de contar o tempo e fazer a média
		Date horaFim = new Date();
		horaFim.getTime();
		mediaTempo = (mediaTempo - tempo.getTime()) / 5;
	}

}
