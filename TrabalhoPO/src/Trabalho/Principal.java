package Trabalho;

import Dados.Multa;

public class Principal {

	public static void main(String[] args) {
		String[] tempos = new String[105];
		long inicio = 0;
		long fim = 0;
		double diferenca = 0;
		int cont = 0;		
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

		//7) Pocessar do 2 ao 6 para cada um dos tamanhos, arquivos e metodos
		for (int tam = 0; tam < tamanhos.length; tam++) {
			for (int tip = 0; tip < tipos.length; tip++) {

				/**SHELL SORT**/
				//1) Comecar a contar o tempo
				inicio = System.currentTimeMillis();

				//5) Processar 5 vezes do "2" ao "4"
				for (int i = 0; i < 4; i++) {

					//2) Carregar arquivo
					String caminhoArquivo = new String("arquivos/multa" + tamanhos[tam] + tipos[tip] + ".txt");
					Multa[] multas = new Multa[tamanhos[tam]];
					multas = Apoio.lerArquivo(caminhoArquivo, tamanhos[tam]);	

					//3) Criar arquivo com as multas ordenadas
					Metodos.ShellSort(multas);
					caminhoArquivo = "arquivos/gerados/ShellSortMulta" + tamanhos[tam] + tipos[tip] + ".txt";
					Apoio.escreverArquivo(multas, caminhoArquivo);

					//4) Pesquisar placas e gerar arquivo com todas as multas de cada placa
					caminhoArquivo = "arquivos/placas.txt";
					String[] placas = new String[200];
					placas = Apoio.lerPlacas(caminhoArquivo, 200);
					caminhoArquivo = "arquivos/gerados/placasMultas.txt";
					int[] indices = new int[200];
					for (int j = 0; j < placas.length; j++) {
						indices[j] = Metodos.pesquisaBinaria(placas[j], multas);
					}
					Apoio.escreveMultasPlacas(indices, multas, caminhoArquivo, placas);

				}

				//6) Terminar de contar o tempo e fazer a media
				fim = System.currentTimeMillis();
				diferenca = ((fim - inicio) / 5);
				tempos[cont] = "ShellSort" + tipos[tip] + tamanhos[tam] + " - " + Double.toString(diferenca);
				cont++;


				/**HEAP SORT**/
				//1) Comecar a contar o tempo
				inicio = System.currentTimeMillis();

				//5) Processar 5 vezes do "2" ao "4"
				for (int i = 0; i < 4; i++) {

					//2) Carregar arquivo
					String caminhoArquivo = new String("arquivos/multa" + tamanhos[tam] + tipos[tip] + ".txt");
					Multa[] multas = new Multa[tamanhos[tam]];
					multas = Apoio.lerArquivo(caminhoArquivo, tamanhos[tam]);	

					//3) Criar arquivo com as multas ordenadas
					Metodos.heapSort(multas);
					caminhoArquivo = "arquivos/gerados/HeapSortMulta" + tamanhos[tam] + tipos[tip] + ".txt";
					Apoio.escreverArquivo(multas, caminhoArquivo);

					//4) Pesquisar placas e gerar arquivo com todas as multas de cada placa
					caminhoArquivo = "arquivos/placas.txt";
					String[] placas = new String[200];
					placas = Apoio.lerPlacas(caminhoArquivo, 200);
					caminhoArquivo = "arquivos/gerados/placasMultas.txt";
					int[] indices = new int[200];
					for (int j = 0; j < placas.length; j++) {
						indices[j] = Metodos.pesquisaBinaria(placas[j], multas);
					}
					Apoio.escreveMultasPlacas(indices, multas, caminhoArquivo, placas);

				}

				//6) Terminar de contar o tempo e fazer a media
				fim = System.currentTimeMillis();
				diferenca = ((fim - inicio) / 5);
				tempos[cont] = "HeapSort" + tipos[tip] + tamanhos[tam] + " - " + Double.toString(diferenca);
				cont++;


				/**QUICK SORT COM INSERCAO**/
				//1) Comecar a contar o tempo
				inicio = System.currentTimeMillis();

				//5) Processar 5 vezes do "2" ao "4"
				for (int i = 0; i < 4; i++) {

					//2) Carregar arquivo
					String caminhoArquivo = new String("arquivos/multa" + tamanhos[tam] + tipos[tip] + ".txt");
					Multa[] multas = new Multa[tamanhos[tam]];
					multas = Apoio.lerArquivo(caminhoArquivo, tamanhos[tam]);	

					//3) Criar arquivo com as multas ordenadas
					Metodos.quicksortInsercao(multas);
					caminhoArquivo = "arquivos/gerados/quickInsMulta" + tamanhos[tam] + tipos[tip] + ".txt";
					Apoio.escreverArquivo(multas, caminhoArquivo);

					//4) Pesquisar placas e gerar arquivo com todas as multas de cada placa
					caminhoArquivo = "arquivos/placas.txt";
					String[] placas = new String[200];
					placas = Apoio.lerPlacas(caminhoArquivo, 200);
					caminhoArquivo = "arquivos/gerados/placasMultas.txt";
					int[] indices = new int[200];
					for (int j = 0; j < placas.length; j++) {
						indices[j] = Metodos.pesquisaBinaria(placas[j], multas);
					}
					Apoio.escreveMultasPlacas(indices, multas, caminhoArquivo, placas);

				}

				//6) Terminar de contar o tempo e fazer a media
				fim = System.currentTimeMillis();
				diferenca = ((fim - inicio) / 5);
				tempos[cont] = "QuickInsercao" + tipos[tip] + tamanhos[tam] + " - " + Double.toString(diferenca);
				cont++;


				/**QUICK SORT**/
				//1) Comecar a contar o tempo
				inicio = System.currentTimeMillis();

				//5) Processar 5 vezes do "2" ao "4"
				for (int i = 0; i < 4; i++) {

					//2) Carregar arquivo
					String caminhoArquivo = new String("arquivos/multa" + tamanhos[tam] + tipos[tip] + ".txt");
					Multa[] multas = new Multa[tamanhos[tam]];
					multas = Apoio.lerArquivo(caminhoArquivo, tamanhos[tam]);	

					//3) Criar arquivo com as multas ordenadas
					Metodos.quickSort(multas);
					caminhoArquivo = "arquivos/gerados/quickSortMulta" + tamanhos[tam] + tipos[tip] + ".txt";
					Apoio.escreverArquivo(multas, caminhoArquivo);

					//4) Pesquisar placas e gerar arquivo com todas as multas de cada placa
					caminhoArquivo = "arquivos/placas.txt";
					String[] placas = new String[200];
					placas = Apoio.lerPlacas(caminhoArquivo, 200);
					caminhoArquivo = "arquivos/gerados/placasMultas.txt";
					int[] indices = new int[200];
					for (int j = 0; j < placas.length; j++) {
						indices[j] = Metodos.pesquisaBinaria(placas[j], multas);
					}
					Apoio.escreveMultasPlacas(indices, multas, caminhoArquivo, placas);

				}

				//6) Terminar de contar o tempo e fazer a media
				fim = System.currentTimeMillis();
				diferenca = ((fim - inicio) / 5);
				tempos[cont] = "QuickSort" + tipos[tip] + tamanhos[tam] + " - " + Double.toString(diferenca);
				cont++;
				
				
				/**ABB**/
				//8) Comece a contar o tempo
				inicio = System.currentTimeMillis();
				
				//11) Repita 4 vezes os processos 9 e 10
				for (int i = 0; i < 4; i++) {
					
					//9) Carregue o arquivo de multas
					String caminhoArquivo = new String("arquivos/multa" + tamanhos[tam] + tipos[tip] + ".txt");
					Multa[] multas = new Multa[tamanhos[tam]];
					multas = Apoio.lerArquivo(caminhoArquivo, tamanhos[tam]);
					
					//10) Faca a pesquisa ABB
					caminhoArquivo = "arquivos/placas.txt";
					String[] placas = new String[200];
					placas = Apoio.lerPlacas(caminhoArquivo, 200);
					caminhoArquivo = "arquivos/gerados/placasMultas.txt";
					int[] indices = new int[200];
					for (int j = 0; j < placas.length; j++) {
//						indices[j] = Metodos.pesquisaABB(placas[j], multas);
					}
					Apoio.escreveMultasPlacas(indices, multas, caminhoArquivo, placas);
					
				}
				
				//12) Termine de contar o tempo, faça uma média e armazene este resultado
				fim = System.currentTimeMillis();
				diferenca = ((fim - inicio) / 4);
				tempos[cont] = "ABB" + tipos[tip] + tamanhos[tam] + " - " + Double.toString(diferenca);
				cont++;
				
				
				/**AVL**/
				//8) Comece a contar o tempo
				inicio = System.currentTimeMillis();
				
				//11) Repita 4 vezes os processos 9 e 10
				for (int i = 0; i < 4; i++) {
					
					//9) Carregue o arquivo de multas
					String caminhoArquivo = new String("arquivos/multa" + tamanhos[tam] + tipos[tip] + ".txt");
					Multa[] multas = new Multa[tamanhos[tam]];
					multas = Apoio.lerArquivo(caminhoArquivo, tamanhos[tam]);
					
					//10) Faca a pesquisa AVL
					caminhoArquivo = "arquivos/placas.txt";
					String[] placas = new String[200];
					placas = Apoio.lerPlacas(caminhoArquivo, 200);
					caminhoArquivo = "arquivos/gerados/placasMultas.txt";
					int[] indices = new int[200];
					for (int j = 0; j < placas.length; j++) {
//						indices[j] = Metodos.pesquisaAVL(placas[j], multas);
					}
					Apoio.escreveMultasPlacas(indices, multas, caminhoArquivo, placas);
					
				}
				
				//12) Termine de contar o tempo, faça uma média e armazene este resultado
				fim = System.currentTimeMillis();
				diferenca = ((fim - inicio) / 4);
				tempos[cont] = "AVL" + tipos[tip] + tamanhos[tam] + " - " + Double.toString(diferenca);
				cont++;
				
				
				/**HASHING**/
				//14) Comece a contar o tempo
				inicio = System.currentTimeMillis();
				
				//17) Repita 4 vezes os processos 9 e 10
				for (int i = 0; i < 4; i++) {
					
					//15) Carregue o arquivo de multas
					String caminhoArquivo = new String("arquivos/multa" + tamanhos[tam] + tipos[tip] + ".txt");
					Multa[] multas = new Multa[tamanhos[tam]];
					multas = Apoio.lerArquivo(caminhoArquivo, tamanhos[tam]);
					
					//16) Faca a pesquisa AVL
					caminhoArquivo = "arquivos/placas.txt";
					String[] placas = new String[200];
					placas = Apoio.lerPlacas(caminhoArquivo, 200);
					caminhoArquivo = "arquivos/gerados/placasMultas.txt";
					int[] indices = new int[200];
					for (int j = 0; j < placas.length; j++) {
//						indices[j] = Metodos.pesquisaHashing(placas[j], multas);
					}
					Apoio.escreveMultasPlacas(indices, multas, caminhoArquivo, placas);
					
				}
				
				//12) Termine de contar o tempo, faça uma média e armazene este resultado
				fim = System.currentTimeMillis();
				diferenca = ((fim - inicio) / 4);
				tempos[cont] = "Hashing" + tipos[tip] + tamanhos[tam] + " - " + Double.toString(diferenca);
				cont++;

			}
		}				

		Apoio.escreverTempos(tempos, "arquivos/gerados/tempos.txt");
		System.out.println("Fim");
	}

}