package vetores;

import componentes.Item;
import componentes.ItemComparator;

/**Classe que modela um Vetor de Item*/


public class VetorItem {
	private Item vetItem [];
	private int nElem;


	/**
	 * Construtor da Classe VetorItem() sem parâmetro
	 */
	public VetorItem() {
		this.vetItem=null;
		this.nElem=0;
	}

	/**
	 * Construtor da Classe VetorItem() com parâmetro
	 *  @param tam = tamanho do vetor
	 */
	public VetorItem(int tam){
		this.vetItem=new Item[tam];
		this.nElem=0;
	}

	/**
	 * Obtém o tamanho do vetor
	 * @return tamanho do vetor
	 */
	public int tamVet(){
		return vetItem.length;
	}
	/**
	 * Obtém o Conteúdo da posição passado no parâmetor
	 * @param i 
	 * @return   
	 */
	public Item getVetItem(int i) {
		return vetItem[i];
	}
	/**
	 * Coloca a um Item na posição passado no parâmetro
	 * @param i
	 * @param elem
	 */
	public void setVetItem(int i, Item elem) {
		this.vetItem[i] = elem;
	}
	/**
	 * 
	 */
	//	public String toString (){
	//		String str="";
	//		for (int i=0; i< this.nElem; i++)
	//			str += this.vetItem[i].toString()+"\n";
	//		return str;
	//	}
	/**
	 *  Impprime i Item
	 * @return
	 */
	public String toString (){
		String str="";
		for (int i=0; i< this.nElem; i++){
			
			str += this.getVetItem(i).getNome() + ";" + this.getVetItem(i).getCpf() + ";" + this.getVetItem(i).getFuncao() + "\n";
			
		}
		return str;
	}
/**
 * Insere um Item passado no parâmetro
 * @param elem
 * @return
 */
	public boolean insere (Item elem){
		if (this.nElem == this.vetItem.length)
			return false;
		else{
			this.vetItem[this.nElem++] = elem;
			//System.out.println(this.nElem);
		}
		return true;
	}
/**
 *  Método SHELLSORT de ordenação
 * @throws Exception
 */
	public void shellsort () throws Exception{
		int i, j, h;
		Item temp;
		h = 1;
		do{
			h = 3*h+1;
		}while (h < this.vetItem.length);
		do{
			h = h/3;
			for (i=h; i < this.vetItem.length; i++){
				temp = this.vetItem[i];
				j = i;
				while (ItemComparator.compare(this.vetItem[j-h],temp)> 0){
					this.vetItem[j] = this.vetItem[j-h];
					j -= h;
					if (j < h)
						break;
				}

				this.vetItem[j] = temp;
			}
		}while (h != 1);
	}
/**
 * Método QUIKSORT de ordenação
 */
	public void quicksort (){
		ordena (0, this.nElem-1);}

