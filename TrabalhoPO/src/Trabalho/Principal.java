package Trabalho;

import java.util.Date;

import Dados.Multa;

public class Principal {

	public static void main(String[] args) {
		//1) Começar a contar o tempo
		Date tempo = new Date();
		long mediaTempo = tempo.getTime();

		//7) Pocessar do 2 ao 6 para cada um dos tamanhos, arquivos e métodos
		int[] tamanhos = new int[5];
		tamanhos[0] = 500;
		tamanhos[1] = 1000;
		tamanhos[2] = 5000;
		tamanhos[3] = 10000;
		tamanhos[4] = 50000;
		String[] tipos = new String[3];
		tipos[0] = "alea";
		tipos[1] = "inv";
		tipos[2] = "ord";
		for (int tam = 0; tam < tamanhos.length; tam++) {
			for (int tip = 0; tip < tipos.length; tip++) {

				//5) Processar 5 vezes do "2" ao "4"
				for (int i = 0; i < 4; i++) {

					//2) Carregar arquivo
					String caminhoArquivo = new String("arquivos/multa" + tamanhos[tam] + tipos[tip] + ".txt");
					Multa[] multas = new Multa[tamanhos[tam]];
					multas = Apoio.lerArquivo(caminhoArquivo, tamanhos[tam]);	

					//3) Ordenar pela placa e gravar num arquivo
					Metodos.ShellSort(multas);
					caminhoArquivo = "arquivos/gerados/multa" + tamanhos[tam] + tipos[tip] + ".txt";
					Apoio.escreverArquivo(multas, caminhoArquivo);

					//4) Pesquisar placas e escrever no arquivo
					

				}

				//6) Terminar de contar o tempo e fazer a média
				Date horaFim = new Date();
				horaFim.getTime();
				mediaTempo = (mediaTempo - tempo.getTime()) / 5;

			}
		}
	}

}
