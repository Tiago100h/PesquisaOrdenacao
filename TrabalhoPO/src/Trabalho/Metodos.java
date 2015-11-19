package Trabalho;

import Dados.Multa;

public class Metodos {

	/** 
	 * Metodo ShellSort de ordenacao
	 * @param multas Vetor do tipo Multa
	 * @return Ordena o vetor passado como parametro
	 */
	public static void ShellSort(Multa[] multas) {		
		int i, j, h;
		Multa temp;
		h = 1;
		do{
			h = 3 * h + 1;
		}while (h < multas.length);
		do{
			h = h/3;
			for (i = h; i < multas.length; i++){
				temp = multas[i];
				j = i;								
				while (multas[j - h].getPlaca().compareTo(temp.getPlaca()) > 0){
					multas[j] = multas[j-h];
					j -= h;
					if (j < h)
						break;
				}
				multas[j] = temp;
			}
		}while (h != 1);		
	}
	
	/**
	 * Pesquisa binaria em vetor
	 * @param placa Placa a ser pesquisada
	 * @param multas Vetor de multas
	 * @return indice correspondente a placa encontrada (retorna -1 se nao encontrar)
	 */
	public static int pesquisaBinaria (String placa, Multa[] multas){
		int meio, esq, dir;
		esq = 0;
		dir = multas.length - 1;
		while (esq <= dir){
			meio = (esq + dir)/2;
			if (placa.compareTo(multas[meio].getPlaca()) == 0)
				return meio;
			else{
				if (placa.compareTo(multas[meio].getPlaca()) < 0)
					dir = meio - 1;
				else
					esq = meio + 1;
			}
		}
		return - 1;
	}

	/*	

	//Método QuickSort de ordenação		
	public void quicksort (){
		ordena (0, this.tamanhoVetor-1);}

	private void ordena (int esq, int dir){
		Item pivo;
		int i = esq, j = dir;
		Item temp;

		pivo = this.multas[(i+j)/2];
		do {
			while (this.multas[i].getChave() < 0)
				i++;
			while (this.multas[j].getChave() > 0)
				j--;
			if (i <= j) {
				temp = this.multas[i];
				this.multas[i] = this.multas[j];
				this.multas[j] = temp;
				i++;
			}
		} while (i <= j);
		if (esq < j)
			ordena (esq, j);
		if (dir > i)
			ordena (i, dir);
	}	

	//Método HEAPSORT de ordenação

	public void heapSort (){
		int dir = nElem-1;
		int esq = (dir-1)/2;
		Item temp;
		while (esq >= 0){
			refazHeap (esq, this.nElem-1);
			esq--;
		}
		while (dir > 0){
			temp = this.multas[0];
			this.multas [0] = this.multas [dir];
			this.multas [dir] = temp;
			dir--;
			refazHeap(0, dir);
		}
	}

	private void refazHeap (int esq, int dir){
		int i = esq;
		int maiorFolha = 2*i+1;
		Item raiz = this.multas[i];
		boolean heap = false;
		while ((maiorFolha <= dir) && (!heap)){
			if (maiorFolha < dir)
				if (this.multas[maiorFolha].getChave() < this.multas[maiorFolha+1].getChave())
					maiorFolha ++;
			if (raiz.getChave () < this.multas[maioFolha].getChave()) { this.multas[i] = this.multas[maiorFolha];
			i = maiorFolha;
			maiorFolha = 2*i+1;
			}
			else
				heap = true;
		}
		this.multas[i] = raiz;
	}*/

}