	private void ordena (int esq, int dir){
		Item pivo;
		int i = esq, j = dir;
		Item temp;
		pivo = this.vetItem[(i+j)/2];
		do {
			while ((ItemComparator.compare(this.vetItem[i], pivo))<0)
				i++;
			while ((ItemComparator.compare(this.vetItem[j], pivo))>0)
				j--;
			if (i <= j) {
				temp = this.vetItem[i];
				this.vetItem[i] = this.vetItem[j];
				this.vetItem[j] = temp;
				i++;
			}
		} while (i <= j);
		if (esq < j)
			ordena (esq, j);
		if (dir > i)
			ordena (i, dir);
	}
/**
 * Método HEAPSORT de ordenação
 */
	public void heapSort (){
		int dir = nElem-1;
		int esq = (dir-1)/2;
		Item temp;
		while (esq >= 0){
			refazHeap (esq, this.nElem-1);
			esq--;
		}
		while (dir > 0){
			temp = this.vetItem[0];
			this.vetItem [0] = this.vetItem [dir];
			this.vetItem [dir] = temp;
			dir--;
			refazHeap(0, dir);
		}
	}
	/**
	 * Método REFAZHEAP  
	 * @param esq
	 * @param dir
	 */
	private void refazHeap (int esq, int dir){
		int i = esq;
		int maiorFolha = 2*i+1;
		Item raiz = this.vetItem[i];
		boolean heap = false;
		while ((maiorFolha <= dir) && (!heap)){
			if (maiorFolha < dir)
				if ((ItemComparator.compare(this.vetItem[maiorFolha], this.vetItem[maiorFolha+1])<0))
					maiorFolha ++;
			if (ItemComparator.compare(raiz , this.vetItem[maiorFolha])<0) {
				this.vetItem[i] = this.vetItem[maiorFolha];
				i = maiorFolha;
				maiorFolha = 2*i+1;
			}
			else
				heap = true;
		}
		this.vetItem[i] = raiz;
	}

/**
 * Método INSERÇÂODIRETA usado na QUICKINSERTION
 */
	public void insercaoDireta(){
		int i, j;
		Item temp;
		for (i=1; i < this.vetItem.length; i++){
			temp = this.vetItem[i];
			j = i - 1;
			while ((j >= 0) && (ItemComparator.compare(this.vetItem[j] ,temp)) > 0){
				this.vetItem [j+1] = this.vetItem[j--];
			}
			this.vetItem[j+1] = temp;
		}
	}
/**
 * Método QUICKSORTINSERÇÂO  chama o Inserção quando da divisão do vetor é menor que 25 elementos.
 * Executa a inserção direta quando 
 */
	public void quicksortInsercao (){
		ordenaInsercao (0, this.vetItem.length-1);
	}
	private void ordenaInsercao (int esq, int dir){
		int i = esq, j = dir;
		Item pivo;
		Item temp;
		pivo = this.vetItem[(i+j)/2];
		do {
			while ((ItemComparator.compare(this.vetItem[i], pivo))<0)
				i++;
			while ((ItemComparator.compare(this.vetItem[j], pivo))>0)
				j--;
			if (i <= j) {
				temp = this.vetItem[i];
				this.vetItem[i] = this.vetItem[j];
				this.vetItem[j] = temp;
				i++;
				j--;
			}
		} while (i <= j);
		if (esq < j){
			if(j-esq>=25){
				ordena (esq, j);
			}else{
				this.insercaoDireta();
			}
		}

		if (dir > i){
			if(dir-i>=25){
				ordena (i, dir);
			}else{
				this.insercaoDireta();
			}
		}
	}
	
/**
 *   Método  que chama o PesquisaBinaria , recebe como parâmetro o vetor de 200 cpfs
 * @param vetString 
 * @return
 */
	public String chamaPesqBinaria(String []vetString){
		String resu = "";
		for (int i = 0; i < vetString.length; i++) {
			if(pesqBinaria(vetString[i]) != "")
				resu+=pesqBinaria(vetString[i]);
			else
				resu+=vetString[i] +" NOME INEXISTENTE"+"\n";
		}
		return resu;
	}
/**
 * Método que  executa a pesquisa Binária
 * @param elem
 * @return
 */
	private String pesqBinaria (String elem){
		int meio, esq, dir,camDir,camEsq;
		String str = "";
		esq = 0;
		dir = this.vetItem.length-1;
		while (esq <= dir){
			meio = (esq + dir)/2;
			
			if (elem.equalsIgnoreCase(this.vetItem[meio].getNome())){
				camDir = meio+1; 
				camEsq = meio-1;
				str += this.vetItem[meio].toString()+"\n";
				if(camEsq < 0)
					return str;
				while (elem.equalsIgnoreCase(this.vetItem[camEsq].getNome())&& camEsq >= esq ){
					str += this.vetItem[camEsq].toString()+"\n";
					camEsq--;
				}			
				while (elem.equalsIgnoreCase(this.vetItem[camDir].getNome())&&camDir <= dir ){
					str += this.vetItem[camDir].toString()+"\n";
					camDir++;
				}				
				return str;	
			}else{
				if (elem.compareToIgnoreCase(this.vetItem[meio].getNome()) < 0)
					dir = meio - 1;
				else
					esq = meio + 1;
			}
		}
		return str;
	}
}
