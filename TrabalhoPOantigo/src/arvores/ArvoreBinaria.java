package arvores;

import vetores.VetorItem;
import componentes.Item;
import componentes.ItemComparator;
import componentes.NoARV;
/**Classe que modela a Arovore Binaria 
 *@author Derlandy Belchior, Kevin Sossai, Marilio Freire de Almeida, Mauricio Valentin Junior 
 */


public class ArvoreBinaria {
	private int quantNos;
	private NoARV raiz;
	public static String achadosARV="";
	public  static boolean encontrouARV = false;
	/**
	 * Construtor da Arvore Binária
	 */
	public ArvoreBinaria(){
		this.raiz = null;
		this.quantNos=0;
	}
	/**
	 * Teste se a Arvore está vazia
	 * @return
	 */
	public boolean éVazia(){
		return (this.raiz==null);
	}
	/**
	 * Obtém a o tamanho da Arvore
	 * @return
	 */
	public int getQuantNos() {
		return quantNos;
	}
	/**
	 * Obtém a  raiz da Arvore
	 * @return
	 */
	public NoARV getRaiz() {
		return raiz;
	}
	/**
	 * Coloca um NoARV na raiz da Arvore
	 * @param raiz
	 */
	public void setRaiz(NoARV raiz) {
		this.raiz = raiz;
	}


	/**
	 * Insere uma Item na Arvore binária
	 * @param elem
	 * @return
	 */
	
	int cont = 0;
	
	public boolean insere (Item elem){
		boolean existe;
		existe = this.pesquisa (elem);
		
		if (existe)
			return false;
		else{
			this.raiz = this.insere (elem, this.raiz);
			this.quantNos++;
			return true;
		}
	}
	/**
	 * Recursão para a Inserção
	 * @param elem
	 * @param no
	 * @return
	 */
	private NoARV insere (Item elem, NoARV no){
		
		NoARV novo = null;
		if (no == null){
			novo = new NoARV(elem);
			return novo;
		}
		else {

			if ((ItemComparator.compare(elem, no.getInfo()))<0) {
				no.setEsq(this.insere (elem, no.getEsq()));
				return no;
			}
			else{
				no.setDir(this.insere (elem, no.getDir()));
				return no;
			}
		}
	}

	/**
	 * Faz a pesquisa na Arvore binaria
	 * Utilizada na Inserção de um Item
	 * @param elem
	 * @return
	 */

	public boolean pesquisa (Item elem){
		NoARV temp;
		temp = this.pesquisa (elem, this.raiz);
		if (temp != null)
			return true;
		else
			return false;
	}
	/**
	 * Recurção da Pesquisa
	 * @param elem
	 * @param no
	 * @return
	 */	
	private NoARV pesquisa (Item elem, NoARV no){
		NoARV temp;
		temp = no;
		if (temp != null){
			if(temp.getInfo().getNome().compareTo(elem.getNome())<0) 
				temp = this.pesquisa (elem, temp.getEsq());
			else{
				if (temp.getInfo().getNome().compareTo(elem.getNome())>0) 
					temp = this.pesquisa (elem, temp.getDir());
			}
		}
		return temp;
	}

	//
	//	private NoARV pesquisa (String cpf, NoARV no){
	//		NoARV temp;
	//		temp = no;
	//		if (temp != null){
	//			if(temp.getInfo().getCpf().compareTo(cpf)<0) 
	//
	//				temp = this.pesquisa (cpf, temp.getEsq());
	//			else{
	//				if (temp.getInfo().getCpf().compareTo(cpf)>0) 
	//					temp = this.pesquisa (cpf, temp.getDir());
	//			}
	//		}
	//		return temp;
	//	}




	/**
	 * Caminhamento Central utilizado na ABB Balanceada
	 * @return
	 */
	public VetorItem CamCentral (){
		int []n= new int[1];
		n[0]=0;
		VetorItem vet = new VetorItem(this.getQuantNos());
		return (FazCamCentral (this.raiz, vet, n));
	}
	/**
	 * Recursão do Caminhamento Central
	 * @param arv
	 * @param vet
	 * @param n
	 * @return
	 */
	private VetorItem FazCamCentral (NoARV arv, VetorItem vet, int []n){
		if (arv != null) {
			vet = FazCamCentral (arv.getEsq(),vet,n);
			vet.setVetItem(n[0], arv.getInfo());
			n[0]++;
			vet = FazCamCentral (arv.getDir(),vet,n);
		}
		return vet;
	}
	/**
	 * Balanceia a Arvore ABB Balanceada
	 * @param vetor
	 * @return
	 */

	public ArvoreBinaria BalancearArvore (VetorItem vetor) {
		ArvoreBinaria temp = new ArvoreBinaria();
		this.Balancear (vetor, temp, 0, (vetor.tamVet())-1);
		return temp;
	}
	/**
	 * Recursão do BalancearArvore
	 * @param vetor
	 * @param temp
	 * @param inic
	 * @param fim
	 */
	private void Balancear (VetorItem vetor, ArvoreBinaria temp, int inic, int fim) {
		int meio;
		if (fim >= inic){
			meio = (inic+fim)/2;
			temp.insere(vetor.getVetItem(meio));
			this.Balancear (vetor, temp, inic, meio - 1);
			this.Balancear (vetor, temp, meio + 1, fim);
		}
	}

	
	/**
	 * Pesquisa os 200 Nomes na Arvore
	 * @param vetString
	 */
	public void chamaPesquisaABB(String []vetString){

		for (int i = 0; i < vetString.length; i++) {
			pesquisaABB(vetString[i], this.raiz);
			if (ArvoreBinaria.encontrouARV == false){
				ArvoreBinaria.achadosARV += vetString[i] +" NOME INEXISTENTE"+ "\n";	
			}
			ArvoreBinaria.encontrouARV = false;
		}
	}
	/**
	 * Recursão do  chamaPesquisaABB
	 * @param nome
	 * @param no
	 * @return
	 */
	private NoARV pesquisaABB (String nome, NoARV no){
		NoARV temp = no;
		if (temp != null){
			if (nome.compareTo(temp.getInfo().getNome())== 0){
				ArvoreBinaria.achadosARV += temp.getInfo().toString() + "\n";
				ArvoreBinaria.encontrouARV = true;
				if ((temp.getEsq() != null))
					this.pesquisaABB (nome, temp.getEsq());
				if ((temp.getDir() != null))
					this.pesquisaABB (nome, temp.getDir());
			}else{	
				if ((temp.getEsq() != null) &&(nome.compareTo(temp.getInfo().getNome()) < 0))
					this.pesquisaABB (nome, temp.getEsq());
				else{
					if ((temp.getDir() != null) &&(nome.compareTo(temp.getInfo().getNome()) > 0))
						this.pesquisaABB (nome, temp.getDir());
				}
			}
		}
		return temp;
	}
	
	
	String strArvore;
	
	public String toString(){
		
		strArvore = "";
		imprimirABB(this.getRaiz());		
		return strArvore;
	}
	
	private void imprimirABB(NoARV no){
		
		if(no != null) {
			imprimirABB(no.getEsq());
			//System.out.print(no.getInfo().getNome() + ";" + no.getInfo().getCpf() + ";" + no.getInfo().getFuncao() + "\n");
			strArvore += no.getInfo().getNome() + ";" + no.getInfo().getCpf() + ";" + no.getInfo().getFuncao() + "\n";
			imprimirABB(no.getDir());
		}
		
	}
	



}

