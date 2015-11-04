package Trabalho;

import java.util.Date;

import Dados.Multa;

public class Principal {

	public static void main(String[] args) {
		//7) Pocessar do 2 ao 6 para cada um dos tamanhos, arquivos e metodos
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
				
				/**SHELL SORT**/
				//1) Comecar a contar o tempo
				String[] tempos = new String[4];
				Date tempo = new Date();
				long inicio = tempo.getTime();

				//5) Processar 5 vezes do "2" ao "4"
				for (int i = 0; i < 4; i++) {

					//2) Carregar arquivo
					String caminhoArquivo = new String("arquivos/multa" + tamanhos[tam] + tipos[tip] + ".txt");
					Multa[] multas = new Multa[tamanhos[tam]];
					multas = Apoio.lerArquivo(caminhoArquivo, tamanhos[tam]);	

					//3) Criar arquivo com as multas ordenadas
					Metodos.ShellSort(multas);
					caminhoArquivo = "arquivos/gerados/multa" + tamanhos[tam] + tipos[tip] + ".txt";
					Apoio.escreverArquivo(multas, caminhoArquivo);

					//4) Pesquisar placas e escrever no arquivo
					caminhoArquivo = "arquivos/placas.txt";
					String[] placas = new String[200];
					placas = Apoio.lerPlacas(caminhoArquivo, 200);
					System.out.println("Sucesso");

				}

				//6) Terminar de contar o tempo e fazer a media
				long fim = tempo.getTime();
				tempos[0] = String.valueOf((fim - inicio) / 5);

			}
		}
	}

}