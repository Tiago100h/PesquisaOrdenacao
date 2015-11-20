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
		Multa temp,test;
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
					//-----ORDENANDO PELA HORA
					if(multas[j - h].getPlaca().equals(temp.getPlaca()) && (multas[j - h].getDataHora().getYear() >= temp.getDataHora().getYear())){
						if((multas[j - h].getDataHora().getYear() == temp.getDataHora().getYear())&&(multas[j - h].getDataHora().getHours() > temp.getDataHora().getHours())){
							test = multas[j - h];
							multas[j - h] = temp;
							temp = test;
						}else{
							test = multas[j - h];
							multas[j - h] = temp;
							temp = test;
						}
					}
					//------
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

	/**
	 * Método INSERÇÂODIRETA usado na QUICKINSERTION
	 */
	public static void insercaoDireta(Multa[] multas){
		int i, j;
		Multa temp,auxil;
		for (i=1; i < multas.length; i++){
			temp = multas[i];
			j = i - 1;
			while ((j >= 0) && (multas[j].getPlaca().compareTo(temp.getPlaca()) > 0)){
				multas[j+1] = multas[j--];
				//-----ORDENANDO PELA HORA
			}
			if(multas[j].getPlaca().equals((temp.getPlaca())) && (multas[j].getDataHora().getYear() > (temp.getDataHora().getYear()))){

				auxil = multas[j];
				multas[j] =temp;
				temp = auxil;
			}
			if((multas[j].getDataHora().getYear() ==(temp.getDataHora().getYear())) && (multas[j].getDataHora().getHours() > (temp.getDataHora().getHours()))){

				auxil = multas[j];
				multas[j] =temp;
				temp = auxil;
			}
			//----------
			multas[j+1] = temp;
		}
	}

	/*
	 * Método QUICKSORTINSERÇÂO  chama o Inserção quando da divisão do vetor é menor que 25 elementos.
	 */
	public static void quicksortInsercao (Multa[] multas){
		//ordenaInsercao (0, multas.length-1,  multas);
	}
	public static void ordenaInsercao (int esq, int dir, Multa[] multas){
		int i = esq, j = dir;
		Multa pivo;
		Multa temp;
		pivo = multas[(i+j)/2];
		do {
			while ((multas[i].getPlaca()).compareTo(pivo.getPlaca()) < 0)
				i++;
			while ((multas[j].getPlaca()).compareTo(pivo.getPlaca())>0)
				j--;
			if (i <= j) {
				//-----ORDENANDO PELA HORA
				if(multas[j].getPlaca().equals((multas[i].getPlaca())) && (multas[j].getDataHora().getYear() > (multas[i].getDataHora().getYear()))){

					temp = multas[j];
					multas[j] =multas[i];
					multas[i] = temp;
				}
				if((multas[j].getDataHora().getYear() ==(multas[i].getDataHora().getYear())) && (multas[j].getDataHora().getHours() > (multas[i].getDataHora().getHours()))){

					temp = multas[j];
					multas[j] =multas[i];
					multas[i] = temp;
				}
				//-------
				temp = multas[i];
				multas[i] = multas[j];
				multas[j] = temp;
				i++;
				j--;
			}
		} while (i <= j);
		if (esq < j){
			if(j-esq>=25){
				ordenaInsercao (esq, j, multas);
			}else{
				insercaoDireta(multas);
			}
		}

		if (dir > i){
			if(dir-i>=25){
				ordenaInsercao (i, dir, multas);
			}else{
				insercaoDireta(multas);
			}
		}
	}

	/*TA DANDO ERRO*/
	//MÃ©todo QuickSort de ordenaÃ§Ã£o		
	public static void quickSort (Multa[] multas){
		ordenaquickSort (0, multas.length-1, multas);}

	public static void ordenaquickSort (int esq, int dir, Multa[] multas ){

		int i = esq, j = dir;
		Multa pivo;
		Multa temp;
		pivo = multas[(i+j)/2];

		do {

			while ( (multas[i].getPlaca()).compareTo(pivo.getPlaca()) < 0)
				i++;
			while ((multas[j].getPlaca()).compareTo(pivo.getPlaca())  > 0)
				j--;

			if (i <= j){
				//-----ORDENANDO PELA HORA
				if(multas[j].getPlaca().equals((multas[i].getPlaca())) && (multas[j].getDataHora().getYear() > (multas[i].getDataHora().getYear()))){

					temp = multas[j];
					multas[j] =multas[i];
					multas[i] = temp;
				}
				if((multas[j].getDataHora().getYear() ==(multas[i].getDataHora().getYear())) && (multas[j].getDataHora().getHours() > (multas[i].getDataHora().getHours()))){

					temp = multas[j];
					multas[j] =multas[i];
					multas[i] = temp;
				}
				//------------
				temp = multas[i];
				multas[i] = multas[j];
				multas[j] = temp;
				i++;
				j--;

			}
		}
		while (i <= j);
		if (esq < j)
			ordenaquickSort  (esq, j, multas);
		if (dir > i)
			ordenaquickSort  (i, dir, multas);
	}	




	/*public static void ordenaDataHora (Multa[] multas) {
		Multa temp,test;

		if(multas[j - h].getPlaca().equals(temp.getPlaca()) && (multas[j - h].getDataHora().getYear() >= temp.getDataHora().getYear())){
			  if((multas[j - h].getDataHora().getYear() == temp.getDataHora().getYear())&&(multas[j - h].getDataHora().getHours() > temp.getDataHora().getHours())){
				test = multas[j - h];
				multas[j - h] = temp;
				temp = test;
			  }else{
				  test = multas[j - h];
				  multas[j - h] = temp;
				  temp = test;
			  }
		}

	}*/




	//MÃ©todo HEAPSORT de ordenaÃ§Ã£o

	public static void heapSort (Multa[] multas){
		int dir = multas.length-1;
		int esq = (dir-1)/2;
		Multa temp;
		while (esq >= 0){
			refazHeap (esq, multas.length -1, multas);
			esq--;
		}
		while (dir > 0){

			temp = multas[0];
			multas[0] = multas[dir];
			multas[dir] = temp;
			dir--;
			refazHeap(0, dir, multas);
		}
	}

	public static void refazHeap (int esq, int dir, Multa[] multas){
		Multa temp1;
		int i = esq;
		int maiorFolha = 2*i+1;
		Multa raiz = multas[i];
		boolean heap = false;
		while ((maiorFolha <= dir) && (!heap)){
			if (maiorFolha < dir)
				if ( multas[maiorFolha].getPlaca().compareTo(multas[maiorFolha+1].getPlaca()) < 0)
					maiorFolha ++;
			if (raiz.getPlaca().compareTo(multas[maiorFolha].getPlaca()) < 0) {
				multas[i] = multas[maiorFolha];

				/*-----ORDENANDO PELA HORA
					if(multas[0].getPlaca().equals((multas[dir].getPlaca())) && (multas[0].getDataHora().getYear() < (multas[dir].getDataHora().getYear()))){

						temp1 = multas[dir];
					    multas[dir] =multas[0];
						multas[0] = temp1;
					  }

					------*/
				i = maiorFolha;
				maiorFolha = 2*i+1;
			}
			else
				heap = true;
		}

		multas[i] = raiz;
	}



}
